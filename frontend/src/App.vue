<template>
  <v-app>
    <router-view></router-view>
    <LoadingScreen v-if="isLoading"/>
  </v-app>
</template>

<script>

  import LoadingScreen from "./components/LoadingScreen";
  import {AxiosInstance as axios} from "axios";

  export default {
    name: 'App',
    components: {
      LoadingScreen
    },
    data () {
      return {
      }
    },
    computed:{ isLoading(){ return this.$store.getters.isLoading },
    watch: {
      $route(to, from) {
        document.title = to.meta.title || 'Weekndr';
      },
    },
      created(){
        this.axios.interceptors.request.use(function (config) {
          // Do something before request is sent
          this.$store.commit('isLoading', true);
          return config;
        }, function (error) {
          // Do something with request error
          this.$store.commit('isLoading', false);
          return Promise.reject(error);
        });

// Add a response interceptor
        this.axios.interceptors.response.use(function (response) {
          // Do something with response data
          this.$store.commit('isLoading', false);
          return response;
        }, function (error) {
          // Do something with response error
          this.$store.commit('isLoading', false);
          return Promise.reject(error);
        });
    }
    }
  }
</script>
<style>
  @import url("https://fonts.googleapis.com/css?family=Nunito+Sans|Quicksand");
  h1, h2, h3, h4, h5, h6, .v-btn__content, p, .v-toolbar__title, .v-tabs__item {
    font-family: 'Quicksand', sans-serif;
  }
  .display-1, .display-3, .title {
    font-family: 'Quicksand', sans-serif !important;
  }
  .v-btn__content {
    font-size: medium;
  }
  .v-btn:hover {
    transform: scale(1.07);
  }
  .v-input, .v-text-field, .v-timeline-item, .v-timeline-item__opposite, small, .v-card__text {
    font-family: 'Nunito Sans', sans-serif;
  }

  body {
    background-color: white;
  }

  h1 {
    color: #E96445;
  }

  .button-color {
    color: #E96445;
  }

  @media only screen and (min-width: 1264px) {
      .container {
          max-width: 1000px !important;
      }
  }
  @media only screen and (min-width: 1904px) {
      .container {
          max-width: 1200px !important;
      }
  }

</style>
