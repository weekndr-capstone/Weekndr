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
                cards: [
                    {title: "card test", description: "this is a card description", src: "12345"},
                    {title: "woot woot test", description: "woot woot test card description", src: "12345"},
                    {title: "wahoo test", description: "wahoo test card description", src: "12345"}
                ]
            }
        },
    }
</script>