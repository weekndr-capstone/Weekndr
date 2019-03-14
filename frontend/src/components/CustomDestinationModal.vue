<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-dialog v-model="Add" max-width="600px">
        <template v-slot:activator="{ on }">
            <v-btn flat v-on="on">Add a Destination</v-btn>
        </template>
        <v-card>
            <v-card-text>
                <v-flex class="ml-4">
                    <h1>Add a Destination</h1>
                </v-flex>
                <v-container grid-list-md>
                    <v-layout wrap>
                        <v-flex xs12>
                            <p>Where</p>
                            <v-text-field v-model="Where" placeholder="Where" required solo></v-text-field>
                        </v-flex>
                        <v-flex xs12 class="d-inline-block">
                            <v-menu v-model="menu1" :close-on-content-click="false" :nudge-right="40"
                                    lazy transition="scale-transition" offset-y full-width min-width="290px">
                                <template v-slot:activator="{ on }">
                                    <p>Date</p>
                                    <v-text-field v-model="Dates.Start" label="yyyy/mm/dd" readonly v-on="on" solo></v-text-field>
                                </template>
                                <v-date-picker :min="minDate" v-model="Dates.Start" @input="menu1 = false"></v-date-picker>
                            </v-menu>
                        </v-flex>
                        <v-flex class="xs12">
                            <p>Description</p>
                            <v-textarea
                                    v-model="Description"
                                    auto-grow
                                    solo
                                    label="Description"
                                    rows="1"
                            ></v-textarea>
                        </v-flex>
                        <v-flex >
                        <v-card-actions>
                            <v-spacer></v-spacer>
                                <v-btn @click="Add = false" flat>Close</v-btn>
                                <v-btn @click="Add = false" flat>Add to Itinerary</v-btn>
                        </v-card-actions>
                        </v-flex>
                    </v-layout>
                </v-container>
            </v-card-text>
        </v-card>
    </v-dialog>
</template>

<script>
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
        name: "CustomDestinationModal",
        data:()=> {
            return ({
                Where: '',
                Dates: {
                    Start: ''
                },
                minDate: today,
                Add: false
            });
        }
    }
</script>

<style scoped>

</style>