<template>
    <v-container>
        <v-layout row wrap class="white-background" elevation-1>
                <v-flex class="zero-margin" xs3 sm2 md2 lg2 xl1>
                    <v-img right max-height="100px" min-height="100px"  src="https://picsum.photos/300"></v-img>
                </v-flex>
                <v-flex class="margin" xs8 sm7 md8 lg8 xl10>
                    <v-flex xs5>
                    <h4 @click="routeSingle()">{{trip.title}}</h4>
                    </v-flex>
                    <v-flex xs5>
                        <p v-if="trip.start_date !== null && trip.end_date !== null">{{trip.start_date.split('T')[0] +"  -  " + trip.end_date.split('T')[0]}}</p>
                    </v-flex>
                    <v-avatar  class="avatar-margin" size="36px" v-for="n in trip.users" :key="n">
                        <div :id="user.id"></div>
                    </v-avatar>
                </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    import store from '../store'
    import router from '../router'
    import * as filestack from 'filestack-js'
    import axios from 'axios'

    export default {
        name: "PastTrip",
        user: {
            img_path: '',
        },
        props:{
            trip: Object,
        },
        methods:{
            async routeSingle() {
                await store.commit('changeCurrentlyViewedTrip', this.trip);
                router.push('/itenerary')
            }
        },
        async mounted() {

            console.log(store.state.user.trips.users);
            console.log(this.trip);
            this.trips.users.forEach(user => {

            console.log("INSIDE DISPLAY AVATARS FOR EACH");

                axios({

                    method: 'GET',
                    url:'/user',
                    headers: {'Content-Type' : 'application/json'},
                    params:{
                        id: user.user_id,
                    }

                }).then(res => {

                    console.log(res.data);

                    this.user = res.data;

                        console.log(this.user);

                        const apikey = 'AsNx10Lk3SEiGRvMmw223z';
                        const client = filestack.init(apikey);

                        let handler = user.img_path;
                        console.log(handler);

                        client.retrieve(handler).then((blob) => {
                            console.log("Handler:" + handler);
                            let imgLocation = document.getElementById(`${user.id}`);
                            const urlCreator = window.URL || window.webkitURL;
                            const img = document.createElement('img');
                            console.log("HERE");
                            img.src = urlCreator.createObjectURL(blob);
                            img.style.height = '36px';
                            img.style.width = '36px';
                            imgLocation.appendChild(img);
                            console.log(imgLocation.appendChild(img));

                        }).catch((error) => {
                            console.error(error);
                        });
                    });
            })
        },
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