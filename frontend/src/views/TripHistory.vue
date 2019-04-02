<template>
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
        data(){
            return{
                trips: store.state.user.trips
            }
        },
        computed: {
            userTrips() {
                let all = this.trips;
                let current = new Date();

                return all.filter(t => {
                    let temp = new Date(t.end_date);
                    console.log(temp);
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
