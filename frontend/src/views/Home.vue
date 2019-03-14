<template>
    <div>
        <HelloWorld/>

        <ItineraryTabs />
        <h1>The map should be here:</h1>
        <TripHistory/>

    </div>
</template>

<script>

    import HelloWorld from '../components/HelloWorld';
    import ItineraryTabs from '../components/ItineraryTabs';
    import TripHistory from "../components/TripHistory";

  export default {
    components: {
      TripHistory,
      HelloWorld,
      ItineraryTabs
    }
  }
</script>
