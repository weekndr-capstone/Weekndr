<template>
    <v-carousel light hide-delimiters :cycle="false" height="270px" class="carousel-transparent">
        <v-carousel-item :key="i" v-for="i in 5">
            <v-layout row>
                <v-flex xs15 sm6 md4 :key="j" v-for="j in Results">
                    <CardItem :card="j" class="margin">
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