<template>
        <div>
            <Toolbar/>
            <GoogleMap/>
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
                console.log(all);
                let current = new Date();
                console.log(current);

                return all.filter(t => {
                    let temp = new Date(t.end_date)
                    console.log(temp)
                    if (temp < current){
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
