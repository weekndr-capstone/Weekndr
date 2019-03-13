<template>
    <v-container>
        <form action="">
            <input type="file" />
            <br>
            <v-btn id="upload">Upload</v-btn>
        </form>
    </v-container>
</template>

<script>
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

                console.log()
            }
        }
    }
</script>


<style scoped>

</style>