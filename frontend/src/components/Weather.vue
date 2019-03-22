<template>
    <div :v-text="Results">

    </div>
</template>

<script>
    export default {
        name: "Weather",
    props:{
        Results: Array,
    },
    data() {
        return {
        }
        }
    }
</script>

<style scoped>

</style>