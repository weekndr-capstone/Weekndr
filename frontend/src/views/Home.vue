<template>
    <div>
        <HelloWorld/>
        <FileUpload/>
        <ItineraryTabs />
        <PastTrip/>

        <h1>The map should be here:</h1>
        <TripHistory/>


    </div>
</template>

<script>

    import HelloWorld from '../components/HelloWorld'
    import ItineraryTabs from '../components/ItineraryTabs'
    import FileUpload from "../components/FileUpload";
    import TripHistory from "../components/TripHistory";
    import PastTrip from "../components/PastTrip";

  export default {
    components: {
        FileUpload,
        HelloWorld,
        ItineraryTabs,
        TripHistory,
        PastTrip
    }
  }
</script>
