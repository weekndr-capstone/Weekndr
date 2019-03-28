<template>
            <v-container>
                <v-layout row class="white-background"  elevation-1>
                    <v-flex  class="zero-padding" mr-4 xs5>
                        <v-img :src="getImgUrl(place.url)" right height="100px" width="100px"  />
                    </v-flex>
                    <v-flex xs7 align-self-center>
                        <h2 @click="search(place)">{{place.name}}</h2>
                    </v-flex>
                </v-layout>
            </v-container>
</template>



<script>
    import store from '../store'
    import router from '../router'
    import axios from 'axios'

    export default {
        name: "FHEBlock",
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
            async search(search){
                store.commit('changeLocation', store.state.currentViewedTrip.location);
                if (search.name === 'Food'){
                    await axios.get('/yelpList/' + store.state.location + "/2")
                        .then( res => {store.commit('changeFoodResults', res.data.businesses)})
                        .catch(err => {
                            console.log(err)
                        })
                } else if (search.name === "Hotel"){
                    await axios.get('/yelpList/' + store.state.location + "/3")
                        .then( res => { store.commit('changeHotelResults', res.data.businesses)})
                        .catch(err => {
                            console.log(err)
                        })
                } else {
                    await axios.get('/yelpList/'+ store.state.location + "/1")
                        .then( res => { store.commit('changeExperiencesResults', res.data.businesses);})
                        .catch(err => {
                            console.log(err)
                        })
                }
                router.push('/search');
            },
        }
    }
</script>

<style scoped>
    .white-background{
        background-color: white;
    }

    .zero-padding {
        padding: 0 !important;
    }
</style>