<template>
    <v-container>
        <v-layout row class="white-background">
                <v-flex xs3>
                    <v-img src="https://picsum.photos/300"></v-img>
                </v-flex>
                <v-flex xs9 mx-2>
                    <v-card-title>Trip Title</v-card-title>
                    <v-card-text>dates here</v-card-text>
                    <v-card-text>Trip descrption here</v-card-text>
                    <v-avatar  class="avatar-margin" size="36px" v-for="n in 6" :key="n">
                        <img ml-50 src="https://cdn.vuetifyjs.com/images/john.jpg" alt="John">
                    </v-avatar>
                </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    export default {
        name: "PastTrip"
    }
</script>

<style scoped>
   .white-background{
       background-color: white;
    }

    .avatar-margin{
        margin-left: 20px;
    }
</style>