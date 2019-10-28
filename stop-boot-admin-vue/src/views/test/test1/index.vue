<template>
    <div class="app-container">
        <!--分页过滤条件-->
        <div class="filter-container">
            <el-form ref="filterForm" :model="pageQuery">
                <el-row>
                                        <el-col :span="4">
                        <el-form-item prop="id" label="id">
                            <el-input v-model="pageQuery.id" placeholder="id" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="name" label="name">
                            <el-input v-model="pageQuery.name" placeholder="name" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="age" label="age">
                            <el-input v-model="pageQuery.age" placeholder="age" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="birthday" label="birthday">
                            <el-input v-model="pageQuery.birthday" placeholder="birthday" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="createTime" label="createTime">
                            <el-input v-model="pageQuery.createTime" placeholder="createTime" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="info" label="info">
                            <el-input v-model="pageQuery.info" placeholder="info" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="status" label="status">
                            <el-input v-model="pageQuery.status" placeholder="status" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="headImg" label="headImg">
                            <el-input v-model="pageQuery.headImg" placeholder="headImg" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="deleteFlag" label="deleteFlag">
                            <el-input v-model="pageQuery.deleteFlag" placeholder="deleteFlag" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="4">
                        <el-form-item prop="updateTime" label="updateTime">
                            <el-input v-model="pageQuery.updateTime" placeholder="updateTime" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    <!--@click="cleanFilter"-->

                    <el-col :span="4">
                        <el-form-item label="">
                          <span v-permission="['test22_ADD']">permission : test22_ADD</span>
                            <el-button class="filter-item" type="danger" icon="el-icon-close" @click="cleanFilter" circle/>
                            <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter" circle/>
                            <el-button class="filter-item" type="success" icon="el-icon-plus" @click="preCreate" circle/>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
        </div>
        <!--表格-->
        <el-table
                :key="tableKey"
                v-loading="pageLoading"
                :data="pageData"
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
                    <el-button type="primary" size="mini" @click="preEdit(row)">
                        Edit
                    </el-button>
                    <el-button v-if="row.status!='deleted'" size="mini" type="danger" @click="handleDelete(row)">
                        Delete
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <!--分页组件-->
        <pagination v-show="total>0" :total="total" :page.sync="pageQuery.pageNum" :limit.sync="pageQuery.pageSize"
                    @pagination="loadPageData"/>

        <!--新增组件-->
        <create-form ref="createForm"></create-form>

        <!--编辑组件-->
        <edit-form ref="editForm" :editRowData='editRowData'></edit-form>

    </div>
</template>

<script>
    import Pagination from '@/components/Pagination'
    //新增组件
    import createForm from './create'
    //编辑组件
    import editForm from './edit'
    //接口
    import {Test1PageRequest} from '@/sdk/api/test/test1/page'


    export default {
        name: 'Test1PageTable',
        components: {Pagination, createForm, editForm},
        data() {
            return {
                tableKey: 'Test1',
                pageData: null,
                total: 0,
                pageLoading: true,
                pageQuery: {
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
                editRowData: {}
            }
        },
        filters: {},
        created() {
            this.loadPageData()
        },
        methods: {
            loadPageData() {
                this.pageLoading = true
                let request = new Test1PageRequest();
                request.setParams(this.pageQuery);
                request.api().then(res => {
                    this.pageLoading = false
                    this.pageData = res['list']
                    this.total = res['total']
                    console.log("Test1 page data res:", res)
                })
            },
            handleFilter() {
                this.pageQuery.pageNum = 1
                this.loadPageData()
            },
            cleanFilter() {
                this.$refs['filterForm'].resetFields();
                this.loadPageData()
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
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                    const index = this.pageData.indexOf(row)
                    this.pageData.splice(index, 1)
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
