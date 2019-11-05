<template>
  <div class="app-container">
    <!--分页过滤条件-->
    <div v-permission="['P_SYSTEM_DICTIONARY_PAGE']" class="filter-container">
      <el-form ref="filterForm" :model="tableQuery">
        <el-row>

          <el-col :span="4">
            <el-form-item prop="dicName" label="字典名称">
              <el-input v-model="tableQuery.dicName" placeholder="dicName" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="dicKey" label="字典key">
              <el-input v-model="tableQuery.dicKey" placeholder="dicKey" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <!--@click="cleanFilter"-->
          <el-col :span="4">
            <div class="el-form-item__label" style="width:50px">&nbsp;</div>
            <div class="el-form-item__content">
              <div class="filter-item" style="width: 180px;">
                <el-button v-permission="['P_SYSTEM_DICTIONARY_PAGE']" class="filter-item" type="danger"
                           icon="el-icon-close" @click="cleanFilter" circle/>
                <el-button v-permission="['P_SYSTEM_DICTIONARY_PAGE']" class="filter-item" type="primary"
                           icon="el-icon-search" @click="handleFilter" circle/>
                <el-button v-permission="['P_SYSTEM_DICTIONARY_ADD']" class="filter-item" type="success"
                           icon="el-icon-plus" @click="preCreate" circle/>
              </div>
            </div>
          </el-col>
        </el-row>
      </el-form>
    </div>

    <el-row>
      <el-col :span="12">
        <!--表格-->
        <el-table
          v-permission="['P_SYSTEM_DICTIONARY_PAGE']"
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
          <el-table-column type="index" align="center">

          </el-table-column>
          <el-table-column prop="dicName" label="字典名称" align="center">
            <template slot-scope="scope">
              <el-link type="primary" @click="rowSelected(scope.row)">{{ scope.row.dicName }}</el-link>
            </template>
          </el-table-column>
          <el-table-column prop="dicKey" label="字典key" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.dicKey }}</span>
            </template>
          </el-table-column>
          <el-table-column prop="status" label="status" align="center">
            <template slot-scope="scope">
              <span>{{ scope.row.status }}</span>
            </template>
          </el-table-column>
          <el-table-column class-name="small-padding fixed-width" label="操作" align="center">
            <template slot-scope="{row}">
              <el-button v-permission="['P_SYSTEM_DICTIONARY_ONE']" type="primary" size="mini" @click="preEdit(row)">
                编辑
              </el-button>
              <el-button v-permission="['P_SYSTEM_DICTIONARY_DELETE']" size="mini" type="danger"
                         @click="handleDeleteAll(row)">
                删除
              </el-button>
            </template>
          </el-table-column>
        </el-table>

        <!--分页组件-->
        <pagination v-permission="['P_SYSTEM_DICTIONARY_PAGE']" v-show="total>0" :total="total"
                    :page.sync="tableQuery.pageNum" :limit.sync="tableQuery.pageSize"
                    @pagination="loadData"/>

      </el-col>

      <el-col :span="12">
        <div style="margin-left: 20px;">
          <el-tabs type="border-card">
            <el-tab-pane>
              <span slot="label"><i class="el-icon-date"></i>字典值</span>
              <span>已选：{{ selectedDictionaryName }}</span>
              <el-button type="primary" size="small" @click="preCreate()">添加</el-button>
              <el-divider></el-divider>
              <!--表格-->
              <el-table
                v-permission="['P_SYSTEM_DICTIONARY_PAGE']"
                :key="tableKey2"
                :data="selectedDictionaryValues"
                border
                stripe
                empty-text
                fit
                highlight-current-row
                style="width: 100%;"
              >
                <el-table-column prop="dicKey" label="字典key" align="center">
                  <template slot-scope="scope">
                    <span>{{ scope.row.dicKey }}</span>
                  </template>
                </el-table-column>
                <el-table-column prop="dicValue" label="字典value" align="dicValue">
                  <template slot-scope="scope">
                    <span>{{ scope.row.dicValue }}</span>
                  </template>
                </el-table-column>
                <el-table-column prop="dicDesc" label="字典描述" align="center">
                  <template slot-scope="scope">
                    <span>{{ scope.row.dicDesc }}</span>
                  </template>
                </el-table-column>
                <el-table-column class-name="small-padding fixed-width" label="操作" align="center">
                  <template slot-scope="{row}">
                    <el-button v-permission="['P_SYSTEM_DICTIONARY_ONE']" type="primary" size="mini"
                               @click="preEdit(row)">
                      编辑
                    </el-button>
                    <el-button v-permission="['P_SYSTEM_DICTIONARY_DELETE']" size="mini" type="danger"
                               @click="handleDeleteOne(row)">
                      删除
                    </el-button>
                  </template>
                </el-table-column>
              </el-table>
            </el-tab-pane>
          </el-tabs>
        </div>

      </el-col>
    </el-row>

    <!--新增组件-->
    <create-form v-permission="['P_SYSTEM_DICTIONARY_ADD']" ref="createForm" :rowData='createRowData'
                 @loadData="loadData"></create-form>

    <!--编辑组件-->
    <edit-form v-permission="['P_SYSTEM_DICTIONARY_UPDATE']" ref="editForm" :rowData='editRowData'
               @loadData="loadData"></edit-form>

  </div>
