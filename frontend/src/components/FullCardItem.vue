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
                <v-card>
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
                                                <v-text-field v-model="chosenDate" label="yyyy/mm/dd" readonly v-on="on" solo></v-text-field>
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
                        <v-btn color="blue darken-1" flat @click="dialog = false">Save</v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </v-layout>
    </v-container>
</template>

<script>
    import store from '../store'
    export default {
        name: "FullCardItem",
        data(){
            return {
                place: store.state.singleResult,
                dialog:false,
                menu1: false,
                Dates: store.state.dates,
                chosenDate: '',
            }
        },
        computed:{

        }
    }
</script>

<style scoped>

</style>