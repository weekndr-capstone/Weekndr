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
    </div>
</template>

<script>
    import Timeline from "../components/Timeline";
    import Toolbar from '../components/Toolbar';
    import RecommendedDestinations from '../components/RecommendedDestinations'
    import FHEBlock from "../components/FHEBlock";

    export default {
        name: "Itenerary",
        components: {
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
                ]
            }
        }
    }
</script>

<style scoped>

</style>