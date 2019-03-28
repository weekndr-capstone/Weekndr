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
    import RecommendedDestinations from "../components/RecommendedDestinations";

  export default {
    data(){
        return {
            randomIndex1: null,
            randomIndex2: null,
            randomIndex3: null,

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
                {id: 10, name: 'New york', url: 'NewYork.jpg'},
                {id: 11, name: 'Lisbon', url: 'Lisbon.jpg'},
                {id: 12, name: 'Sayulita', url: 'Sayulita.jpg'},
            ],
        }
    },
      mounted () {
          store.commit('changeCurrentlyViewedTrip', '');

          this.randomIndex1 = Math.floor(Math.random() * 4);
          this.randomIndex2 = Math.floor(Math.random() * 4) + 4;
          this.randomIndex3 = Math.floor(Math.random() * 4) + 8;
      },
    components: {
        RecommendedDestinations,
        Banner,
    },
    computed: {
        userTrips(){
            return store.getters.user
        }
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
