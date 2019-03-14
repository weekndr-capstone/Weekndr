<template>
    <div>
        <HelloWorld/>
        <CardCarousel />
        <CustomDestinationModal/>
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
    import CustomDestinationModal from "../components/CustomDestinationModal";
    import FullCardItem from "../components/FullCardItem";
    
  export default {
    components: {
        CustomDestinationModal,
        FullCardItem,
        FileUpload,
        HelloWorld,
        ItineraryTabs
    }
  }
</script>
