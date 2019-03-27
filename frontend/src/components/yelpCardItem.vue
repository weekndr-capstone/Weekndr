<template>
    <v-card light>
        <v-img
                height="13em" :src="card.image_url"
        ></v-img>
        <v-card-title>
                <!--<v-layout justify-start row>-->
                    <!--<span class="title mb-0 ml-2 vCardText" @click="routeSingle()">{{card.name}}</span>-->
                    <!--<v-icon half-icon half-increment readonly color="green" class="ml-2">{{card.price}}</v-icon>-->
                <!--</v-layout>-->
                <!--<v-layout justify-end row>-->
                    <!--<v-rating v-model="card.rating" readonly background-color="#89B6BE" color="#E96445" height="20px"></v-rating>-->
                <!--</v-layout>-->
            <div>
                <h3 class="headline mb-0 text-truncate"><span class="title mb-0 ml-2 vCardText text-truncate" @click="routeSingle()">{{card.name}}</span>
                    <v-icon half-icon half-increment readonly color="green" class="ml-2">{{card.price}}</v-icon></h3>
                <div><v-rating v-model="card.rating" readonly background-color="#89B6BE" color="#E96445" height="20px"></v-rating></div>
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
        width: 12em;
    }
</style>