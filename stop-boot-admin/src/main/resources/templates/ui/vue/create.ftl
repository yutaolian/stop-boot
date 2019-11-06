<template>
    <!--新增-->
    <el-dialog title="新增" :visible.sync="dialogFormVisible">
        <el-form ref="createFormRef" :rules="rules" :model="createFormData" label-position="left" label-width="100px">
            <#list tableColumnsData as colum>
             <#if colum.createShow ==true>
            <el-form-item prop="${colum.camelColumnName}" label="${colum.chineseName}" >
                <#if colum.componentName =='DateTimePicker'>
                    <el-date-picker
                            v-model="createFormData.${colum.camelColumnName}"
                            type="datetime"
                            placeholder="${colum.chineseName}">
                    </el-date-picker>
                <#elseif colum.componentName =='DatePicker'>
                    <el-date-picker
                            v-model="createFormData.${colum.camelColumnName}"
                            type="date"
                            placeholder="${colum.chineseName}">
                    </el-date-picker>
                <#elseif colum.componentName =='TimePicker'>
                    <el-time-select
                            v-model="createFormData.${colum.camelColumnName}"
                            placeholder="${colum.chineseName}">
                    </el-time-select>
                <#elseif colum.componentName =='Select'>
                    <el-select v-model="createFormData.${colum.camelColumnName}" placeholder="请选择">
                        <el-option
                                v-for="item in this.dictValueList"
                                :key="item.id"
                                :label="item.dicDesc"
                                :value="item.dicValue">
                        </el-option>
                    </el-select>
                <#else>
                    <el-input v-model="createFormData.${colum.camelColumnName}"/>
                </#if>
            </el-form-item>
            </#if>
            </#list>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="resetForm">
                重置
            </el-button>
            <el-button v-permission="['${fullPathToPermission}_ADD']" type="primary" @click="submitForm">
                提交
            </el-button>
        </div>
    </el-dialog>
</template>
<script>
    //接口
    import {${model?cap_first}AddRequest} from '@${jsSdkConfigPath}${fullPath}/add'

    export default {
        name: 'create_form',
        props: ['rowData'],  //接收父组件的传值
        watch: {
            dialogFormVisible(val) {
                if (val) {
                    this.createFormData = this.rowData
                }
            }
        },
        data() {
            return {
                loading: false,
                createFormData: {
            <#list tableColumnsData as colum>
            <#if colum.createShow ==true>
                    ${colum.camelColumnName}: undefined,
            </#if>
            </#list>
                },
                dialogFormVisible: false,
                rules: {
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
                this.$refs['createFormRef'].validate((valid) => {
                    if (valid) {
                        this.$confirm('此操作将提交数据, 是否继续?', '提示', {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning'
                        }).then(() => {
                            let request = new ${model?cap_first}AddRequest();
                            request.setParams(this.createFormData)
                                .api().then(res => {
                                this.dialogFormVisible = false
                                this.$emit('loadData');
                                this.$message({
                                    type: 'success',
                                    message: '新增成功!'
                                });
                                console.log("${model?cap_first}AddRequest res:", res)
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
            resetForm() {
                this.$refs['createFormRef'].resetFields();
            }
        }
    }
</script>
