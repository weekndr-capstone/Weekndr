<template>
  <v-app>
    <Toolbar />
    <HelloWorld/>
    <CardItem/>
    <CardCarousel />
  </v-app>
</template>

<script>
import HelloWorld from './components/HelloWorld'
import CardItem from './components/CardItem'
import Toolbar from './components/Toolbar'
import CardCarousel from './components/CardCarousel'

export default {
  name: 'App',
  components: {
    HelloWorld,
    Toolbar,
    CardCarousel,
    CardItem
  },
  data () {
    return {
      //
    }
  }
}
</script>
