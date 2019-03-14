<template>
    <div>
        <HelloWorld/>
        <CardCarousel />
        <CustomDestinationModal/>
        <FileUpload/>
        <Map/>
    </div>
</template>

<script>
    import HelloWorld from '../components/HelloWorld'
    import CardCarousel from '../components/CardCarousel'
    import Map from "../components/Map";
    import FileUpload from "../components/FileUpload";
    import CustomDestinationModal from "../components/CustomDestinationModal";

  export default {
    components: {
        CustomDestinationModal,
        FileUpload,
        Map,
      HelloWorld,
      CardCarousel
    }
  }
</script>
