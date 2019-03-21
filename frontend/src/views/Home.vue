<template>
    <div>
        <Banner/>
        <div>
            <v-carousel light hide-delimiters :cycle="false" height="auto" class="carousel-transparent">
                <v-carousel-item :key="i" v-for="i in 3">
                    <v-layout row>
                        <v-flex xs12 sm6 md4 :key="j.id" v-for="j in places.slice((3 * (i-1)),(-12 + (3*(i))))">
                            <RecommendedDestinations :place="j" class="margin"/>
                        </v-flex>
                    </v-layout>
                </v-carousel-item>
            </v-carousel>
            <TripHistory v-if="userTrips.trips != null" :trips="userTrips.trips"/>
        </div>
    </div>
</template>

<script>
    import Banner from '../components/Banner'
    import store from '../store'
    import TripHistory from "./TripHistory";
    import RecommendedDestinations from "../components/RecommendedDestinations";
    import Itenerary from "./Itenerary";
    import YelpCardItem from "../components/yelpCardItem";

  export default {
    data(){
        return {
            places:[
                {name: 'london', image: 'image'},
                {name: 'boston', image: 'image'},
                {name: 'tokyo', image: 'image'},
                {name: 'barcelona',image: 'image'},

                {name: 'new jersey', image: 'image'},
                {name: 'boise', image: 'image'},
                {name: 'berlin', image: 'image'},
                {name: 'amsterdam',image: 'image'},

                {name: 'toronto', image: 'image'},
                {name: 'new york', image: 'image'},
                {name: 'lisbon', image: 'image'},
                {name: 'san jose',image: 'image'},
            ],
        }
    },
    components: {
        YelpCardItem,
        Itenerary,
        RecommendedDestinations,
        TripHistory,
        Banner,
    },
    computed: {
        userTrips(){
            return store.getters.user
        }
    }
  }
</script>
