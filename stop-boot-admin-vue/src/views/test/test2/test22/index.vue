<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="listQuery.title" placeholder="名称" style="width: 200px;" class="filter-item"
                @keyup.enter.native="handleFilter"/>
      <el-select v-model="listQuery.status" placeholder="状态" clearable style="width: 90px" class="filter-item">
        <el-option v-for="item in importanceOptions" :key="item" :label="item" :value="item"/>
      </el-select>
      <!--      @click="cleanFilter"-->
      <el-button v-waves class="filter-item" type="danger" icon="el-icon-close" circle/>
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter" circle/>
      <el-button class="filter-item" style="margin-left: 10px;" type="success" icon="el-icon-plus" @click="handleCreate"
                 circle>
      </el-button>
      <el-button v-waves :loading="downloadLoading" class="filter-item" icon="el-icon-download"
                 @click="handleDownload" circle>22
      </el-button>
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
            <el-form-item label="商品名称21">
              <span>{{ scope.row.name }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column label="ID" prop="id" sortable="custom" align="center" width="80"
                       :class-name="getSortClass('id')">
        <template slot-scope="scope">
          <span>{{ scope.row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column label="封面图22" width="80px" align="center">
        <template slot-scope="scope">
          <el-image style="width: 50px; height: 40px"
                    :src="scope.row.headImg" :lazy="true"
                    :preview-src-list="[scope.row.headImg]">
          </el-image>
        </template>
      </el-table-column>
<!--      <el-table-column label="名称" width="100px" align="center">-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ scope.row.name}}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="年龄" align="center">-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ scope.row.age}}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="生日" align="center">-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ scope.row.birthday}}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->


      <el-table-column label="Actions" align="center" class-name="small-padding fixed-width">
        <template slot-scope="{row}">
          <el-button type="primary" size="mini" @click="handleUpdate(row)">
            Edit
          </el-button>
          <!--          <router-link to="/course/detail">详情</router-link>-->
          <router-link :to="{name:'courseDetail',query:{id:row.id}}">详情</router-link>

          <el-button v-if="row.status!='deleted'" size="mini" type="danger" @click="handleModifyStatus(row,'deleted')">
            Delete
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.pageNum" :limit.sync="listQuery.pageSize"
                @pagination="getList"/>

    <add-test ref="addTest"></add-test>
    <update-test ref="updateTest" :row='update_json'></update-test>
    <!--删除-->
    <el-dialog :visible.sync="dialogPvVisible" title="Reading statistics">
      <el-table :data="pvData" border fit highlight-current-row style="width: 100%">
        <el-table-column prop="key" label="Channel"/>
        <el-table-column prop="pv" label="Pv"/>
      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogPvVisible = false">Confirm</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
    import {TestPageRequest, testPage} from '@/sdk/api/test/test1/page'
    import waves from '@/directive/waves' // waves directive
    import {parseTime} from '@/utils'
    import Pagination from '@/components/Pagination' // secondary package based on el-pagination
    import addTest from './add'
    import updateTest from './update'

    export default {
        name: 'ComplexTable',
        components: {Pagination,addTest,updateTest},
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
                sortOptions: [{label: 'ID Ascending', key: '+id'}, {label: 'ID Descending', key: '-id'}],
                
                showReviewer: false,
                temp: {},
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



                update_json:{}
            }
        },
        created() {
            this.getList()
        },
        methods: {
            getList() {
                this.listLoading = true
                let request = new TestPageRequest()
                request.setPageNum(this.listQuery.pageNum)
                request.setPageSize(this.listQuery.pageSize)
                testPage(request).then(res => {
                    this.listLoading = false
                    this.list = res['list']
                    this.total = res['total']
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
            handleCreate() {
                this.dialogStatus = 'create'
                this.$refs.addTest.dialogFormVisible = true
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
                this.update_json = Object.assign({}, row) // copy obj
                this.dialogStatus = 'update'
                this.$refs.updateTest.dialogFormVisible = true
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
