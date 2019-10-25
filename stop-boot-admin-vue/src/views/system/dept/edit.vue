<template>
    <!--编辑-->
    <el-dialog title="编辑" :visible.sync="dialogFormVisible">
        <el-form ref="editFormRef" :rules="rules" :model="editForm" label-position="left" label-width="70px"
                 style="width: 400px; margin-left:50px;">
                        <el-form-item label="id" prop="id">
                <el-input v-model="editForm.id"/>
            </el-form-item>
            <el-form-item label="createTime" prop="createTime">
                <el-input v-model="editForm.createTime"/>
            </el-form-item>
            <el-form-item label="updateTime" prop="updateTime">
                <el-input v-model="editForm.updateTime"/>
            </el-form-item>
            <el-form-item label="opUserId" prop="opUserId">
                <el-input v-model="editForm.opUserId"/>
            </el-form-item>
            <el-form-item label="status" prop="status">
                <el-input v-model="editForm.status"/>
            </el-form-item>
            <el-form-item label="deleteFlag" prop="deleteFlag">
                <el-input v-model="editForm.deleteFlag"/>
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
                        this.$confirm('此操作将提交修改数据, 是否继续?', '提示', {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning'
                        }).then(() => {
                            this.$message({
                                type: 'success',
                                message: '修改成功!'
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
