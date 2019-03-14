<template>
    <div>
        <HelloWorld/>
        <FileUpload/>
        <ItineraryTabs />

        <h1>The map should be here:</h1>
        <TripHistory/>


    </div>
</template>

<script>

    import HelloWorld from '../components/HelloWorld'
    import ItineraryTabs from '../components/ItineraryTabs'
    import FileUpload from "../components/FileUpload";
    import TripHistory from "../components/TripHistory";

  export default {
    components: {
        FileUpload,
        HelloWorld,
        ItineraryTabs,
        TripHistory
    }
  }
</script>
