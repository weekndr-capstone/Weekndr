<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
<div>
        <v-layout justify-center>
            <v-card height="350px" xs12>
                <v-container fill-height>
                    <v-layout align-center justify-center>
                        <v-card-text>
                            <v-flex offset-xs1>
                            <h1>Search a Destination</h1>
                            </v-flex>
                            <v-flex xs10 offset-xs1>
                                <p>Where</p>
                                <v-text-field v-model="Where" placeholder="Where" required solo
                                ></v-text-field>
                            </v-flex>
                            <v-flex xs5 offset-xs1 class="d-inline-block">
                                <v-menu v-model="menu1" :close-on-content-click="false" :nudge-right="40"
                                        lazy transition="scale-transition" offset-y full-width min-width="290px">
                                    <template v-slot:activator="{ on }">
                                        <p>Start Date</p>
                                        <v-text-field v-model="Dates.Start" label="mm/dd/yyyy" readonly v-on="on" solo></v-text-field>
                                    </template>
                                    <v-date-picker :min="minDate" v-model="Dates.Start" @input="menu1 = false"></v-date-picker>
                                </v-menu>
                            </v-flex>
                            <v-flex xs5 class="d-inline-block">
                                <v-menu v-model="menu2" :close-on-content-click="false" :nudge-right="40"
                                        lazy transition="scale-transition" offset-y full-width min-width="290px">
                                    <template v-slot:activator="{ on }">
                                        <p>End Date</p>
                                        <v-text-field
                                                v-model="Dates.End"
                                                label="mm/dd/yyyy"
                                                readonly
                                                v-on="on"
                                                solo
                                        ></v-text-field>
                                    </template>
                                    <v-date-picker :min="minDate" :max="maxDate" v-model="Dates.End" @input="menu2 = false"></v-date-picker>
                                </v-menu>
                            </v-flex>
                            <v-flex offset-xs8>
                            <v-btn @click="searchLocation()" color="info">Search</v-btn>
                            </v-flex>
                        </v-card-text>
                    </v-layout>
                </v-container>
            </v-card>
        </v-layout>
</div>
</template>

<script>
    import store from '../store'
    import router from '../router'
    let today = new Date();
    let dd = today.getDate();
    let mm = today.getMonth() + 1; //January is 0!
    let yyyy = today.getFullYear();

    if (dd < 10) {
        dd = '0' + dd;
    }

    if (mm < 10) {
        mm = '0' + mm;
    }

    today = yyyy + '-' + mm + '-' + dd;
    export default {
        name: "SearchCard",
        data(){
            return{
                Where: '',
                Dates:{
                    Start: '',
                    End: ''
                },
                minDate: today,
                maxDate: '',
                menu1: false,
                menu2: false
            }
        },
        methods: {
            searchLocation(){
                store.commit('changeLocation', this.Where);
                store.commit('changeStartDate', this.Dates.Start);
                store.commit('changeEndDate', this.Dates.End);
                router.push('/search');
                console.log(store.state.location);
                console.log(store.state.dates);
            }
        }
    }
</script>

<style scoped>

</style>