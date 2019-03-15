<template>
    <v-container>
        <v-layout row class="white-background">
            <v-flex xs3>
                <v-img src="https://picsum.photos/311"></v-img>
            </v-flex>
            <v-flex xs9 mx-2>
                <v-card-title><h1>Destination City Name</h1></v-card-title>
            </v-flex>
        </v-layout>
    </v-container>
</template>


<script>
    export default {
        name: "RecommendedDestinations"
    }
</script>

<style scoped>
    .white-background{
        background-color: white;
    }

</style>



