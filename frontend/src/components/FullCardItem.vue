<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-container>
        <v-layout row>
           <v-flex>
              <v-img :src="place.image_url"/>
           </v-flex>
           <v-flex>
              <v-card-title primary-title><span class="title"><a :href="place.url" target="_blank">{{place.name}}</a></span></v-card-title>
              <v-card-title>Address:{{place.location.address1}} City: {{place.location.city}}</v-card-title>
              <v-card-text>Phone: {{place.phone}}</v-card-text>
              <v-icon half-icon half-increment readonly color="green">{{place.price}}</v-icon>
              <v-rating v-model="place.rating" background-color="pink lighten-3" color="pink"></v-rating>
              <v-card-text>I am a really awesome Description</v-card-text>
           </v-flex>
        </v-layout>
            <v-layout row justify-center>
                <v-dialog v-model="dialog" persistent max-width="600px">
                    <template v-slot:activator="{ on }">
                        <v-btn outline color="indigo" dark v-on="on">Add to Itinerary</v-btn>
                    </template>
                    <v-tabs v-model="active">
                        <v-tab ripple>Create Trip</v-tab>
                        <v-tab ripple>Add to Itinerary</v-tab>
                        <v-tab-item>
                    <v-card>
                        <v-card-title class="pb-0">
                            <span class="headline">New Trip</span>
                        </v-card-title>
                            <v-container grid-list-md class="pt-0">
                                <v-card-text class="pl-0">We have the dates now we just need a little more information!</v-card-text>
                                <v-layout wrap>
                                    <v-flex xs12>
                                        <v-text-field v-model="trip.title" label="Title*" required></v-text-field>
                                    </v-flex>
                                    <v-flex xs12>
                                        <v-text-field v-model="trip.trip_description" label="Description*" required></v-text-field>
                                    </v-flex>
                                    <v-flex xs12>
                                        <h2>Invite Friends</h2>
                                        <v-text-field v-for="f in friends" :key="f" label="Friends Number*" hint="We will shoot them a text and help them join in on the fun"></v-text-field>
                                        <v-btn @click="addFriend()"><v-icon>person_add</v-icon></v-btn>
                                        <small v-if="!premium">*Add another friend</small>
                                        <small class="red--text" v-if="premium">*beyond 6 friends requires a premium account</small>
                                    </v-flex>
                                    <v-flex xs12>
                                        <h3>Upload Trip Photo</h3>
                                        <file-upload/>
                                    </v-flex>
                                </v-layout>
                            </v-container>
                            <small>*indicates required field</small>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="blue darken-1" flat @click="dialog = false">Close</v-btn>
                            <v-btn color="blue darken-1" flat @click="next">Next</v-btn>
                        </v-card-actions>
                    </v-card>
                   </v-tab-item>
                        <v-tab-item>
                            <v-card>
                            <v-layout column justify-center>
                               <v-card-title>
                                   <span class="headline">New Experience</span>
                               </v-card-title>
                               <v-card-text>
                                   <v-container grid-list-md>
                                       <v-layout wrap>
                                           <v-flex xs12>
                                               <v-text-field label="Description*" required></v-text-field>
                                           </v-flex>
                                           <v-flex xs12>
                                               <v-flex xs5 class="d-inline-block">
                                                   <v-menu v-model="menu1" :close-on-content-click="false" :nudge-right="40"
                                                           lazy transition="scale-transition" offset-y full-width min-width="290px">
                                                       <template v-slot:activator="{ on }">
                                                           <p>Date</p>
                                                           <v-text-field v-model="experience.event_date" label="yyyy/mm/dd" readonly v-on="on" solo></v-text-field>
                                                       </template>
                                                       <v-date-picker :min="Dates.start_date" v-model="chosenDate" @input="menu1 = false"></v-date-picker>
                                                   </v-menu>
                                               </v-flex>
                                           </v-flex>
                                       </v-layout>
                                   </v-container>
                                   <small>*indicates required field</small>
                               </v-card-text>
                               <v-card-actions>
                                   <v-spacer></v-spacer>
                                   <v-btn color="blue darken-1" flat @click="dialog = false">Close</v-btn>
                                   <v-btn color="blue darken-1" flat @click="saveExperience()">Save</v-btn>
                               </v-card-actions>
                            </v-layout>
                           </v-card>
                        </v-tab-item>
                    </v-tabs>
                </v-dialog>
            </v-layout>
    </v-container>
</template>

<script>
    import store from '../store'
    import FileUpload from "./FileUpload";
    import axios from 'axios'
    export default {
        name: "FullCardItem",
        components: {FileUpload},
        data(){
            return {
                place: store.state.singleResult,
                    // {location: {
                    // address1: 'hi'
                    // }},
                dialog:false,
                menu1: false,
                Dates: store.state.dates,
                active: null,
                friends: [1,2],
                premium: false,
                trip:{
                    id:'',
                    title: '',
                    location: store.state.location,
                    trip_description: '',
                    start_date: store.state.start_date,
                    end_date:store.state.end_date,
                    user_id: 1
                },
                experience:{
                 name: store.state.singleResult.name,
                 location: store.state.singleResult.address,
                 imgurl: store.state.singleResult.image_url,
                 event_date: '',
                 phone_number: store.state.singleResult.phone_number,
                 yelp_uniq: store.state.singleResult.id,
                 websiteurl: store.state.singleResult.url,
                 price: store.state.singleResult.price,
                 rating: store.state.singleResult.rating,
                 suggested: false,
                 trip_id: '',
                 user_id: store.state.user.id
                }
            }
        },
        methods:{
            async next () {
                const active = parseInt(this.active)
                this.active = (active < 2 ? active + 1 : 0)
                await axios(
                        {
                            method: 'POST',
                            url:'/trip',
                            headers: {'Content-Type': 'application/json'},
                            data: {
                                title: this.trip.title,
                                location: store.state.location,
                                trip_description: this.trip.trip_description,
                                start_date: store.state.start_date,
                                end_date:store.state.end_date,
                                created_at: new Date(),
                                user_id: {
                                    id: store.state.user.id,
                                }
                            }
                        })
                    .then(res => {
                        this.trip = res.data
                    }).catch(err => {
                        console.log(err)
                    })
            },
            addFriend(){
                if (this.friends.length < 6){
                    this.friends.push(this.friends.length +1);
                    this.premium = false;
                }else{
                    this.premium = true;
                }
            },
            saveExperience(){

            }
        }
    }
</script>

<style scoped>

</style>