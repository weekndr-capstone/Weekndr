<template>
    <div>
        <HelloWorld/>
        <FileUpload/>
        <Map/>
        <ItineraryTabs />
<<<<<<< HEAD
        <h1>The map should be here:</h1>
        <TripHistory/>

=======
>>>>>>> master
    </div>
</template>

<script>

<<<<<<< HEAD
    import HelloWorld from '../components/HelloWorld';
    import ItineraryTabs from '../components/ItineraryTabs';
    import TripHistory from "../components/TripHistory";

  export default {
    components: {
      TripHistory,
      HelloWorld,
      ItineraryTabs
=======
    import HelloWorld from '../components/HelloWorld'
    import ItineraryTabs from '../components/ItineraryTabs'
    import Map from "../components/Map";
    import FileUpload from "../components/FileUpload";

  export default {
    components: {
        FileUpload,
        Map,
        HelloWorld,
        ItineraryTabs
>>>>>>> master
    }
  }
</script>
