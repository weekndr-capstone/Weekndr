<template>
    <div>
        <Banner/>
        <CardCarousel/>
        <!--<TripHistory/>-->
    </div>
</template>

<script>
    import Banner from '../components/Banner'
    import TripHistory from "../components/TripHistory";
    
  export default {
    components: {
        Banner,
        TripHistory
    }
  }
</script>
