<template>
  <div class="app-container">
    <!--表格-->
    <el-table
      v-permission="['P_SYSTEM_MENU_PAGE']"
      :key="tableKey"
      row-key="id"
      v-loading="tableLoading"
      :data="tableData"
      border
      empty-text
      fit
      highlight-current-row
      style="width: 100%;"
      :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
      default-expand-all
    >
      <el-table-column label="标题" prop="title" align="center" width="200">
        <template slot-scope="scope">
          <span>{{ scope.row.title }}</span>
        </template>
      </el-table-column>
      <el-table-column label="类型" prop="type" align="center" width="100">
        <template slot-scope="scope">
          <el-link v-if="scope.row.type === 1" type="primary">菜单(内部)</el-link>
          <el-link v-if="scope.row.type === 2" type="warning">菜单(外部)</el-link>
          <el-link v-if="scope.row.type === 3" type="success">路由</el-link>
        </template>
      </el-table-column>
      <el-table-column label="名称" prop="name" align="center" width="100">
        <template slot-scope="scope">
          <span>{{ scope.row.name }}</span>
        </template>
      </el-table-column>
      <el-table-column label="组件位置" prop="component" align="center" width="240">
        <template slot-scope="scope">
          <span>{{ scope.row.component }}</span>
        </template>
      </el-table-column>
      <el-table-column label="path(路由)" prop="path" align="center" width="240">
        <template slot-scope="scope">
          <span>{{ scope.row.path }}</span>
        </template>
      </el-table-column>
      <el-table-column label="图标" prop="icon" align="center">
        <template slot-scope="scope">
          <i :class="scope.row.icon"></i>
        </template>
      </el-table-column>
      <el-table-column label="hidden" prop="hidden" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.hidden }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" prop="status" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.status }}</span>
        </template>
      </el-table-column>
      <el-table-column label="排序" prop="sort" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.sort }}</span>
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-dropdown @command='handledropdownCommand'>
            <el-button type="primary" size="small">
              更多<i class="el-icon-arrow-down el-icon--right"></i>
            </el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item v-permission="['P_SYSTEM_MENU_ADD']" :command='{type:"add",row:scope.row}'>新增
              </el-dropdown-item>
              <el-dropdown-item v-permission="['P_SYSTEM_MENU_UPDATE']" :command='{type:"edit",row:scope.row}'
                                v-if="scope.row.pid != 0">编辑
              </el-dropdown-item>
              <el-dropdown-item v-permission="['P_SYSTEM_MENU_DELETET']" v-if="scope.row.pid != 0">删除</el-dropdown-item>
              <el-dropdown-item
                v-if="scope.row.pid != 0 || scope.row.component !='Layout' || scope.row.component !='Empty'">
                <router-link :to="{ path: '/utils/generator', query: { menuId: scope.row.id}}">生成代码</router-link>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </template>
      </el-table-column>
    </el-table>

    <!--新增组件-->
    <create-form v-permission="['P_SYSTEM_MENU_ADD']" ref="createForm" :rowData='createRowData'
                 @loadData="loadData"></create-form>

    <!--编辑组件-->
    <edit-form v-permission="['P_SYSTEM_MENU_UPDATE']" ref="editForm" :rowData='editRowData'
               @loadData="loadData"></edit-form>

  </div>
</template>

<script>
    //新增组件
    import createForm from './create'
    //编辑组件
    import editForm from './edit'
    //Menu page 接口
    import {MenuListRequest} from '@/sdk/api/system/menu/list'
    //Menu delete 接口
    import {MenuDeleteRequest} from '@/sdk/api/system/menu/delete'

    export default {
        name: 'Menu-Table',
        components: {createForm, editForm},
        data() {
            return {
                tableKey: 'Menu',
                tableData: null,
                total: 0,
                tableLoading: true,
                tableQuery: {
                    id: undefined,
                    pid: undefined,
                    title: undefined,
                    name: undefined,
                    component: undefined,
                    path: undefined,
                    icon: undefined,
                    type: undefined,
                    link: undefined,
                    code: undefined,
                    hidden: undefined,
                    status: undefined,
                    sort: undefined,
                    deleteFlag: undefined,
                    opUserId: undefined,
                    createTime: undefined,
                    updateTime: undefined,
                },
                dialogFormVisible: false,
                editRowData: {},
                createRowData: {}
            }
        },
        filters: {},
        created() {
            this.loadData()
        },
        computed: {
            istype() {
                return (type) => {
                    return type ? '隐藏' : '显示'
                }
            }
        },
        methods: {
            loadData() {
                this.$nextTick(() => {
                    this.tableLoading = true
                    let request = new MenuListRequest();
                    request.setParams(this.tableQuery);
                    request.api().then(res => {
                        this.tableLoading = false
                        this.tableData = res
                        console.log("Menu tableData res:", res)
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
                this.createRowData = Object.assign({}, row)
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
                    let request = new MenuDeleteRequest();
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
            },
            addNode(row) {
                this.$refs.createForm.dialogFormVisible = true;
                this.createRowData = row;
            },
            editNode(row) {
                this.$refs.editForm.dialogFormVisible = true;
                this.editRowData = row;
            },
            handledropdownCommand(data) {
                if (!data) return;
                let {type, row} = data;
                switch (type) {
                    case 'add':
                        this.preCreate(row)
                        break;
                    case 'edit':
                        this.preEdit(row)
                        break;
                    default:
                        break;
                }
            },
        }
    }
</script>
