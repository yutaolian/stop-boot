<template>
    <div class="app-container">
        <!--分页过滤条件-->
        <div v-permission="['P_SYSTEM_DEPT_PAGE']" class="filter-container" >
            <el-form ref="filterForm" :model="tableQuery">
                <el-row>
                    <el-col :span="4">
                        <el-form-item prop="id" label="id">
                            <el-input v-model="tableQuery.id" placeholder="id" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="createTime" label="createTime">
                            <el-input v-model="tableQuery.createTime" placeholder="createTime" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="updateTime" label="updateTime">
                            <el-input v-model="tableQuery.updateTime" placeholder="updateTime" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="opUserId" label="opUserId">
                            <el-input v-model="tableQuery.opUserId" placeholder="opUserId" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="status" label="status">
                            <el-input v-model="tableQuery.status" placeholder="status" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="deleteFlag" label="deleteFlag">
                            <el-input v-model="tableQuery.deleteFlag" placeholder="deleteFlag" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <!--@click="cleanFilter"-->
                    <el-col :span="4">
                        <div class="el-form-item__label" style="width:50px">&nbsp;</div>
                        <div class="el-form-item__content">
                            <div class="filter-item" style="width: 180px;">
                                <el-button v-permission="['P_SYSTEM_DEPT_PAGE']" class="filter-item" type="danger" icon="el-icon-close" @click="cleanFilter" circle/>
                                <el-button v-permission="['P_SYSTEM_DEPT_PAGE']" class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter" circle/>
                                <el-button v-permission="['P_SYSTEM_DEPT_ADD']" class="filter-item" type="success" icon="el-icon-plus" @click="preCreate" circle/>
                            </div>
                        </div>
                    </el-col>
                </el-row>
            </el-form>
        </div>
        <!--表格-->
        <el-table
                v-permission="['P_SYSTEM_DEPT_PAGE']"
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
            <el-table-column prop="id" label="id" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.id }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="createTime" label="createTime" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.createTime }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="updateTime" label="updateTime" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.updateTime }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="opUserId" label="opUserId" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.opUserId }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="status" label="status" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.status }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="deleteFlag" label="deleteFlag" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.deleteFlag }}</span>
                </template>
            </el-table-column>

            <el-table-column  class-name="small-padding fixed-width" label="操作" align="center">
                <template slot-scope="{row}">
                    <el-button v-permission="['P_SYSTEM_DEPT_ONE']"  type="primary" size="mini" @click="preEdit(row)">
                        编辑
                    </el-button>
                    <el-button v-permission="['P_SYSTEM_DEPT_DELETE']" size="mini" type="danger" @click="handleDelete(row)">
                        删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <!--分页组件-->
        <pagination  v-permission="['P_SYSTEM_DEPT_PAGE']" v-show="total>0" :total="total" :page.sync="tableQuery.pageNum" :limit.sync="tableQuery.pageSize"
                    @pagination="loadData"/>

        <!--新增组件-->
        <create-form v-permission="['P_SYSTEM_DEPT_ADD']"  ref="createForm" :rowData='createRowData'  @loadData="loadData"></create-form>

        <!--编辑组件-->
        <edit-form v-permission="['P_SYSTEM_DEPT_UPDATE']" ref="editForm" :rowData='editRowData'  @loadData="loadData"></edit-form>

    </div>
</template>

<script>
    //分页组件
    import Pagination from '@/components/Pagination'
    //新增组件
    import createForm from './create'
    //编辑组件
    import editForm from './edit'
    //Dept page 接口
    import {DeptPageRequest} from '@/sdk/api/system/dept/page'
    //Dept delete 接口
    import {DeptDeleteRequest} from '@/sdk/api/system/dept/delete'

    export default {
        name: 'Dept-Table',
        components: {Pagination, createForm, editForm},
        data() {
            return {
                tableKey: 'Dept',
                tableData: null,
                total: 0,
                tableLoading: true,
                tableQuery: {
                    pageNum: 1,
                    pageSize: 10,
                    id: undefined,
                    createTime: undefined,
                    updateTime: undefined,
                    opUserId: undefined,
                    status: undefined,
                    deleteFlag: undefined,
                },
                dialogFormVisible: false,
                editRowData: {},
                createRowData:{}
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
                    let request = new DeptPageRequest();
                    request.setParams(this.tableQuery);
                    request.api().then(res => {
                        this.tableLoading = false
                        this.tableData = res['list']
                        this.total = res['total']
                        console.log("Dept tableData res:", res)
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
            preCreate(row) {
                // this.createRowData = Object.assign({}, row)
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
                    let request = new DeptDeleteRequest();
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
            }
        }
    }
</script>
