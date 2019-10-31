<template>
  <div class="app-container">
    <!--表格-->
    <el-table
      v-loading="tableLoading"
      :data="tableData"
      style="width: 100%;margin-bottom: 20px;"
      row-key="id"
      border
      default-expand-all
      :tree-props="{children: 'children'}">

      <el-table-column label="ID" prop="id" align="center" width="80">
        <template slot-scope="scope">
          <span>{{ scope.row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column label="菜单标题" prop="title" align="center" width="150">
        <template slot-scope="scope">
          <span>{{ scope.row.title }}</span>
        </template>
      </el-table-column>
      <el-table-column label="菜单FullPath" prop="title" align="center" width="150">
        <template slot-scope="scope">
          <span>{{ scope.row.fullPath }}</span>
        </template>
      </el-table-column>

      <el-table-column label="菜单组件" prop="component" align="center" width="350">
        <template slot-scope="scope">
          <span>{{ scope.row.component }}</span>
        </template>
      </el-table-column>

      <el-table-column label="权限" align="center">
        <template slot-scope="scope"
                  v-if="scope.row.flag == true">
          <el-table
            :data="scope.row.permissions">
            <el-table-column
              prop="tagName"
              label="tag名称">
            </el-table-column>
            <el-table-column
              prop="tag"
              label="tag">
            </el-table-column>
            <el-table-column
              label="操作">
              <template slot-scope="scope">
                <el-button type="text" size="small" @click="preEdit(scope.row)">编辑</el-button>
                <el-button type="text" size="small" @click="handleDelete(scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </template>
      </el-table-column>
      <el-table-column label="操作" prop="sort" align="center" width="120">
        <template slot-scope="scope" v-if="scope.row.flag == true">
          <el-button type="primary" size="small" @click="preCreate(scope.row)">添加权限</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!--新增组件-->
    <create-form ref="createForm" :rowData="createRowData" @loadData="loadData"></create-form>

    <!--编辑组件-->
    <edit-form ref="editForm" :rowData='editRowData' @loadData="loadData"></edit-form>

  </div>
</template>

<script>
    //新增组件
    import createForm from './create'
    //编辑组件
    import editForm from './edit'
    //接口
    import {PermissionListRequest} from '@/sdk/api/system/permission/list'

    import {PermissionDeleteRequest} from '@/sdk/api/system/permission/delete'

    export default {
        name: 'PermissionPageTable',
        components: {createForm, editForm},
        data() {
            return {
                tableKey: 'Permission',
                tableData: null,
                tableLoading: true,
                dialogFormVisible: false,
                editRowData: {},
                createRowData: {
                    menuId: undefined,
                    tagPrefix: undefined,
                    tagNamePrefix: undefined
                }
            }
        },
        created() {
            this.loadData()
        },
        methods: {
            loadData() {
                this.$nextTick(() => {
                    this.tableLoading = true
                    let request = new PermissionListRequest();
                    request.api().then(res => {
                        this.tableLoading = false
                        this.tableData = res
                    })
                })
            },
            preCreate(row) {
                this.createRowData = Object.assign({}, row)
                this.createRowData.tagPrefix = "P" + row.fullPath.replace(/\//g, '\_').toUpperCase() + "_";
                this.createRowData.tagNamePrefix = row.title + "_";
                this.createRowData.menuId = row.id;
                this.$refs.createForm.dialogFormVisible = true
            },
            preEdit(row) {
                this.editRowData = Object.assign({}, row)
                this.$refs.editForm.dialogFormVisible = true
            },
            handleDelete(row) {
                this.$confirm('确认删除, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let request = new PermissionDeleteRequest();
                    request.setId(row.id).api().then(res => {
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                        this.loadData()
                    })
                }).catch((err) => {
                    this.$message({
                        type: 'info',
                        message: '已取消'
                    });
                    console.log("err:", err);
                });
            }
        }
    }
</script>
