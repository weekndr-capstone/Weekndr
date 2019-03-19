<template>
  <v-img src="https://picsum.photos/1920/1080" background-position aspect-ratio="2">
    <Toolbar/>
    <SearchCard/>
  </v-img>
</template>
<script>
  import SearchCard from "./SearchCard";
  import Toolbar from "../components/Toolbar";

  export default {
    components: {
        Toolbar,
        SearchCard
    },
    data: () => ({

    })
  }
</script>

<style>

</style>
