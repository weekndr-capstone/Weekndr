<template>
<span>
     <v-layout row>
          <v-flex class="zero-padding">
              <v-img :src="getImgUrl(place.url)"  contain  width="135px" height="90px" />
          </v-flex>
          <v-flex  align-self-center class="text-xs-center">
              <h2 @click="search(place.name)" class="scale">{{place.name}}</h2>
          </v-flex>
      </v-layout>
        <LoadingScreen v-if="isLoading"/>
</span>
</template>

<script>
    import store from '../store'
    import router from '../router'
    import axios from 'axios'
    import LoadingScreen from "./LoadingScreen";

    export default {
        name: "RecommendedDestinations",
        components: {LoadingScreen},
        data() {
          return{
              isLoading: false
          }
        },
        props:{
            place: Object,
        },
        methods:{
            getImgUrl(pic) {
                if (pic == null){
                    return require('../assets/weekdnr_logo.svg')
                }
                return require('../assets/'+ pic)
            },
            async search(searchCity){
                store.commit('changeLocation', searchCity);
                this.isLoading = true;
                await axios.all([
                    axios.get('/yelpList/'+ store.state.location + "/4"),
                    axios.get('/yelpList/'+ store.state.location + "/1"),
                    axios.get('/yelpList/' + store.state.location + "/2"),
                    axios.get('/yelpList/' + store.state.location + "/3"),
                    axios.get("https://maps.googleapis.com/maps/api/geocode/json?address="+ store.state.location +"&key=" + "AIzaSyAih6iqhzWmzLIe11sF9yMDuwPhVyFYP2w")
                ]).then(axios.spread((suggestedRes, experiencesRes, foodRes, hotelRes, weatherRes) =>{
                    store.commit('changeSuggestedResults', suggestedRes.data.businesses);
                    store.commit('changeExperiencesResults', experiencesRes.data.businesses);
                    store.commit('changeFoodResults', foodRes.data.businesses);
                    store.commit('changeHotelResults', hotelRes.data.businesses);
                    store.commit('changeWeatherResults', weatherRes.data.results[0]);
                    this.isLoading = false;
                    console.log(suggestedRes, experiencesRes, foodRes, hotelRes, weatherRes)
                }));
                router.push('/search');
              },
        }
    }
</script>

<style scoped>
    .white-background{
        background-color: red;
    }

    .zero-padding{
        padding: 0 !important;
    }
    .scale {
        cursor: pointer;
    }
    .scale:hover {
        transform: scale(1.05);
    }
</style>



