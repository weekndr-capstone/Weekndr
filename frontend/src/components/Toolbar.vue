<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-toolbar flat class="Navbar">
        <v-flex xs5 sm3 md2 xl1>
            <router-link :to="'/'">
                <v-img :src="require ('../assets/weekdnr_logo.svg')" class="icon"></v-img>
            </router-link>
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
                                        <v-text-field v-model="user.phoneNumber" label="Phone Number*" required solo></v-text-field>
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
                                    <v-flex xs12>
                                        <v-btn id="upload" color="info" v-on:click="fileUpload()">Upload Photo</v-btn>
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
                <v-layout v-if="loggedIn" justify-end fill-height>
                    <v-avatar  id="avatar" class="avatar-margin" size="40px"/>
                    <v-btn flat @click="logout()">Logout</v-btn>
                </v-layout>
                <v-dialog v-if="!loggedIn" v-model="Login" max-width="550px">
                    <template  v-slot:activator="{ on }">
                        <div class="text-xs-center">
                            <v-menu v-model="menu" :close-on-content-click="false" :nudge-width="200" offset-x>
                                <template v-slot:activator="{ on }">
                                    <v-btn color="indigo" dark v-on="on">
                                        Menu
                                    </v-btn>
                                </template>

                                <v-card>
                                    <v-list>
                                        <v-list-tile avatar>
                                            <v-list-tile-avatar>
                                                <v-avatar  id="avatar" class="avatar-margin" size="40px"/>
                                            </v-list-tile-avatar>
                                            <v-list-tile-content>
                                                <v-list-tile-title>username</v-list-tile-title>
                                            </v-list-tile-content>
                                        </v-list-tile>
                                    </v-list>

                                    <v-divider></v-divider>

                                    <v-list>
                                        <v-list-tile avatar>
                                            <v-list-tile-avatar>
                                                <v-avatar  id="avatar" class="avatar-margin" size="40px"/>
                                            </v-list-tile-avatar>
                                            <v-list-tile-action>
                                                <v-btn>Current/Upcoming Trips</v-btn>
                                                <v-btn>Past Trips</v-btn>
                                            </v-list-tile-action>
                                        </v-list-tile>
                                    </v-list>

                                    <v-card-actions>
                                        <v-spacer></v-spacer>

                                        <v-btn flat @click="menu = false">Cancel</v-btn>
                                    </v-card-actions>
                                </v-card>
                            </v-menu>
                        </div>
                        <v-btn flat v-on="on">Login</v-btn>
                    </template>
                    <v-card>
                        <v-card-text>
                            <v-container grid-list-md>
                                <v-toolbar-title class="display-1">Login</v-toolbar-title>
                                <br>
                                <v-layout wrap>
                                    <v-flex xs12>
                                        <v-text-field v-model="userLogin.username" label="Username" required solo></v-text-field>
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
    import * as filestack from 'filestack-js'
    import axios from 'axios'
    import router from '../router'
    import store from '../store'
    import FileUpload from "./FileUpload";


    export default {
        name: "Toolbar",
        components: {FileUpload},
        data: () => ({
            SignUp: false,
            Login: false,
            menu: false,
            user:{
                username: '',
                email:'',
                password:'',
                phoneNumber: '',
                img_path: '',
                created_at: new Date()
            },
            userLogin: {
                username:'',
                password: '',
            }
        }),
        computed:{
            loggedIn() {
                return store.getters.loggedIn
            }
        },
        methods: {
            signup(){
                  axios
                    .post('/signup', this.user)
                      .then(res => {
                          this.SignUp = false;
                          this.displayAvatar();
                          console.log(res.data)
                      }).catch(err => {
                          console.log(err.data)
                  })
            },
            login(){
                axios({
                    method: 'POST',
                    url:'/async-login',
                    params: {
                        username:this.userLogin.username,
                        password:this.userLogin.password
                    }
                })
                    .then(res => {
                        if (res.data.email != null) {
                            store.commit('changeLoggedIn', true);
                            store.commit('changeUser', res.data);
                            this.Login = false;
                            console.log(store.state.user);
                            this.displayAvatar();
                        }
                    }).catch(err => {
                    console.log(err)
                })
            },
            logout(){
                store.commit('changeUser', '');
                store.commit('changeLoggedIn', false);
                store.commit('changeCurrentlyViewedTrip', '');
                this.Login = false;
            },
            fileUpload() {
                const apikey = 'AsNx10Lk3SEiGRvMmw223z';
                const client = filestack.init(apikey);
                const options = {
                    maxFiles: 1,
                    uploadInBackground: false,

                    onOpen: () => console.log("opened!"),
                    onUploadDone: (res) => {
                        console.log(res);
                        this.user.img_path = res.filesUploaded[0].handle;
                    }
                }
                client.picker(options).open();
            },
            displayAvatar(){
                const apikey = 'AsNx10Lk3SEiGRvMmw223z';
                const client = filestack.init(apikey);

                let handler = store.state.user.img_path;
                console.log(handler);

                client.retrieve(handler).then((blob) => {
                    let imgLocation = document.getElementById('avatar');
                    const urlCreator = window.URL || window.webkitURL;
                    const img = document.createElement('img');
                    img.src = urlCreator.createObjectURL(blob);
                    img.height = 36;
                    img.width = 36;
                    imgLocation.appendChild(img);
                }).catch((error) => {
                    console.error(error);
                });
            }
        },
        mounted () {

        }
    }
</script>

<style scoped>
    .Navbar {
        background: transparent;
        border-color: transparent;
    }
    .icon {
        width: 50px;
        height: 50px;
    }
</style>