<template>
    <v-container grid-list-md text-xs-center>
        <h1 class="h1color">{{this.direction.formatted_address}}</h1>
        <br>
        <h2>Current Weather Forecast</h2>
        <br>
        <v-layout row wrap justify-center v-if="weatherLoaded" fill-height>
            <v-flex v-if="forecastArr.length > 1" v-for="(day, index) in forecastArr" :key="index" xs4 md2 fill-height>
                <v-card light flat>
                        <v-card-text class="px-0 headline">{{timeConverter(day.time)}}</v-card-text>
                        <v-card-text class="px-0 subheading">High {{` ${day.apparentTemperatureHigh}&#176;F `}}</v-card-text>
                        <v-card-text class="px-0 subheading">Low {{` ${day.apparentTemperatureLow}&#176;F `}}</v-card-text>
                        <v-card-text class="px-0 px-0 pr-4 pl-4 subheading">{{day.summary}}</v-card-text>
                </v-card>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    import CardItem from "./CardItem";
    import axios from "axios";
    import store from '../store';

    export default {
        name: "Weather",
        components: {CardItem},
        props:{
            Results: Array
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
                weatherIconClass: ['fa', ''],
            }
        },
        mounted() {
            this.getWeatherCall();
        },
        computed: {
            direction() {
                return store.getters.weather
            },
        },
        methods: {
            getWeatherCall: function () {
                const lat = this.direction.geometry.location.lat;
                const lon = this.direction.geometry.location.lng;
                const address = this.direction.formatted_address;
                const location = store.state.location;
                const minDate = store.state.minDate;
                const options = {
                    params: {
                        lat: lat,
                        lon: lon,
                        location: location,
                        address: address,
                        minDate: minDate
                    }
                };
                console.log(options);
                axios.get('/api/weather/', options).then((res) => {
                    console.log('success');
                    console.log(res);
                    this.onSuccess(res.data);
                }).catch(err => {
                    console.log(err);
                })
            },
            onSuccess: function (data){
                this.weatherLoaded = true;
                this.temp = Math.round(data.currently.temperature);
                this.condition = this.setCondition(data.currently.icon);
                this.summary = data.daily.summary;
                this.forecastArr = data.daily.data;
                this.forecastArr.length = 5;
                this.weatherIconClass[1] = this.setWeatherIcon(data.currently.icon);
            },
            setWeatherIcon: function (icon) {
                return this.weatherConditions[icon][0];
            },
            setCondition: function (icon) {
                return this.weatherConditions[icon][1];
            },
            timeConverter: function(UNIX_timestamp){
            let a = new Date(UNIX_timestamp * 1000);
            let months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
            let year = a.getFullYear();
            let month = months[a.getMonth()];
            let date = a.getDate();
            // let hour = a.getHours();
            // let min = a.getMinutes();
            // let sec = a.getSeconds();
            let time = date + ' ' + month + ' ' + year;
            return time;
    }
        }
    }
</script>

<style scoped>
    .h1color {
        color: #E96445;
    }
</style>