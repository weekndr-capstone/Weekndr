<template>
    <div>
        <HelloWorld/>
        <CardCarousel/>
        <CustomDestinationModal/>
        <FileUpload/>
        <ItineraryTabs />
        <TripHistory/>
        <FullCardItem/>
        <RecommendedDestinations/>
    </div>
</template>

<script>

    import HelloWorld from '../components/HelloWorld'
    import ItineraryTabs from '../components/ItineraryTabs'
    import FileUpload from "../components/FileUpload";
    import TripHistory from "../components/TripHistory";
    import CustomDestinationModal from "../components/CustomDestinationModal";
    import FullCardItem from "../components/FullCardItem";
    import RecommendedDestinations from "../components/RecommendedDestinations";

  export default {
    components: {
        CustomDestinationModal,
        FullCardItem,
        FileUpload,
        HelloWorld,
        ItineraryTabs,
        TripHistory,
        RecommendedDestinations
    }
  }
</script>
