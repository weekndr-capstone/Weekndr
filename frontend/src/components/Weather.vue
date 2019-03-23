<template>
    <div class="weather-tile" v-if="weatherLoaded">
        <span class="weather-container">
            <span class="top-row">
                <span class="weather-desc">
                    <span class="temp">{{`${temp}&#176;F `}}</span>
                    <i :class="weatherIconClass"></i>
                </span>
            </span>
            <span class="bottom-row condition">{{` ${condition} `}}</span>
        </span>
    </div>
</template>

<script>
    import Vue from "vue";
    import CardItem from "./CardItem";
    import axios, {AxiosResponse} from "axios";
    import {store} from '../store/store';
    export default {
        name: "Weather",
        components: {CardItem},
        props:{
        Results: Array,
        lat: Array.lat,
        lon: Array.lon
    },
        data() {
            return {
                weatherConditions: {
                    'clear-day': ['fas fa-sun', 'under clear skies'],
                    'clear-night': ['fas fa-moon', 'under starry skies'],
                    'rain': ['fas fa-cloud-rain', 'with rain'],
                    'snow': ['fas fa-snowflake', 'with snow'],
                    'sleet': ['fas fa-sleet', 'with sleet'],
                    'wind': ['fas fa-wind', 'with windy conditions'],
                    'fog': ['fas fa-smog', 'with foggy conditions'],
                    'cloudy': ['fas fa-cloudy', 'under cloudy skies'],
                    'partly-cloudy-day': ['fas fa-cloud-sun', 'under partly cloudy skies'],
                    'partly-cloudy-night': ['fas fa-cloud-moon', 'under partly cloudy skies']
                },
                weatherLoaded: true,
                weatherData: {},
                temp: 0,
                condition: '',
                summary: '',
                forecastArr: [''],
                weatherIconClass: ['wi', ''],
            }
        },
        mounted() {
            this.getWeatherCall();
        },
        computed: {
            direction() {
                return store.state.weatherResults
            },
        },
        methods: {
            getWeatherCall: function () {
                console.log('getting weather');
                const lat = this.weatherResults.lat;
                const lon = this.weatherResults.lng;
                axios.get('/api/weather/' + lat + "/" + lon).then((res) => {
                    console.log('success');
                    console.log(res);
                    this.onSuccess(res.data);
                }).catch(err => {
                    console.log(err);
                })
            },
            onSuccess: function (data) {
                this.weatherLoaded = true;
                this.temp = Math.round(data.currently.temperature);
                this.weatherIconClass[1] = this.setWeatherIcon(data.currently.icon);
                this.condition = this.setCondition(data.currently.icon);
                this.summary = data.daily.summary;
                this.forecastArr = data.daily.data;
            },
            setWeatherIcon: function (icon) {
                console.log(this.weatherConditions[icon]);
                return this.weatherConditions[icon][0];
            },
            setCondition: function (icon) {
                return this.weatherConditions[icon][1];
            }
        }
    }
</script>

<style scoped>

</style>