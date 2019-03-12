<template>
  <HelloWorld />
  <button @click="dotest()"></button>
</template>

<script>
  import HelloWorld from '../components/HelloWorld'
  import axios, {AxiosResponse} from "axios";

  export default {
    components: {
      HelloWorld
    },
    methods: {
        dotest() {
            axios
                .get("/place")
                .then(res => {
                    console.log(res)
                }).catch(err => {
                    console.log(err)
            })
        }
    }
  }
</script>
