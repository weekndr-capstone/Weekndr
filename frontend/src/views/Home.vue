<template>
    <div>
        <Banner/>
        <TripHistory/>
    </div>
</template>

<script>
    import Banner from '../components/Banner'
    import TripHistory from "./TripHistory";
  export default {
    components: {
        Banner,
        TripHistory
    }
  }
</script>
