<template>
    <div class="app-container">
        <!--分页过滤条件-->
        <div v-permission="['${fullPathToPermission}_PAGE']" class="filter-container" >
            <el-form ref="filterForm" :model="tableQuery">
                <el-row>
                    <#list tableColumnsData as colum>
                    <el-col :span="4">
                        <el-form-item prop="${colum.camelColumnName}" label="${colum.camelColumnName}">
                            <el-input v-model="tableQuery.${colum.camelColumnName}" placeholder="${colum.camelColumnName}" style="width: 180px;" class="filter-item"
                                      @keyup.enter.native="handleFilter"/>
                        </el-form-item>
                    </el-col>
                    </#list>
                    <!--@click="cleanFilter"-->
                    <el-col :span="4">
                        <div class="el-form-item__label" style="width:50px">&nbsp;</div>
                        <div class="el-form-item__content">
                            <div class="filter-item" style="width: 180px;">
                                <el-button v-permission="['${fullPathToPermission}_PAGE']" class="filter-item" type="danger" icon="el-icon-close" @click="cleanFilter" circle/>
                                <el-button v-permission="['${fullPathToPermission}_PAGE']" class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter" circle/>
                                <el-button v-permission="['${fullPathToPermission}_ADD']" class="filter-item" type="success" icon="el-icon-plus" @click="preCreate" circle/>
                            </div>
                        </div>
                    </el-col>
                </el-row>
            </el-form>
        </div>
        <!--表格-->
        <el-table
                v-permission="['${fullPathToPermission}_PAGE']"
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
            <#list tableColumnsData as colum>
            <el-table-column prop="${colum.camelColumnName}" label="${colum.camelColumnName}" align="center">
                <template slot-scope="scope">
                    <span>{{ scope.row.${colum.camelColumnName} }}</span>
                </template>
            </el-table-column>
            </#list>

            <el-table-column  class-name="small-padding fixed-width" label="操作" align="center">
                <template slot-scope="{row}">
                    <el-button v-permission="['${fullPathToPermission}_ONE']"  type="primary" size="mini" @click="preEdit(row)">
                        编辑
                    </el-button>
                    <el-button v-permission="['${fullPathToPermission}_DELETE']" size="mini" type="danger" @click="handleDelete(row)">
                        删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <!--分页组件-->
        <pagination  v-permission="['${fullPathToPermission}_PAGE']" v-show="total>0" :total="total" :page.sync="tableQuery.pageNum" :limit.sync="tableQuery.pageSize"
                    @pagination="loadData"/>

        <!--新增组件-->
        <create-form v-permission="['${fullPathToPermission}_ADD']"  ref="createForm" :rowData='createRowData'  @loadData="loadData"></create-form>

        <!--编辑组件-->
        <edit-form v-permission="['${fullPathToPermission}_UPDATE']" ref="editForm" :rowData='editRowData'  @loadData="loadData"></edit-form>

    </div>
</template>

<script>
    //分页组件
    import Pagination from '@/components/Pagination'
    //新增组件
    import createForm from './create'
    //编辑组件
    import editForm from './edit'
    //${model?cap_first} page 接口
    import {${model?cap_first}PageRequest} from '@${jsSdkConfigPath}${fullPath}/page'
    //${model?cap_first} delete 接口
    import {${model?cap_first}DeleteRequest} from '@${jsSdkConfigPath}${fullPath}/delete'

    export default {
        name: '${model?cap_first}-Table',
        components: {Pagination, createForm, editForm},
        data() {
            return {
                tableKey: '${model?cap_first}',
                tableData: null,
                total: 0,
                tableLoading: true,
                tableQuery: {
                    pageNum: 1,
                    pageSize: 10,
                    <#list tableColumnsData as colum>
                    ${colum.camelColumnName}: undefined,
                    </#list>
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
                    let request = new ${model?cap_first}PageRequest();
                    request.setParams(this.tableQuery);
                    request.api().then(res => {
                        this.tableLoading = false
                        this.tableData = res['list']
                        this.total = res['total']
                        console.log("${model?cap_first} tableData res:", res)
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
                    let request = new ${model?cap_first}DeleteRequest();
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
