<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-toolbar flat class="Navbar">
        <v-flex xs5 sm3 md2 xl1>
                <v-img :src="require ('../assets/weekdnr_logo.svg')" class="icon"></v-img>
        </v-flex>

        <v-layout justify-end fill-height>
            <v-toolbar-items>
                <v-dialog v-if="!loggedIn" v-model="SignUp" max-width="550px">
                    <template v-slot:activator="{ on }">
                        <v-btn flat v-on="on">Sign Up</v-btn>
                    </template>
                    <v-card>
                        <v-card-text>
                            <v-container grid-list-md>
                                <v-toolbar-title class="display-1">Sign Up</v-toolbar-title>
                                <br>
                                <v-layout wrap>
                                    <v-flex xs12>
                                        <v-text-field v-model="user.phone_number" label="Phone Number*" required solo></v-text-field>
                                    </v-flex>
                                    <v-flex xs12>
                                        <v-text-field v-model="user.email" label="Email Address*" required solo></v-text-field>
                                    </v-flex>
                                    <v-flex xs12>
                                        <v-text-field v-model="user.username" label="Username*" required solo></v-text-field>
                                    </v-flex>
                                    <v-flex xs12>
                                        <v-text-field v-model="user.password" label="Password*" type="password" required solo></v-text-field>
                                    </v-flex>
                                    <v-layout justify-start>
                                    <small>*indicates required field</small>
                                    </v-layout>
                                    <v-layout justify-end>
                                        <v-card-actions>
                                            <v-btn flat @click="SignUp = false">Close</v-btn>
                                            <v-btn flat @click="signup()">Sign Up</v-btn>
                                        </v-card-actions>
                                    </v-layout>
                                    </v-layout>
                            </v-container>
                        </v-card-text>
                    </v-card>
                </v-dialog>
                <v-dialog v-if="!loggedIn" v-model="Login" max-width="550px">
                    <template  v-slot:activator="{ on }">
                        <v-btn flat v-on="on">Login</v-btn>
                    </template>
                    <v-card>
                        <v-card-text>
                            <v-container grid-list-md>
                                <v-toolbar-title class="display-1">Login</v-toolbar-title>
                                <br>
                                <v-layout wrap>
                                    <v-flex xs12>
                                        <v-text-field v-model="userLogin.username" label="Email Address" required solo></v-text-field>
                                    </v-flex>
                                    <v-flex xs12>
                                        <v-text-field v-model="userLogin.password" label="Password" type="password" required solo></v-text-field>
                                    </v-flex>
                                </v-layout>
                                <v-layout justify-end>
                                    <v-card-actions>
                                        <v-spacer></v-spacer>
                                        <v-btn flat @click="Login = false">Close</v-btn>
                                        <v-btn flat @click="login()">Login</v-btn>
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
    import axios from 'axios'
    import router from '../router'
    import store from '../store'

    export default {
        name: "Toolbar",
        data: () => ({
            SignUp: false,
            Login: false,
            user:{
                username: '',
                email:'',
                password:'',
                phone_number: '',
            },
            userLogin: {
                username:'',
                password: '',
            },
            loggedIn: false,
        }),
        methods: {
            signup(){
                  axios
                    .post('/signup', this.user)
                      .then(res => {
                          console.log(res.data)
                      }).catch(err => {
                          console.log(err.data)
                  })
            },
            login(){
                axios({
                    method: 'POST',
                    url:'/async-login',
                    data: {
                        username:this.userLogin.username,
                        password:this.userLogin.password
                    }
                })
                    .then(res => {
                        if (res.data.email != null) {
                            this.loggedIn = true;
                            store.state.user =  res.data;
                            console.log(store.state.user)
                        }
                    }).catch(err => {
                    console.log(err)
                })
            }
        }
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