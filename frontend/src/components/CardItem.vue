<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
            <v-card>
                <v-img class="white--text" height="200px" :src="card.image_url">
                    <v-container fill-height fluid>
                        <v-layout fill-height>
                            <v-flex xs12 align-end flexbox>
                                <span class="headline" @click="routeSingle()">"{{card.name}}</span>
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
                                            <p>Display the comments here</p>
                                            <h3>{{ card.title }}</h3>
                                            <ul>
                                                <li v-for="comment in comments">{{ comment.comment }}</li>
                                            </ul>
                                        </v-flex>
                                        <v-flex xs12>
                                            <v-textarea v-model="comment.comment" label="Add Comment" required solo></v-textarea>
                                        </v-flex>
                                    </v-layout>
                                </v-container>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer> </v-spacer>
                                <v-btn flat v-on:click="dialogue = false">Close</v-btn>
                                <v-btn flat v-on:click="userInput()">Add Comment</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>
                </v-card-actions>
            </v-card>
</template>

<script>
    import store from '../store'
    import router from '../router'
    import axios from 'axios'

    export default {
        name: "CardItem",
        // TODO: will receive properties from parent
        data() {
            return {
                counter: 0,
                dialogue: false,
                isLiked: false,
                heartIconClasses: "far fa-heart",
                comment: {
                    comment: '',
                    created_at: new Date(),
                    user: store.state.user,
                    place: this.card,
                    comment_id: null,
                },
                comments: []
            }
        },
        props:{
            card: Object
        },
        methods: {
            async redHeartAndIncrement(){
               await axios(
                   {
                       method: 'POST',
                       url: '/vote',
                       headers: {'Content-Type': 'application/json'},
                       data: {
                           user: {
                               id: store.state.user.id,
                           },
                           place: {
                               id: this.card.id,
                           },
                           created_at: new Date(),
                           upvote: true,
                       }
                   })
                   .then(res => {
                       console.log(res.data)
                       if(res.data === true){
                           this.counter++;
                           this.heartIconClasses = "fas fa-heart color-red"
                       } else {
                           this.counter--;
                           this.heartIconClasses = "far fa-heart"
                       }

                   }).catch(err => {
                       console.log(err)
                   })
                 },
            async userInput(){
                await axios(
                    {
                        method: 'POST',
                        url:'/commentPost',
                        headers: {'Content-Type' : 'application/json'},
                        data: {
                            comment: this.comment.comment,
                            created_at: this.comment.created_at,
                            place_id: {
                                id: this.card.id
                            },
                            comment_id: this.comment.comment_id,
                            user: {
                                  id: store.state.user.id,
                            }
                        }
                    })
                    .then(res => {
                        console.log(res.data)
                        this.comments = res.data;
                    }).catch(err => {
                        console.log(err)
                    })
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