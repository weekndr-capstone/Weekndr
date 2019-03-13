<template>
    <div>
        <HelloWorld/>

        <ItineraryTabs />

    </div>
</template>

<script>

    import HelloWorld from '../components/HelloWorld'
    import ItineraryTabs from '../components/ItineraryTabs'
    import Map from "../components/Map";

  export default {
    components: {
        Map,
      HelloWorld,
      ItineraryTabs
    }
  }
</script>
