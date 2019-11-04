<template>
  <div class="app-container">
    <!--分页过滤条件-->
    <div class="filter-container">
      <el-form ref="filterForm" :model="tableQuery">
        <el-row>
          <el-col :span="4">
            <el-form-item prop="name" label="name">
              <el-input v-model="tableQuery.name" placeholder="name" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="tag" label="tag">
              <el-input v-model="tableQuery.tag" placeholder="tag" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <!--@click="cleanFilter"-->
          <el-col :span="4">
            <div class="el-form-item__label" style="width:50px">&nbsp;</div>
            <div class="el-form-item__content">
              <div class="filter-item" style="width: 180px;">
              <el-button class="filter-item" type="danger" icon="el-icon-close" @click="cleanFilter" circle/>
              <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter" circle/>
              <el-button class="filter-item" type="success" icon="el-icon-plus" @click="preCreate" circle/>
              </div>
            </div>
          </el-col>
        </el-row>
      </el-form>
    </div>
    <el-row>
      <el-col :span="10">
        <!--表格-->
        <el-table
          :key="tableKey"
          v-loading="tableLoading"
          :data="tableData"
          border
          stripe
          empty-text
          fit
          highlight-current-row
          style="width: 100%;"
        >
          <el-table-column label="id" prop="id" align="center" width="60px">
            <template slot-scope="scope">
              <span>{{ scope.row.id }}</span>
            </template>
          </el-table-column>
          <el-table-column label="name" prop="name" align="center">
            <template slot-scope="scope">
              <el-link type="primary" @click="roleSelected(scope.row)">{{ scope.row.name }}</el-link>
            </template>
          </el-table-column>
          <!--      <el-table-column label="description" prop="description" align="center">-->
          <!--        <template slot-scope="scope">-->
          <!--          <span>{{ scope.row.description }}</span>-->
          <!--        </template>-->
          <!--      </el-table-column>-->
          <el-table-column label="tag" prop="tag" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.tag }}</span>
            </template>
          </el-table-column>
          <el-table-column label="状态" prop="status" align="center">
            <template slot-scope="scope">
              <el-switch
                v-model="scope.row.status"
                active-text="激活"
                inactive-text="冻结"
                active-value="1"
                inactive-value="0">
              </el-switch>
            </template>
          </el-table-column>
          <!--      <el-table-column label="createTime" prop="createTime" align="center">-->
          <!--        <template slot-scope="scope">-->
          <!--          <span>{{ scope.row.createTime }}</span>-->
          <!--        </template>-->
          <!--      </el-table-column>-->
          <!--      <el-table-column label="updateTime" prop="updateTime" align="center">-->
          <!--        <template slot-scope="scope">-->
          <!--          <span>{{ scope.row.updateTime }}</span>-->
          <!--        </template>-->
          <!--      </el-table-column>-->

          <el-table-column label="操作" align="center" width="100px">
            <template slot-scope="scope">
              <el-dropdown @command='handledropdownCommand' trigger="click">
                <el-button type="primary" size="small">
                  更多<i class="el-icon-arrow-down el-icon--right"></i>
                </el-button>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item :command='{type:"edit",index:scope.$index,row:scope.row}'>编辑</el-dropdown-item>
                  <el-dropdown-item :command='{type:"delete",index:scope.$index,row:scope.row}'>删除</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </template>
          </el-table-column>
        </el-table>

      </el-col>
      <el-col :span="14">
        <div style="margin-left: 20px;">
          <el-tabs type="border-card">
            <el-tab-pane>
              <span slot="label"><i class="el-icon-date"></i>{{tabPaneName}}</span>
              <el-row>
                <el-col :span="8">
                  <el-tree
                    :data="menuTreeData"
                    ref="menuTree"
                    highlight-current
                    default-expand-all
                    show-checkbox
                    node-key="id"
                    :props="defaultProps"
                    @check="handleMenuTreeNodeClick"
                    @node-click="menuNodeClick">
                  </el-tree>
                </el-col>
                <el-col :span="16">
                  <template>
                    <el-transfer v-model="selectedPermission"
                                 :titles="['未分配权限', '已分配权限']"
                                 :data="transferData"
                                 :left-default-checked="[77]"
                                 :props="{
                                    key: 'id',
                                    label: 'tagName'
                                  }"
                    ></el-transfer>
                  </template>
                </el-col>
              </el-row>
              <el-button class="filter-item" type="primary" icon="el-icon-edit" size="mini"
                         @click="saveRoleMenuAndPermission">保存
              </el-button>
            </el-tab-pane>
          </el-tabs>

        </div>
      </el-col>
    </el-row>
    <!--分页组件-->
    <pagination v-show="total>0" :total="total" :page.sync="tableQuery.pageNum" :limit.sync="tableQuery.pageSize"
                @pagination="loadData"/>

    <!--新增组件-->
    <create-form ref="createForm" :rowData='createRowData' @loadData="loadData"></create-form>

    <!--编辑组件-->
    <edit-form ref="editForm" :rowData='editRowData' @loadData="loadData"></edit-form>

  </div>
</template>

<style>
  .el-transfer-panel__body {
    height: 524px;
  }
</style>

