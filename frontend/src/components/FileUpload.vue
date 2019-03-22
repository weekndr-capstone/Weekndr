<template>
            <v-btn id="upload" color="info" v-on:click="fileUpload()">Upload Photo</v-btn>
</template>


<script>
    import * as filestack from 'filestack-js'
    import axios from 'axios'
    import store from '../store'
    export default {
        name: "FileUpload",
        data() {
            return {
                file: {
                    name: '',
                }
            }
        },
        props: {
            pictureLocation: String,
            card: Object
        },
        methods: {
            fileUpload() {
                const apikey = 'AsNx10Lk3SEiGRvMmw223z';
                const client = filestack.init(apikey);
                const options = {
                    maxFiles: 1,
                    uploadInBackground: false,

                    onOpen: () => console.log("opened!"),
                    onUploadDone: (res) => {
                        console.log(res);

                        if (this.pictureLocation === 'placePicture') {
                            this.url = '/placePhoto'
                        } else if  (this.pictureLocation !== 'placePicture'){
                            this.url = '/profilePicture'
                        }
                        axios(
                            {
                                method: 'POST',
                                url: this.url,
                                headers: {'Content-Type': 'application/json'},
                                data: {
                                    img_path: res.filesUploaded[0].handle,
                                    created_at: new Date(),
                                    user: {
                                        id: store.state.user.id
                                    },
                                    place: {
                                        id: this.card.id
                                    }
                                }
                            }).then(res => {
                                console.log(res.data);
                        }).catch(err => {
                            console.log(err)
                        });

                    }
                }
                client.picker(options).open();
            }

        }
    }

</script>


<style scoped>

</style>