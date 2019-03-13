<template>
  <v-app>
    <HelloWorld/>
    <ItineraryTabs/>
    <CardCarousel />
  </v-app>
</template>

<script>
import HelloWorld from './components/HelloWorld'
import Toolbar from './components/Toolbar'
import CardCarousel from './components/CardCarousel'
import ItineraryTabs from './components/ItineraryTabs'

export default {
  name: 'App',
  components: {
    HelloWorld,
    Toolbar,
    CardCarousel,
    ItineraryTabs
  },
  data () {
    return {
      //
    }
  }
}
</script>
