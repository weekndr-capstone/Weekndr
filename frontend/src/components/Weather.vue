<template>
    <v-container  grid-list-md text-xs-center>
        <h1 class="align-center">{{this.direction.formatted_address}}</h1>
        <v-divider></v-divider>
        <h2 class="align-center">Weather Forecast</h2>
        <v-layout row wrap v-if="weatherLoaded">
            <v-flex v-if="forecastArr.length > 1" v-for="day in forecastArr" :key="forecastArr">
                <v-card dark color="secondary" xs1>
                    <v-card-text class="px-0">
                            <span class="top-row">
                            <span class="weather-desc">
                                <h3>{{day.time}}</h3>
                                <span class="temp"><h4>High</h4>{{` ${day.apparentTemperatureHigh}&#176;F `}}</span>
                                <i :class="weatherIconClass"></i>
                                <span class="temp"><h4>Low</h4>{{` ${day.apparentTemperatureLow}&#176;F `}}</span>
                                <i :class="weatherIconClass"></i>
                            </span>
                        </span>
                        <p>{{day.summary}}</p>
                    </v-card-text>
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
                return store.state.weatherResults
            },
        },
        methods: {
            getWeatherCall: function () {
                const lat = this.direction.geometry.location.lat;
                const lon = this.direction.geometry.location.lng;
                const address = this.direction.formatted_address;
                const location = store.state.location;
                const Start = store.state.dates.start_date;
                const options = {
                    params: {
                        lat: lat,
                        lon: lon,
                        location: location,
                        address: address,
                        Start: Start
                    }
                };
                console.log(options);
                axios.get('/api/weather/', options).then((res) => {
                    console.log('success');
                    console.log(res);
                    console.log(Start);
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
                this.forecastArr.forEach(function(element){
                    for(let i =0; i < this.forecastArr.length; i++){
                        this.weatherIconClass[1] = this.setWeatherIcon(data.currently.icon);
                    }
                });
            },
            setWeatherIcon: function (icon) {
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