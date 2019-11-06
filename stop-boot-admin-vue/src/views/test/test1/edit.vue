<template>
    <!--编辑-->
    <el-dialog title="编辑" :visible.sync="dialogFormVisible">
        <el-form ref="editFormRef" :rules="rules" :model="editFormData" label-position="left" label-width="100px">
                        <el-form-item prop="id" label="id" >
                    <el-input v-model="editFormData.id"/>
            </el-form-item>
            <el-form-item prop="name" label="姓名" >
                    <el-input v-model="editFormData.name"/>
            </el-form-item>
            <el-form-item prop="age" label="年龄" >
                    <el-input v-model="editFormData.age"/>
            </el-form-item>
            <el-form-item prop="birthday" label="生日" >
                    <el-date-picker
                            v-model="editFormData.birthday"
                            type="date"
                            placeholder="生日">
                    </el-date-picker>
            </el-form-item>
            <el-form-item prop="info" label="信息" >
                    <el-input v-model="editFormData.info"/>
            </el-form-item>
            <el-form-item prop="status" label="状态" >
                    <el-select v-model="editFormData.status" placeholder="请选择">
                        <el-option
                                v-for="item in this.dictValueList"
                                :key="item.id"
                                :label="item.dicDesc"
                                :value="item.dicValue">
                        </el-option>
                    </el-select>
            </el-form-item>
            <el-form-item prop="headImg" label="头像" >
                    <el-input v-model="editFormData.headImg"/>
            </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="cancleForm">
                取消
            </el-button>
            <el-button v-permission="['P_TEST_TEST3_UPDATE']" type="primary" @click="submitForm">
                保存
            </el-button>
        </div>
    </el-dialog>
</template>
<script>
    import {Test3UpdateRequest} from '@/sdk/api/test/test3/update'

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
                id: undefined,
                name: undefined,
                age: undefined,
                birthday: undefined,
                info: undefined,
                status: undefined,
                headImg: undefined,
                },
                dialogFormVisible: false,
                rules:{
                    name: [
                        {required: true, message: '请输入姓名', trigger: 'blur'},
                    ],
                    age: [
                        {required: true, message: '请输入年龄', trigger: 'blur'},
                    ],
                    birthday: [
                        {required: true, message: '请输入生日', trigger: 'blur'},
                    ],
                    info: [
                        {required: true, message: '请输入信息', trigger: 'blur'},
                    ],
                    status: [
                        {required: true, message: '请输入状态', trigger: 'blur'},
                    ],
                    headImg: [
                        {required: true, message: '请输入头像', trigger: 'blur'},
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
                            let request = new Test3UpdateRequest();
                            request.setParams(this.editFormData)
                                .api().then(res => {
                                this.dialogFormVisible = false
                                this.$emit('loadData');
                                this.$message({
                                    type: 'success',
                                    message: '修改成功!'
                                });
                                console.log("Test3UpdateRequest res:", res)
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
