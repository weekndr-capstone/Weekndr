<template>
    <v-layout>
        <v-flex xs12 sm12>
            <v-card  flat>
                <v-card-actions>
                    <v-spacer></v-spacer>
                </v-card-actions>
                <v-container  flat fluid id="grid">
                    <v-layout row wrap style="overflow:hidden">
                        <v-flex flat v-for="photo in photos" xs4>
                            <v-card tile height="150px">
                                <div class="imageSize" :id="photo.id"></div>
                            </v-card>
                        </v-flex>
                    </v-layout>
                </v-container>
            </v-card>
        </v-flex>
    </v-layout>
</template>

<script>

    import axios from 'axios'
    import * as filestack from 'filestack-js'
    import store from '../store'

    export default {
        name: "PictureGrid",

        data() {
            return {}
        },
        props: {
            photos: Object
        },
        mounted() {

            //for each photo in a place it will run filestack and display images only when button has been clicked and this is mounted
            this.photos.forEach(photo => {
                const apikey = 'AsNx10Lk3SEiGRvMmw223z';
                const client = filestack.init(apikey);

                let handler = photo.img_path;

                client.retrieve(handler).then((blob) => {
                    let imgLocation = document.getElementById(`${photo.id}`);
                    const urlCreator = window.URL || window.webkitURL;
                    const img = document.createElement('img');
                    img.src = urlCreator.createObjectURL(blob);
                    img.style.height = '100%';
                    img.style.width = '100%';
                    imgLocation.appendChild(img);

                }).catch((error) => {
                    console.error(error);
                });
            })
        }
    }


</script>

<style scoped>
    #grid {
        box-shadow: none;
    }

    .imageSize {
        height: 150px !important;
    }

</style>