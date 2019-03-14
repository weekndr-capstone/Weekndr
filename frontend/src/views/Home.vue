<template>
    <div>
        <HelloWorld/>
        <FileUpload/>
        <Map/>
        <ItineraryTabs />
    </div>
</template>

<script>

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
    }
  }
</script>
