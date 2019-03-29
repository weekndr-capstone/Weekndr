<template>
    <v-carousel hide-delimiters :cycle="false" height="25em" class="carousel-transparent">
        <v-carousel-item :key="i" v-for="i in 7">
            <v-layout row>
                    <v-flex xs4 :key="j" v-for="j in Results.slice((3 * (i-1)),(-Results.length + (3*(i))))">
                        <yelp-card-item :hotel="hotel" :card="j" class="margin">
                        </yelp-card-item>
                    </v-flex>
            </v-layout>
        </v-carousel-item>
    </v-carousel>
</template>

<script>
    import CardItem from '../components/CardItem'
    import YelpCardItem from "./yelpCardItem";

    export default {
        name: "CardCarousel",
        components: {
            YelpCardItem,
            CardItem
        },
        props:{
            Results: Array,
            hotel: Boolean
        },
        data() {
            return {
                }
            }
        }

</script>

<style scoped>


.margin {
    margin-left: 8px;
    margin-right: 8px;
}

.carousel-transparent{
    background: transparent;
    border-color: transparent;
    box-shadow: none;
}
</style>