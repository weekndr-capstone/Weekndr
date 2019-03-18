<template>
    <div>
        <Banner/>
        <v-carousel light hide-delimiters :cycle="false" height="270px" class="carousel-transparent">
            <v-carousel-item :key="i" v-for="i in 5">
                <v-layout row>
                        <RecommendedDestinations/>
                </v-layout>
            </v-carousel-item>
        </v-carousel>
        <v-carousel>
            <v-carousel-item :key="i" v-for="i in 5">
                <v-layout row>
                    <v-flex xs4 :key="j" v-for="j in 3">
                        <img :src="'https://placehold.it/380x500/?text=' + i + '-' + j" alt="">
                    </v-flex>
                </v-layout>
            </v-carousel-item>
        </v-carousel>
        <v-container>
        <v-layout>
            <RecommendedDestinations/>
            <RecommendedDestinations/>
            <RecommendedDestinations/>
            <RecommendedDestinations/>
        </v-layout>
        </v-container>
        <TripHistory v-if="userTrips.trips != null" :trips="userTrips.trips"/>
    </div>
</template>

<script>
    import Banner from '../components/Banner'
    import store from '../store'
    import TripHistory from "./TripHistory";
    import RecommendedDestinations from "../components/RecommendedDestinations";
  export default {
    data(){
        return {
        }
    },
    components: {
        RecommendedDestinations,
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
