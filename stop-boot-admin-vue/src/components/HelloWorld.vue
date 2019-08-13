<template>
  <div class="hello">
    <h1>{{ msg }} </h1>
    <el-form :model="loginForm">
      <h2>Ray商城登录</h2>
      <el-form-item>
        <el-input name="username" placeholder="请输入用户名/手机号" auto-complete="on"></el-input>
      </el-form-item>

      <el-form-item>
        <el-input  name="password" placeholder="请输入密码" auto-complete="on"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data(){
    return{
      msg:"this is a vue demo"
    }
  },
  mounted() {
    this.$axios.get("http://localhost:8080/").then(res=>{
      alert(res.data)
    });
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
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
