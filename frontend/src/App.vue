<template>
  <v-app>
    <HelloWorld/>
    <CardItem/>
    <CardCarousel />
  </v-app>
</template>

<script>
import HelloWorld from './components/HelloWorld'
import CardItem from './components/CardItem'
import CardCarousel from './components/CardCarousel'

export default {
  name: 'App',
  components: {
    HelloWorld,
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
