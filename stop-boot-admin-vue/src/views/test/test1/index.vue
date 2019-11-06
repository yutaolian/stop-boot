<template>
  <div class="app-container">
    <!--分页过滤条件-->
    <div class="filter-container">
      <el-form ref="filterForm" :model="tableQuery">
        <el-row>
          <el-col :span="4">
            <el-form-item prop="id" label="id">
              <el-input v-model="tableQuery.id" placeholder="id" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="name" label="name">
              <el-input v-model="tableQuery.name" placeholder="name" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="age" label="age">
              <el-input v-model="tableQuery.age" placeholder="age" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="birthday" label="birthday">
<!--              <el-input v-model="tableQuery.birthday" placeholder="birthday" style="width: 180px;" class="filter-item"-->
<!--                        @keyup.enter.native="handleFilter"/>-->

<!--              <el-radio-group v-model="tableQuery.birthday">-->
<!--                <el-radio v-for="item in this.dictValueList" :label="item.dicValue">{{item.dicDesc}}</el-radio>-->
<!--              </el-radio-group>-->
----
              <el-checkbox-group v-model="options"  @change="handleCheckedChange">
                <el-checkbox  v-for="item in this.dictValueMap.sex" :label="item.dicValue" :key="item.id">{{item.dicDesc}}</el-checkbox>
              </el-checkbox-group>

              
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="status" label="status">
<!--              <el-select v-model="value" placeholder="请选择">-->
<!--                <el-option-->
<!--                  v-for="item in this.dictValueList"-->
<!--                  :key="item.id"-->
<!--                  :label="item.dicDesc"-->
<!--                  :value="item.dicValue">-->
<!--                </el-option>-->
<!--              </el-select>-->
            </el-form-item>
          </el-col>
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
      v-loading="tableLoading"
      :data="tableData"
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
          <el-button size="mini" type="danger" @click="handleDelete(row)">
            Delete
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--分页组件-->
    <pagination v-show="total>0" :total="total" :page.sync="tableQuery.pageNum" :limit.sync="tableQuery.pageSize"
                @pagination="loadData"/>

    <!--新增组件-->
    <create-form ref="createForm" :rowData='createRowData' @loadData="loadData"></create-form>

    <!--编辑组件-->
    <edit-form ref="editForm" :rowData='editRowData' @loadData="loadData"></edit-form>

  </div>
</template>

<script>
    //分页组件
    import Pagination from '@/components/Pagination'
    //新增组件
    import createForm from './create'
    //编辑组件
    import editForm from './edit'
    //Test1 page 接口
    import {Test1PageRequest} from '@/sdk/api/test/test1/page'
    //Test1 delete 接口
    import {Test1DeleteRequest} from '@/sdk/api/test/test1/delete'

    import dict from '@/mixins/dict'

    export default {
        name: 'Test1-Table',
        mixins: [dict],
        components: {Pagination, createForm, editForm},
        data() {
            return {
                tableKey: 'Test1',
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
                    createTime: undefined,
                    info: undefined,
                    status: undefined,
                    headImg: undefined,
                    deleteFlag: undefined,
                    updateTime: undefined,
                },
                dialogFormVisible: false,
                editRowData: {},
                createRowData: {},
                options: [],
                value: ''
            }
        },
        filters: {},
        created() {
            this.loadData()
        },
        methods: {
          handleCheckedChange(val){
            console.log(val)
          },
          loadData() {
              this.$nextTick(() => {
                  this.tableLoading = true
                  let request = new Test1PageRequest();
                  request.setParams(this.tableQuery);
                  request.api().then(res => {
                      this.tableLoading = false
                      this.tableData = res['list']
                      this.total = res['total']
                      console.log("Test1 tableData res:", res)
                  })
                  this.loadDictValue('sex')
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
                    let request = new Test1DeleteRequest();
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
