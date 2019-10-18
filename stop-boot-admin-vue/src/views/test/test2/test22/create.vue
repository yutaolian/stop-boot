<template>
  <!--新增-->
    <el-dialog title="新增" :visible.sync="dialogFormVisible">
      <el-form ref="createFormRef" :rules="rules" :model="createForm" label-position="left" label-width="70px"
               style="width: 400px; margin-left:50px;">

        <el-form-item label="Title" prop="name">
          <el-input v-model="createForm.name"/>
        </el-form-item>

        <el-form-item label="Title" prop="name">
          <el-input v-model="createForm.name"/>
        </el-form-item>

        <el-form-item label="Title" prop="name">
          <el-input v-model="createForm.name"/>
        </el-form-item>

        <el-form-item label="Title" prop="name">
          <el-input v-model="createForm.name"/>
        </el-form-item>

        <el-form-item label="Title" prop="name">
          <el-input v-model="createForm.name"/>
        </el-form-item>

        <el-form-item label="Title" prop="name">
          <el-input v-model="createForm.name"/>
        </el-form-item>

        <el-form-item label="Title" prop="name">
          <el-input v-model="createForm.name"/>
        </el-form-item>

        <el-form-item label="Title" prop="name">
          <el-input v-model="createForm.name"/>
        </el-form-item>

        <el-form-item label="Title" prop="name">
          <el-input v-model="createForm.name"/>
        </el-form-item>

        <el-form-item label="Title" prop="name">
          <el-input v-model="createForm.name"/>
        </el-form-item>

        <el-form-item label="Title" prop="name">
          <el-input v-model="createForm.name"/>
        </el-form-item>

        <el-form-item label="Title" prop="name">
          <el-input v-model="createForm.name"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="resetForm">
          重置
        </el-button>
        <el-button type="primary" @click="onSubmit">
          创建
        </el-button>
      </div>
    </el-dialog>
</template>
<script>
  export default {
    name:'create_form',
    props:['dialogTitle'],  //接收父组件的传值
    data() {
      return {
        loading:false,
          createForm:{
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
        this.$refs['createFormRef'].validate((valid) => {
          if (valid) {
            this.$confirm('此操作将提交数据, 是否继续?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
              this.$message({
                type: 'success',
                message: '新增成功!'
              });
            }).catch(() => {
              this.$message({
                type: 'info',
                message: '已取消'
              });          
            });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm() {
        this.$refs['createFormRef'].resetFields();
      }
    }
  }
</script>
