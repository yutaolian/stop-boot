<template>
    <!--编辑-->
    <el-dialog title="编辑" :visible.sync="dialogFormVisible">
        <el-form ref="editFormRef" :rules="rules" :model="editFormData" label-position="left" label-width="100px">
                            <el-form-item label="id" prop="id">
                    <el-input v-model="editFormData.id"/>
                </el-form-item>
                <el-form-item label="name" prop="name">
                    <el-input v-model="editFormData.name"/>
                </el-form-item>
                <el-form-item label="mobile" prop="mobile">
                    <el-input v-model="editFormData.mobile"/>
                </el-form-item>
                <el-form-item label="password" prop="password">
                    <el-input v-model="editFormData.password"/>
                </el-form-item>
                <el-form-item label="email" prop="email">
                    <el-input v-model="editFormData.email"/>
                </el-form-item>
                <el-form-item label="status" prop="status">
                    <el-input v-model="editFormData.status"/>
                </el-form-item>
                <el-form-item label="deleteFlag" prop="deleteFlag">
                    <el-input v-model="editFormData.deleteFlag"/>
                </el-form-item>
                <el-form-item label="createTime" prop="createTime">
                    <el-input v-model="editFormData.createTime"/>
                </el-form-item>
                <el-form-item label="updateTime" prop="updateTime">
                    <el-input v-model="editFormData.updateTime"/>
                </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="cancleForm">
                取消
            </el-button>
            <el-button v-permission="['P_USER_LIST_UPDATE']" type="primary" @click="submitForm">
                保存
            </el-button>
        </div>
    </el-dialog>
</template>
<script>
    import {UserListUpdateRequest} from '@/sdk/api/user/list/update'

    export default {
        name: 'edit_form',
        props: ['rowData'],  //接收父组件的传值
        watch: {
            dialogFormVisible(val) {
                if (val) {
                    console.log(this.rowData)
                    this.editFormData = this.rowData
                }
            }
        },
        data() {
            return {
                loading: false,
                editFormData: {
            id:
            undefined,
            name:
            undefined,
            mobile:
            undefined,
            password:
            undefined,
            email:
            undefined,
            status:
            undefined,
            deleteFlag:
            undefined,
            createTime:
            undefined,
            updateTime:
            undefined,
        },
            dialogFormVisible: false,
                rules
        :
            {
                name: [
                    {required: true, message: '请输入名称', trigger: 'blur'},
                ],
            }
        }
        },
        methods: {
            submitForm() {
                this.$refs['editFormRef'].validate((valid) => {
                    if (valid) {
                        this.$confirm('此操作将提交修改数据, 是否继续?', '提示', {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning'
                        }).then(() => {
                            let request = new UserListUpdateRequest();
                            request.setParams(this.editFormData)
                                .api().then(res => {
                                this.dialogFormVisible = false
                                this.$emit('loadData');
                                this.$message({
                                    type: 'success',
                                    message: '修改成功!'
                                });
                                console.log("UserListUpdateRequest res:", res)
                            })
                        }).catch((err) => {
                            this.$message({
                                type: 'info',
                                message: '已取消'
                            });
                            console.log("err:", err)
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
        }
    }
</script>
