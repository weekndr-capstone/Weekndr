<template>
  <v-app>
    <Toolbar />

    <CardItem />
    <HelloWorld/>

  </v-app>
</template>

<script>
import HelloWorld from './components/HelloWorld'
import Toolbar from './components/Toolbar'
import CardItem from './components/CardItem'

export default {
  name: 'App',
  components: {
    HelloWorld,
    Toolbar,
      CardItem
  },
  data () {
    return {
      //
    }
  }
}
</script>
