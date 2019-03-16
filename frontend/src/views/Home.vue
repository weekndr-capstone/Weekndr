<template>
    <div>
        <Banner/>
        <TripHistory v-if="userTrips.trips != null" :trips="userTrips.trips"/>
    </div>
</template>

<script>
    import Banner from '../components/Banner'
    import store from '../store'
    import TripHistory from "./TripHistory";
  export default {
    data(){
        return {
        }
    },
    components: {
        TripHistory,
        Banner
    },
    computed: {
        userTrips(){
            return store.getters.user
        }
    }
  }
</script>
