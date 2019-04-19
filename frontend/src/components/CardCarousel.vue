<template>
    <!--<v-carousel v-if="isMobile()" hide-delimiters :cycle="false" height="22em" class="carousel-transparent">-->
        <!--<v-carousel-item :key="i" v-for="i in 7">-->
            <!--<v-layout row>-->
               <!--<v-flex xs4 :key="j" v-for="j in results.slice((3 * (i-1)),(-results.length + (3*(i))))">-->
                   <!--<yelp-card-item :hotel="hotel" :card="j" class="margin">-->
                   <!--</yelp-card-item>-->
               <!--</v-flex>-->
            <!--</v-layout>-->
        <!--</v-carousel-item>-->
    <!--</v-carousel>-->
    <v-carousel hide-delimiters :cycle="false" height="22em" class="carousel-transparent">
    <v-carousel-item :key="i.id" v-for="i in results">
        <v-flex>
            <yelp-card-item xs-12 :hotel="hotel" :card="i" class="margin">
            </yelp-card-item>
        </v-flex>
    </v-carousel-item>
    </v-carousel>
</template>

<script>

    import YelpCardItem from "./yelpCardItem"

    export default {
        name: "CardCarousel",
        components: {
            YelpCardItem
        },
        props: {
            results: Array,
            hotel: Boolean
        },
        methods: {
            isMobile() {
                if(/Android|webOS|iPhone||iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) {
                    console.log("DESKTOP");
                    return true
                } else {
                    console.log("MOBILE");
                    return false
                }
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