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
                                            <div>
                                                <comment v-if="comments[index] !== undefined"  :key="index" v-for="(comment, index) in comments"
                                                         :comments="comment.childComments"
                                                         :label="comment.comment"
                                                         :id="comment.id"
                                                         :depth="0">
                                                </comment>
                                            </div>
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
    import comment from '../components/comment'
    import Vue from 'vue'

    export default {
        name: "CardItem",
        components:{
            comment
        },
        // TODO: will receive properties from parent
        data() {
            return {
                counter: 0,
                dialogue: false,
                isLiked: false,
                heartIconClasses: "far fa-heart",
                loadingDone: true,
                comment: {
                    comment: '',
                    created_at: new Date(),
                    user: store.state.user,
                    place: this.card,
                    parent_comment: null,
                },
                comments: '',
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
                            user: {
                                  id: store.state.user.id,
                            },
                            place: {
                                id: this.card.id
                            },
                            parentComment: {
                                id: store.state.parentComment
                            }
                        }
                    })
                    .then(res => {
                            function childF(child) {
                                child.forEach((c) => {
                                    axios({
                                        method: 'GET',
                                        url: '/childComment',
                                        headers: {'Content-Type': 'application/json'},
                                        params: {
                                            comment: c.id
                                        }
                                    }).then(res => {
                                        if (res.data.length !== 0) {
                                            c.childComments = res.data;
                                            childF(c.childComments);
                                        }
                                    }).catch(err => {
                                        console.log(err)
                                    })
                                })
                            }

                            res.data.forEach((c => {
                                axios({
                                    method: 'GET',
                                    url: '/childComment',
                                    headers: {'Content-Type': 'application/json'},
                                    params: {
                                        comment: c.id
                                    }
                                }).then(res => {
                                    if (res.data.length !== 0) {
                                        c.childComments = res.data;
                                        childF(c.childComments);
                                    }
                                }).catch(err => {
                                    console.log(err)
                                });
                            }));
                        this.comments = res.data;
                        this.dialogue = false;
                    }).catch(err => {
                        console.log(err)
                    });
            },
            async routeSingle() {
                await store.commit('changeSingleResult', this.card);
                router.push('/single')
            },

            parent(id){
                this.comment.parent_comment = id;
                console.log(this.comment.parent_comment)
            }
        },
        async mounted(){
            function childF(child){
                child.forEach((c)=> {
                    axios ({
                        method: 'GET',
                        url: '/childComment',
                        headers: {'Content-Type' : 'application/json'},
                        params:{
                            comment: c.id
                        }
                    }).then(res => {
                        if (res.data.length !== 0){
                            c.childComments = res.data;
                            childF(c.childComments);
                        }
                    }).catch(err => {
                        console.log(err)
                    })
                })
            }
            await axios({
                method: 'GET',
                url:'/placeComments',
                headers: {'Content-Type' : 'application/json'},
                params:{
                    place: this.card.id
                }
            }).then(res => {
                this.comments = res.data;
            }).catch(err => {
                console.log(err.data);
            });

             await this.comments.forEach((c => {
                 axios ({
                    method: 'GET',
                    url: '/childComment',
                     headers: {'Content-Type' : 'application/json'},
                     params:{
                         comment: c.id
                     }
                }).then(res => {
                    if (res.data.length !== 0){
                        c.childComments = res.data;
                        childF(c.childComments);
                    }
                 }).catch(err => {
                     console.log(err)
                 })
            }));

                this.card.votes.forEach((v)=>{
                    if(v.upvote === true){

                        if(v.user === store.state.user.id){
                            this.heartIconClasses = "fas fa-heart color-red";
                        }

                        console.log("in the votes foreach");
                        this.counter++;
                    }
                })
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