<template>
  <v-img src="https://picsum.photos/1920/1080" background-position aspect-ratio="2">
    <SearchCard/>
  </v-img>
</template>
<script>
  import SearchCard from "./SearchCard";
  import Toolbar from "./Toolbar";
  export default {
    components: {Toolbar, SearchCard},
    data: () => ({

    })
  }
</script>

<style>

</style>
