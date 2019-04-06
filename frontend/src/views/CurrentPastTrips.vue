<template>

    <div>
        <Toolbar/>
            <v-layout row>
                <v-flex class="box" xs12 sm8 offset-sm2 md10 lg8 offset-lg2 offset-md1>
                        <h1>Current</h1>
                        <PastTrip v-for="n in userCurrent" :key="n.id" :trip="n"/>
                </v-flex>
            </v-layout>
            <v-layout row>
                <v-flex class="box" xs12 sm8 offset-sm2 md10 lg8 offset-lg2 offset-md1>
                        <h1>Upcoming</h1>
                        <PastTrip v-for="n in userUpcoming" :key="n.id" :trip="n"/>
                </v-flex>
            </v-layout>
    </div>

</template>

<script>
    import Toolbar from '../components/Toolbar'
    import PastTrip from '../components/PastTrip'
    import store from '../store'

    export default {
        name: "CurrentPastTrips",
        components: {
            Toolbar,
            PastTrip
        },
        computed: {

            //filters out whether a trip is current based on the start date having past but the end date not yet passing and passes results as props
            userCurrent() {
                let all = store.getters.user.trips;
                let current = new Date();

                return all.filter(t => {
                    let tempEnd = new Date(t.end_date);
                    let tempStart = new Date(t.start_date);
                    if (tempEnd > current && tempStart < current){
                        return t;
                    }
                });
            },

            //filters out whether a trip is upcoming based on the start date having not past and passes results as props
            userUpcoming() {
                let all = store.getters.user.trips;
                let current = new Date();

                return all.filter(t => {
                    let tempEnd = new Date(t.end_date);
                    let tempStart = new Date(t.start_date);
                    if (tempEnd > current && tempStart > current){
                        return t;
                    }
                });
               },
            },
    }
</script>

<style scoped>

</style>