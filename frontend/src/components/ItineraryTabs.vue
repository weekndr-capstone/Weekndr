<template>
    <div>
        <v-tabs
                v-model="active"
                light
                slider-color="black"
        >
            <v-tab
                    v-for="n in 3"
                    :key="n"
                    ripple
            >
                Item {{ n }}

            </v-tab>
            <v-tab-item
                    v-for="n in 3"
                    :key="n"
            >
                <v-card flat>
                    <v-card-text>{{ text }}</v-card-text>
                </v-card>
            </v-tab-item>
        </v-tabs>

    </div>
</template>

<script>
    export default {
        name: "ItineraryTabs"
    }
</script>

<style scoped>

</style>