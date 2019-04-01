<template>
    <v-container>
        <v-layout row wrap class="white-background" elevation-1>
                <v-flex class="zero-margin" xs3 sm2 md2 lg2 xl1>
                    <v-img right max-height="100px" min-height="100px"  src="https://picsum.photos/300?random"></v-img>
                </v-flex>
                <v-flex class="margin" xs8 sm7 md8 lg8 xl10>
                    <v-flex xs5>
                    <h4 @click="routeSingle()">{{trip.title}}</h4>
                    </v-flex>
                    <v-flex xs5>
                        <p v-if="trip.start_date !== null && trip.end_date !== null">{{trip.start_date.split('T')[0] +"  -  " + trip.end_date.split('T')[0]}}</p>
                    </v-flex>
                    <v-avatar  class="avatar-margin" size="36px" v-for="(n,index) in trip.users" :key="index" :id="'id--' + n.id + trip.id">
                        <!--<v-avatar  id="avatar" class="avatar-margin" size="40px"/>-->
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
                        this.displayAvatar(res.data);
                })
            },

            displayAvatar(user){
                if(user.img_path !== undefined && user.img_path !== "") {
                    const apikey = 'AsNx10Lk3SEiGRvMmw223z';
                    const client = filestack.init(apikey);

                    let handler = user.img_path;
                    console.log(handler);
                    client.retrieve(handler).then((blob) => {
                        let imgLocation = document.getElementById('id--' + user.id + this.trip.id);
                        console.log(imgLocation);
                        const urlCreator = window.URL || window.webkitURL;
                        const img = document.createElement('img');
                        img.src = urlCreator.createObjectURL(blob);
                        img.height = 36;
                        img.width = 36;
                        imgLocation.appendChild(img);
                    }).catch((error) => {
                        console.error(error);
                    });
                }
            },

            async routeSingle() {
                await store.commit('changeCurrentlyViewedTrip', this.trip);
                router.push('/itenerary')
            },
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