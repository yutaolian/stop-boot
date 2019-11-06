<template>
    <div class="app-container">
        <!--分页过滤条件-->
        <div v-permission="['P_TEST_TEST3_PAGE']" class="filter-container" >
            <el-form ref="filterForm" :model="tableQuery">
                <el-row>
                    <el-col :span="4">
                        <el-form-item prop="id" label="id">
                                 <el-input v-model="tableQuery.id" placeholder="id" style="width: 180px;" class="filter-item"
                                           @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="name" label="姓名">
                                 <el-input v-model="tableQuery.name" placeholder="姓名" style="width: 180px;" class="filter-item"
                                           @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="age" label="年龄">
                                 <el-input v-model="tableQuery.age" placeholder="年龄" style="width: 180px;" class="filter-item"
                                           @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="birthday" label="生日">
                                 <el-date-picker
                                         v-model="tableQuery.birthday"
                                         type="date"
                                         placeholder="生日">
                                 </el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="info" label="信息">
                                 <el-input v-model="tableQuery.info" placeholder="信息" style="width: 180px;" class="filter-item"
                                           @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="status" label="状态">
                                 <el-select v-model="tableQuery.status" placeholder="请选择">
                                     <el-option
                                             v-for="item in this.dictValueList"
                                             :key="item.id"
                                             :label="item.dicDesc"
                                             :value="item.dicValue">
                                     </el-option>
                                 </el-select>
                        </el-form-item>
                    </el-col>
                    <!--@click="cleanFilter"-->
                    <el-col :span="4">
                        <div class="el-form-item__label" style="width:50px">&nbsp;</div>
                        <div class="el-form-item__content">
                            <div class="filter-item" style="width: 180px;">
                                <el-button v-permission="['P_TEST_TEST3_PAGE']" class="filter-item" type="danger" icon="el-icon-close" @click="cleanFilter" circle/>
                                <el-button v-permission="['P_TEST_TEST3_PAGE']" class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter" circle/>
                                <el-button v-permission="['P_TEST_TEST3_ADD']" class="filter-item" type="success" icon="el-icon-plus" @click="preCreate" circle/>
                            </div>
                        </div>
                    </el-col>
                </el-row>
            </el-form>
        </div>
        <!--表格-->
        <el-table
                v-permission="['P_TEST_TEST3_PAGE']"
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
            <el-table-column prop="name" label="姓名" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.name }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="age" label="年龄" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.age }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="birthday" label="生日" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.birthday }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="info" label="信息" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.info }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="status" label="状态" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.status }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="headImg" label="头像" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.headImg }}</span>
                </template>
            </el-table-column>

            <el-table-column  class-name="small-padding fixed-width" label="操作" align="center">
                <template slot-scope="{row}">
                    <el-button v-permission="['P_TEST_TEST3_ONE']"  type="primary" size="mini" @click="preEdit(row)">
                        编辑
                    </el-button>
                    <el-button v-permission="['P_TEST_TEST3_DELETE']" size="mini" type="danger" @click="handleDelete(row)">
                        删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <!--分页组件-->
        <pagination  v-permission="['P_TEST_TEST3_PAGE']" v-show="total>0" :total="total" :page.sync="tableQuery.pageNum" :limit.sync="tableQuery.pageSize"
                    @pagination="loadData"/>

        <!--新增组件-->
        <create-form v-permission="['P_TEST_TEST3_ADD']"  ref="createForm" :rowData='createRowData'  @loadData="loadData"></create-form>

        <!--编辑组件-->
        <edit-form v-permission="['P_TEST_TEST3_UPDATE']" ref="editForm" :rowData='editRowData'  @loadData="loadData"></edit-form>

    </div>
</template>

<script>
    //分页组件
    import Pagination from '@/components/Pagination'
    //新增组件
    import createForm from './create'
    //编辑组件
    import editForm from './edit'
    //Test3 page 接口
    import {Test3PageRequest} from '@/sdk/api/test/test3/page'
    //Test3 delete 接口
    import {Test3DeleteRequest} from '@/sdk/api/test/test3/delete'
    import dict from '@/mixins/dict'

    export default {
        name: 'Test3-Table',
        components: {Pagination, createForm, editForm},
        mixins: [dict],
        data() {
            return {
                tableKey: 'Test3',
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
                    info: undefined,
                    status: undefined,
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
                    let request = new Test3PageRequest();
                    request.setParams(this.tableQuery);
                    request.api().then(res => {
                        this.tableLoading = false
                        this.tableData = res['list']
                        this.total = res['total']
                        console.log("Test3 tableData res:", res)
                    })
                    this.loadDictValue('status')
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
                    let request = new Test3DeleteRequest();
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
