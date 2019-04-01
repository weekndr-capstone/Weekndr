<template>
    <span>
        <span id="overlay">
            <v-layout align-center justify-center>
                <WeekndrLogo/>
            </v-layout>
        </span>
    </span>
</template>

<script>

    import WeekndrLogo from "./WeekndrLogo";
    export default {
        name: "LoadingScreen",
        components: {WeekndrLogo},
        data() {
            return {
            }
        }
    }
</script>

<style scoped>
    body {
        margin: 0;
    }
    #overlay{
        position: fixed;
        top: 0;
        left: 0;
        z-index: 999;
        width: 100%;
        height: 100vh;
        background: rgba(7, 23, 37, 0.9);
        color:white;
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>