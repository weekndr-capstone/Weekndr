<template>
    <div>
        <Banner/>
        <v-container grid-list-md>
            <h2 class="orange-text">Recommended for you</h2>
            <v-layout row wrap>
                <v-flex xs12 sm6 md4 class="zero-padding">
                    <v-card xs12 class="margin">
                        <RecommendedDestinations v-if="places[randomIndex1]" :place="places[randomIndex1]"  />
                    </v-card>
                </v-flex>
                <v-flex xs12 sm6 md4 class="zero-padding">
                    <v-card xs12 class="margin">
                        <RecommendedDestinations v-if="places[randomIndex2]" :place="places[randomIndex2]"  />
                    </v-card>
                </v-flex>
                <v-flex xs12 sm12 md4 class="zero-padding">
                    <v-card xs12 class="margin">
                        <RecommendedDestinations v-if="places[randomIndex3]" :place="places[randomIndex3]"  />
                    </v-card>
                </v-flex>
            </v-layout>
        </v-container>
    </div>
</template>


<script>
    import Banner from '../components/Banner'
    import store from '../store'
    import RecommendedDestinations from "../components/RecommendedDestinations"
    import CardCarousel from "../components/CardCarousel"

  export default {
    components: {
        RecommendedDestinations,
        Banner,
        CardCarousel
    },
    data(){
        return {
            randomIndex1: null,
            randomIndex2: null,
            randomIndex3: null,
            test:[
                  {name: 'TEST1', image_url: 'g', id: 11, price: '$$', rating: 4.5},
                  {name: 'TEST2', image_url: 'g', id: 12, price: '$$', rating: 4.5},
                  {name: 'TEST3', image_url: 'g', id: 13, price: '$$', rating: 4.5},
                  {name: 'TEST1', image_url: 'g', id: 14, price: '$$', rating: 4.5},
                  {name: 'TEST2', image_url: 'g', id: 15, price: '$$', rating: 4.5},
                  {name: 'TEST3', image_url: 'g', id: 16, price: '$$', rating: 4.5},
                  {name: 'TEST1', image_url: 'g', id: 17, price: '$$', rating: 4.5},
                  {name: 'TEST2', image_url: 'g', id: 18, price: '$$', rating: 4.5},
                  {name: 'TEST3', image_url: 'g', id: 19, price: '$$', rating: 4.5},
                  {name: 'TEST1', image_url: 'g', id: 10, price: '$$', rating: 4.5},
                  {name: 'TEST2', image_url: 'g', id: 1, price: '$$', rating: 4.5},
                  {name: 'TEST3', image_url: 'g', id: 2, price: '$$', rating: 4.5},
                  {name: 'TEST1', image_url: 'g', id: 3, price: '$$', rating: 4.5},
                  {name: 'TEST2', image_url: 'g', id: 4, price: '$$', rating: 4.5},
                  {name: 'TEST3', image_url: 'g', id: 5, price: '$$', rating: 4.5},
                  {name: 'TEST1', image_url: 'g', id: 6, price: '$$', rating: 4.5},
                  {name: 'TEST2', image_url: 'g', id: 7, price: '$$', rating: 4.5},
                  {name: 'TEST3', image_url: 'g', id: 8, price: '$$', rating: 4.5},
                ],

            places:[
                {id: 1, name: 'London', url: 'London.jpg'},
                {id: 2, name: 'Boston', url: 'Boston.jpg'},
                {id: 3, name: 'Tokyo', url: 'Tokyo.jpg'},
                {id: 4, name: 'Barcelona', url: 'Barcelona.jpg'},

                {id: 5, name: 'Chicago', url: 'Chicago.jpg'},
                {id: 6, name: 'Paris', url: 'Paris.jpg'},
                {id: 7, name: 'Berlin', url: 'Berlin.jpg'},
                {id: 8, name: 'Amsterdam', url: 'Amsterdam.jpg'},

                {id: 9, name: 'Toronto', url: 'Toronto.jpg'},
                {id: 10, name: 'New York', url: 'NewYork.jpg'},
                {id: 11, name: 'Lisbon', url: 'Lisbon.jpg'},
                {id: 12, name: 'Sayulita', url: 'Sayulita.jpg'},
            ],
        }
    },
    computed: {
        userTrips(){
            return store.getters.user
        }
    },
    mounted () {
        store.commit('changeCurrentlyViewedTrip', '');

        this.randomIndex1 = Math.floor(Math.random() * 4);
        this.randomIndex2 = Math.floor(Math.random() * 4) + 4;
        this.randomIndex3 = Math.floor(Math.random() * 4) + 8;
    }
  }
</script>
<style>
    .fade-out {
        visibility: hidden;
        opacity: 0;
        transition: visibility 0s 2s, opacity 2s linear;
    }

    .margin {
        margin-left: 1em;
        margin-right: 1em;
        margin-bottom: 1em;
    }

    .zero-padding {
        padding: 0;
    }

    .orange-text {
        color: #E96445;
        margin-bottom: 1em;
    }
</style>
