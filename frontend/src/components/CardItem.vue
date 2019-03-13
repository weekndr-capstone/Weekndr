<template>
            <v-card>
                <v-img
                        class="white--text"
                        height="200px"
                        src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
                >
                    <v-container fill-height fluid>
                        <v-layout fill-height>
                            <v-flex xs12 align-end flexbox>
                                <span class="headline">Top 10 Australian beaches</span>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-img>
                <v-card-actions>
                    <v-btn icon>
                        <i class="far fa-heart"></i>
                    </v-btn>
                    <v-btn icon>
                        <i class="far fa-comment 10x"></i>
                    </v-btn>
                </v-card-actions>
            </v-card>

</template>

<script>
    export default {
        name: "CardItem",
        // TODO: will receive properties from parent
        data() {
            return {
                cards: [
                    {title: "hi", src: "hi"},
                    {title: "hi", src: "hi"},
                    {title: "hi", src: "hi"}
                ]
            }
        }
    }
</script>

<style scoped>


</style>