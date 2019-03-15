<template>
    <v-container>
        <v-layout row wrap>
             <v-flex xs6 sm4 md3>
                 <v-card color="white">
                     <v-layout>
                          <v-flex xs4><v-img src="https://picsum.photos/311" height="100%" contain /></v-flex>
                              <v-flex xs8 align-self-center class="text-xs-center">
                                      <h2>City Name</h2>
                          </v-flex>
                      </v-layout>
                  </v-card>
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
        background-color: red;
    }

</style>



