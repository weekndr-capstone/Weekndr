<template>
  <div>
    <Toolbar/>
    <Weather :results= "weather"/>
    <CardCarousel  :results = "suggested" :hotel="false"/>
    <CardCarousel  :results = "hotels" :hotel="true" />
    <CardCarousel  :results = "food" :hotel="false"/>
    <CardCarousel  :results = "experiences" :hotel="false"/>
  </div>
</template>

<script>
    import store from '../store'
    import CardCarousel from '../components/CardCarousel'
    import Toolbar from '../components/Toolbar'
    import Weather from "../components/Weather";
    import LoadingScreen from "../components/LoadingScreen";

    export default {
        components: {
          Weather,
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
                weather: store.state.weatherResults,
                fadeout: 'fade-out'
            }
        },
    }
</script>