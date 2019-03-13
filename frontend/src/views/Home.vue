<template>
    <div>
        <HelloWorld/>
        <CardCarousel />
        <Map/>
    </div>
</template>

<script>
    import HelloWorld from '../components/HelloWorld'
    import CardCarousel from '../components/CardCarousel'
    import Map from "../components/Map";

  export default {
    components: {
        Map,
      HelloWorld,
      CardCarousel
    }
  }
</script>
