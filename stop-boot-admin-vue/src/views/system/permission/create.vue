<template>
  <!--新增-->
  <el-dialog title="新增" :visible.sync="dialogFormVisible">
    <el-form ref="createFormRef" :rules="rules" :model="rowData" label-position="left" label-width="70px">
      <el-form-item label="menuId" prop="menuId">
        <el-input disabled v-model="rowData.menuId"/>
      </el-form-item>
      <el-form-item label="tag名称" prop="tagName">
        <el-input v-model="rowData.tagName" autocomplete="off" placeholder="请输入定义的tag名称(汉字)">
          <template slot="prepend">{{rowData.tagNamePrefix}}</template>
        </el-input>
      </el-form-item>
      <el-form-item label="tag" prop="tag">
        <el-input v-model="rowData.tag" autocomplete="off" placeholder="请输入定义的tag名称(英文大写)">
          <template slot="prepend">{{rowData.tagPrefix}}</template>
        </el-input>
      </el-form-item>
      <el-form-item label="tag描述" prop="tagDesc">
        <el-input type="textarea"
                  placeholder="请输入tag描述" maxlength="50"
                  show-word-limit v-model="rowData.tagDesc" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="resetForm">
        重置
      </el-button>
      <el-button type="primary" @click="onSubmit">
        提交
      </el-button>
    </div>
  </el-dialog>
</template>
<script>
    import {PermissionAddRequest} from '@/sdk/api/system/permission/add'

    export default {
        name: 'create_form',
        props: ['rowData'],  //接收父组件的传值
        data() {
            return {
                loading: false,
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
                this.$refs['createFormRef'].validate((valid) => {
                    if (valid) {
                        this.$confirm('此操作将提交数据, 是否继续?', '提示', {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning'
                        }).then(() => {
                            let request = new PermissionAddRequest();
                            request.setMenuId(this.rowData.menuId)
                                .setTag((this.rowData.tagPrefix + this.rowData.tag).toUpperCase())
                                .setTagName((this.rowData.tagNamePrefix + this.rowData.tagName))
                                .setTagDesc(this.rowData.tagDesc)
                                .api().then(res => {
                                console.log("PermissionAddRequest res:", res)
                                this.dialogFormVisible = false
                                this.$emit('loadData');
                                this.$message({
                                    type: 'success',
                                    message: '新增成功!'
                                });
                            })
                        }).catch(() => {
                            this.$message({
                                type: 'info',
                                message: '已取消'
                            });
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
