<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
            <v-card>
                <v-img class="white--text" height="200px" :src="card.image_url">
                    <v-container fill-height fluid>
                        <v-layout fill-height>
                            <v-flex xs12 align-end flexbox>
                                <span class="headline" @click="routeSingle()">"{{card.alias}}</span>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-img>
                <v-card-actions>
                    <v-btn :ripple="false" icon v-on:click="redHeartAndIncrement()">
                        <i  :class=heartIconClasses></i>
                        <span> {{ counter }}</span>
                    </v-btn>
                    <v-dialog v-model="dialogue" max-width="600px">
                        <template v-slot:activator="{ on }">
                            <v-spacer>
                            <v-btn :ripple="false" icon v-on="on">
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
    import store from '../store'
    import router from '../router'
    export default {
        name: "CardItem",
        // TODO: will receive properties from parent
        data() {
            return {
                counter: 0,
                dialogue: false,
                isLiked: false,
                heartIconClasses: "far fa-heart",
            }
        },
        props:{
            card: Object
        },
        methods: {
            redHeartAndIncrement(){
                this.heartIconClasses = "fas fa-heart color-red";
                this.counter ++;
            },
            async routeSingle() {
                await store.commit('changeSingleResult', this.card);
                router.push('/single')
            }
        }
    }
</script>

<style scoped>
.color-red{
    color: red;
    background-color: transparent;
}

.v-btn:hover:before {
    background-color: transparent;
}

</style>