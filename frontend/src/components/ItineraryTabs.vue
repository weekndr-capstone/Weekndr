<template>
    <div class="container">
        <v-tabs v-model="active" light slider-color="black">
            <v-tab v-for="n in 3" :key="n" ripple>
                Day {{ n }}
            </v-tab>
            <v-tab-item v-for="n in 3" :key="n">
                <v-card flat>
                    <v-card-text>
                        <Timeline />
                    </v-card-text>
                </v-card>
            </v-tab-item>
        </v-tabs>

    </div>
</template>

<script>
    import Timeline from "./Timeline";
    import CardCarousel from "./CardCarousel";
    import CardItem from "./CardItem";
    export default {
        name: "ItineraryTabs",
        components: {CardCarousel, CardItem, Timeline},
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
    .title-margin{
        margin-top: 30px;
        margin-bottom: 30px;
    }
</style>