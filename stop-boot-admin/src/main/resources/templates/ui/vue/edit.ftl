<template>
    <!--编辑-->
    <el-dialog title="编辑" :visible.sync="dialogFormVisible">
        <el-form ref="editFormRef" :rules="rules" :model="editFormData" label-position="left" label-width="100px">
            <#list tableColumnsData as colum>
                <el-form-item label="${colum.camelColumnName}" prop="${colum.camelColumnName}">
                    <el-input v-model="editFormData.${colum.camelColumnName}"/>
                </el-form-item>
            </#list>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="cancleForm">
                取消
            </el-button>
            <el-button v-permission="['${fullPathToPermission}_UPDATE']" type="primary" @click="submitForm">
                保存
            </el-button>
        </div>
    </el-dialog>
</template>
<script>
    import {${model?cap_first}UpdateRequest} from '@${jsSdkConfigPath}${fullPath}/update'

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
            <#list tableColumnsData as colum>
            ${colum.camelColumnName}:
            undefined,
            </#list>
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
                            let request = new ${model?cap_first}UpdateRequest();
                            request.setParams(this.editFormData)
                                .api().then(res => {
                                this.dialogFormVisible = false
                                this.$emit('loadData');
                                this.$message({
                                    type: 'success',
                                    message: '修改成功!'
                                });
                                console.log("${model?cap_first}UpdateRequest res:", res)
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
