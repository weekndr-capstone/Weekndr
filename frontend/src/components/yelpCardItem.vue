<template>
    <v-card>
        <v-img class="white--text" height="200px" :src="card.image_url">
            <v-container fill-height fluid>
                <v-layout fill-height>
                </v-layout>
            </v-container>
        </v-img>
        <v-card-actions>
            <v-flex xs12 align-end flexbox>
                <span @click="routeSingle()">"{{card.name}}</span>
                <v-icon half-icon half-increment readonly color="green">{{card.price}}</v-icon>
                <v-rating v-model="card.rating" readonly background-color="pink lighten-3" color="pink"></v-rating>
            </v-flex>
        </v-card-actions>
    </v-card>
</template>

<script>
    import store from '../store'
    import router from '../router'
    export default {
        name: "yelpCardItem",
        data() {
            return {
            }
        },
        props:{
            card: Object,
            hotel: Boolean
        },
        methods: {
            async routeSingle() {
                if (this.hotel === true){
                    await store.commit('changeSingleResult', this.card);
                    router.push({
                        name: 'single',
                        params: {
                            hotel: true
                        }
                    })
                } else {
                    await store.commit('changeSingleResult', this.card);
                    router.push({
                        name: 'single',
                        params: {
                            hotel: false
                        }
                    })
                }
            }
        }
    }
</script>

<style scoped>

</style>