<template>


    <v-carousel light hide-delimiters>
        <v-carousel-item :key="i" v-for="i in 5">
            <v-layout row>
                <v-flex xs4 :key="j" v-for="j in 3">
                    <CardItem>

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



</style>