<script>
    //分页组件
    import Pagination from '@/components/Pagination'
    //新增组件
    import createForm from './create'
    //编辑组件
    import editForm from './edit'
    //Role page 接口
    import {RolePageRequest} from '@/sdk/api/system/role/page'
    //Role delete 接口
    import {RoleDeleteRequest} from '@/sdk/api/system/role/delete'

    //router菜单列表
    import {MenuListRequest} from '@/sdk/api/system/menu/list'
    //
    import {PermissionListRequest} from '@/sdk/api/system/permission/list'

    import {RoleMenuRequest} from '@/sdk/api/system/role/menu'

    import {RoleRequest} from '@/sdk/api/system/role'

    import {RolePermissionRequest} from '@/sdk/api/system/role/permission'

    import {RoleSaveRequest} from '@/sdk/api/system/role/save'

    export default {
        name: 'Role-Table',
        components: {Pagination, createForm, editForm},
        data() {
            return {
                tableKey: 'Role',
                tableData: null,
                total: 0,
                tableLoading: true,
                tableQuery: {
                    pageNum: 1,
                    pageSize: 10,
                    name: undefined,
                    tag: undefined,
                },
                menuQuery: {
                    roleId: undefined
                },
                dialogFormVisible: false,
                editRowData: {},
                createRowData: {},
                menuTreeData: [],
                transferData: [],
                defaultProps: {
                    children: 'children',
                    label: 'title'
                },
                selectedPermission: [],
                selectedMenus: [],
                leftDefaultChecked: [77],
                tabPaneName:"菜单权限分配"
            }


        },
        created() {
            this.loadData();
        },
        methods: {
            loadData() {
                this.$nextTick(() => {
                    this.tableLoading = true
                    let request = new RolePageRequest();
                    request.setParams(this.tableQuery);
                    request.api().then(res => {
                        this.tableLoading = false
                        this.tableData = res['list']
                        this.total = res['total']
                    })
                })
                //加载菜单
                this.$nextTick(() => {
                    let request2 = new PermissionListRequest()
                    request2.setParams(this.menuQuery).api().then(res => {
                        this.menuTreeData = res;
                    })
                })
            },
            loadMenuAndPermission() {
                this.$nextTick(() => {
                    if (this.menuQuery.roleId != undefined) {
                        //获得已选菜单
                        let request = new RoleMenuRequest()
                        request.setParams(this.menuQuery).api().then(res => {
                            this.selectedMenus = res;
                            this.$refs['menuTree'].setCheckedKeys(this.selectedMenus);
                            //获取选中菜单的全部权限
                            let node = this.$refs['menuTree'].getCheckedNodes();
                            let tempData = [];
                            node.forEach((item, index, arr) => {
                                if (item.permissions != undefined) {
                                    tempData = tempData.concat(item.permissions);
                                }
                            })
                            this.transferData = tempData;

                        })
                        //获得已有权限
                        let request3 = new RolePermissionRequest()
                        request3.setParams(this.menuQuery).api().then(res => {
                            this.selectedPermission = res
                        })
                    }
                })
            },
            handleFilter() {
                this.tableQuery.pageNum = 1
                this.loadData()
            },
            cleanFilter() {
                this.$refs['filterForm'].resetFields();
                this.loadData()
            },
            preCreate() {
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
                    let request = new RoleDeleteRequest();
                    request.setId(row.id).api().then(res => {
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                        this.loadData()
                    })
                }).catch(() => {
                    this.$message({
                        type: 'error',
                        message: '删除错误'
                    });
                });
            },
            handledropdownCommand(data) {
                if (!data) return;
                let {type, index, row} = data;
                switch (type) {
                    case 'delete':
                        this.handleDelete(row)
                        break;
                    case 'edit':
                        this.preEdit(row)
                        break;
                    default:
                        break;
                }
            },
            handleMenuTreeNodeClick(data, checked, indeterminate) {
                let node = this.$refs['menuTree'].getCheckedNodes();
                let tempData = [];
                node.forEach((item, index, arr) => {
                    if (item.permissions != undefined) {
                        tempData = tempData.concat(item.permissions);
                    }
                })
                this.transferData = tempData;

            },
            menuNodeClick(obj, data, node,) {
                console.log("obj,data,node,", obj, data, node,)
                if (obj.permissions != undefined) {
                    // this.leftDefaultChecked = obj.permissions;
                }
                // console.log("leftDefaultChecked----", this.leftDefaultChecked)
            },
            roleSelected(row) {
                this.menuQuery.roleId = row.id;
                this.loadMenuAndPermission();
                console.log("xxx--this.selectedMenus = res;", this.selectedMenus)
                this.tabPaneName = "菜单权限分配";
                this.tabPaneName = this.tabPaneName+"(已选角色:"+row.name+")"
            },
            saveRoleMenuAndPermission: function () {
                console.log("已选 roleId ", this.menuQuery.roleId)
                console.log("已选 permission ", this.selectedPermission)
                if (this.menuQuery.roleId) {
                    this.$confirm('确认修改, 是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        this.$message({
                            type: 'success',
                            message: '修改成功!'
                        });
                        let node = this.$refs['menuTree'].getCheckedNodes(true, true);
                        console.log("已选 node ", node)
                        let node2 = this.$refs['menuTree'].getCheckedKeys(true);
                        console.log("已选 node2 true ", node2)

                        let node23 = this.$refs['menuTree'].getCheckedKeys(false);
                        console.log("已选 node23 false ", node23)

                        let node24 = this.$refs['menuTree'].getHalfCheckedKeys();
                        console.log("已选 node24 getHalfCheckedKeys ", node24)

                        let node25 = this.$refs['menuTree'].getHalfCheckedNodes();
                        console.log("已选 node24 getHalfCheckedNodes ", node25)

                        let menuIds = node.map(n => {
                            return n.id
                        });
                        let request = new RoleSaveRequest();
                        request.setRoleId(this.menuQuery.roleId);
                        request.setMenuIds(menuIds);
                        request.setPermissionIds(this.selectedPermission);
                        request.api().then(res => {
                            this.loadMenuAndPermission();
                        })
                    }).catch(() => {
                        this.$message({
                            type: 'error',
                            message: '保存失败'
                        });
                    });
                } else {
                    this.$message({
                        type: 'error',
                        message: '请选择角色!'
                    });
                }
            }
        }
    }
</script>
