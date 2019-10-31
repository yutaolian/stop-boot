<template>
  <!--编辑-->
  <el-dialog title="编辑" :visible.sync="dialogFormVisible">
    <el-form ref="editFormRef" :rules="rules" :model="rowData" label-position="left" label-width="70px">
      <el-form-item label="id" prop="id">
        <el-input v-model="rowData.id"/>
      </el-form-item>
      <el-form-item label="tag名称" prop="tagName">
        <el-input v-model="rowData.tagName"/>
      </el-form-item>
      <el-form-item label="tag" prop="tag">
        <el-input v-model="rowData.tag"/>
      </el-form-item>
      <el-form-item label="tagDesc" prop="tagDesc">
        <el-input v-model="rowData.tagDesc"/>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="cancleForm">
        取消
      </el-button>
      <el-button type="primary" @click="onSubmit">
        保存
      </el-button>
    </div>
  </el-dialog>
</template>
<script>

    import {PermissionUpdateRequest} from '@/sdk/api/system/permission/update'

    export default {
        name: 'edit_form',
        props: ['rowData'],  //接收父组件的传值
        data() {
            return {
                loading: false,
                editForm: {
                    name: ''
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
            onSubmit() {
                this.$refs['editFormRef'].validate((valid) => {
                    if (valid) {
                        this.$confirm('此操作将提交修改数据, 是否继续?', '提示', {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning'
                        }).then(() => {
                            let request = new PermissionUpdateRequest();
                            request.
                            setId(id).
                            setMenuId(menuId).
                            setTag(tag).
                            setTagDesc(tagDesc).
                            api().then(res => {
                                console.log("PermissionUpdateRequest res:", res)
                                this.$emit('loadData');
                            })



                            this.$message({
                                type: 'success',
                                message: '修改成功!'
                            });
                        }).catch((err) => {
                            this.$message({
                                type: 'info',
                                message: '已取消'
                            });

                            console.error("error:",err)
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
        },
        watch: {
            dialogFormVisible(val) {
                if (val) {
                    console.log(this.row)
                    this.ruleForm = this.row
                }
            }
        }
    }
</script>
