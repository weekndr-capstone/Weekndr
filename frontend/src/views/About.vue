<template>
    <v-img :src="pictureToDisplay" background-position aspect-ratio="2">
        <Toolbar/>
        <v-container>
            <v-flex xs12>
                <v-card class="mx-1 mb-3 opacity">
                <v-card-text class="display-1 text-xs-center orangeColor font-weight-bold">Weekndr</v-card-text>
                <v-card-text class="title mb-3 text-xs-center">An Application for all of your travel needs. Create travel groups and plan your whole travel itinerary in one place. Plan Hotels, Restaurants, and Experiences and communicate to your group with ease. (Spring Boot, Java , Vue , Vuetify, JavaScript, MySQL, HTML, CSS)</v-card-text>
                </v-card>
            </v-flex>
            <v-layout row wrap justify-center>
                <v-flex xs10 md4>
                    <v-card class="mx-1 mb-3 opacity">
                        <v-img
                                src="https://s3.amazonaws.com/alumni.codeup.com/AllenJustinBlanco.jpg"
                                aspect-ratio="1"
                        ></v-img>
                        <v-card-text class="px-0 text-xs-center display-1">Justin Blanco</v-card-text>
                        <v-layout row wrap justify-center>
                            <v-flex xs12>
                                <v-card-text class="px-0 text-xs-center display-1"><a href="https://alumni.codeup.com/students/605" target="_blank"><i class="fas fa-user"></i> Codeup</a></v-card-text>
                            </v-flex>
                        <v-flex xs12>
                        <v-card-text class="px-0 text-xs-center display-1"><a href="https://www.linkedin.com/in/justin-blanco/" target="_blank"><i class="fab fa-linkedin"></i> LinkedIn</a></v-card-text>
                        </v-flex>
                        <v-flex xs12>
                            <v-card-text class="px-0 text-xs-center display-1"><a href="https://github.com/allenjustinblanco" target="_blank"><i class="fab fa-github"></i> Github</a> </v-card-text>
                        </v-flex>
                        </v-layout>
                    </v-card>
                </v-flex>

                <v-flex xs10 md4>
                    <v-card class="mx-1 mb-3 opacity">
                        <v-img
                                src="https://s3.amazonaws.com/alumni.codeup.com/LexiMorgan.jpg"
                                aspect-ratio="1"
                        ></v-img>
                        <v-card-text class="px-0 text-xs-center display-1">Lexi Morgan</v-card-text>
                        <v-layout row wrap justify-center>
                            <v-flex xs12>
                                <v-card-text class="px-0 text-xs-center display-1"><a href="https://alumni.codeup.com/students/602" target="_blank"><i class="fas fa-user"></i> Codeup</a></v-card-text>
                            </v-flex>
                            <v-flex xs12>
                                <v-card-text class="px-0 text-xs-center display-1"><a href="https://www.linkedin.com/in/lexi-morgan/" target="_blank"><i class="fab fa-linkedin"></i> LinkedIn</a></v-card-text>
                            </v-flex>
                            <v-flex xs12>
                                <v-card-text class="px-0 text-xs-center display-1"><a href="https://github.com/LexiPedrottiMorgan" target="_blank"><i class="fab fa-github"></i> Github</a></v-card-text>
                            </v-flex>
                        </v-layout>
                    </v-card>
                </v-flex>

                <v-flex xs10 md4>
                    <v-card class="mx-1 mb-3 opacity">
                        <v-img
                                src="https://s3.amazonaws.com/alumni.codeup.com/LandonHarvey.jpg"
                                aspect-ratio="1"
                        ></v-img>
                        <v-card-text class="px-0 text-xs-center display-1">Landon Harvey</v-card-text>
                        <v-layout row wrap justify-center>
                            <v-flex xs12>
                                <v-flex xs12>
                                    <v-card-text class="px-0 text-xs-center display-1"><a href="https://alumni.codeup.com/students/599" target="_blank"><i class="fas fa-user"></i> Codeup</a></v-card-text>
                                </v-flex>
                            </v-flex>
                            <v-flex xs12>
                                <v-card-text class="px-0 text-xs-center display-1"><a href="https://www.linkedin.com/in/landon-harvey/" target="_blank"><i class="fab fa-linkedin"></i> LinkedIn</a></v-card-text>
                            </v-flex>
                            <v-flex xs12>
                                <v-card-text class="px-0 text-xs-center display-1"><a href="https://github.com/landon-harvey" target="_blank"><i class="fab fa-github"></i> Github</a></v-card-text>
                            </v-flex>
                        </v-layout>
                    </v-card>
                </v-flex>

            </v-layout>
        </v-container>
        </v-img>
</template>

<script>
    import Toolbar from "../components/Toolbar";
    export default {
        name: "About",
        components: {Toolbar},
        data() {
            return {
                pictureToDisplay: '',
            }
        },
        mounted() {
            let pictures = [1050, 1015, 989, 986, 985, 973, 961, 941, 916, 901, 890, 864, 862, 853, 829, 641, 517, 436, 1084, 938, 908, 907, 877, 851, 10, 11];
            let randomIndex = Math.floor(Math.random() * pictures.length);
            this.pictureToDisplay = "https://picsum.photos/1920/1080?image=" + pictures[randomIndex];
        }
    }
</script>

<style scoped>
    a {
        color: #E96445;
        text-decoration: none;
    }
    a:hover {
        transform: scale(1.5);
    }
    .orangeColor {
        color: #E96445;
    }
    .opacity {
        background-color: rgba(255, 255, 255, 0.8);
    }
</style>