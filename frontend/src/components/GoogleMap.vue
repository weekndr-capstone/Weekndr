<template>
    <v-content class="App"></v-content>
</template>

<script>
    import gmapsInit from '../googlemaps';

    export default {
        name: "App",
        props: {
            trips: Object,
        },
        methods:{
        },
        async mounted(){

            //creates google map
            try {
                const google = await gmapsInit();
                const geocoder = new google.maps.Geocoder();
                var latlng = new google.maps.LatLng(-0.397, 5.644);
                var options = {
                    zoom: 3,
                    center: latlng,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
                const map = new google.maps.Map(this.$el, options);

                for (var i = 0; i < this.trips.length; i++) {
                    var address = this.trips[i].location;
                    codeAddress(address, this.trips[i]);
                }

            //finds locations lat and long and displays pin on the map for each location
            function codeAddress(address, trip) {
                geocoder.geocode({ 'address': address }, function(results, status) {
                    if (status === google.maps.GeocoderStatus.OK) {
                        map.setCenter(results[0].geometry.location);
                        var marker = new google.maps.Marker({
                            map: map,
                            position: results[0].geometry.location,
                            title: trip.location
                        });
                        var infowindow = new google.maps.InfoWindow({
                            content: "<h1>Trip: " + trip.location + '</h1>' + '<br>Description: ' +
                                    trip.trip_description + '<br><br>Ended: ' + trip.end_date.split('T')[0]
                        });
                        google.maps.event.addListener(marker, 'click', function() {
                            infowindow.open(map,marker);
                        });
                    } else {
                        alert("Geocode unsuccessful");
                    }
                });
            }
            } catch (error) {
                console.error(error);
            }
        },
    }


</script>

<style scoped>

    /*!* Always set the map height explicitly to define the size of the div*/
     /** element that contains the map. *!*/
    html,
    body {
        margin: 0;
        padding: 0;
    }

    .App {
        width: 100vw;
        height: 100vh;
    }


</style>