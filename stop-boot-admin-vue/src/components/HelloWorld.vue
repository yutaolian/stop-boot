<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>Essential Links</h2>

    <h3>{{  this.$store.state.count }}</h3>

    <h3>{{ this.$store.getters.getStateCount }}</h3>

    <p>count的值 {{this.$store.state.count}}</p>
    <button @click="add">+</button>
    <button @click="sub">-</button>
    <p>count1： {{ count1 }}</p>



    <router-link to="/login">login</router-link>
  </div>
</template>

<script>

import {mapState} from 'vuex'

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    add () {
      var n = 5
      // this.$store.commit('add')
      this.$store.dispatch('addA', n)
    },

    sub () {
      // this.$store.commit('sub')
      this.$store.dispatch('subA')
    }
  },
  computed: {
    ...mapState({
      count1: state => state.count
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
