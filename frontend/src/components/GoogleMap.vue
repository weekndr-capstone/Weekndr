<template>
    <div class="App"/>
</template>

<script>
    import gmapsInit from '../googlemaps';

    export default {
        name: "App",
        async mounted(){
            try {
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
    #mapName {
        width: 100%;
    }
    /* Optional: Makes the sample page fill the window. */
    html, body {
        height: 100%;
        margin: 0 auto;
        padding: 0;
    }
</style>