<template>
    <!--TODO: need a map at the top that has pins dropped in all of the locations you've visited-->
    <!--TODO: list of all of your past trips with a button that will take you to that trips page-->
<div>
    <Toolbar/>
    <GoogleMap/>
    <PastTrip v-for="n in trips" :key="n" :trip="n"/>
</div>

</template>

<script>
    import GoogleMap from '../components/GoogleMap';
    import PastTrip from '../components/PastTrip';
    export default {
        name: "TripHistory",
        components: {
            GoogleMap,
            PastTrip
        },
        props:{
            trips: Array,
        }
    }
</script>

<style scoped>

</style>
