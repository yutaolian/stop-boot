<template>
  
  <el-dialog
    :title="dialogTitle"
    :visible.sync="dialogVisible"
    :before-close="handleClose"
  >
  
    <el-form
      label-position="right"
      label-width="auto"
      :model="msg"
      :rules="rules"
      ref='dialogCom'
    >
    <el-row>
      <el-col :span="12">
        <el-form-item
          v-for="(item,key) in dataFormat"
          :key="key"
          :label="item"
          :prop='item'
          v-if="key%2!=0"
        >
          <el-input v-model="msg[item]"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item
          v-for="(item,key) in dataFormat"
          :key="key"
          :label="item"
          :prop='item'
          v-if="key%2==0"
        >
          <el-input v-model="msg[item]"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
      <el-form-item>
        <el-button
          type="primary"
          @click="submitForm"
        >提交</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>
<script>
export default {
  name: 'dialogComponent',
  props:['data','dialogTitle','vdata','rules'],  //接收父组件的传值
  data(){
    return {
      dialogVisible:false,
      msg:{},
    }
  },
  computed:{
    dataFormat(){
      return Object.keys(this.data)
    }
  },
  methods:{
    handleClose(){
      this.dialogVisible = false;
    },
    submitForm(){
      this.$refs.dialogCom.validate((valid) => {
        if (valid) {
          console.log('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    }
  },
  watch:{
    dialogVisible(val){
      if(val){
        this.msg = JSON.parse(JSON.stringify(this.vdata));
      }
    }
  }
};
</script>
