<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-toolbar flat class="Navbar">
        <v-flex xs5 sm3 md2 xl1>
                <v-img :src="require ('../assets/weekdnr_logo.svg')" class="icon"></v-img>
        </v-flex>

        <v-layout justify-end fill-height>
            <v-toolbar-items>
                <v-dialog v-model="SignUp" max-width="550px">
                    <template v-slot:activator="{ on }">
                        <v-btn flat v-on="on">Sign Up</v-btn>
                    </template>
                    <v-card>
                        <v-card-text>
                            <v-container grid-list-md>
                                <v-toolbar-title class="display-1">Sign Up</v-toolbar-title>
                                <br>
                                <v-layout wrap>
                                    <v-flex xs12 sm6>
                                        <v-text-field label="First name*" required solo></v-text-field>
                                    </v-flex>
                                    <v-flex xs12 sm6>
                                        <v-text-field label="Last name*" required solo></v-text-field>
                                    </v-flex>
                                    <v-flex xs12>
                                        <v-text-field label="Email Address*" required solo></v-text-field>
                                    </v-flex>
                                    <v-flex xs12>
                                        <v-text-field label="Username*" required solo></v-text-field>
                                    </v-flex>
                                    <v-flex xs12>
                                        <v-text-field label="Password*" type="password" required solo></v-text-field>
                                    </v-flex>
                                    <v-layout justify-start>
                                    <small>*indicates required field</small>
                                    </v-layout>
                                    <v-layout justify-end>
                                        <v-card-actions>
                                            <v-btn flat @click="SignUp = false">Close</v-btn>
                                            <v-btn flat @click="SignUp = false">Sign Up</v-btn>
                                        </v-card-actions>
                                    </v-layout>
                                    </v-layout>
                            </v-container>
                        </v-card-text>
                    </v-card>
                </v-dialog>
                <v-dialog v-model="Login" max-width="550px">
                    <template v-slot:activator="{ on }">
                        <v-btn flat v-on="on">Login</v-btn>
                    </template>
                    <v-card>
                        <v-card-text>
                            <v-container grid-list-md>
                                <v-toolbar-title class="display-1">Login</v-toolbar-title>
                                <br>
                                <v-layout wrap>
                                    <v-flex xs12>
                                        <v-text-field label="Email Address" required solo></v-text-field>
                                    </v-flex>
                                    <v-flex xs12>
                                        <v-text-field label="Password" type="password" required solo></v-text-field>
                                    </v-flex>
                                </v-layout>
                                <v-layout justify-end>
                                    <v-card-actions>
                                        <v-spacer></v-spacer>
                                        <v-btn flat @click="Login = false">Close</v-btn>
                                        <v-btn flat @click="Login = false">Login</v-btn>
                                    </v-card-actions>
                                </v-layout>
                            </v-container>
                        </v-card-text>
                        </v-card>
                </v-dialog>
            </v-toolbar-items>
        </v-layout>
    </v-toolbar>
</template>

<script>
    export default {
        name: "Toolbar",
        data: () => ({
            SignUp: false,
            Login: false
        })
    }
</script>

<style scoped>
    .Navbar {
        background: transparent;
        border-color: transparent;
    }
    .icon {
        width: 60%;
    }
</style>