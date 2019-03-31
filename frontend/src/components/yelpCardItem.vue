<template>
    <v-card light class="overflow-x-hidden">
        <v-img
                height="13em" :src="card.image_url"
        ></v-img>
        <v-card-title class="overflow-y-hidden">
            <div>
                <h3 class="headline mb-0"><span class="title mb-0 ml-2 vCardText" @click="routeSingle()">{{card.name}}</span>
                    <v-icon half-icon half-increment readonly color="green" class="ml-2">{{card.price}}</v-icon></h3>
                <div><v-rating v-model="card.rating" readonly background-color="#F6EFE4" color="#E96445" height="20px" class="overflow-x-hidden"></v-rating></div>
            </div>
        </v-card-title>
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
    .vCardText {
        font-family: 'Nunito Sans', sans-serif;
        cursor: pointer;
    }
    .v-card__title--primary, .v-card__title {
        padding: 0 !important;
    }
    .v-icon {
        height: 37px;
    }
    .mb-0 {
        width: 10em;
    }
    .v-card {
        height: 21em;
    }
    @media only screen and (max-width: 500px) {
        .v-card {
            width: 9em;
        }
    }
    @media only screen and (max-width: 600px) and (min-width: 500px) {
        .v-card {
            width: 11em;
        }
    }
    @media only screen and (max-width: 720px) and (min-width: 600px) {
        .v-card {
            width: 15em;
        }
    }
    @media only screen and (max-width: 800px) and (min-width: 750px) {
        .v-card {
            width: 15em;
        }
    }
    @media only screen and (min-width: 800px) and (max-width: 1000px) {
        .v-card {
            width: 19em;
        }
    }
</style>