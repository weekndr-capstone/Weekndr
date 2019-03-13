<template>
  <div>
    <CardCarousel  :results = "suggested"/>
    <CardCarousel  :results = "hotels" />
    <CardCarousel  :results = "food"/>
    <CardCarousel  :results = "experiences"/>
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
                experiences: store.state.experiencesResults,
                // suggestedback: false,
                // hotelsback: false,
                // foodback: false,
                // experiencesback: false,
                cards: [
                    {title: "card test", description: "this is a card description", src: "12345"},
                    {title: "woot woot test", description: "woot woot test card description", src: "12345"},
                    {title: "wahoo test", description: "wahoo test card description", src: "12345"}
                ]
            }
        },

        // beforeMount() {
        //         axios
        //             .get('/yelpList/'+ store.state.location + "/4")
        //             .then(res => {
        //                 store.commit('changeSuggestedResults', res.data.businesses);
        //             }).catch(err => {
        //                 console.log(err)
        //         });
        //         axios
        //             .get('/yelpList/'+ store.state.location + "/1")
        //             .then(res => {
        //                 store.commit('changeExperiencesResults', res.data.businesses);
        //             }).catch(err => {
        //             console.log(err)
        //         });
        //         axios
        //             .get('/yelpList/' + store.state.location + "/2")
        //             .then(res => {
        //                 store.commit('changeFoodResults', res.data.businesses);
        //             }).catch(err => {
        //             console.log(err)
        //         });
        //         axios
        //             .get('/yelpList/' + store.state.location + "/3")
        //             .then(res => {
        //                 store.commit('changeHotelResults', res.data.businesses);
        //             }).catch(err => {
        //             console.log(err)
        //         });
        // }
    }
</script>