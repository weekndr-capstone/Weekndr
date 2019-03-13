<template>
  <div>

  </div>
</template>

<script>
    import store from '../store'
    import axios from 'axios'
    export default {
        components: {

        },
        mounted() {
                axios
                    .get('/yelpList/'+ store.state.location)
                    .then(res => {
                        console.log(res)
                    }).catch(err => {
                        console.log(err)
                })
        }
    }
</script>