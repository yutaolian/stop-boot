<template>
    <div class="app-container">
        <!--分页过滤条件-->
        <div v-permission="['P_TEST_TEST4_PAGE']" class="filter-container" >
            <el-form ref="filterForm" :model="tableQuery">
                <el-row>
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
                        <el-form-item prop="status" label="状态">
                                 <el-select v-model="tableQuery.status" placeholder="请选择">
                                     <el-option
                                             v-for="item in this.dictValueMap.sex"
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
                                <el-button v-permission="['P_TEST_TEST4_PAGE']" class="filter-item" type="danger" icon="el-icon-close" @click="cleanFilter" circle/>
                                <el-button v-permission="['P_TEST_TEST4_PAGE']" class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter" circle/>
                                <el-button v-permission="['P_TEST_TEST4_ADD']" class="filter-item" type="success" icon="el-icon-plus" @click="preCreate" circle/>
                            </div>
                        </div>
                    </el-col>
                </el-row>
            </el-form>
        </div>
        <!--表格-->
        <el-table
                v-permission="['P_TEST_TEST4_PAGE']"
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
            <el-table-column prop="headImg" label="头像" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.headImg }}</span>
                </template>
            </el-table-column>

            <el-table-column  class-name="small-padding fixed-width" label="操作" align="center">
                <template slot-scope="{row}">
                    <el-button v-permission="['P_TEST_TEST4_ONE']"  type="primary" size="mini" @click="preEdit(row)">
                        编辑
                    </el-button>
                    <el-button v-permission="['P_TEST_TEST4_DELETE']" size="mini" type="danger" @click="handleDelete(row)">
                        删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <!--分页组件-->
        <pagination  v-permission="['P_TEST_TEST4_PAGE']" v-show="total>0" :total="total" :page.sync="pageNum" :limit.sync="pageSize"
                    @pagination="loadData"/>

        <!--新增组件-->
        <create-form v-permission="['P_TEST_TEST4_ADD']"  ref="createForm" :rowData='createRowData'  @loadData="loadData"></create-form>

        <!--编辑组件-->
        <edit-form v-permission="['P_TEST_TEST4_UPDATE']" ref="editForm" :rowData='editRowData'  @loadData="loadData"></edit-form>

    </div>
</template>

<script>
    //分页组件
    import Pagination from '@/components/Pagination'
    //新增组件
    import createForm from './create'
    //编辑组件
    import editForm from './edit'
    //Test4 page 接口
    import {Test4PageRequest} from '@/sdk/api/test/test4/page'
    //Test4 delete 接口
    import {Test4DeleteRequest} from '@/sdk/api/test/test4/delete'
    //接口混入
    import api from '@/mixins/api'

    export default {
        name: 'Test4-Table',
        components: {Pagination, createForm, editForm},
        mixins: [api],
        data() {
            return {
                tableKey: 'Test4',
                total: 0,
                tableLoading: true,
                tableQuery: {
                    name: undefined,
                    age: undefined,
                    status: undefined,
                },
                dialogFormVisible: false,
                editRowData: {},
                createRowData:{},
                deleteParams:{
                    id:undefined
                }
            }
        },
        filters: {},
        created() {
            this.loadData()
            this.dict('sex')
        },
        methods: {
            loadData() {
                this.$nextTick(() => {
                    //加载数据
                    let request = new Test4PageRequest();
                    request.setParams(this.tableQuery)
                    this.page(request)
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
                this.createRowData = Object.assign({}, row)
                this.$refs.createForm.dialogFormVisible = true
            },
            preEdit(row) {
                this.editRowData = Object.assign({}, row)
                this.$refs.editForm.dialogFormVisible = true
            },
            handleDelete(row) {
                let request = new Test4DeleteRequest()
                this.deleteParams.id = row.id
                request.setParams(this.deleteParams)
                this.delete(request).then(res => {
                    this.loadData()
                })
            }
        }
    }
</script>
