<template>
    <div class="App"/>
</template>

<script>
    import gmapsInit from '../googlemaps';

    export default {
        name: "App",
        async mounted(){
            try {
                const locations = [
                    {
                        position: {
                            lat: 48.160910,
                            lng: 16.383330,
                        },
                    },
                    {
                        position: {
                            lat: 48.174270,
                            lng: 16.329620,
                        },
                    },
                    // ...
                ];
                const google = await gmapsInit();
                const geocoder = new google.maps.Geocoder();
                const map = new google.maps.Map(this.$el);

                geocoder.geocode({ address: 'Austria' }, (results, status) => {
                    if (status !== 'OK' || !results[0]) {
                        throw new Error(status);
                    }

                    map.setCenter(results[0].geometry.location);
                    map.fitBounds(results[0].geometry.viewport);
                });

                const markers = locations
                    .map(x => new google.maps.Marker({ ...x, map }));
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