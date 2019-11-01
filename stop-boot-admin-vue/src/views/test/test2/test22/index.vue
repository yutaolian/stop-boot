<template>
    <div class="app-container">
        <!--分页过滤条件-->
        <div v-permission="['P_TEST_TEST2_TEST22_PAGE']" class="filter-container" >
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
                        <el-form-item prop="age" label="age">
                            <el-input v-model="tableQuery.age" placeholder="age" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="birthday" label="birthday">
                            <el-input v-model="tableQuery.birthday" placeholder="birthday" style="width: 180px;" class="filter-item"
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
                        <el-form-item prop="info" label="info">
                            <el-input v-model="tableQuery.info" placeholder="info" style="width: 180px;" class="filter-item"
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
                        <el-form-item prop="headImg" label="headImg">
                            <el-input v-model="tableQuery.headImg" placeholder="headImg" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="deleteFlag" label="deleteFlag">
                            <el-input v-model="tableQuery.deleteFlag" placeholder="deleteFlag" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="updateTime" label="updateTime">
                            <el-input v-model="tableQuery.updateTime" placeholder="updateTime" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <!--@click="cleanFilter"-->
                    <el-col :span="4">
                        <el-form-item label="">
                            <el-button v-permission="['P_TEST_TEST2_TEST22_PAGE']" class="filter-item" type="danger" icon="el-icon-close" @click="cleanFilter" circle/>
                            <el-button v-permission="['P_TEST_TEST2_TEST22_PAGE']" class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter" circle/>
                            <el-button v-permission="['P_TEST_TEST2_TEST22_ADD']" class="filter-item" type="success" icon="el-icon-plus" @click="preCreate" circle/>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
        </div>
        <!--表格-->
        <el-table
                v-permission="['P_TEST_TEST2_TEST22_PAGE']"
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
                    <span>{{ scope.row.name }}</span>
                </template>
            </el-table-column>
            <el-table-column label="age" prop="age" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.age }}</span>
                </template>
            </el-table-column>
            <el-table-column label="birthday" prop="birthday" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.birthday }}</span>
                </template>
            </el-table-column>
            <el-table-column label="createTime" prop="createTime" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.createTime }}</span>
                </template>
            </el-table-column>
            <el-table-column label="info" prop="info" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.info }}</span>
                </template>
            </el-table-column>
            <el-table-column label="status" prop="status" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.status }}</span>
                </template>
            </el-table-column>
            <el-table-column label="headImg" prop="headImg" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.headImg }}</span>
                </template>
            </el-table-column>
            <el-table-column label="deleteFlag" prop="deleteFlag" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.deleteFlag }}</span>
                </template>
            </el-table-column>
            <el-table-column label="updateTime" prop="updateTime" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.updateTime }}</span>
                </template>
            </el-table-column>

            <el-table-column label="Actions" align="center" class-name="small-padding fixed-width">
                <template slot-scope="{row}">
                    <el-button v-permission="['P_TEST_TEST2_TEST22_ONE']"  type="primary" size="mini" @click="preEdit(row)">
                        Edit
                    </el-button>
                    <el-button v-permission="['P_TEST_TEST2_TEST22_DELETE']" size="mini" type="danger" @click="handleDelete(row)">
                        Delete
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <!--分页组件-->
        <pagination  v-permission="['P_TEST_TEST2_TEST22_PAGE']" v-show="total>0" :total="total" :page.sync="tableQuery.pageNum" :limit.sync="tableQuery.pageSize"
                    @pagination="loadData"/>

        <!--新增组件-->
        <create-form v-permission="['P_TEST_TEST2_TEST22_ADD']"  ref="createForm" :rowData='createRowData'  @loadData="loadData"></create-form>

        <!--编辑组件-->
        <edit-form v-permission="['P_TEST_TEST2_TEST22_UPDATE']" ref="editForm" :rowData='editRowData'  @loadData="loadData"></edit-form>

    </div>
</template>

<script>
    //分页组件
    import Pagination from '@/components/Pagination'
    //新增组件
    import createForm from './create'
    //编辑组件
    import editForm from './edit'
    //Test22 page 接口
    import {Test22PageRequest} from '@/sdk/api/test/test2/test22/page'
    //Test22 delete 接口
    import {Test22DeleteRequest} from '@/sdk/api/test/test2/test22/delete'

    export default {
        name: 'Test22-Table',
        components: {Pagination, createForm, editForm},
        data() {
            return {
                tableKey: 'Test22',
                tableData: null,
                total: 0,
                tableLoading: true,
                tableQuery: {
                    pageNum: 1,
                    pageSize: 10,
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
                    let request = new Test22PageRequest();
                    request.setParams(this.tableQuery);
                    request.api().then(res => {
                        this.tableLoading = false
                        this.tableData = res['list']
                        this.total = res['total']
                        console.log("Test22 tableData res:", res)
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
                    let request = new Test22DeleteRequest();
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
