<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">

    <v-timeline>
        <v-timeline-item v-for="n in trip" :key="n.id" color="black lighten-2" small>
            <template v-slot:opposite>
                <span>{{n.name}}</span>
            </template>
            <CardItem :card="n" />
        </v-timeline-item>
    </v-timeline>
</template>

<script>
    import CardItem from './CardItem';
    import store from '../store';

    export default {
        name: "Timeline",
        components: {CardItem},
        data(){
            return{
            }
        },
        computed: {
            trip(){
                return store.state.currentViewedTrip.places.filter(place => {
                    if (place.suggested === false){
                        return place;
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>