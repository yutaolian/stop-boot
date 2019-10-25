<template>
    <div class="app-container">
        <!--分页过滤条件-->
        <div class="filter-container">
            <el-form ref="filterForm" :model="pageQuery">
                <el-row>
                    <#list tableColumnsData as colum>
                    <el-col :span="4">
                        <el-form-item prop="${colum.camelColumnName}" label="${colum.camelColumnName}">
                            <el-input v-model="pageQuery.${colum.camelColumnName}" placeholder="${colum.camelColumnName}" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    </#list>
                    <!--@click="cleanFilter"-->
                    <el-col :span="4">
                        <el-form-item label="">
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
            <#list tableColumnsData as colum>
            <el-table-column label="${colum.camelColumnName}" prop="${colum.camelColumnName}" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.${colum.camelColumnName} }}</span>
                </template>
            </el-table-column>
            </#list>

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
    import {${model?cap_first}PageRequest} from '@${jsSdkConfigPath}${fullPath}/page'


    export default {
        name: '${model?cap_first}PageTable',
        components: {Pagination, createForm, editForm},
        data() {
            return {
                tableKey: '${model?cap_first}',
                pageData: null,
                total: 0,
                pageLoading: true,
                pageQuery: {
                    pageNum: 1,
                    pageSize: 10,
                    <#list tableColumnsData as colum>
                    ${colum.camelColumnName}: undefined,
                    </#list>
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
                let request = new ${model?cap_first}PageRequest();
                request.setParams(this.pageQuery);
                request.api().then(res => {
                    this.pageLoading = false
                    this.pageData = res['list']
                    this.total = res['total']
                    console.log("${model?cap_first} page data res:", res)
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
