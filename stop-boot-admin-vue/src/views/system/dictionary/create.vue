<template>
  <!--新增-->
  <el-dialog title="新增" :visible.sync="dialogFormVisible">
    <el-form ref="createFormRef" :rules="rules" :model="createFormData" label-position="left" label-width="100px">
      <el-form-item label="字典名" prop="dicName">
        <el-input v-model="createFormData.dicName"/>
      </el-form-item>
      <el-form-item label="字典key" prop="dicKey">
        <el-input v-model="createFormData.dicKey"/>
      </el-form-item>
      <el-form-item label="字典值" prop="dicValue">
        <el-input v-model="createFormData.dicValue"/>
      </el-form-item>
      <el-form-item label="字典描述" prop="dicDesc">
        <el-input v-model="createFormData.dicDesc"/>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="resetForm">
        重置
      </el-button>
      <el-button v-permission="['P_SYSTEM_DICTIONARY_ADD']" type="primary" @click="submitForm">
        提交
      </el-button>
    </div>
  </el-dialog>
</template>
<script>
    //接口
    import {DictionaryAddRequest} from '@/sdk/api/system/dictionary/add'

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
                    dicName: undefined,
                    dicKey: undefined,
                    dicValue: undefined,
                    dicDesc: undefined,
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
                            let request = new DictionaryAddRequest();
                            request.setParams(this.createFormData)
                                .api().then(res => {
                                this.dialogFormVisible = false
                                this.$emit('loadData');
                                this.$message({
                                    type: 'success',
                                    message: '新增成功!'
                                });
                                console.log("DictionaryAddRequest res:", res)
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
