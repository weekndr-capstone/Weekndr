<template>

    <div>
        <Toolbar/>
        <v-container>
            <v-layout row>
                <v-flex class="box" xs12 sm8 offset-sm2 md10 lg8 offset-lg2 offset-md1>
                    <div>
                        <h1>Current</h1>
                        <PastTrip v-for="n in userCurrent" :key="n.id" :trip="n"/>
                    </div>
                </v-flex>
            </v-layout>
            <v-layout row>
                <v-flex class="box" xs12 sm8 offset-sm2 md10 lg8 offset-lg2 offset-md1>
                    <div>
                        <h1>Upcoming</h1>
                        <PastTrip v-for="n in userUpcoming" :key="n.id" :trip="n"/>
                    </div>
                </v-flex>
            </v-layout>
        </v-container>
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
        userCurrent() {
            let all = store.getters.user.trips;
            console.log(all);
            let current = new Date();

            return all.filter(t => {
                let tempEnd = new Date(t.end_date);
                let tempStart = new Date(t.start_date);
                console.log(tempEnd);
                console.log(tempStart);
                if (tempEnd > current && tempStart < current){
                    console.log("HERE");
                    return t;
                }
            });
        },
        userUpcoming() {
            let all = store.getters.user.trips;
            console.log(all);
            let current = new Date();

            return all.filter(t => {
                let tempEnd = new Date(t.end_date);
                let tempStart = new Date(t.start_date);
                console.log(tempEnd);
                console.log(tempStart);
                if (tempEnd > current && tempStart > current){
                    console.log("HERE");
                    return t;
                }
            });
           }
        }
    }
</script>

<style scoped>

</style>