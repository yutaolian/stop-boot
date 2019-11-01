<template>
  <div class="app-container">
    <!--    &lt;!&ndash;表格&ndash;&gt;-->
    <!--    <el-table-->
    <!--      v-loading="tableLoading"-->
    <!--      :data="tableData"-->
    <!--      style="width: 100%;margin-bottom: 20px;"-->
    <!--      row-key="id"-->
    <!--      border-->
    <!--      default-expand-all-->
    <!--      :tree-props="{children: 'children'}">-->

    <!--      <el-table-column label="ID" prop="id" align="center" width="80">-->
    <!--        <template slot-scope="scope">-->
    <!--          <span>{{ scope.row.id }}</span>-->
    <!--        </template>-->
    <!--      </el-table-column>-->
    <!--      <el-table-column label="菜单标题" prop="title" align="center" width="150">-->
    <!--        <template slot-scope="scope">-->
    <!--          <span>{{ scope.row.title }}</span>-->
    <!--        </template>-->
    <!--      </el-table-column>-->
    <!--      <el-table-column label="菜单FullPath" prop="title" align="center" width="150">-->
    <!--        <template slot-scope="scope">-->
    <!--          <span>{{ scope.row.fullPath }}</span>-->
    <!--        </template>-->
    <!--      </el-table-column>-->

    <!--      <el-table-column label="菜单组件" prop="component" align="center" width="350">-->
    <!--        <template slot-scope="scope">-->
    <!--          <span>{{ scope.row.component }}</span>-->
    <!--        </template>-->
    <!--      </el-table-column>-->

    <!--      <el-table-column label="权限" align="center">-->
    <!--        <template slot-scope="scope"-->
    <!--                  v-if="scope.row.flag == true">-->
    <!--          <el-table-->
    <!--            :data="scope.row.permissions">-->
    <!--            <el-table-column-->
    <!--              prop="tagName"-->
    <!--              label="tag名称">-->
    <!--            </el-table-column>-->
    <!--            <el-table-column-->
    <!--              prop="tag"-->
    <!--              label="tag">-->
    <!--            </el-table-column>-->
    <!--            <el-table-column-->
    <!--              label="操作">-->
    <!--              <template slot-scope="scope">-->
    <!--                <el-button type="text" size="small" @click="preEdit(scope.row)">编辑</el-button>-->
    <!--                <el-button type="text" size="small" @click="handleDelete(scope.row)">删除</el-button>-->
    <!--              </template>-->
    <!--            </el-table-column>-->
    <!--          </el-table>-->
    <!--        </template>-->
    <!--      </el-table-column>-->
    <!--      <el-table-column label="操作" prop="sort" align="center" width="120">-->
    <!--        <template slot-scope="scope" v-if="scope.row.flag == true">-->
    <!--          <el-button type="primary" size="small" @click="preCreate(scope.row)">添加权限</el-button>-->
    <!--        </template>-->
    <!--      </el-table-column>-->
    <!--    </el-table>-->

    <el-row>
      <el-col :span="6">
        <el-tree
          :data="menuTreeData"
          ref="menuTree"
          highlight-current
          default-expand-all
          node-key="id"
          :props="defaultProps"
          @node-click="handleMenuTreeNodeClick">
        </el-tree>
      </el-col>
      <el-col :span="18">
        <div style="margin-left: 20px;">
          <el-tabs type="border-card">
            <el-tab-pane>
              <span slot="label"><i class="el-icon-date"></i>菜单按钮及接口权限</span>
              <template>
                <span>{{ selectedMenuTitle }}</span>
                <el-button type="primary" size="small" @click="preCreate()">添加</el-button>
                <el-divider></el-divider>
                <el-table
                  :data="menuPermissions">
                  <el-table-column
                    label="tag名称">
                    <template slot-scope="scope">
                      <span>{{ scope.row.tagName }}</span>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="tag">
                    <template slot-scope="scope">
                      <el-tag>{{ scope.row.tag }}
                      </el-tag>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="接口url">
                    <template slot-scope="scope">
                      {{ scope.row.url }}
                    </template>
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
            </el-tab-pane>
          </el-tabs>
        </div>
      </el-col>
    </el-row>
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
    import ScrollPane from "../../../components/ScrollPane/index";

    export default {
        name: 'PermissionPageTable',
        components: {ScrollPane, createForm, editForm},
        data() {
            return {
                tableKey: 'Permission',
                tableData: null,
                tableLoading: true,
                dialogFormVisible: false,
                editRowData: {},
                menuTreeData: [],
                menuPermissions: [],
                selectedMenu: undefined,
                selectedMenuTitle: undefined,
                rowData: undefined,
                createRowData: {
                    menuId: undefined,
                    urlPrefix: undefined,
                    tagPrefix: undefined,
                    tagNamePrefix: undefined
                },
                defaultProps: {
                    children: 'children',
                    label: 'title'
                },
            }
        },
        created() {
            this.loadData()
        },
        methods: {
            loadData() {
                // this.$nextTick(() => {
                //     this.tableLoading = true
                //     let request = new PermissionListRequest();
                //     request.api().then(res => {
                //         this.tableLoading = false
                //         this.tableData = res
                //     })
                // })

                //加载菜单
                this.$nextTick(() => {
                    let request2 = new PermissionListRequest()
                    request2.api().then(res => {
                        this.menuTreeData = res;
                    })
                })
            },
            preCreate() {
                if (this.selectedMenu) {
                    this.createRowData = this.selectedMenu;
                    this.createRowData.tagPrefix = "P" + this.selectedMenu.fullPath.replace(/\//g, '\_').toUpperCase() + "_";
                    this.createRowData.tagNamePrefix = this.selectedMenu.title + "_";
                    this.createRowData.menuId = this.selectedMenu.id;
                    this.createRowData.urlPrefix = this.selectedMenu.fullPath + "/";
                    this.$refs.createForm.dialogFormVisible = true
                } else {
                    this.$message({
                        type: 'error',
                        message: '请选择菜单!'
                    });
                }
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
            },
            handleMenuTreeNodeClick(data, checked, indeterminate) {
                this.selectedMenu = Object.assign({}, data)
                this.menuPermissions = data.permissions
                if (this.selectedMenu) {
                    this.selectedMenuTitle = "已选：" + data.title
                } else {
                    this.selectedMenuTitle = "未选择菜单"
                }
            },
        }
    }
</script>
