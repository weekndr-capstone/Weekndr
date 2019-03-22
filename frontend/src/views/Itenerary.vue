<template>
    <div>
        <Toolbar/>
        <v-item-group>
            <v-container grid-list-md>
                <v-layout style="overflow-x: scroll;">
                    <v-flex v-for="t in tabs" :key="t.id">
                        <v-item>
                            <FHEBlock :place="t"/>
                        </v-item>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-item-group>
        <Timeline/>
        <h1>Trip Suggestions</h1>
        <v-item-group>
            <v-container grid-list-md>
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
                        url: 'food.jpg'
                    },
                    {
                        id:2,
                        name: 'Hotel',
                        url: 'hotel.jpg'
                    },
                    {
                        id:3,
                        name: 'Experience',
                        url: 'experience.jpg'
                    }
                ],
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
                console.log(res.data);
                store.commit('changeMainUser', res.data);
            }).catch(err => {
                console.log(err)
            });
        }
    }
</script>

<style scoped>

</style>