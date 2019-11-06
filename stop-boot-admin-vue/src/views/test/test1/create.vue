<template>
  <!--新增-->
  <el-dialog title="新增" :visible.sync="dialogFormVisible" width="50%">
    <el-form ref="createFormRef" :rules="rules" :model="createFormData" label-position="left" label-width="100px">
      <el-form-item label="id" prop="id">
        <el-input v-model="createFormData.id"/>
      </el-form-item>
      <el-form-item label="name" prop="name">
        <el-input v-model="createFormData.name"/>
      </el-form-item>
      <el-form-item label="age" prop="age">
        <el-input v-model="createFormData.age"/>
      </el-form-item>
      <el-form-item label="birthday" prop="birthday">
        <el-input v-model="createFormData.birthday"/>
      </el-form-item>
      <el-form-item label="createTime" prop="createTime">
        <el-input v-model="createFormData.createTime"/>
      </el-form-item>
      <el-form-item label="info" prop="info">
        <el-radio-group v-model="createFormData.age">
<!--          <el-radio v-for="item in this.dictValueList" :label="item.dicValue">{{item.dicDesc}}</el-radio>-->
        </el-radio-group>
      </el-form-item>
      <el-form-item label="status" prop="status">
        <el-select v-model="createFormData.status" placeholder="请选择">
          <el-option
            v-for="item in this.dictValueList"
            :key="item.id"
            :label="item.dicDesc"
            :value="item.dicValue">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="headImg" prop="headImg">
        <el-input v-model="createFormData.headImg"/>
      </el-form-item>
      <el-form-item label="deleteFlag" prop="deleteFlag">
        <el-input v-model="createFormData.deleteFlag"/>
      </el-form-item>
      <el-form-item label="updateTime" prop="updateTime">
        <el-input v-model="createFormData.updateTime"/>
      </el-form-item>
      <el-form-item>
        <el-button @click="resetForm">
          重置
        </el-button>
        <el-button type="primary" @click="submitForm">
          提交
        </el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>
<script>
    //接口
    import {Test1AddRequest} from '@/sdk/api/test/test1/add'
    import dict from '@/mixins/dict'

    export default {
        name: 'create_form',
        mixins: [dict],
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
                    name: undefined,
                    age: undefined,
                    birthday: undefined,
                    createTime: undefined,
                    info: undefined,
                    status: undefined,
                    headImg: undefined,
                    deleteFlag: undefined,
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
                            let request = new Test1AddRequest();
                            request.setParams(this.createFormData)
                                .api().then(res => {
                                this.dialogFormVisible = false
                                this.$emit('loadData');
                                this.$message({
                                    type: 'success',
                                    message: '新增成功!'
                                });
                                console.log("Test1AddRequest res:", res)
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
