<template>
    <!--编辑-->
    <el-dialog title="编辑" :visible.sync="dialogFormVisible">
        <el-form ref="editFormRef" :rules="rules" :model="editFormData" label-position="left" label-width="100px">
                            <el-form-item label="id" prop="id">
                    <el-input v-model="editFormData.id"/>
                </el-form-item>
                <el-form-item label="pid" prop="pid">
                    <el-input v-model="editFormData.pid"/>
                </el-form-item>
                <el-form-item label="title" prop="title">
                    <el-input v-model="editFormData.title"/>
                </el-form-item>
                <el-form-item label="name" prop="name">
                    <el-input v-model="editFormData.name"/>
                </el-form-item>
                <el-form-item label="component" prop="component">
                    <el-input v-model="editFormData.component"/>
                </el-form-item>
                <el-form-item label="path" prop="path">
                    <el-input v-model="editFormData.path"/>
                </el-form-item>
                <el-form-item label="icon" prop="icon">
                    <el-input v-model="editFormData.icon"/>
                </el-form-item>
                <el-form-item label="type" prop="type">
                    <el-input v-model="editFormData.type"/>
                </el-form-item>
                <el-form-item label="link" prop="link">
                    <el-input v-model="editFormData.link"/>
                </el-form-item>
                <el-form-item label="code" prop="code">
                    <el-input v-model="editFormData.code"/>
                </el-form-item>
                <el-form-item label="hidden" prop="hidden">
                    <el-input v-model="editFormData.hidden"/>
                </el-form-item>
                <el-form-item label="status" prop="status">
                    <el-input v-model="editFormData.status"/>
                </el-form-item>
                <el-form-item label="sort" prop="sort">
                    <el-input v-model="editFormData.sort"/>
                </el-form-item>
                <el-form-item label="deleteFlag" prop="deleteFlag">
                    <el-input v-model="editFormData.deleteFlag"/>
                </el-form-item>
                <el-form-item label="opUserId" prop="opUserId">
                    <el-input v-model="editFormData.opUserId"/>
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
            <el-button v-permission="['P_SYSTEM_MENU_UPDATE']" type="primary" @click="submitForm">
                保存
            </el-button>
        </div>
    </el-dialog>
</template>
<script>
    import {MenuUpdateRequest} from '@/sdk/api/system/menu/update'

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
            pid:
            undefined,
            title:
            undefined,
            name:
            undefined,
            component:
            undefined,
            path:
            undefined,
            icon:
            undefined,
            type:
            undefined,
            link:
            undefined,
            code:
            undefined,
            hidden:
            undefined,
            status:
            undefined,
            sort:
            undefined,
            deleteFlag:
            undefined,
            opUserId:
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
                            let request = new MenuUpdateRequest();
                            request.setParams(this.editFormData)
                                .api().then(res => {
                                this.dialogFormVisible = false
                                this.$emit('loadData');
                                this.$message({
                                    type: 'success',
                                    message: '修改成功!'
                                });
                                console.log("MenuUpdateRequest res:", res)
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
