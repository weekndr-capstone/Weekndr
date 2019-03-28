<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-toolbar flat class="Navbar">
        <v-flex xs5 sm3 md2 xl1>
            <router-link :to="'/'">
                <v-img :src="require('../assets/weekdnr_logo.svg')" class="icon"></v-img>
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
                                <v-form ref="form" v-model="valid" lazy-validation>
                                    <v-layout wrap>
                                        <v-flex xs12>
                                            <v-text-field v-model="user.phoneNumber" label="Phone Number*" required solo :rules="phoneRules"></v-text-field>
                                        </v-flex>
                                        <v-flex xs12>
                                            <v-text-field v-model="user.email" label="Email Address*" required solo :rules="emailRules"></v-text-field>
                                        </v-flex>
                                        <v-flex xs12>
                                            <v-text-field v-model="user.username" label="Username*" required solo :rules="userRules"></v-text-field>
                                        </v-flex>
                                        <v-flex xs12>
                                            <v-text-field v-model="user.password" label="Password*" type="password" required solo :rules="passRules"></v-text-field>
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
                                </v-form>
                            </v-container>
                        </v-card-text>
                    </v-card>
                </v-dialog>
                <v-layout v-if="loggedIn" justify-end fill-height>
                    <v-avatar  id="avatar" class="avatar-margin" size="40px"/>
                    <v-menu v-model="menu" :close-on-content-click="false">
                        <template v-slot:activator="{ on }">
                            <v-btn flat v-on="on">Menu</v-btn>
                        </template>
                        <v-card min-height="200px">
                            <v-list>
                                <v-list-tile avatar>
                                    <v-list-tile-avatar>
                                        <v-avatar  id="avatar" class="avatar-margin" size="40px"/>
                                    </v-list-tile-avatar>
                                    <v-list-tile-content>
                                        <v-list-tile-title>{{username}}</v-list-tile-title>
                                    </v-list-tile-content>
                                </v-list-tile>
                            </v-list>

                            <v-divider></v-divider>
                            <v-list>
                                <v-list-tile>
                                    <v-list-tile-action>
                                        <router-link to="/current">
                                            <v-btn flat>Current/Upcoming</v-btn>
                                        </router-link>
                                        <router-link to="/triphistory">
                                            <v-btn flat>Past Trips</v-btn>
                                        </router-link>
                                        <v-btn flat @click="menu = false">Cancel</v-btn>
                                    </v-list-tile-action>
                                </v-list-tile>
                            </v-list>
                        </v-card>
                    </v-menu>
                    <v-btn flat @click="logout()">Logout</v-btn>
                </v-layout>
                <v-dialog v-if="!loggedIn" v-model="Login" max-width="550px">
                    <template  v-slot:activator="{ on }">
                        <v-btn flat v-on="on">Login</v-btn>
                    </template>
                    <v-card>
                        <v-card-text>
                            <v-container grid-list-md>
                                <v-toolbar-title class="display-1">Login</v-toolbar-title>
                                <br>
                                <v-form ref="form2" v-model="valid2" lazy-validation>
                                    <v-layout wrap>
                                        <v-flex xs12>
                                            <v-text-field v-model="userLogin.username" label="Username" required solo :rules="loginUsernameRules"></v-text-field>
                                        </v-flex>
                                        <v-flex xs12>
                                            <v-text-field v-model="userLogin.password" label="Password" type="password" required solo :rules="passLoginRules"></v-text-field>
                                        </v-flex>
                                        <v-card-text class="red--text">{{loginRules}}</v-card-text>
                                    </v-layout>
                                </v-form>
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
            valid: true,
            valid2:true,
            username: '',
            phoneRules: [
                v => !!v || 'Phone Number is required',
                v => (v && v.length === 10) || 'Phone Number must be 10 numbers excluding dashes - '
            ],
            emailRules: [
                v => !!v || 'Email is required',
                v => /.+@.+/.test(v) || 'E-mail must be valid'
            ],
            userRules: [
                v => !!v || 'Username is required',
                v => (v && v.length >= 5) || 'Username must be greater than 5 characters'
            ],
            passRules: [
                v => !!v || 'Password is required',
                v => (v && v.length >= 5) || 'Password must be greater than 5 characters'
            ],
            passLoginRules: [
                v => !!v || 'Password is required',
            ],
            loginUsernameRules: [
                v => !!v || 'Username is required',
            ],
            loginRules:'',
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
            validate () {
                this.valid = !!this.$refs.form.validate();
            },
            validate2 () {
                this.valid2 = !!this.$refs.form2.validate();
            },
            async getPlace(place, index){
                await axios({
                    method: 'GET',
                    url: '/place',
                    params: {
                        id: user
                    }
                }).then(res => {
                    console.log(res.data);
                    Vue.set(temp.trips.places,index,res.data)
                })
            },
            signup(){
                this.validate();
                console.log(this.valid);
                console.log(this.valid2);
                if (this.valid) {
                    axios
                        .post('/signup', this.user)
                        .then(res => {
                            this.SignUp = false;
                            this.displayAvatar();
                            console.log(res.data)
                        }).catch(err => {
                        console.log(err.data)
                    })
                }
            },
            login(){
                this.validate2();
                if (this.valid2) {
                    axios({
                        method: 'POST',
                        url: '/async-login',
                        params: {
                            username: this.userLogin.username,
                            password: this.userLogin.password
                        }
                    })
                        .then(res => {
                            if (res.data.email != null) {
                                let temp = res.data;
                                store.commit('changeLoggedIn', true);
                                store.commit('changeUser', res.data);
                                this.username = res.data.username;
                                this.Login = false;
                                this.displayAvatar();
                            } else {
                                this.loginRules = 'Incorrect Login Try Again'
                            }
                        }).catch(err => {
                        this.loginRules = 'Our Gnomes have stopped working try again';
                        console.log(err)
                    })
                }
            },
            logout(){
                store.commit('changeUser', '');
                store.commit('changeLoggedIn', false);
                store.commit('changeCurrentlyViewedTrip', '');
                this.Login = false;
                router.push('/');
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
                };
                client.picker(options).open();
            },
            displayAvatar(){
                const apikey = 'AsNx10Lk3SEiGRvMmw223z';
                const client = filestack.init(apikey);

                let handler = store.state.user.img_path;

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

    a {
        text-decoration: none;
    }

</style>