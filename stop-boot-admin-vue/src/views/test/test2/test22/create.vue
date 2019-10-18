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

            this.loading = true;

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
