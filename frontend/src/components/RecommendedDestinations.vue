<template>

            <v-layout row>
                 <v-flex class="zero-padding">
                     <v-img :src="getImgUrl(place.url)"  contain  width="135px" height="90px" />
                 </v-flex>
                 <v-flex  align-self-center class="text-xs-center">
                     <h2 @click="search(place.name)">{{place.name}}</h2>
                 </v-flex>
             </v-layout>

</template>

<script>
    import store from '../store'
    import router from '../router'
    import axios from 'axios'

    export default {
        name: "RecommendedDestinations",
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
                await axios.all([
                    axios.get('/yelpList/'+ store.state.location + "/4"),
                    axios.get('/yelpList/'+ store.state.location + "/1"),
                    axios.get('/yelpList/' + store.state.location + "/2"),
                    axios.get('/yelpList/' + store.state.location + "/3"),
                ]).then(axios.spread((suggestedRes, experiencesRes, foodRes, hotelRes) =>{
                    store.commit('changeSuggestedResults', suggestedRes.data.businesses);
                    store.commit('changeFoodResults', experiencesRes.data.businesses);
                    store.commit('changeExperiencesResults', foodRes.data.businesses);
                    store.commit('changeHotelResults', hotelRes.data.businesses);
                    console.log(suggestedRes, experiencesRes, foodRes, hotelRes)
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
</style>



