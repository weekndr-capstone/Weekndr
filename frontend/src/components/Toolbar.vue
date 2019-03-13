<template>
    <div>
    <v-toolbar flat class="Navbar">
        <v-toolbar-side-icon  @click.stop="drawer = !drawer" class="hidden-md-and-up"></v-toolbar-side-icon>
        <v-toolbar-title>Weekndr</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items class="hidden-sm-and-down">
            <v-btn flat>Help</v-btn>
            <v-dialog v-model="SignUp" persistent max-width="600px">
                <template v-slot:activator="{ on }">
                    <v-btn flat v-on="on">Sign Up</v-btn>
                </template>
                <v-card>
                    <v-card-text>
                        <v-container grid-list-md>
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
                                <small>*indicates required field</small>
                            </v-layout>
                        </v-container>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn flat @click="SignUp = false">Close</v-btn>
                        <v-btn flat @click="SignUp = false">Login</v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
                <v-dialog v-model="Login" persistent max-width="600px">
                    <template v-slot:activator="{ on }">
                        <v-btn flat v-on="on">Login</v-btn>
                    </template>
                    <v-card>
                        <v-card-text>
                            <v-container grid-list-md>
                                <v-layout wrap>
                                    <v-flex xs12>
                                        <v-text-field label="Email Address" required solo></v-text-field>
                                    </v-flex>
                                    <v-flex xs12>
                                        <v-text-field label="Password" type="password" required solo></v-text-field>
                                    </v-flex>
                                </v-layout>
                            </v-container>
                            </v-card-text>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn flat @click="Login = false">Close</v-btn>
                            <v-btn flat @click="Login = false">Login</v-btn>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
        </v-toolbar-items>
    </v-toolbar>
        <v-navigation-drawer
                v-model="drawer"
                temporary
                absolute
                width = "200"
                id = "drawer"
        >
            <v-toolbar flat>
                <v-list>
                    <v-list-tile>
                        <v-list-tile-title class="title">
                            Application
                        </v-list-tile-title>
                    </v-list-tile>
                </v-list>
            </v-toolbar>

            <v-divider></v-divider>

            <v-list dense class="pt-0">
                <v-list-tile>
                    <v-list-tile-content>
                        <v-list-tile-title>Home</v-list-tile-title>
                        <v-list-tile-title>Sign Up</v-list-tile-title>
                        <v-list-tile-title>Login</v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>
            </v-list>
        </v-navigation-drawer>
    </div>
</template>

<script>
    export default {
        name: "Toolbar",
        data: () => ({
            SignUp: false,
            Login: false,
            drawer: null
        })
    }
</script>

<style scoped>
    .Navbar {
        background: transparent;
        border-color: transparent;
    }
</style>