<template>
    <div class="comment-tree">
        <div :style="indent">
            {{label}} CHILD
            <v-btn :ripple="false" icon @click="parent(id)">
                <i class="far fa-comment 10x"></i>
            </v-btn>
            <comment v-if="comments[index] != undefined"  v-for="(comment, index) in comments" :key="index" :comments="comment.childComments" :label="comment.comment" :id="comment.id" :depth="depth + 1">
            </comment>
        </div>
    </div>
</template>

<script>
    import store from '../store'
    export default {
        name: "comment",
        props: [ 'label', 'comments', 'depth', 'id' ],
        computed: {
            indent() {
                return { transform: `translate(${this.depth * 50}px)` }
            }
        },
        methods:{
            parent(id){
                store.commit('changeParentComment',id);
                console.log(store.state.parentComment)
            }
        }
    }
</script>

<style scoped>

</style>