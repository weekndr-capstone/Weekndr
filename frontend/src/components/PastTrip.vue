<template>
    <v-container>
        <v-layout row wrap class="white-background" elevation-1>
                <v-flex class="zero-margin" xs3 sm2 md2 lg2 xl1>
                    <v-img v-if="trip.places[0].image_url" right max-height="100px" min-height="100px"  :src="pastTripPhoto()"></v-img>
                </v-flex>
                <v-flex xs8>
                    <h4 @click="routeSingle()" class="pl-3">{{trip.title}}</h4>
                    <p class="pl-3" v-if="trip.start_date !== null && trip.end_date !== null">{{trip.start_date.split('T')[0] +"  -  " + trip.end_date.split('T')[0]}}</p>
                    <v-avatar class="ml-2" size="36px" v-for="(n,index) in trip.users" :key="index" :id="'id--' + n.id + trip.id">
                    </v-avatar>
                </v-flex>

        </v-layout>
    </v-container>
</template>

<script>
    import store from '../store'
    import router from '../router'
    import axios from 'axios'
    import Vue from 'vue'
    import * as filestack from 'filestack-js'

    export default {
        name: "PastTrip",
        props:{
            trip: Object,
        },
        methods:{
            async getPlace(place, index){
                await axios({
                    method: 'GET',
                    url: '/place',
                    params: {
                        id: place
                    }
                }).then(res => {
                    Vue.set(this.trip.places,index,res.data)
                })
            },

            async getUser(user, index){
                await axios({
                    method: 'GET',
                    url: '/user',
                    params: {
                        id: user
                    }
                }).then(res => {
                    Vue.set(this.trip.users,index,res.data);
                    if(res.data.img_path !== undefined && res.data.img_path !== "") {
                        this.displayAvatar(res.data);
                    }
                })
            },

            displayAvatar(user){
                    const apikey = 'AsNx10Lk3SEiGRvMmw223z';
                    const client = filestack.init(apikey);

                    let handler = user.img_path;
                    client.retrieve(handler).then((blob) => {
                        let imgLocation = document.getElementById('id--' + user.id + this.trip.id);
                        const urlCreator = window.URL || window.webkitURL;
                        const img = document.createElement('img');
                        img.src = urlCreator.createObjectURL(blob);
                        img.height = 36;
                        img.width = 36;
                        imgLocation.appendChild(img);
                    }).catch((error) => {
                        console.error(error);
                    });
            },

            async routeSingle() {
                await store.commit('changeCurrentlyViewedTrip', this.trip);
                router.push('/itenerary')
            },
            pastTripPhoto() {
                if (this.trip.places[0].image_url !== undefined && this.trip.places[0].image_url !== null){
                    return this.trip.places[0].image_url;
                } else {
                    return "https://picsum.photos/100/100/?random";
                }
            }
        },
        mounted(){
             this.trip.places.forEach((place,index) => {
                if (place.id === undefined) {
                    this.getPlace(place, index);
                }
            });
            this.trip.users.forEach((user,index) => {
                if (user.id === undefined){
                    this.getUser(user, index);
                }else {
                    this.displayAvatar(user)
                }
            });
        }
    }
</script>

<style scoped>
   .white-background{
       background-color: white;
    }

    .avatar-margin{
        margin: 2px;

    }

   .zero-margin{
       margin: 0;
   }

    .margin {
        margin-left: 20px !important;
    }
</style>