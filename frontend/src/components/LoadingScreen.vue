<template>
    <span id="overlay" class="loading">
        <v-layout align-center justify-center>
            <WeekndrLogo/>
        </v-layout>
    </span>
</template>

<script>

    import WeekndrLogo from "./WeekndrLogo";
    export default {
        name: "LoadingScreen",
        components: {WeekndrLogo}
    }
</script>

<style scoped>
    body {
        margin: 0;
    }
    #loading {
        color: white;
        font-size: 32px;
        padding-top: 10vh;
        height: 100vh;
        text-align: center;
    }
    #overlay{
        position: fixed;
        top: 0;
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