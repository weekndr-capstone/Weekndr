<template>
  <v-app>
    <HelloWorld/>
    <ItineraryTabs/>
  </v-app>
</template>

<script>
import HelloWorld from './components/HelloWorld'
import Toolbar from './components/Toolbar'
import ItineraryTabs from './components/ItineraryTabs'

export default {
  name: 'App',
  components: {
    HelloWorld,
    Toolbar,
    ItineraryTabs
  },
  data () {
    return {
      //
    }
  }
}
</script>
