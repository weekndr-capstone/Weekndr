<template>
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
                        <v-btn outline color="indigo">Add to Itinerary</v-btn>
                </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    import store from '../store'
    export default {
        name: "FullCardItem",
        data(){
            return {
                place: store.state.singleResult
            }
        },
        computed:{

        }
    }
</script>

<style scoped>

</style>