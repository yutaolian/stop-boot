<template>
  <div class="app-container">
    <el-row>
      <el-col :span="16">
        <div class="filter-container">
          <el-input v-model="listQuery.title" placeholder="名称" style="width: 200px;" class="filter-item"
                    @keyup.enter.native="handleFilter"/>
          <el-input v-model="listQuery.title" placeholder="tag" style="width: 200px;" class="filter-item"
                    @keyup.enter.native="handleFilter"/>
          <el-button v-waves class="filter-item" type="danger" icon="el-icon-close" size="small" round>清空</el-button>
          <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter" size="small" round>搜索</el-button>
          <el-button v-waves class="filter-item" type="success" icon="el-icon-plus" @click="handleCreate" size="small" round>新增</el-button>
        </div>
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

          <el-table-column type="expand">
            <template slot-scope="scope">
              <el-form label-position="left" inline class="demo-table-expand">
                <el-form-item label="ID">
                  <span>{{ scope.row.id }}</span>
                </el-form-item>
                <el-form-item label="角色描述">
                  <span>{{ scope.row.description }}</span>
                </el-form-item>
              </el-form>
            </template>
          </el-table-column>

          <el-table-column label="ID" prop="id" align="center" width="80">
            <template slot-scope="scope">
              <span>{{ scope.row.id }}</span>
            </template>
          </el-table-column>
          <el-table-column label="角色名称" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.name}}</span>
            </template>
          </el-table-column>
          <el-table-column label="角色tag" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.tag}}</span>
            </template>
          </el-table-column>
          <el-table-column label="状态" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.status}}</span>
            </template>
          </el-table-column>
          <el-table-column label="Actions" align="center" class-name="small-padding fixed-width">
            <template slot-scope="{row}">
              <el-button type="primary" size="mini" @click="handleUpdate(row)">
                Edit
              </el-button>
              <el-button v-if="row.status!='deleted'" size="mini" type="danger"
                         @click="handleModifyStatus(row,'deleted')">
                Delete
              </el-button>
            </template>
          </el-table-column>
        </el-table>
        <pagination v-show="total>0" :total="total" :page.sync="listQuery.pageNum" :limit.sync="listQuery.pageSize"
                    @pagination="getList"/>

      </el-col>

      <el-col :span="8">
        <div style="margin-top: 60px">
          <el-tabs type="border-card">
            <el-tab-pane>
              <span slot="label"><i class="el-icon-date"></i> 菜单分配</span>
              <el-tree
                :data="data"
                default-expand-all
                show-checkbox
                node-key="id"
                :default-expanded-keys="[2, 3]"
                :default-checked-keys="[5]"
                :props="defaultProps">
              </el-tree>

              <el-button v-waves class="filter-item" type="primary" icon="el-icon-edit" size="mini">保存</el-button>
            </el-tab-pane>
            <el-tab-pane>
              <span slot="label"><i class="el-icon-date"></i> 权限分配</span>

              <el-tree
                :data="data2"
                default-expand-all
                show-checkbox
                node-key="id"
                :default-expanded-keys="[1, 3]"
                :default-checked-keys="[5]"
                :props="defaultProps">
              </el-tree>

              <el-button v-waves class="filter-item" type="primary" icon="el-icon-edit" size="mini">保存2</el-button>
            </el-tab-pane>
          </el-tabs>

        </div>
      </el-col>
    </el-row>


  </div>
</template>

<script>
    // import { fetchList, fetchPv, createArticle, updateArticle } from '@/api/article'

    import {RolePageRequest, rolePage} from '@/sdk/api/role/page'
    import waves from '@/directive/waves' // waves directive
    import {parseTime} from '@/utils'
    import Pagination from '@/components/Pagination' // secondary package based on el-pagination

    const calendarTypeOptions = [
        {key: 'CN', display_name: 'China'},
        {key: 'US', display_name: 'USA'},
        {key: 'JP', display_name: 'Japan'},
        {key: 'EU', display_name: 'Eurozone'}
    ]

    // arr to obj, such as { CN : "China", US : "USA" }
    const calendarTypeKeyValue = calendarTypeOptions.reduce((acc, cur) => {
        acc[cur.key] = cur.display_name
        return acc
    }, {})

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
                calendarTypeOptions,
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
                filterText: '',
                data: [{
                    id: 1,
                    label: '一级 1',
                    children: [{
                        id: 4,
                        label: '二级 1-1',
                        children: [{
                            id: 9,
                            label: '三级 1-1-1'
                        }, {
                            id: 10,
                            label: '三级 1-1-2'
                        }]
                    }]
                }, {
                    id: 2,
                    label: '一级 2',
                    children: [{
                        id: 5,
                        label: '二级 2-1'
                    }, {
                        id: 6,
                        label: '二级 2-2'
                    }]
                }, {
                    id: 3,
                    label: '一级 3',
                    children: [{
                        id: 7,
                        label: '二级 3-1'
                    }, {
                        id: 8,
                        label: '二级 3-2'
                    }]
                }],
                data2: [{
                    id: 1,
                    label: '一级 1',
                    children: [{
                        id: 4,
                        label: '二级 1-1',
                        children: [{
                            id: 9,
                            label: '三级 1-1-1'
                        }, {
                            id: 10,
                            label: '三级 1-1-2'
                        }]
                    }]
                }, {
                    id: 2,
                    label: '一级 2',
                    children: [{
                        id: 5,
                        label: '二级 2-1'
                    }, {
                        id: 6,
                        label: '二级 2-2'
                    }]
                }, {
                    id: 3,
                    label: '一级 3',
                    children: [{
                        id: 7,
                        label: '二级 3-1'
                    }, {
                        id: 8,
                        label: '二级 3-2'
                    }]
                }],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }
            };
        },
        created() {
            this.getList()
        },
        watch: {
            filterText(val) {
                this.$refs.tree.filter(val);
            }
        },
        methods: {
            getList() {
                this.listLoading = true
                var request = new RolePageRequest()
                request.setUserId(7919)
                request.setPageNum(this.listQuery.pageNum)
                request.setPageSize(this.listQuery.pageSize)
                rolePage(request).then(res => {
                    this.listLoading = false
                    this.list = res['list']
                    this.total = res['total']
                })

                // fetchList(this.listQuery).then(response => {
                //     this.list = response.data.items
                //     this.total = response.data.total
                //
                //     // Just to simulate the time of the request
                //     setTimeout(() => {
                //         this.listLoading = false
                //     }, 1.5 * 1000)
                // })
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
            },
            filterNode(value, data) {
                if (!value) return true;
                return data.label.indexOf(value) !== -1;
            }
        }
    }
</script>
