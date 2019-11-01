<template>
  <!--新增-->
  <el-dialog title="新增" :visible.sync="dialogFormVisible">
    <el-form ref="createFormRef" :rules="rules" :model="createFormData" label-position="left" label-width="100px">
      <el-form-item label="id" prop="id">
        <el-input v-model="createFormData.id"/>
      </el-form-item>
      <el-form-item label="pid" prop="pid">
        <el-input v-model="createFormData.pid"/>
      </el-form-item>
      <el-form-item label="title" prop="title">
        <el-input v-model="createFormData.title"/>
      </el-form-item>
      <el-form-item label="name" prop="name">
        <el-input v-model="createFormData.name"/>
      </el-form-item>
      <el-form-item label="component" prop="component">
        <el-input v-model="createFormData.component"/>
      </el-form-item>
      <el-form-item label="path" prop="path">
        <el-input v-model="createFormData.path"/>
      </el-form-item>
      <el-form-item label="icon" prop="icon">
        <el-input v-model="createFormData.icon"/>
      </el-form-item>
      <el-form-item label="type" prop="type">
        <el-input v-model="createFormData.type"/>
      </el-form-item>
      <el-form-item label="link" prop="link">
        <el-input v-model="createFormData.link"/>
      </el-form-item>
      <el-form-item label="code" prop="code">
        <el-input v-model="createFormData.code"/>
      </el-form-item>
      <el-form-item label="hidden" prop="hidden">
        <el-input v-model="createFormData.hidden"/>
      </el-form-item>
      <el-form-item label="status" prop="status">
        <el-input v-model="createFormData.status"/>
      </el-form-item>
      <el-form-item label="sort" prop="sort">
        <el-input v-model="createFormData.sort"/>
      </el-form-item>
      <el-form-item label="deleteFlag" prop="deleteFlag">
        <el-input v-model="createFormData.deleteFlag"/>
      </el-form-item>
      <el-form-item label="opUserId" prop="opUserId">
        <el-input v-model="createFormData.opUserId"/>
      </el-form-item>
      <el-form-item label="createTime" prop="createTime">
        <el-input v-model="createFormData.createTime"/>
      </el-form-item>
      <el-form-item label="updateTime" prop="updateTime">
        <el-input v-model="createFormData.updateTime"/>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="resetForm">
        重置
      </el-button>
      <el-button v-permission="['P_SYSTEM_MENU_ADD']" type="primary" @click="submitForm">
        提交
      </el-button>
    </div>
  </el-dialog>
</template>
<script>
    //接口
    import {MenuAddRequest} from '@/sdk/api/system/menu/add'

    export default {
        name: 'create_form',
        props: ['rowData'],  //接收父组件的传值
        watch: {
            dialogFormVisible(val) {
                if (val) {
                    console.log(this.rowData)
                    this.createFormData = this.rowData
                }
            }
        },
        data() {
            return {
                loading: false,
                createFormData: {
                    id: undefined,
                    pid: undefined,
                    title: undefined,
                    name: undefined,
                    component: undefined,
                    path: undefined,
                    icon: undefined,
                    type: undefined,
                    link: undefined,
                    code: undefined,
                    hidden: undefined,
                    status: undefined,
                    sort: undefined,
                    deleteFlag: undefined,
                    opUserId: undefined,
                    createTime: undefined,
                    updateTime: undefined,
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
            submitForm() {
                this.$refs['createFormRef'].validate((valid) => {
                    if (valid) {
                        this.$confirm('此操作将提交数据, 是否继续?', '提示', {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning'
                        }).then(() => {
                            let request = new MenuAddRequest();
                            request.setParams(this.createFormData)
                                .api().then(res => {
                                this.dialogFormVisible = false
                                this.$emit('loadData');
                                this.$message({
                                    type: 'success',
                                    message: '新增成功!'
                                });
                                console.log("MenuAddRequest res:", res)
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
