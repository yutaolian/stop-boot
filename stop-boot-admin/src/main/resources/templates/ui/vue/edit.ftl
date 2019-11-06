<template>
    <!--编辑-->
    <el-dialog title="编辑" :visible.sync="dialogFormVisible">
        <el-form ref="editFormRef" :rules="rules" :model="editFormData" label-position="left" label-width="100px">
            <#list tableColumnsData as colum>
            <#if colum.editShow ==true>
            <el-form-item prop="${colum.camelColumnName}" label="${colum.chineseName}" >
                <#if colum.componentName =='DateTimePicker'>
                    <el-date-picker
                            v-model="editFormData.${colum.camelColumnName}"
                            type="datetime"
                            placeholder="${colum.chineseName}">
                    </el-date-picker>
                <#elseif colum.componentName =='DatePicker'>
                    <el-date-picker
                            v-model="editFormData.${colum.camelColumnName}"
                            type="date"
                            placeholder="${colum.chineseName}">
                    </el-date-picker>
                <#elseif colum.componentName =='TimePicker'>
                    <el-time-select
                            v-model="editFormData.${colum.camelColumnName}"
                            placeholder="${colum.chineseName}">
                    </el-time-select>
                <#elseif colum.componentName =='Select'>
                    <el-select v-model="editFormData.${colum.camelColumnName}" placeholder="请选择">
                        <el-option
                                v-for="item in this.dictValueList"
                                :key="item.id"
                                :label="item.dicDesc"
                                :value="item.dicValue">
                        </el-option>
                    </el-select>
                <#else>
                    <el-input v-model="editFormData.${colum.camelColumnName}"/>
                </#if>
            </el-form-item>
            </#if>
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
            <#if colum.editShow ==true>
                ${colum.camelColumnName}: undefined,
            </#if>
            </#list>
                },
                dialogFormVisible: false,
                rules:{
                <#list tableColumnsData as colum>
                <#if colum.createShow ==true>
                    ${colum.camelColumnName}: [
                        {required: true, message: '请输入${colum.chineseName}', trigger: 'blur'},
                    ],
                </#if>
                </#list>
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
