<template>
    <div>
        <Toolbar/>
        <v-container>
            <Weather :results= "weather"/>
            <v-divider></v-divider>
            <br>
            <h2>Suggestions</h2>
            <br>
            <CardCarousel  :results = "suggested" :hotel="false"/>
            <br>
            <h2>Hotels</h2>
            <br>
            <CardCarousel  :results = "hotels" :hotel="true" />
            <br>
            <h2>Food</h2>
            <br>
            <CardCarousel  :results = "experiences" :hotel="false"/>
            <br>
            <h2>Experiences</h2>
            <br>
            <CardCarousel  :results = "food" :hotel="false"/>
        </v-container>
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