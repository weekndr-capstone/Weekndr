<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">

    <v-timeline>
        <v-timeline-item v-for="n in places" :key="n.id" color="black lighten-2" small>
            <template v-slot:opposite>
                <span>Title of event here</span>
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
        props:{

        },
        data(){
            return{
                places: [{
                    id: 1,
                    alias: 'Hello',
                    image_url:'Bob'
                },
                    {
                    id: 2,
                    alias: 'Hello',
                    image_url:'Bob'
                },
                    {
                    id: 3,
                    alias: 'Hello',
                    image_url:'Bob'
                },
                    {
                    id: 4,
                    alias: 'Hello',
                    image_url:'Bob'
                }
                ]
            }
        },
        computed: {
            trip(){
                return store.getters.currentlyViewedTrip
            }
        }
    }
</script>

<style scoped>

</style>