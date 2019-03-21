<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
<v-container fill-height fluid>
        <v-layout justify-center>
            <v-card height="400px" xs12>
                <v-container fill-height>
                    <v-layout align-center justify-center>
                        <v-card-text>
                            <v-flex offset-xs1 class="mt-2">
                            <h1>Search a Destination</h1>
                            </v-flex>
                            <v-flex xs10 offset-xs1>
                                <v-divider></v-divider>
                                <h4 class="font-weight-bold mt-3 mb-4">Where</h4>
                                <v-text-field :ref="autocomplete" class="search-location"onfocus="value = ''"  v-model="Where" placeholder="Where" required solo
                                ></v-text-field>
                            </v-flex>
                            <v-flex xs5 offset-xs1 class="d-inline-block">
                                <v-menu v-model="menu1" :close-on-content-click="false" :nudge-right="40"
                                        lazy transition="scale-transition" offset-y full-width min-width="290px">
                                    <template v-slot:activator="{ on }">

                                        <p class="font-weight-bold">Start Date</p>
                                        <v-text-field v-model="Dates.Start" label="yyyy/mm/dd" readonly v-on="on" solo></v-text-field>

                                    </template>
                                    <v-date-picker :min="minDate" v-model="Dates.Start" @input="menu1 = false"></v-date-picker>
                                </v-menu>
                            </v-flex>
                            <v-flex xs5 class="d-inline-block">
                                <v-menu v-model="menu2" :close-on-content-click="false" :nudge-right="40"
                                        lazy transition="scale-transition" offset-y full-width min-width="290px">
                                    <template v-slot:activator="{ on }">
                                        <p class="font-weight-bold">End Date</p>
                                        <v-text-field
                                                v-model="Dates.End"
                                                label="yyyy/mm/dd"
                                                readonly
                                                v-on="on"
                                                solo
                                        ></v-text-field>
                                    </template>
                                    <v-date-picker :min="Dates.Start" v-model="Dates.End" @input="menu2 = false"></v-date-picker>
                                </v-menu>
                            </v-flex>
                            <v-flex offset-xs8>
                                <v-btn @click="searchLocation()" color="info">Search</v-btn>
                            </v-flex>
                        </v-card-text>
                    </v-layout>
                </v-container>
            </v-card>
        </v-layout>
</v-container>
</template>

<script>
    import store from '../store'
    import router from '../router'
    import axios from 'axios'
    
    let today= new Date();
    let dd = today.getDate();
    let mm = today.getMonth() + 1; //January is 0!
    let yyyy = today.getFullYear();

    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }
    today = yyyy + '-' + mm + '-' + dd;

    export default {
        name: "SearchCard",
        data(){
            return{
                Where: '',
                Dates:{
                    Start: '',
                    End: ''
                },
                minDate: today,
                minEndDate: '',
                menu1: false,
                menu2: false
            }
        },
        methods: {
            async searchLocation(){
                store.commit('changeLocation', this.Where);
                store.commit('changeStartDate', this.Dates.Start);
                store.commit('changeEndDate', this.Dates.End);
                await axios.all([
                    axios.get('/yelpList/'+ store.state.location + "/4"),
                    axios.get('/yelpList/'+ store.state.location + "/1"),
                    axios.get('/yelpList/' + store.state.location + "/2"),
                    axios.get('/yelpList/' + store.state.location + "/3"),
                    ]).then(axios.spread((suggestedRes, experiencesRes, foodRes, hotelRes) =>{
                    store.commit('changeSuggestedResults', suggestedRes.data.businesses);
                    store.commit('changeFoodResults', experiencesRes.data.businesses);
                    store.commit('changeExperiencesResults', foodRes.data.businesses);
                    store.commit('changeHotelResults', hotelRes.data.businesses);
                    console.log(suggestedRes, experiencesRes, foodRes, hotelRes)
                }));

                router.push('/search');
            },
                initialize() {
                    var input = document.getElementById('searchTextField');
                    new google.maps.places.Autocomplete(input);
                }
        },
        mounted() {
            let AutoComplete = document.createElement('script');
            AutoComplete.setAttribute('src', 'https://maps.googleapis.com/maps/api/js?key=AIzaSyAih6iqhzWmzLIe11sF9yMDuwPhVyFYP2w&libraries=places"');
            AutoComplete.async = true;

            this.autocomplete = new google.maps.places.Autocomplete(
                (this.$refs.autocomplete),
                {types: ['geocode']}
            );
            this.autocomplete.addListener('place_changed', () => {
                let place = this.autocomplete.getPlace();
                let ac = place.address_components;
                let lat = place.geometry.location.lat();
                let lon = place.geometry.location.lng();
                let city = ac[0]["short_name"];

                console.log(`The user picked ${city} with the coordinates ${lat}, ${lon}`);
            });
        },
    }
</script>

<style scoped>

</style>