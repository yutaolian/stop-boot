<template>
  <div class="app-container">
    <!--分页过滤条件-->
    <div class="filter-container">
      <el-form ref="filterForm" :model="pageQuery">
        <el-row>
          <el-col :span="4">
            <el-form-item prop="name" label="名称">
              <el-input v-model="pageQuery.name" placeholder="名称" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="age" label="年龄">
              <el-input v-model="pageQuery.age" placeholder="年龄" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="age" label="年龄">
              <el-input v-model="pageQuery.age" placeholder="年龄" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="age" label="年龄">
              <el-input v-model="pageQuery.age" placeholder="年龄" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item prop="age" label="年龄">
              <el-input v-model="pageQuery.age" placeholder="年龄" style="width: 180px;" class="filter-item"
                        @keyup.enter.native="handleFilter"/>
            </el-form-item>
          </el-col>
          <!--@click="cleanFilter"-->
          <el-col :span="4">
            <el-form-item label="">
              <el-button class="filter-item" type="danger" icon="el-icon-close" @click="cleanFilter" circle/>
              <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter" circle/>
              <el-button class="filter-item" type="success" icon="el-icon-plus" @click="preCreate" circle/>

              user permission : {{this.$route.meta.permission}}
              <span v-permission="['test22_ADD']">permission : test22_ADD</span>
              <span v-permission="['TEST_ADD1']">permission : TEST_ADD1</span>
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

      <el-table-column label="ID" prop="id" sortable="custom" align="center" width="80">
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
      <el-table-column label="名称" width="100px" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.name}}</span>
        </template>
      </el-table-column>
      <el-table-column label="年龄" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.age}}</span>
        </template>
      </el-table-column>
      <el-table-column label="生日" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.birthday}}</span>
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
    import {TestPageRequest} from '@/sdk/api/test/test11/page'


    export default {
        name: 'Test22PageTable',
        components: {Pagination, createForm, editForm},
        data() {
            return {
                tableKey: 0,
                pageData: null,
                total: 0,
                pageLoading: true,
                pageQuery: {
                    pageNum: 1,
                    pageSize: 10,
                    name: undefined,
                    age: undefined,
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
                let request = new TestPageRequest();
                request.setParams(this.pageQuery);
                request.api().then(res => {
                    this.pageLoading = false
                    this.pageData = res['list']
                    this.total = res['total']
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
                console.log("this.$router:",this.$route)
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
