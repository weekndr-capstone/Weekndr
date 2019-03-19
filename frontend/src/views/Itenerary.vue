<template>
    <div>
        <Toolbar/>
        <Timeline/>
    </div>
</template>

<script>
    import Timeline from "../components/Timeline";
    import Toolbar from '../components/Toolbar';

    export default {
        name: "Itenerary",
        components: {
            Timeline,
            Toolbar
        }
    }
</script>

<style scoped>

</style>