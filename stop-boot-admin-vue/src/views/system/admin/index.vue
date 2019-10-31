<template>
  <div class="app-container">
    <!--分页过滤条件-->
    <div class="filter-container">
      <el-form ref="filterForm" :model="tableQuery">
        <el-row>
          <el-col :span="4">
            <el-form-item prop="id" label="id">
              <el-input v-model="tableQuery.id" placeholder="id" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="name" label="name">
              <el-input v-model="tableQuery.name" placeholder="name" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="mobile" label="mobile">
              <el-input v-model="tableQuery.mobile" placeholder="mobile" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="email" label="email">
              <el-input v-model="tableQuery.email" placeholder="email" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="status" label="status">
              <el-input v-model="tableQuery.status" placeholder="status" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <!--@click="cleanFilter"-->
          <el-col :span="4">
            <el-form-item label="">
              <el-button class="filter-item" type="danger" icon="el-icon-close" @click="cleanFilter" circle/>
              <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter" circle/>

              <el-button v-permission="['P_SYSTEM_ADMIN_ADD']" class="filter-item" type="success" icon="el-icon-plus" @click="preCreate" circle/>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </div>
    <el-row>
      <el-col :span="18">
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
          <el-table-column label="id" prop="id" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.id }}</span>
            </template>
          </el-table-column>
          <el-table-column label="name" prop="name" align="center">
            <template slot-scope="scope">
              <el-link type="primary" @click="adminSelected(scope.row)">{{ scope.row.name }}</el-link>
            </template>
          </el-table-column>
          <el-table-column label="mobile" prop="mobile" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.mobile }}</span>
            </template>
          </el-table-column>
          <el-table-column label="password" prop="password" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.password }}</span>
            </template>
          </el-table-column>
          <el-table-column label="email" prop="email" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.email }}</span>
            </template>
          </el-table-column>
          <el-table-column label="status" prop="status" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.status }}</span>
            </template>
          </el-table-column>
          <el-table-column label="deleteFlag" prop="deleteFlag" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.deleteFlag }}</span>
            </template>
          </el-table-column>
          <el-table-column label="createTime" prop="createTime" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.createTime }}</span>
            </template>
          </el-table-column>
          <el-table-column label="updateTime" prop="updateTime" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.updateTime }}</span>
            </template>
          </el-table-column>

          <el-table-column label="Actions" align="center" class-name="small-padding fixed-width">
            <template slot-scope="{row}">

              <el-button v-permission="['P_SYSTEM_ADMIN_EDIT']" type="primary" size="mini" @click="preEdit(row)">
                Edit
              </el-button>
              <el-button v-permission="['P_SYSTEM_ADMIN_DELETE']" size="mini" type="danger" @click="handleDelete(row)">
                Delete
              </el-button>
            </template>
          </el-table-column>
        </el-table>

        <!--分页组件-->
        <pagination v-show="total>0" :total="total" :page.sync="tableQuery.pageNum" :limit.sync="tableQuery.pageSize"
                    @pagination="loadData"/>

      </el-col>
      <el-col :span="6">
        <div style="margin-left: 20px;">
          <el-tabs type="border-card">
            <el-tab-pane>
              <span slot="label"><i class="el-icon-date"></i>角色分配</span>
              <el-row>
                <el-table
                  ref="multipleTable"
                  :data="tableData"
                  tooltip-effect="dark"
                  style="width: 100%"
                  @selection-change="handleSelectionChange">
                  <el-table-column
                    prop="name"
                    label="姓名"
                    width="120">
                  </el-table-column>
                </el-table>
              </el-row>
              <el-button class="filter-item" type="primary" icon="el-icon-edit" size="mini"
                         @click="saveRoleMenuAndPermission">保存
              </el-button>
            </el-tab-pane>
          </el-tabs>

        </div>
      </el-col>
    </el-row>

    <!--新增组件-->
    <create-form ref="createForm" :rowData='createRowData' @loadData="loadData"></create-form>

    <!--编辑组件-->
    <edit-form ref="editForm" :rowData='editRowData' @loadData="loadData"></edit-form>

  </div>
</template>

<script>
    //分页组件
    import Pagination from '@/components/Pagination'
    //新增组件
    import createForm from './create'
    //编辑组件
    import editForm from './edit'
    //Admin page 接口
    import {AdminPageRequest} from '@/sdk/api/system/admin/page'
    //Admin delete 接口
    import {AdminDeleteRequest} from '@/sdk/api/system/admin/delete'

    export default {
        name: 'Admin-Table',
        components: {Pagination, createForm, editForm},
        data() {
            return {
                tableKey: 'Admin',
                tableData: null,
                total: 0,
                tableLoading: true,
                tableQuery: {
                    pageNum: 1,
                    pageSize: 10,
                    id: undefined,
                    name: undefined,
                    mobile: undefined,
                    password: undefined,
                    email: undefined,
                    status: undefined,
                    deleteFlag: undefined,
                    createTime: undefined,
                    updateTime: undefined,
                },
                dialogFormVisible: false,
                editRowData: {},
                createRowData: {},
                tableData: []
            }
        },
        filters: {},
        created() {
            this.loadData()
        },
        methods: {
            loadData() {
                this.$nextTick(() => {
                    this.tableLoading = true
                    let request = new AdminPageRequest();
                    request.setParams(this.tableQuery);
                    request.api().then(res => {
                        this.tableLoading = false
                        this.tableData = res['list']
                        this.total = res['total']
                        console.log("Admin tableData res:", res)
                    })
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
                    let request = new AdminDeleteRequest();
                    request.setId(row.id).api().then(res => {
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                        this.loadData()
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消'
                    });
                });
            },
            adminSelected(row){

            }
        }
    }
</script>
