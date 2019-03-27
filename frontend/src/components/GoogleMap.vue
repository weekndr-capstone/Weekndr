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
        async mounted(){
            try {


                const google = await gmapsInit();
                const geocoder = new google.maps.Geocoder();
                var latlng = new google.maps.LatLng(-0.397, 5.644);
                var options = {
                    zoom: 1,
                    center: latlng,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
                const map = new google.maps.Map(this.$el, options);

                for (var i = 0; i < this.trips.length; i++) {
                    var address = this.trips[i].location;
                    codeAddress(address);
                    console.log(address);
                }
            function codeAddress(address) {
                geocoder.geocode({ 'address': address }, function(results, status) {
                    console.log(results);
                    if (status === google.maps.GeocoderStatus.OK) {
                        map.setCenter(results[0].geometry.location);
                        var marker = new google.maps.Marker({
                            map: map,
                            position: results[0].geometry.location
                        });
                    } else {
                        alert("Geocode unsuccessful");
                    }
                    // map.setCenter(results[0].geometry.location);
                    // map.fitBounds(results[0].geometry.viewport);
                });
            }

                // geocoder.geocode({ address: 'Austria' }, (results, status) => {
                //     if (status !== 'OK' || !results[0]) {
                //         throw new Error(status);
                //     }
                //
                //     map.setCenter(results[0].geometry.location);
                //     map.fitBounds(results[0].geometry.viewport);
                // });
                //
                // const markers = locations
                //     .map(x => new google.maps.Marker({ ...x, map }));
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