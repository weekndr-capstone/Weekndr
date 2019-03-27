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
            time(event_date) {
                if (event_date !== null) {
                    let firstSplit = event_date.split('T')[1];
                    let secondSplit = firstSplit.split('.')[0];
                    let thirdSplit = secondSplit.split(':');

                    let hours = Number(thirdSplit[0]);
                    let minutes = Number(thirdSplit[1]);

                    //not displaying seconds but they're here if we need them:
                    let seconds = Number(thirdSplit[2]);

                    let amPm = "AM";

<<<<<<< HEAD
                if(hours > 12){
                    hours -= 12;
                    amPm = "PM";
                }
=======
                    if (hours > 12) {
                        hours -= 12;
                        amPm = "PM";
                    }
>>>>>>> master

                    return (hours + ":" + minutes).toString() + amPm;
                }
            }
        },
        computed: {
            trip(){
                return store.state.currentViewedTrip.places.filter(place => {
                    if (place.suggested === false){
                        return place;
                    }
                })
            },
            dates(){
                let startsplit = store.state.currentViewedTrip.start_date.split('-')[2];
                let secondstartsplit = startsplit.split('T')[0];
                let endsplit = store.state.currentViewedTrip.end_date.split('-')[2];
                let secondendsplit = endsplit.split('T')[0];
                let dates = [];
                for (let i = secondstartsplit; i <= secondendsplit; i++) {
                    dates.push(i);
                }
                return dates;
            },
            placesByDate(){
                let places = [];
                this.dates.forEach(date => {
                    let tempArray = [];
                    store.state.currentViewedTrip.places.filter(place => {
                        console.log(place);
                        if (place.checkin_date === null && !place.suggested){
                            if (place.event_date.split('T')[0].includes(date)){
                                console.log("Not Suggested");
                                tempArray.push(place);
                            }
                        }else if (place.checkin_date === null && place.suggested) {

                        }else  {
                            if ((place.checkin_date.includes(date) || place.checkout_date.includes(date)) && !place.suggested){
                                tempArray.push(place);
                            }
                        }
                    });
                    tempArray.sort(function (a,b){
                        if (a.event_date !== null) {
                          a = a.event_date.split('T')[1];
                          a = a.split('+')[0]
                          a = a.split(':')[0] + a.split(':')[1]
                        }
                        if (b.event_date !== null) {
                          b = b.event_date.split('T')[1];
                          b = b.split('+')[0]
                          b = b.split(':')[0] + b.split(':')[1]
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