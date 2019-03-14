<template>
    <v-container>
        <form>
            <v-btn id="upload" color="info" @click="fileUpload">Upload Photo</v-btn>
        </form>
    </v-container>
</template>

<script>
    import * as filestack from 'filestack-js';
    export default {
        name: "FileUpload",
        data(){
            return{
                file: {
                    name: ''
                }
            }
        },
        methods: {
            fileUpload(){
                const apikey = '';
                const client = filestack.init(apikey);
                const options = {
                    maxFiles: 20,
                    uploadInBackground: false,
                    onOpen: () => console.log('opened!'),
                    onUploadDone: (res) => {
                        console.log(res);
                    }
                };
                client.picker(options).open();
            }
        }
    }
</script>


<style scoped>

</style>