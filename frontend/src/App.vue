<template>
  <v-app>
    <router-view></router-view>
  </v-app>
</template>

<script>

  export default {
    name: 'App',
    components: {
    },
    data () {
      return {
      }
    },
    watch: {
        $route(to, from) {
            document.title = to.meta.title || 'Weekndr';
        },
    }
}
</script>
<style>
  @import url("https://fonts.googleapis.com/css?family=Nunito+Sans|Quicksand");
  h1, h2, h3, h4, h5, h6, .v-btn__content, p, .v-toolbar__title, .v-tabs__item {
    font-family: 'Quicksand', sans-serif;
  }
  .display-1 {
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
  /*.v-carousel__next, .v-carousel__prev {*/
    /*background-color: black;*/
    /*border-radius: 100px;*/
  /*}*/
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
