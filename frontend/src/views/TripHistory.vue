<template>
    <!--TODO: need a map at the top that has pins dropped in all of the locations you've visited-->
    <!--TODO: list of all of your past trips with a button that will take you to that trips page-->
<div>
    <GoogleMap/>
    <PastTrip v-for="n in 3" :key="n"/>
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
    }
</script>

<style scoped>

</style>
