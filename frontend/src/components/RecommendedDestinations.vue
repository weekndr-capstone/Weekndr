<template>
        <v-card color="white">
            <v-layout wrap>
                 <v-flex xs4><v-img :src="getImgUrl(place.url)" height="80px" width="80px" contain /></v-flex>
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
        },
        methods:{
            getImgUrl(pic) {
                if (pic == null){
                    return require('../assets/weekdnr_logo.svg')
                }
                return require('../assets/'+ pic)
            }
        }
    }
</script>

<style scoped>
    .white-background{
        background-color: red;
    }

</style>



