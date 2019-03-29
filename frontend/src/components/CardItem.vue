<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
            <v-card>
                <v-img class="white--text" height="200px" :src="card.image_url">
                    <v-container fill-height fluid>
                        <v-layout fill-height>
                            <v-flex xs12 align-end flexbox>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-img>
                <v-card-actions>
                    <v-layout row wrap>
                    <v-btn :ripple="false" icon v-on:click="redHeartAndIncrement()">
                        <i :class=heartIconClasses></i>
                        <span class="pl-1"> {{ counter }}</span>
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
                                        <h3>{{ card.name }}</h3>
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
                            <v-btn outline color="#E96445" flat v-on:click="dialogue = false">Close</v-btn>
                            <v-btn outline color="#E96445" flat v-on:click="userInput()">Add Comment</v-btn>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
                <v-dialog v-model="dialogue5" max-width="600px">
                          <template v-slot:activator="{ on }">
                                <v-btn :ripple="false" icon v-on="on">
                                    <i  :class=photoIconClasses></i>
                                </v-btn>
                            </template>
                            <v-card>
                                <v-card-actions>
                                    <v-layout>
                                        <v-flex xs12 text-xs-center>
                                            <h1>{{ card.name }}</h1>
                                        </v-flex>
                                    </v-layout>
                                </v-card-actions>
                                <PictureGrid :photos="this.card.photos"></PictureGrid>
                                    <v-card-actions>
                                        <v-spacer></v-spacer>
                                                <FileUpload :card="this.card" :pictureLocation="'placePicture'"></FileUpload>
                                                <v-btn outline color="#E96445" flat v-on:click="dialogue5 = false">Close</v-btn>
                                    </v-card-actions>
                            </v-card>
                    </v-dialog>



                    <v-dialog v-model="dialogue4" max-width="600px">
                        <template v-slot:activator="{ on }">
                            <v-btn :ripple="false" icon v-on="on">
                                <i :class=infoIconClasses></i>
                            </v-btn>
                        </template>
                        <v-card>
                            <v-card-text>
                                <v-container grid-list-md>
                                    <v-layout wrap>
                                        <v-flex xs12>
                                            <h1>{{ card.name }}</h1>
                                            <p>{{  card.description }}</p>
                                            <p><i class="fas fa-map-marker-alt"></i>{{  card.address }}</p>
                                            <p><i class="fas fa-phone"></i>{{  card.phone_number }}</p>
                                            <p>{{  card.price }}</p>
                                            <p>{{  card.rating }}</p>
                                            <p><a :href="card.websiteURL" target="_blank">go to website</a></p>
                                        </v-flex>
                                    </v-layout>
                                </v-container>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer> </v-spacer>
                                <v-btn outline color="#E96445" flat v-on:click="dialogue4 = false">Close</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>
                    <v-dialog v-if="mainUser === true" v-model="dialogue2" max-width="600px">
                        <template v-slot:activator="{ on }">
                            <v-btn :ripple="false" icon v-on="on">
                                <i  :class=editIconClasses />
                            </v-btn>
                        </template>
                        <v-card>
                            <v-card-text>
                                <v-container grid-list-md>
                                    <v-layout wrap>
                                        <v-flex xs12>
                                            <h1>{{ card.name }}</h1>
                                            <br/>
                                            <p>Edit Description:</p>
                                            <v-flex xs12>
                                                <v-textarea v-model="card.description" :label="card.description" required solo></v-textarea>
                                            </v-flex>
                                        </v-flex>
                                    </v-layout>
                                </v-container>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer> </v-spacer>
                                <v-btn outline color="#E96445" flat v-on:click="dialogue2 = false">Close</v-btn>
                                <v-btn outline color="#E96445" flat v-on:click="editPlace()">Save Changes</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>
                    <v-dialog v-if="mainUser === true" v-model="dialogue3" max-width="600px">
                        <template v-slot:activator="{ on }">
                            <v-btn :ripple="false" icon v-on="on">
                                <i  :class=deleteIconClasses />
                            </v-btn>
                        </template>
                        <v-card>
                            <v-card-text>
                                <v-container grid-list-md>
                                    <v-layout wrap>
                                        <v-flex xs12>
                                           <p>Are you sure you want to delete <strong><em>{{ card.name }}</em></strong> from your itinerary?</p>
                                        </v-flex>
                                    </v-layout>
                                </v-container>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer> </v-spacer>
                                <v-btn outline color="#E96445" flat v-on:click="dialogue3 = false">No</v-btn>
                                <v-btn outline color="#E96445" flat v-on:click="deletePlace()">Yes, Delete</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>
                  </v-layout>
                </v-card-actions>
            </v-card>
</template>

<script>
    import store from '../store'
    import router from '../router'
    import axios from 'axios'
    import comment from '../components/comment'
    import Vue from 'vue'
    import FileUpload from '../components/FileUpload'
    import PictureGrid from '../components/PictureGrid'

    export default {
        name: "CardItem",
        components:{
            comment,
            FileUpload,
            PictureGrid
        },

        data() {
            return {
                counter: 0,
                dialogue: false,
                dialogue2: false,
                dialogue3: false,
                dialogue4: false,
                dialogue5: false,
                isLiked: false,
                heartIconClasses: "far fa-heart",
                editIconClasses: "far fa-edit",
                deleteIconClasses: "far fa-trash-alt",
                infoIconClasses: "far fa-question-circle",
                photoIconClasses: "far fa-images",
                card: {
                    id: this.card.id,
                    description: '',
                },
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
        computed:{
            mainUser(){
                return store.getters.mainUser
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

            async editPlace(){

                    await axios (
                        {
                            method: 'POST',
                            url: '/editPlace',
                            headers: {'Content-Type': 'application/json'},
                            params: {
                                    id: this.card.id,
                                    description: this.card.description

                                }


                        }).then(res => {
                            this.dialogue2 = false;
                            console.log(res.data)
                    }).catch(err =>{
                        console.log(err);
                    })
            },
            async deletePlace(){
                await axios (
                    {
                        method: 'POST',
                        url: '/deletePlace',
                        headers: {'Content-Type': 'application/json'},
                        params: {
                            id: this.card.id,
                        }

                    }).then(res => {
                    this.dialogue3 = false;
                    store.state.currentViewedTrip.places.filter((place,index) => {
                        if (place.id === this.card.id){
                            store.state.currentViewedTrip.places.splice(index,1)
                        }
                    })
                    // console.log(res.data)
                }).catch(err =>{
                    console.log(err);
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
                                  id: store.state.user.id
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