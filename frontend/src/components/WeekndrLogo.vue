<template>
    <v-flex xs5 sm3 md2 xl1 class=".svg-container">
    <svg class="svg weekndr" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 393.11 280.07">
        <g id="Layer_2" data-name="Layer 2">
            <g class="leftSpin">
                <path class="cls-1" d="M157.88,221.28a27.61,27.61,0,0,1-23.94-13.78L81.17,116.09A27.59,27.59,0,1,1,129,88.5l52.77,91.4a27.61,27.61,0,0,1-10.1,37.69h0A27.33,27.33,0,0,1,157.88,221.28ZM105,90.2a12.09,12.09,0,0,0-10.42,18.15l52.77,91.4a12.1,12.1,0,1,0,21-12.1L115.54,96.24a12.27,12.27,0,0,0-10.54-6Z"/>
            </g>
            <g class="rightSpin">
                <path class="cls-1" d="M240.14,221.28a27.92,27.92,0,0,1-7.22-.95,27.47,27.47,0,0,1-16.76-12.83l-52.77-91.41a27.62,27.62,0,0,1,10.1-37.69,27.66,27.66,0,0,1,37.69,10.1L264,179.9a27.62,27.62,0,0,1-10.1,37.69h0A27.25,27.25,0,0,1,240.14,221.28ZM187.22,90.2a12.09,12.09,0,0,0-10.42,18.15l52.78,91.4a12.15,12.15,0,0,0,16.53,4.43h0a12.13,12.13,0,0,0,4.43-16.54l-52.78-91.4a12.27,12.27,0,0,0-10.54-6Z"/>
            </g>
            <g class="droplet">
                <path class="cls-2" d="M288.44,156.16l-23.38-39.72a27.66,27.66,0,0,1,9.78-37.78,27.71,27.71,0,0,1,12.61-3.75h.62a27.59,27.59,0,0,1,23.08,41.14Zm-.55-65.76a12,12,0,0,0-10.75,9,12.07,12.07,0,0,0,1.26,9.17l9.78,16.61,9.5-16.77a12.17,12.17,0,0,0-4.57-16.49A11.8,11.8,0,0,0,287.89,90.4Z"/>
            </g>
        </g>
    </svg>
    </v-flex>
</template>

<script>
    export default {
        name: "WeekndrLogo"
    }
</script>

<style scoped>
    .svg {
        width: 100%;
        height: auto;
    }
    .svg path {
        fill: #000 !important;
    }
    .weekndr path {
        fill: #E96445;
    }

    .leftSpin {
        -webkit-animation: leftSpin ; /* Safari 4+ */
        -moz-animation:    leftSpin ; /* Fx 5+ */
        -o-animation:      leftSpin ; /* Opera 12+ */
        animation:         leftSpin ; /* IE 10+, Fx 29+ */
    }
    .weekndr path {
        -webkit-animation: droplet 5s infinite; /* Safari 4+ */
        -moz-animation:    droplet 5s infinite; /* Fx 5+ */
        -o-animation:      droplet 5s infinite; /* Opera 12+ */
        animation:         droplet 5s infinite; /* IE 10+, Fx 29+ */
    }

    @keyframes droplet {
        0% { transform: translateY(0px) ; fill: #E96445; }
        25% { transform: translateY(20px); fill: #89B6BE;}
        50% { transform: translateY(50px); fill: #E96445;}
        75% { transform: translateY(20px); fill: #89B6BE; }
        100% { transform: translateY(0px); fill: #E96445; }
    }
</style>