<template>
    <div>
        <Toolbar/>
        <v-item-group>
            <v-container grid-list-md>
                <v-layout wrap>
                    <v-flex v-for="t in tabs" :key="t.id" xs4 md4>
                        <v-item>
                            <RecommendedDestinations :place="t"/>
                        </v-item>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-item-group>
        <Timeline/>
    </div>
</template>

<script>
    import Timeline from "../components/Timeline";
    import Toolbar from '../components/Toolbar';
    import RecommendedDestinations from '../components/RecommendedDestinations'

    export default {
        name: "Itenerary",
        components: {
            Timeline,
            Toolbar,
            RecommendedDestinations
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
                ]
            }
        }
    }
</script>

<style scoped>

</style>