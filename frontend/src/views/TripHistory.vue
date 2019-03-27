<template>
    <!--TODO: need a map at the top that has pins dropped in all of the locations you've visited-->
    <!--TODO: list of all of your past trips with a button that will take you to that trips page-->
    <div>
        <Toolbar/>
        <GoogleMap :trips="userTrips"/>
        <PastTrip v-for="n in userTrips" :key="n" :trip="n"/>
    </div>
</template>

<script>
    import GoogleMap from '../components/GoogleMap'
    import PastTrip from '../components/PastTrip'
    import Toolbar from '../components/Toolbar'
    import store from '../store'
    export default {
        name: "TripHistory",
        components: {
            GoogleMap,
            PastTrip,
            Toolbar
        },
        computed: {
            userTrips() {
                let all = store.getters.user.trips;
                let current = new Date();

                return all.filter(t => {
                    let temp = new Date(t.end_date);
                    if (temp < current){
                        return t;
                    }
                });
            }
        }
    }
</script>

<style scoped>

</style>