</template>

<script>
    //分页组件
    import Pagination from '@/components/Pagination'
    //新增组件
    import createForm from './create'
    //编辑组件
    import editForm from './edit'
    //Dictionary page 接口
    import {DictionaryPageRequest} from '@/sdk/api/system/dictionary/page'
    //Dictionary delete 接口
    import {DictionaryDeleteRequest} from '@/sdk/api/system/dictionary/delete'
    //Dictionary list 接口
    import {DictionaryListRequest} from '@/sdk/api/system/dictionary/list'

    export default {
        name: 'Dictionary-Table',
        components: {Pagination, createForm, editForm},
        data() {
            return {
                tableKey: 'Dictionary',
                tableKey2: 'Dictionary-Values',
                tableData: null,
                total: 0,
                tableLoading: true,
                tableQuery: {
                    pageNum: 1,
                    pageSize: 10,
                    id: undefined,
                    dicName: undefined,
                    dicKey: undefined,
                    dicValue: undefined,
                    dicDesc: undefined,
                    status: undefined,
                    deleteFlag: undefined,
                    createTime: undefined,
                    updateTime: undefined,
                },
                selectedDicKey: undefined,
                deleteForm: {
                    id: undefined,
                    dicKey: undefined
                },
                dialogFormVisible: false,
                editRowData: {},
                createRowData: {},
                selectedDictionaryName: "",
                selectedDictionaryValues: []
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
                    let request = new DictionaryPageRequest();
                    request.setParams(this.tableQuery);
                    request.api().then(res => {
                        this.tableLoading = false
                        this.tableData = res['list']
                        this.total = res['total']
                        console.log("Dictionary tableData res:", res)
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
            async handleDeleteAll(row) {
                this.deleteForm.dicKey = row.dicKey
                this.deleteForm.id = undefined
                await this.handleDelete(this.deleteForm)
                this.rowSelected(row)
            },
            async handleDeleteOne(row) {
                this.deleteForm.dicKey = undefined
                this.deleteForm.id = row.id
                await this.handleDelete(this.deleteForm)
                this.rowSelected(row)
            },
            async handleDelete(params) {
                await this.$confirm('确认删除, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let request = new DictionaryDeleteRequest();
                    request.setParams(params).api().then(res => {
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消'
                    });
                });
            },
            rowSelected(row) {
                this.selectedDicKey = row.dicKey
                this.selectedDictionaryName = row.dicName
                let request = new DictionaryListRequest()
                request.setDicKey(this.selectedDicKey).api().then(res => {
                    this.selectedDictionaryValues = res;
                })
            }
        }
    }
</script>
