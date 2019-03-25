<template>
    <div>
        <Toolbar/>
        <FullCardItem :hotel="hotel"/>
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
            singleResult: Object,
            hotel: Boolean
        }
    }
</script>

<style scoped>

</style>