<template>
    <div class="app-container">
        <!--分页过滤条件-->
        <div class="filter-container">
            <el-input v-model="pageQuery.title" placeholder="名称" style="width: 200px;" class="filter-item"
                      @keyup.enter.native="handleFilter"/>
            <!--      @click="cleanFilter"-->
            <el-button class="filter-item" type="danger" icon="el-icon-close" circle/>
            <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter" circle/>
            <el-button class="filter-item" style="margin-left: 10px;" type="success" icon="el-icon-plus" @click="preCreate"
                       circle>
            </el-button>
        </div>
        <!--表格-->
        <el-table
                :key="tableKey"
                v-loading="listLoading"
                :data="list"
                border
                stripe
                empty-text
                fit
                highlight-current-row
                style="width: 100%;"
                @sort-change="sortChange"
            >
            <#list tableColumnsData as colum>
            <el-table-column label="${colum.camelColumnName}" prop="${colum.camelColumnName}" align="center" width="80">
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
                    @pagination="getList"/>

        <!--新增组件-->
        <create-form ref="createForm"></create-form>

        <!--编辑组件-->
        <edit-form ref="editForm" :row='updateRowData'></edit-form>

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
        filters: {
            statusFilter(status) {
                const statusMap = {
                    published: 'success',
                    draft: 'info',
                    deleted: 'danger'
                }
                return statusMap[status]
            },
            typeFilter(type) {
                return calendarTypeKeyValue[type]
            }
        },
        data() {
            return {
                tableKey: 0,
                list: null,
                total: 0,
                listLoading: true,
                pageQuery: {
                    pageNum: 1,
                    pageSize: 10,
                },
                dialogFormVisible: false,
                dialogPvVisible: false,
                updateRowData: {}
            }
        },
        created() {
            this.getList()
        },
        methods: {
            getList() {
                this.listLoading = true
                //单独设置参数方式二
                let request = new ${model?cap_first}PageRequest();
                <#list tableColumnsData as colum>
                //request.set${colum.camelColumnName?cap_first}(${colum.camelColumnName});
                </#list>
                request.setPageNum(this.pageQuery.pageNum)
                request.setPageSize(this.pageQuery.pageSize)
                request.api().then(res => {
                    this.listLoading = false
                    this.list = res['list']
                    this.total = res['total']
                    console.log("${model?cap_first}${currentType?cap_first}Request res:", res)
                })
            },
            handleFilter() {
                this.pageQuery.page = 1
                this.getList()
            },
            sortChange(data) {
                const {prop, order} = data
                if (prop === 'id') {
                    this.sortByID(order)
                }
            },
            sortByID(order) {
                if (order === 'ascending') {
                    this.pageQuery.sort = '+id'
                } else {
                    this.pageQuery.sort = '-id'
                }
                this.handleFilter()
            },
            preCreate() {
                this.$refs.createForm.dialogFormVisible = true
            },
            preEdit(row) {
                this.updateRowData = Object.assign({}, row)
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
                    const index = this.list.indexOf(row)
                    this.list.splice(index, 1)
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消'
                    });
                });
            },
            getSortClass: function (key) {
                const sort = this.pageQuery.sort
                return sort === `+${key}`
                    ? 'ascending'
                    : sort === `-${key}`
                        ? 'descending'
                        : ''
            }
        }
    }
</script>
