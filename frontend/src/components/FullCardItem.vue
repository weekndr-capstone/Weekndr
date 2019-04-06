<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-container>
        <v-layout>
            <v-flex xs12 sm10 offset-sm1>
                <v-img :src="place.image_url" aspect-ratio="2"/>
            </v-flex>
        </v-layout>
        <v-layout row>
                <v-flex xs10 offset-sm1 offset-xs-1>
                    <v-card-title primary-title><span class="display-1 font-weight-bold text-xs-center align-content-center"><a :href="place.url" target="_blank">{{place.name}}</a></span></v-card-title>
                </v-flex>
        </v-layout>
            <v-layout row wrap>
                <v-flex xs12 sm5 offset-sm1 offset-xs-2>
                    <v-card-text class="title header-font">Address:</v-card-text><v-card-text class="subheading font-weight-light pt-0">{{place.location.address1}}</v-card-text>
                </v-flex>
                <v-flex xs12 sm5 offset-xs-2>
                    <v-card-text class="title header-font">City:</v-card-text><v-card-text class="subheading font-weight-light pt-0"> {{place.location.city}}</v-card-text>
                </v-flex>
                <v-flex xs12 sm5 offset-sm1 offset-xs-2>
                    <v-card-text class="title header-font">Phone:</v-card-text><v-card-text class="subheading font-weight-light pt-0"> {{place.phone}}</v-card-text>
                </v-flex>
                <v-flex xs12 sm5 offset-xs-2>
                    <v-card-text class="title header-font">Rating:</v-card-text><v-rating v-model="place.rating" readonly background-color="#F6EFE4" color="#E96445" class="ml-1 pt-0"></v-rating>
                </v-flex>
                <v-flex xs12 sm5 offset-sm1 offset-xs-2>
                    <v-card-text class="title header-font">Price:</v-card-text><v-icon half-icon half-increment readonly color="green" class="ml-3 pt-0 pb-4">{{place.price}}</v-icon>
                </v-flex>

            </v-layout>
        <v-layout row xs10 sm6>
            <v-dialog v-model="dialog" persistent max-width="600px">
                <template v-slot:activator="{ on }">
                    <v-flex xs12 sm5 offset-sm1 offset-xs-2>
                        <v-btn outline color="#E96445" flat v-on="on" >Add to Itinerary</v-btn>
                    </v-flex>
                </template>
                <v-tabs v-model="active" slider-color="#E96445">
                    <v-tab v-if="currentViewedTrip === ''" ripple>Create Trip</v-tab>
                    <v-tab ripple>Add to Itinerary</v-tab>
                    <v-tab-item v-if="currentViewedTrip === ''">
                        <v-card>
                            <v-card-title class="pb-0">
                                <span class="headline">New Trip</span>
                            </v-card-title>
                            <v-container grid-list-md class="pt-0">
                                <v-card-text class="pl-0">We have the dates now we just need a little more information!</v-card-text>
                                <v-form ref="form" v-model="valid" lazy-validation>
                                    <v-layout wrap>
                                        <v-flex xs12>
                                            <v-text-field v-model="trip.title" label="Title*" required :rules="titleRules"></v-text-field>
                                        </v-flex>
                                        <v-flex xs12>
                                            <v-text-field v-model="trip.trip_description" label="Description*" required :rules="desRules"></v-text-field>
                                        </v-flex>
                                        <v-flex xs12>
                                            <h2>Send Invites</h2>
                                            <v-text-field v-for="f in friends" :key="f" label="Friends Number*" hint="We will shoot them a text and help them join in on the fun" v-model="f.phoneNumber" :rules="phoneRules"></v-text-field>
                                            <v-btn outline color="#E96445" flat @click="addFriend()"><v-icon>person_add</v-icon></v-btn>
                                            <v-btn outline color="#E96445" flat @click="inviteFriends()" solo>Invite all Friends</v-btn>
                                            <small v-if="!premium">*Add another friend</small>
                                            <small class="red--text" v-if="premium">*beyond 6 friends requires a premium account</small>
                                        </v-flex>
                                    </v-layout>
                                </v-form>
                            </v-container>
                            <small>*indicates required field</small>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn outline color="#E96445" flat @click="dialog = false">Close</v-btn>
                                <v-btn outline color="#E96445" flat @click="next">Next</v-btn>
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
                                            <!-- NOT HOTEL-->
                                            <v-flex v-if="hotel === false" xs12>
                                                <v-form ref="form2" v-model="valid2" lazy-validation>
                                                <v-flex xs12>
                                                    <v-text-field v-model="experience.description" label="Description*" required :rules="desRules"></v-text-field>
                                                </v-flex>
                                                <v-flex xs5 class="d-inline-block">
                                                    <v-menu v-model="menu1" :close-on-content-click="false" :nudge-right="40"
                                                            lazy transition="scale-transition" offset-y full-width min-width="290px">
                                                        <template v-slot:activator="{ on }">
                                                            <p>Date</p>
                                                            <v-text-field v-model="eDate" label="yyyy/mm/dd" readonly v-on="on" solo required :rules="eventRules"></v-text-field>
                                                        </template>
                                                        <v-date-picker :min="Dates.start_date" :max="Dates.end_date" v-model="eDate" @input="menu1 = false"></v-date-picker>
                                                    </v-menu>
                                                </v-flex>

                                                <v-flex xs5 class="d-inline-block">
                                                    <v-menu v-model="menu2" :close-on-content-click="false" :nudge-right="40"
                                                            lazy transition="scale-transition" offset-y full-width min-width="290px">
                                                        <template v-slot:activator="{ on }">
                                                            <p>Time</p>
                                                            <v-text-field v-model="eTime" label="00:00" readonly v-on="on" solo required :rules="timeRules"></v-text-field>
                                                        </template>
                                                        <v-time-picker  v-model="eTime" type="month" width="290" @input="menu2 = false"></v-time-picker>
                                                    </v-menu>
                                                </v-flex>
                                                </v-form>
                                            </v-flex>
                                            <!--HOTEL-->
                                                <v-flex v-if="hotel === true" xs12>
                                                    <v-form ref="form2" v-model="valid2" lazy-validation>
                                                    <v-flex xs12>
                                                        <v-text-field v-model="experience.description" label="Description*" required :rules="desRules"></v-text-field>
                                                    </v-flex>
                                                        <v-flex xs5 class="d-inline-block">
                                                            <v-menu v-model="menu3" :close-on-content-click="false" :nudge-right="40"
                                                                    lazy transition="scale-transition" offset-y full-width min-width="290px">
                                                                <template v-slot:activator="{ on }">
                                                                    <p>Check-In Date</p>
                                                                    <v-text-field v-model="checkIn" label="yyyy/mm/dd" readonly v-on="on" solo required :rules="checkinRules"></v-text-field>
                                                                </template>
                                                                <v-date-picker :min="Dates.start_date" :max="Dates.end_date" v-model="checkIn" @input="menu3 = false"></v-date-picker>
                                                            </v-menu>
                                                        </v-flex>
                                                        <v-flex xs5 class="d-inline-block">
                                                            <v-menu v-model="menu4" :close-on-content-click="false" :nudge-right="40"
                                                                    lazy transition="scale-transition" offset-y full-width min-width="290px">
                                                                <template v-slot:activator="{ on }">
                                                                    <p>Check-Out Date</p>
                                                                    <v-text-field v-model="checkOut" label="yyyy/mm/dd" readonly v-on="on" solo required :rules="checkoutRules"></v-text-field>
                                                                </template>
                                                                <v-date-picker :min="checkIn" :max="Dates.end_date"  v-model="checkOut"  @input="menu4 = false"></v-date-picker>
                                                            </v-menu>
                                                        </v-flex>
                                                    </v-form>
                                                </v-flex>
                                        </v-layout>
                                   </v-container>
                                   <small>*indicates required field</small>
                               </v-card-text>
                               <v-card-actions>
                                   <v-spacer></v-spacer>
                                   <v-btn outline color="#E96445" flat @click="dialog = false">Close</v-btn>
                                   <v-btn outline color="#E96445" flat @click="saveExperience()">Save</v-btn>
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
    import router from '../router'
    //TODO: drastically reduce components size

    export default {
        name: "FullCardItem",
        components: {FileUpload},
        data(){
            return {
                place: store.state.singleResult,
                dialog: false,
                menu1: false,
                eDate: null,
                menu2: false,
                eTime: null,
                menu3: false,
                checkIn: null,
                menu4: false,
                checkOut: null,
                valid: true,
                valid2:true,
                valid3:true,
                eventRules: [
                    v => !!v || 'Event Date is required'
                ],
                desRules: [
                    v => !!v || 'Event Description is required'
                ],
                titleRules: [
                    v => !!v || 'Event Description is required'
                ],
                timeRules: [
                    v => !!v || 'Time is required'
                ],
                checkinRules: [
                    v => !!v || 'CheckIn Date is required'
                ],
                checkoutRules: [
                    v => !!v || 'CheckOut Date is required'
                ],

                Dates: store.state.dates,
                active: null,
                friends: [],
                premium: false,
                fromNumber: '',
                currentViewedTrip: store.state.currentViewedTrip,
                trip:{
                    id:'',
                    title: '',
                    location: store.state.location,
                    trip_description: '',
                    start_date: store.state.start_date,
                    end_date:store.state.end_date,
                    user: store.state.user.id
                },
                experience:{
                    name: store.state.singleResult.name,
                    address: store.state.singleResult.location.address1,
                    image_url: store.state.singleResult.image_url,
                    phone_number: store.state.singleResult.phone,
                    yelp_uniq: store.state.singleResult.id,
                    websiteurl: store.state.singleResult.url,
                    price: store.state.singleResult.price,
                    rating: store.state.singleResult.rating,
                    suggested: false,
                    description: '',
                    user: store.state.user.id
                }
            }
        },
        props:{
            hotel: Boolean
        },
        computed:{

            //returns current even format
            event_date(){
                if (this.eDate !== null) {
                    return this.eDate +"T" + this.eTime
                }else{
                    return null
                }
            },
        },
        methods:{

            //validates inputs
            validate () {
                this.valid = !!this.$refs.form.validate();
            },

            //validates inputs
            validate2 () {
                this.valid2 = !!this.$refs.form2.validate();
            },

            //validates inputs on trip creation
            async next () {
                this.validate();
                if (this.valid) {
                    const active = parseInt(this.active);
                    this.active = (active < 2 ? active + 1 : 0);
                    await axios(
                        {
                            method: 'POST',
                            url: '/trip',
                            headers: {'Content-Type': 'application/json'},
                            data: {
                                title: this.trip.title,
                                location: store.state.location,
                                trip_description: this.trip.trip_description,
                                start_date: store.state.dates.start_date,
                                end_date: store.state.dates.end_date,
                                created_at: new Date(),
                                user: {
                                    id: store.state.user.id,
                                },
                                users: this.friends
                            }
                        })
                        .then(res => {
                            this.trip = res.data;
                            store.state.user.trips.push(res.data);
                            store.commit('changeCurrentlyViewedTrip', res.data);
                            console.log(res.data)
                        }).catch(err => {
                            console.log(err)
                        })
                }
            },

            //adds a friend input up to a certain value
            addFriend(){
                if (this.friends.length < 6){
                    this.friends.push({phoneNumber: ''});
                    this.premium = false;
                }else{
                    this.premium = true;
                }
            },

            //sends twilio request for each phone number
            //TODO:rework how this is running
            inviteFriends(){
                this.friends.forEach((e) => {
                    console.log(e);
                    axios({
                        method: 'POST',
                        url:'/twilio',
                        headers: {'Content-Type': 'application/json'},
                        params: {
                            friends: e.phoneNumber,
                            fromNumber: store.state.user.phoneNumber
                        }
                    })
                        .then(response => {
                            console.log(response);
                        })
                        .catch(error => {
                            console.log(error);
                        });
                })},

            //saves experience to database using post request
            async saveExperience(){
                this.validate2();
                if (this.valid2) {
                    await axios(
                        {
                            method: 'POST',
                            url: '/place',
                            headers: {'Content-Type': 'application/json'},
                            data: {
                                name: this.experience.name,
                                address: this.experience.address,
                                image_url: this.experience.image_url,
                                event_date: this.event_date,
                                checkin_date: this.checkIn,
                                checkout_date: this.checkOut,
                                phone_number: this.experience.phone_number,
                                yelp_uniq: this.experience.yelp_uniq,
                                websiteURL: this.experience.websiteurl,
                                price: this.experience.price,
                                rating: this.experience.rating,
                                suggested: !store.state.mainUser,
                                description: this.experience.description,
                                created_at: new Date(),
                                user: {
                                    id: this.experience.user,
                                },
                                trip: {
                                    id: store.getters.currentViewedTrip.id
                                },
                            }
                        })
                        .then(res => {
                            this.experience = res.data;
                            store.state.user.trips.filter((trip, index) => {
                                if (trip.id === store.getters.currentViewedTrip.id) {
                                    store.state.user.trips[index].places.push(res.data);
                                }
                            });
                            this.dialog = false;
                            router.push('/itenerary');
                        }).catch(err => {
                            console.log(store.state.currentViewedTrip);
                            console.log(this.experience.trip);
                            console.log(err)
                        })
                }
            }
        }
    }
</script>

<style scoped>
    a {
        color: #E96445;
        text-decoration: none;
    }

    .header-font{
        font-family: 'Quicksand', sans-serif !important;
        font-weight: bold;
        color: black;
                /*#E96445*/
    }


</style>