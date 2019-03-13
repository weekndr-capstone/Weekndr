<template>
    <v-carousel light hide-delimiters :cycle="false" height="270px" class="carousel-transparent">
        <v-carousel-item :key="i" v-for="i in 3">
            <v-layout row>
                <v-flex xs15 sm6 md4 :key="j" v-for="j in Results">
                    <CardItem class="margin">
                    </CardItem>
                </v-flex>
            </v-layout>
        </v-carousel-item>
    </v-carousel>
</template>

<script>
    import CardItem from '../components/CardItem'

    export default {
        name: "CardCarousel",
        components: {
            CardItem
        },
        props:{
            Results: Array,
        },
        data() {
            return {
                    cards: [
                        {title: "card test", description: "this is a card description", src: "12345"},
                        {title: "woot woot test", description: "woot woot test card description", src: "12345"},
                        {title: "wahoo test", description: "wahoo test card description", src: "12345"}
                    ]
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