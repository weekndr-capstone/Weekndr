<template>
    <!--TODO: need a map at the top that has pins dropped in all of the locations you've visited-->
    <!--TODO: list of all of your past trips with a button that will take you to that trips page-->

    <GoogleMap name="example"></GoogleMap>

</template>

<script>
    import GoogleMap from '../components/GoogleMap';

    export default {
        name: "TripHistory",
        components: {
            GoogleMap
        }
    }
</script>

<style scoped>

</style>
