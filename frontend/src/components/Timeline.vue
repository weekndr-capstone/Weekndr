<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">

    <v-timeline>
        <v-timeline-item v-for="n in 4" :key="n" color="black lighten-2" small>
            <template v-slot:opposite>
                <span>Title of event here</span>
            </template>
            <CardItem :places="places" />
        </v-timeline-item>
    </v-timeline>

</template>

<script>
    import CardItem from "./CardItem";

    export default {
        name: "Timeline",
        components: {CardItem},
        data(){
            return{
                places:''
            }
        },
    }
</script>

<style scoped>

</style>