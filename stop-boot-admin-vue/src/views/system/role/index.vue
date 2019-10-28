<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="listQuery.title" placeholder="名称" style="width: 200px;" class="filter-item"/>
      <el-input v-model="listQuery.title" placeholder="tag" style="width: 200px;" class="filter-item"/>
      <el-button class="filter-item" type="danger" icon="el-icon-close" size="small" round>清空</el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-search" size="small" round>
        搜索
      </el-button>
      <el-button class="filter-item" type="success" icon="el-icon-plus" @click="handleCreate" size="small" round>
        新增
      </el-button>
    </div>
    <el-row>
      <el-col :span="12">

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

      <el-col :span="12">
        <div style="margin-left: 20px;">
          <el-tabs type="border-card">
<!--            <el-tab-pane>-->
<!--              <span slot="label"><i class="el-icon-date"></i> 菜单分配</span>-->
<!--              <el-tree-->
<!--                :data="data"-->
<!--                default-expand-all-->
<!--                show-checkbox-->
<!--                node-key="id"-->
<!--                :default-expanded-keys="[2, 3]"-->
<!--                :default-checked-keys="[5]"-->
<!--                :props="defaultProps">-->
<!--              </el-tree>-->

<!--              <el-button class="filter-item" type="primary" icon="el-icon-edit" size="mini">保存</el-button>-->
<!--            </el-tab-pane>-->
            <el-tab-pane>
              <span slot="label"><i class="el-icon-date"></i> 菜单权限分配</span>
              <el-row>
                <el-col :span="8">
              <el-tree
                :data="menuTreeData"
                default-expand-all
                show-checkbox
                node-key="id"
                :default-expanded-keys="[1, 3]"
                :default-checked-keys="[5]"
                :props="defaultProps">
              </el-tree>
                </el-col>
                <el-col :span="16">
              <template>
                <el-transfer v-model="value"
                             :titles="['未分配权限', '已分配权限']"
                             :data="transferData"></el-transfer>
              </template>
                </el-col>
              </el-row>
              <el-button class="filter-item" type="primary" icon="el-icon-edit" size="mini">保存2</el-button>
            </el-tab-pane>
          </el-tabs>

        </div>
      </el-col>
    </el-row>


  </div>
</template>

<script>
    import {RolePageRequest, rolePage} from '@/sdk/api/role/page'
    import {menuList, MenuListRequest} from '@/sdk/api/system/menu/list'
    import {PermissionListRequest} from '@/sdk/api/system/permission/list'
    import Pagination from '@/components/Pagination' // secondary package based on el-pagination

    export default {
        name: 'RolePageTable',
        components: {Pagination},
        data() {
            const generateData = _ => {
                const data = [];
                for (let i = 1; i <= 5; i++) {
                    data.push({
                        key: i,
                        label: `备选项 ${ i }`,
                        disabled: i % 3 === 0
                    });
                }
                return data;
            };
            return {
                transferData: generateData(),
                value: [1, 4],
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
                menuTreeData: [],
                defaultProps: {
                    children: 'children',
                    label: 'title'
                },
            };
        },
        created() {
            this.getList()
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

                let request2 = new PermissionListRequest()
                request2.api().then(res => {
                    this.listLoading = false
                    console.log("res", res)
                    this.menuTreeData = res;
                })
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
            filterNode(value, data) {
                if (!value) return true;
                return data.label.indexOf(value) !== -1;
            }
        }
    }
</script>
