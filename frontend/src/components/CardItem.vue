<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
            <v-card>
                <v-img
                        class="white--text"
                        height="200px"
                        src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
                >
                    <v-container fill-height fluid>
                        <v-layout fill-height>
                            <v-flex xs12 align-end flexbox>
                                <span class="headline">Title Info</span>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-img>
                <v-card-actions>
                    <v-btn icon v-on:click="counter += 1">
                        <i class="far fa-heart"></i>
                        <span> {{ counter }}</span>
                    </v-btn>
                    <!--<v-btn icon v-on:click="comments">-->
                        <!--<i class="far fa-comment 10x"></i>-->
                    <!--</v-btn>-->

                    <!--This is the modal on click for comments:-->
                    <v-dialog v-model="dialogue" max-width="600px">
                        <template v-slot:activator="{ on }">
                            <v-spacer>
                            <v-btn icon v-on="on">
                                <i class="far fa-comment 10x"></i>
                            </v-btn>
                            </v-spacer>
                        </template>
                        <v-card>
                            <v-card-text>
                                <v-container grid-list-md>
                                    <v-layout wrap>
                                        <v-flex xs12>
                                            <h3>Card title that's being commented on goes here</h3>
                                            <p>Display the comments here</p>
                                        </v-flex>
                                        <v-flex xs12>
                                            <v-textarea label="Add Comment" required solo></v-textarea>
                                        </v-flex>
                                    </v-layout>
                                </v-container>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer> </v-spacer>
                                <v-btn flat v-on:click="dialogue = false">Close</v-btn>
                                <v-btn flat v-on:click="">Add Comment</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>


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
                ],
                counter: 0,
                dialogue: false
            }
        }
    }
</script>

<style scoped>


</style>