<template>
    <div>
        <HelloWorld/>
        <CardCarousel />
        <FileUpload/>
        <Map/>
    </div>
</template>

<script>
    import HelloWorld from '../components/HelloWorld'
    import CardCarousel from '../components/CardCarousel'
    import Map from "../components/Map";
    import FileUpload from "../components/FileUpload";

  export default {
    components: {
        FileUpload,
        Map,
      HelloWorld,
      CardCarousel
    }
  }
</script>
