<template>
    <v-container>
        <v-layout row wrap class="white-background" elevation-1>
                <v-flex class="zero-margin" xs3 sm2 md2 lg2 xl1>
                    <v-img max-height="100px" max-width="100px" src="https://picsum.photos/300"></v-img>
                </v-flex>
                <v-flex m0 xs8 sm7 md8 lg8 xl10 mx-2>
                    <v-flex xs5>
                    <h4>Trip Title</h4>
                    </v-flex>
                    <v-flex xs5>
                        <p>dates here</p>
                    </v-flex>
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
        /*margin: 5px;*/

    }
</style>