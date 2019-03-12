<template>

        <v-container>
            <v-toolbar flat>
                <v-toolbar-side-icon></v-toolbar-side-icon>
                <v-toolbar-title>Weekndr</v-toolbar-title>
                <v-spacer></v-spacer>
                <v-toolbar-items class="hidden-sm-and-down">
                    <v-btn flat>Help</v-btn>
                    <v-btn flat>Sign up</v-btn>
                    <v-btn flat>Login</v-btn>
                </v-toolbar-items>
            </v-toolbar>
        </v-container>

</template>

<script>
    export default {
        name: "Toolbar"
    }
</script>

<style scoped>

</style>