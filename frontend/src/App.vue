<template>
  <v-app>
    <Toolbar />
    <HelloWorld/>
  </v-app>
</template>

<script>
import HelloWorld from './components/HelloWorld'
import Toolbar from './components/Toolbar'
import SearchCard from "./components/SearchCard";

export default {
  name: 'App',
  components: {
    SearchCard,
    HelloWorld,
    Toolbar
  },
  data () {
    return {
      //
    }
  }
}
</script>
