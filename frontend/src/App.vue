<template>
  <v-app>
    <router-view></router-view>
  </v-app>
</template>

<script>
  export default {
    name: 'App'
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
  .v-input, .v-text-field, .v-timeline-item, .v-timeline-item__opposite, small {
    font-family: 'Nunito Sans', sans-serif;
  }
  body {
    background-color: white;
  }

</style>
