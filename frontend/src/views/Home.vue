<template>
    <div>
        <HelloWorld/>
        <FileUpload/>
        <ItineraryTabs />
        <FullCardItem/>
    </div>
</template>

<script>

    import HelloWorld from '../components/HelloWorld'
    import ItineraryTabs from '../components/ItineraryTabs'
    import Map from "../components/Map";
    import FileUpload from "../components/FileUpload";
    import FullCardItem from "../components/FullCardItem";

  export default {
    components: {
        FullCardItem,
        FileUpload,
        HelloWorld,
        ItineraryTabs
    }
  }
</script>
