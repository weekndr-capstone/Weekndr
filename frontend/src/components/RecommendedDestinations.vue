<template>
        <v-card color="white">
            <v-layout>
                 <v-flex xs4><v-img src="https://picsum.photos/311" height="100%" contain /></v-flex>
                     <v-flex xs8 align-self-center class="text-xs-center">
                             <h2>{{place.name}}</h2>
                 </v-flex>
             </v-layout>
         </v-card>
</template>


<script>
    export default {
        name: "RecommendedDestinations",
        props:{
            place: Object,
        }
    }
</script>

<style scoped>
    .white-background{
        background-color: red;
    }

</style>



