<template>
    <!--编辑-->
    <el-dialog title="编辑" :visible.sync="dialogFormVisible">
        <el-form ref="editFormRef" :rules="rules" :model="editFormData" label-position="left" label-width="80px"
                 style="width: 400px; margin-left:50px;">
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
                                v-for="item in this.dictValueMap.sex"
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
            <el-button v-permission="['P_TEST_TEST4_UPDATE']" type="primary" @click="submitForm">
                保存
            </el-button>
        </div>
    </el-dialog>
</template>
<script>
    import {Test4UpdateRequest} from '@/sdk/api/test/test4/update'
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
                    this.dict('sex')
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
                        let request = new Test4UpdateRequest();
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
