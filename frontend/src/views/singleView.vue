<template>
    <div>
        <Toolbar/>
        <FullCardItem/>
    </div>
</template>
<script>
    import FullCardItem from '../components/FullCardItem'
    import Toolbar from '../components/Toolbar'
    export default {
        name: "singleView",
        components:{
            FullCardItem,
            Toolbar
        },
        props: {
            singleResult: Object
        }
    }
</script>

<style scoped>

</style>