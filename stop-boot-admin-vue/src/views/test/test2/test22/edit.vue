<template>
  <!--编辑-->
  <el-dialog title="编辑" :visible.sync="dialogFormVisible">
    <el-form ref="editFormRef" :rules="rules" :model="editForm" label-position="left" label-width="70px"
             style="width: 400px; margin-left:50px;">
      <el-form-item label="Title" prop="name">
        <el-input v-model="editForm.name"/>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="cancleForm">
        取消
      </el-button>
      <el-button type="primary" @click="onSubmit">
        保存
      </el-button>
    </div>
  </el-dialog>
</template>
<script>
    export default {
        name: 'edit_form',
        props: ['row'],  //接收父组件的传值
        data() {
            return {
                loading: false,
                editForm: {
                    name: ''
                },
                dialogFormVisible: false,
                rules: {
                    name: [
                        {required: true, message: '请输入名称', trigger: 'blur'},
                    ],
                }
            }
        },
        methods: {
            onSubmit() {
                this.$refs['editFormRef'].validate((valid) => {
                    if (valid) {

                        this.loading = true;

                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            cancleForm() {
                this.dialogFormVisible = false
            }
        },
        watch: {
            dialogFormVisible(val) {
                if (val) {
                    console.log(this.row)
                    this.ruleForm = this.row
                }
            }
        }
    }
</script>
