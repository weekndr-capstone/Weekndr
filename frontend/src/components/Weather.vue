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
                    'clear-day': ['wi-day-sunny', 'under clear skies'],
                    'clear-night': ['wi-night-clear', 'under starry skies'],
                    'rain': ['wi-rain', 'with rain'],
                    'snow': ['wi-snow', 'with snow'],
                    'sleet': ['wi-sleet', 'with sleet'],
                    'wind': ['wi-strong-wind', 'with windy conditions'],
                    'fog': ['wi-fog', 'with foggy conditions'],
                    'cloudy': ['wi-cloudy', 'under cloudy skies'],
                    'partly-cloudy-day': ['wi-day-sunny-overcast', 'under partly cloudy skies'],
                    'partly-cloudy-night': ['wi-night-alt-partly-cloudy', 'under partly cloudy skies']
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
                const options = {
                    params: {
                        lat: lat,
                        lon: lon,
                    }
                };
                console.log(options);
                axios.get('/api/weather', options).then((res) => {
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