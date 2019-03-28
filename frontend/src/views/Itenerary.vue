<template>
    <div>
        <Toolbar/>
        <v-item-group>
            <v-container>
                <v-layout row>
                    <v-flex class="box" text-xs-center xs12 sm8 offset-sm2 md10 lg8 offset-lg2 offset-md1>
                        <h1 text-xs-center>{{trip.title}}</h1>
                        <h4 text-xs-center>{{trip.location}}</h4>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-item-group>
        <v-container>
            <Timeline class="itinerary" />
        </v-container>
        <v-container grid-list-md>
            <h2>What else would you like to add?</h2>
            <br/>
            <v-layout style="overflow-x: scroll;">
                <v-flex v-for="t in tabs" :key="t.id">
                    <v-item>
                        <FHEBlock :place="t"/>
                    </v-item>
                </v-flex>
            </v-layout>
        </v-container>
        <v-item-group>
            <v-container grid-list-md>
                <h2>Trip Suggestions</h2>
                <br/>
                <v-layout row style="overflow-x: scroll;">
                    <v-flex xs12 md4 v-for="n in suggested" :key="n.id">
                        <v-item>
                            <CardItem :card="n"/>
                        </v-item>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-item-group>
    </div>
</template>

<script>
    import Timeline from '../components/Timeline'
    import Toolbar from '../components/Toolbar'
    import FHEBlock from "../components/FHEBlock"
    import axios from 'axios'
    import store from '../store'
    import CardItem from "../components/CardItem";

    export default {
        name: "Itenerary",
        components: {
            CardItem,
            FHEBlock,
            Timeline,
            Toolbar,
        },
        data(){
            return {
                tabs: [
                    {
                        id: 1,
                        name: 'Food',
                        url: 'donut.jpg'
                    },
                    {
                        id:2,
                        name: 'Hotel',
                        url: 'hotel-pic.jpg'
                    },
                    {
                        id:3,
                        name: 'Experience',
                        url: 'art-balloon.jpg'
                    }
                ],
                trip: store.state.currentViewedTrip,
            }
        },
        computed:{
            suggested(){
                return store.state.currentViewedTrip.places.filter(place => {
                    if (place.suggested === true){
                        return place;
                    }
                })
            }
        },
        mounted(){
            axios({
                method: 'GET',
                url: '/checkUserMain',
                headers: {'Content-Type': 'application/json'},
                params: {
                    trip: store.state.currentViewedTrip.id,
                    user: store.state.user.id
                }
            }).then(res => {
                store.commit('changeMainUser', res.data);
            }).catch(err => {
                console.log(err)
            });
        }
    }
</script>

<style scoped>
    .itinerary{
        background-color: white;
    }
</style>