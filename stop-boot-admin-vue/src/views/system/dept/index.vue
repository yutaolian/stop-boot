<template>
  <div class="app-container">
    <el-table
      :data="tableData"
      style="width: 100%;margin-bottom: 20px;"
      row-key="id"
      border
      default-expand-all
      :tree-props="{children: 'children', hasChildren: 'hasChildren'}">
      <el-table-column label="菜单标题" prop="title" >
        <template slot-scope="scope">
          <span>{{ scope.row.title }}</span>
        </template>
      </el-table-column>

      <el-table-column label="path" prop="path" >
        <template slot-scope="scope">
          <span>{{ scope.row.path }}</span>
        </template>
      </el-table-column>

      <el-table-column label="组件" prop="component" >
        <template slot-scope="scope">
          <span>{{ scope.row.component }}</span>
        </template>
      </el-table-column>

      <el-table-column label="组件名称" prop="name" :class-name="getSortClass('id')">
        <template slot-scope="scope">
          <span>{{ scope.row.name }}</span>
        </template>
      </el-table-column>

      <el-table-column label="显示状态" prop="sort" >
        <template slot-scope="scope">
          <span>{{ scope.row.hidden }}</span>
        </template>
      </el-table-column>

      <el-table-column label="操作" prop="sort" align="center">
        <template slot-scope="scope">
          <el-button v-waves class="filter-item" type="danger" icon="el-icon-close" size="mini"  round>删除</el-button>
          <el-button class="filter-item" style="margin-left: 10px;" type="success" icon="el-icon-plus" size="mini"  round>新增</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
    import waves from '@/directive/waves' // waves directive
    import Pagination from '@/components/Pagination' // secondary package based on el-pagination
    import {menuList, MenuListRequest} from '@/sdk/api/menu/list'

    export default {
        name: 'ComplexTable',
        components: {Pagination},
        directives: {waves},
        filters: {
            statusFilter(status) {
                const statusMap = {
                    published: 'success',
                    draft: 'info',
                    deleted: 'danger'
                }
                return statusMap[status]
            }
        },
        data() {
            return {
                tableKey: 0,
                list: null,
                total: 0,
                listLoading: true,
                listQuery: {
                    pageNum: 1,
                    pageSize: 10,
                    importance: undefined,
                    title: undefined,
                    type: undefined,
                    sort: '+id',
                    status: undefined
                },
                importanceOptions: [1, 2, 3],
                sortOptions: [{label: 'ID Ascending', key: '+id'}, {label: 'ID Descending', key: '-id'}],
                statusOptions: ['published', 'draft', 'deleted'],
                showReviewer: false,
                temp: {
                    id: undefined,
                    importance: 1,
                    remark: '',
                    timestamp: new Date(),
                    title: '',
                    type: '',
                    status: 'published'
                },
                dialogFormVisible: false,
                dialogStatus: '',
                textMap: {
                    update: 'Edit',
                    create: 'Create'
                },
                dialogPvVisible: false,
                pvData: [],
                rules: {
                    type: [{required: true, message: 'type is required', trigger: 'change'}],
                    timestamp: [{type: 'date', required: true, message: 'timestamp is required', trigger: 'change'}],
                    title: [{required: true, message: 'title is required', trigger: 'blur'}]
                },
                downloadLoading: false,
                tableData: null
            }
        },
        created() {
            this.getList()
        },
        methods: {
            getList() {
                this.listLoading = true
                var request = new MenuListRequest()
                request.setUserId(7919)
                request.setCourseId(2563)
                menuList(request).then(res => {
                    this.listLoading = false
                    console.log("res", res)
                    this.tableData = res;
                    // [{
                    //     id: 1,
                    //     date: '2016-05-02',
                    //     name: '王小虎',
                    //     address: '上海市普陀区金沙江路 1518 弄'
                    // }, {
                    //     id: 2,
                    //     date: '2016-05-04',
                    //     name: '王小虎',
                    //     address: '上海市普陀区金沙江路 1517 弄'
                    // }, {
                    //     id: 3,
                    //     date: '2016-05-01',
                    //     name: '王小虎',
                    //     address: '上海市普陀区金沙江路 1519 弄',
                    //     children: [{
                    //         id: 31,
                    //         date: '2016-05-01',
                    //         name: '王小虎',
                    //         address: '上海市普陀区金沙江路 1519 弄'
                    //     }, {
                    //         id: 32,
                    //         date: '2016-05-01',
                    //         name: '王小虎',
                    //         address: '上海市普陀区金沙江路 1519 弄'
                    //     }]
                    // }, {
                    //     id: 4,
                    //     date: '2016-05-03',
                    //     name: '王小虎',
                    //     address: '上海市普陀区金沙江路 1516 弄'
                    // }]
                })
            },
            handleFilter() {
                this.listQuery.page = 1
                this.getList()
            },
            handleModifyStatus(row, status) {
                this.$message({
                    message: '操作Success',
                    type: 'success'
                })
                row.status = status
            },
            sortChange(data) {
                const {prop, order} = data
                if (prop === 'id') {
                    this.sortByID(order)
                }
            },
            sortByID(order) {
                if (order === 'ascending') {
                    this.listQuery.sort = '+id'
                } else {
                    this.listQuery.sort = '-id'
                }
                this.handleFilter()
            },
            resetTemp() {
                this.temp = {
                    id: undefined,
                    importance: 1,
                    remark: '',
                    timestamp: new Date(),
                    title: '',
                    status: 'published',
                    type: ''
                }
            },
            handleCreate() {
                this.resetTemp()
                this.dialogStatus = 'create'
                this.dialogFormVisible = true
                this.$nextTick(() => {
                    this.$refs['dataForm'].clearValidate()
                })
            },
            createData() {
                this.$refs['dataForm'].validate((valid) => {
                    if (valid) {
                        this.temp.id = parseInt(Math.random() * 100) + 1024 // mock a id
                        this.temp.author = 'vue-element-admin'
                        // createArticle(this.temp).then(() => {
                        //     this.list.unshift(this.temp)
                        //     this.dialogFormVisible = false
                        //     this.$notify({
                        //         title: 'Success',
                        //         message: 'Created Successfully',
                        //         type: 'success',
                        //         duration: 2000
                        //     })
                        // })
                    }
                })
            },
            handleUpdate(row) {
                this.temp = Object.assign({}, row) // copy obj
                this.temp.timestamp = new Date(this.temp.timestamp)
                this.dialogStatus = 'update'
                this.dialogFormVisible = true
                this.$nextTick(() => {
                    this.$refs['dataForm'].clearValidate()
                })
            },
            updateData() {
                this.$refs['dataForm'].validate((valid) => {
                    if (valid) {
                        const tempData = Object.assign({}, this.temp)
                        tempData.timestamp = +new Date(tempData.timestamp) // change Thu Nov 30 2017 16:41:05 GMT+0800 (CST) to 1512031311464
                        // updateArticle(tempData).then(() => {
                        //     for (const v of this.list) {
                        //         if (v.id === this.temp.id) {
                        //             const index = this.list.indexOf(v)
                        //             this.list.splice(index, 1, this.temp)
                        //             break
                        //         }
                        //     }
                        //     this.dialogFormVisible = false
                        //     this.$notify({
                        //         title: 'Success',
                        //         message: 'Update Successfully',
                        //         type: 'success',
                        //         duration: 2000
                        //     })
                        // })
                    }
                })
            },
            handleDelete(row) {
                this.$notify({
                    title: 'Success',
                    message: 'Delete Successfully',
                    type: 'success',
                    duration: 2000
                })
                const index = this.list.indexOf(row)
                this.list.splice(index, 1)
            },
            handleFetchPv(pv) {
                // fetchPv(pv).then(response => {
                //     this.pvData = response.data.pvData
                //     this.dialogPvVisible = true
                // })
            },
            handleDownload() {
                this.downloadLoading = true
                // import('@/vendor/Export2Excel').then(excel => {
                //     const tHeader = ['timestamp', 'title', 'type', 'importance', 'status']
                //     const filterVal = ['timestamp', 'title', 'type', 'importance', 'status']
                //     const data = this.formatJson(filterVal, this.list)
                //     excel.export_json_to_excel({
                //         header: tHeader,
                //         data,
                //         filename: 'table-list'
                //     })
                //     this.downloadLoading = false
                // })
            },
            // formatJson(filterVal, jsonData) {
            //     return jsonData.map(v => filterVal.map(j => {
            //         if (j === 'timestamp') {
            //             return parseTime(v[j])
            //         } else {
            //             return v[j]
            //         }
            //     }))
            // },
            getSortClass: function (key) {
                const sort = this.listQuery.sort
                return sort === `+${key}`
                    ? 'ascending'
                    : sort === `-${key}`
                        ? 'descending'
                        : ''
            }
        }
    }
</script>
