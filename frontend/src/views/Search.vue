<template>
  <div>
    <CardCarousel :results = "hotels" />
    <CardCarousel :results = "suggested"/>
    <CardCarousel :results = "food"/>
    <CardCarousel :results = "experiences"/>
  </div>
</template>

<script>
    import store from '../store'
    import axios from 'axios'
    import CardCarousel from '../components/CardCarousel'
    export default {
        components: {
            CardCarousel

        },

        data(){
            return {
                hotels: store.state.hotelResults,
                suggested: store.state.suggestedResults,
                food: store.state.foodResults,
                experiences: store.state.experiencesResults
            }
        },

        beforeMount() {
                axios
                    .get('/yelpList/'+ store.state.location + "/4")
                    .then(res => {
                        store.commit('changeSuggestedResults', res.data.businesses);
                    }).catch(err => {
                        console.log(err)
                });
                axios
                    .get('/yelpList/'+ store.state.location + "/1")
                    .then(res => {
                        store.commit('changeExperiencesResults', res.data.businesses);
                    }).catch(err => {
                    console.log(err)
                });
                axios
                    .get('/yelpList/' + store.state.location + "/2")
                    .then(res => {
                        store.commit('changeFoodResults', res.data.businesses);
                    }).catch(err => {
                    console.log(err)
                });
                axios
                    .get('/yelpList/' + store.state.location + "/3")
                    .then(res => {
                        store.commit('changeHotelResults', res.data.businesses);
                    }).catch(err => {
                    console.log(err)
                });
        }
    }
</script>