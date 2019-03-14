<template>
    <div>
        <HelloWorld/>
        <CardCarousel />
        <CustomDestinationModal/>
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
    import CustomDestinationModal from "../components/CustomDestinationModal";

  export default {
    components: {
        CustomDestinationModal,
        FileUpload,
        Map,
        HelloWorld,
        ItineraryTabs
    }
  }
</script>
