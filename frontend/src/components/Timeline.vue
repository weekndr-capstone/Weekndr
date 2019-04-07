<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">

    <v-tabs v-model="active" light slider-color="#E96445">
        <v-tab v-for="(d, index) in dates" :key="index" ripple>
            {{d}}
        </v-tab>
        <v-tab-item v-for="(d, index) in dates" :key="index" ripple>
            <v-timeline>
                <v-timeline-item v-for="n in placesByDate[index]" :key="n.id" color="black lighten-2" small>
                    <template v-slot:opposite>
                        <h2 class="font-color">{{n.name}}</h2>
                        <h3>{{time(n.event_date)}}</h3>
                    </template>
                    <v-container>
                        <CardItem :card="n" />
                    </v-container>
                </v-timeline-item>
            </v-timeline>
        </v-tab-item>
    </v-tabs>

</template>

<script>
    import CardItem from './CardItem';
    import store from '../store';

    export default {
        name: "Timeline",
        components: {CardItem},
        data(){
            return{
            }
        },
        methods: {

            //display currect time for individual places
            //TODO: FIX THIS
            time(event_date) {
                if (event_date !== null) {
                    let firstSplit = event_date.split('T')[1];
                    let secondSplit = firstSplit.split('.')[0];
                    let thirdSplit = secondSplit.split(':');

                    let hours = Number(thirdSplit[0]);
                    let minutes = thirdSplit[1];
                    //not displaying seconds but they're here if we need them:
                    let seconds = Number(thirdSplit[2]);

                    let amPm = "AM";

                    if (hours > 12) {
                        hours -= 12;
                        amPm = "PM";

                        return (hours + ":" + minutes) + amPm;
                    }
                    return (hours + ":" + minutes) + amPm;
                }
            }
        },
        computed: {

            //filters out places based on whether they are not suggested
            trip(){
                return store.state.currentViewedTrip.places.filter(place => {
                    if (place.suggested === false){
                        return place;
                    }
                })
            },

            //current way of getting all date tabs to be correct, only for 31 day months
            //TODO: REALLY FIX THIS
            dates(){
                let startsplit = store.state.currentViewedTrip.start_date.split('-')[2];
                let secondstartsplit = startsplit.split('T')[0];
                let endsplit = store.state.currentViewedTrip.end_date.split('-')[2];
                let secondendsplit = endsplit.split('T')[0];
                let dates = [];
                var oneDay = 24*60*60*1000; // hours*minutes*seconds*milliseconds
                var firstDate = new Date(store.state.currentViewedTrip.start_date);
                var secondDate = new Date(store.state.currentViewedTrip.end_date);
                var diffDays = Math.round(Math.abs((firstDate.getTime() - secondDate.getTime())/(oneDay)));
                for (let i = 0; i <= diffDays;) {
                    let check = parseInt(secondstartsplit) + i;
                    if (check - 10 < 0 && !check.toString().includes('0')){
                        dates.push("0"+ check);
                        i++;
                    }else{
                        if (check > 31){
                            check -= 31;
                            if (check - 10 < 0 && !check.toString().includes('0')){
                                dates.push("0"+ check);
                                i++;
                            }else{
                               dates.push(check);
                               i++;
                            }
                        }else {
                            dates.push(check);
                            i++;
                        }
                    }
                }
                return dates;
            },

            //filters out places based on there dates
            placesByDate(){
                let places = [];
                this.dates.forEach(date => {
                    let tempArray = [];
                    store.state.currentViewedTrip.places.filter(place => {
                        if (place.checkin_date === null && !place.suggested){
                            if (place.event_date.split('T')[0].split('-')[2].includes(date)){
                                tempArray.push(place);
                            }
                        }else if (place.checkin_date === null && place.suggested) {
                        }else  {
                            if ((place.checkin_date.split('T')[0].split('-')[2].includes(date) || place.checkout_date.split('T')[0].split('-')[2].includes(date)) && !place.suggested){
                                tempArray.push(place);
                            }
                        }
                    });
                    tempArray.sort(function (a,b){
                        if (a.event_date !== null) {
                            a = new Date(a.event_date);
                          // a = a.event_date.split('T')[1];
                          // a = a.split('+')[0]
                          // a = a.split(':')[0] + a.split(':')[1]
                        }
                        if (b.event_date !== null) {
                            b = new Date(b.event_date);
                          // b = b.event_date.split('T')[1];
                          // b = b.split('+')[0]
                          // b = b.split(':')[0] + b.split(':')[1]
                        }
                        if (a.event_date === null ){
                            a = 0;
                        }
                        if (b.event_date === null ){
                            b = 0;
                        }
                        return a - b
                    });
                    places.push(tempArray);

                });
                return places;
            }
        },
    }
</script>

<style scoped>
    .font-color {
        color: #E96445;
    }
</style>