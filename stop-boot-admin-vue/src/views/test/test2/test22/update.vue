<template>
  <!--编辑-->
    <el-dialog title="新增" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :rules="rules" :model="ruleForm" label-position="left" label-width="70px"
               style="width: 400px; margin-left:50px;">
        <el-form-item label="Title" prop="name">
          <el-input v-model="ruleForm.name"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="resetForm">
          重置
        </el-button>
        <el-button type="primary" @click="onSubmit">
          立即创建
        </el-button>
      </div>
    </el-dialog>
</template>
<script>
  export default {
    name:'update_test',
    props:['row'],  //接收父组件的传值
    data() {
      return {
        loading:false,
        ruleForm:{
          name:''
        },
        dialogFormVisible:false,
        rules: {
          name: [
            { required: true, message: '请输入名称', trigger: 'blur' },
          ],
        }
      }
    },
    methods: {
      onSubmit() {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            
            this.loading = true;

          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm() {
        this.$refs['dataForm'].resetFields();
      }
    },
    watch:{
      dialogFormVisible(val){
        if(val){
          console.log(this.row)
          this.ruleForm = this.row
        }
      }
    }
  }
</script>