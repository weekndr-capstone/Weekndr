<template>
  <v-img :src="pictureToDisplay" background-position aspect-ratio="2">
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
    data() {
        return {
            pictureToDisplay: '',
        }
    },
      mounted() {
            let pictures = [1050, 1015, 989, 986, 985, 973, 961, 941, 916, 901, 890, 864, 862, 853, 829, 641, 517, 436, 1084, 938, 908, 907, 877, 851, 10, 11];
            let randomIndex = Math.floor(Math.random() * pictures.length);
            this.pictureToDisplay = "https://picsum.photos/1920/1080?image=" + pictures[randomIndex];
      }
  }
</script>

<style>

</style>
