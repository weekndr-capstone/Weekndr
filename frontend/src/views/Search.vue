<template>
    <div>
        <LoadingScreen v-if="isLoading"/>
        <Toolbar/>
        <v-container>
            <Weather v-if="weather !== null" :results= "weather"/>
            <v-divider></v-divider>
            <div v-if="suggested.length >= 1">
                <br>
                <h2>Suggestions</h2>
                <br>
                <CardCarousel :results = "suggested" :hotel="false"/>
            </div>
            <div v-if="hotels.length >= 1">
                <br>
                <h2>Hotels</h2>
                <br>
                <CardCarousel :results = "hotels" :hotel="true" />
                <br>
            </div>
            <div v-if="experiences.length >= 1" >
                <h2>Food</h2>
                <br>
                <CardCarousel :results = "experiences" :hotel="false"/>
                <br>
            </div>
            <div v-if="food.length >= 1">
                <h2>Experiences</h2>
                <br>
                <CardCarousel :results = "food" :hotel="false"/>
            </div>
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
                isLoading: store.state.isLoading
            }
        },
    }
</script>