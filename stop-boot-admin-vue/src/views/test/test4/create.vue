<template>
  <!--新增-->
  <el-dialog title="新增" :visible.sync="dialogFormVisible">
    <el-form ref="createFormRef" :rules="rules" :model="createFormData" label-position="left" label-width="100px">
      <el-form-item prop="age" label="年龄">
        <el-input v-model="createFormData.age"/>
      </el-form-item>
      <el-form-item prop="birthday" label="生日">
        <el-date-picker
          v-model="createFormData.birthday"
          type="date"
          placeholder="生日">
        </el-date-picker>
      </el-form-item>
      <el-form-item prop="info" label="信息">
        <el-input v-model="createFormData.info"/>
      </el-form-item>
      <el-form-item prop="status" label="状态">
        <!--                    <el-select v-model="createFormData.status" placeholder="请选择">-->
        <!--                        <el-option-->
        <!--                                v-for="item in this.dictValueList"-->
        <!--                                :key="item.id"-->
        <!--                                :label="item.dicDesc"-->
        <!--                                :value="item.dicValue">-->
        <!--                        </el-option>-->
        <!--                    </el-select>-->
      </el-form-item>
      <el-form-item prop="headImg" label="头像">
        <el-input v-model="createFormData.headImg"/>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="resetForm">
        重置
      </el-button>
      <el-button v-permission="['P_TEST_TEST4_ADD']" type="primary" @click="submitForm">
        提交
      </el-button>
    </div>
  </el-dialog>
</template>
<script>
    //接口
    import {Test4AddRequest} from '@/sdk/api/test/test4/add'
    import api from '@/mixins/api'

    export default {
        name: 'create_form',
        mixins: [api],
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
                    age: undefined,
                    birthday: undefined,
                    info: undefined,
                    status: undefined,
                    headImg: undefined,
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
                        let request = new Test4AddRequest();
                        request.setParams(this.createFormData)
                        this.delete(request).then(res => {
                            this.dialogFormVisible = false
                            this.$emit('loadData');
                        })
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
