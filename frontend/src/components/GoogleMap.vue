<template>
    <div class="google-map" :id="mapName"></div>
</template>

<script>

    export default {
        name: "GoogleMap",
        props: ['name'],
        data(){
            return {
                mapName: this.name + "-map",
                GoogleMap: this.GoogleMap
            }
        },
        mounted: function initMap() {
            // const element = document.getElementById(this.mapName)
            // const options = {
            //     zoom: 14,
            //     center: new google.maps.LatLng(-34.397,150.644)
            // }
            // const map = new google.maps.Map(element, options)

            map = new google.maps.Map(document.getElementById('mapName'), {
                center: {lat: -34.397, lng: 150.644},
                zoom: 8
            });
        }
    }

//    look at the yelp list request on api controller to see how that's done
//    TODO: send a request to the backend where the api key is
//    TODO: have the backend make a request to google
//    TODO: the backend needs to send the info to the front end

</script>

<style scoped>

    .google-map {
        width: 800px;
        height: 600px;
        margin: 0 auto;
        background: gray;
    }




    /*!* Always set the map height explicitly to define the size of the div*/
     /** element that contains the map. *!*/
    /*#mapName {*/
        /*width: 100%;*/
    /*}*/
    /*!* Optional: Makes the sample page fill the window. *!*/
    /*html, body {*/
        /*height: 100%;*/
        /*margin: 0 auto;*/
        /*padding: 0;*/
    /*}*/
</style>