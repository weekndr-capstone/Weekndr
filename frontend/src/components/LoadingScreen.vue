<template>
    <div id="loading">

            <v-layout align-center justify-center>
                <WeekndrLogo/>
            </v-layout>
            <v-layout align-center justify-center>
                <h3>Weekndr</h3>
            </v-layout>
    </div>
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
        background-color: #89B6BE;
        color: white;
        font-size: 32px;
        padding-top: 10vh;
        height: 100vh;
        text-align: center;
    }
</style>