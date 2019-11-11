<template>
    <!--编辑-->
    <el-dialog title="编辑" :visible.sync="dialogFormVisible">
        <el-form ref="editFormRef" :rules="rules" :model="editFormData" label-position="left" label-width="80px"
                 style="width: 400px; margin-left:50px;">
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
                                v-for="item in this.dictValueMap.${colum.dicKey}"
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
    //接口混入
    import api from '@/mixins/api'

    export default {
        name: 'edit_form',
        props: ['rowData'],  //接收父组件的传值
        mixins: [api],
        watch: {
            dialogFormVisible(val) {
                if (val) {
                    this.editFormData = this.rowData
                    <#list tableColumnsData as colum>
                    <#if colum.searchShow ==true>
                    <#if colum.componentName =='Select'>
                    this.dict('${colum.dicKey}')
                    </#if>
                    </#if>
                    </#list>
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
                        let request = new ${model?cap_first}UpdateRequest();
                        request.setParams(this.editFormData)
                        this.update(request).then(res => {
                            this.dialogFormVisible = false
                            this.$emit('loadData');
                        })
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
