<template>
    <FullCardItem/>
</template>
<script>
    import FullCardItem from '../components/FullCardItem'
    export default {
        name: "singleView",
        components:{
            FullCardItem
        },
        props: {
            singleResult: Object
        }
    }
</script>

<style scoped>

</style>