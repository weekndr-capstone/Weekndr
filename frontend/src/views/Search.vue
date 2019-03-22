<template>
  <div>
    <Toolbar/>
    <CardCarousel  :results = "suggested"/>
    <CardCarousel  :results = "hotels" />
    <CardCarousel  :results = "food"/>
    <CardCarousel  :results = "experiences"/>
  </div>
</template>

<script>
    import store from '../store'
    import CardCarousel from '../components/CardCarousel'
    import Toolbar from '../components/Toolbar'
    import LoadingScreen from "../components/LoadingScreen";

    export default {
        components: {
          LoadingScreen,
            CardCarousel,
            Toolbar
        },

        data(){
            return {
                hotels: store.state.hotelResults,
                suggested: store.state.suggestedResults,
                food: store.state.foodResults,
                experiences: store.state.experiencesResults,
                fadeout: 'fade-out'
            }
        },
    }
</script>