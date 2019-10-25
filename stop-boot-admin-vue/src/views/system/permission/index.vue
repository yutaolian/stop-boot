<template>
  <div class="app-container">
    <el-table
      :data="tableData"
      style="width: 100%;margin-bottom: 20px;"
      row-key="id"
      border
      default-expand-all
      :tree-props="{children: 'children'}">

      <el-table-column label="ID" prop="id" align="center" width="80">
        <template slot-scope="scope">
          <span>{{ scope.row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column label="菜单标题" prop="title">
        <template slot-scope="scope">
          <span>{{ scope.row.title }}</span>
        </template>
      </el-table-column>

      <el-table-column label="菜单组件" prop="component">
        <template slot-scope="scope">
          <span>{{ scope.row.component }}</span>
        </template>
      </el-table-column>

      <el-table-column label="按钮权限tagName" prop="tags">
        <template slot-scope="scope"
                  v-if="scope.row.pid != 0 && scope.row.component != 'Layout' && scope.row.component != 'Empty'">
          <el-tag
            :key="scope.row.id+tag"
            v-for="tag in dynamicTags"
            closable
            :disable-transitions="false"
            @close="handleClose(tag)">
            {{tag}}
          </el-tag>
          <el-input
            class="input-new-tag"
            v-if="inputVisible"
            v-model="inputValue"
            ref="saveTagInput"
            size="small"
            @keyup.enter.native="handleInputConfirm"
            @blur="handleInputConfirm"
          >
          </el-input>
          <el-button v-else class="button-new-tag" size="small" @click="showInput">添加</el-button>
        </template>
      </el-table-column>

      <!--      <el-table-column label="操作" prop="sort" align="center">-->
      <!--        <template slot-scope="scope">-->
      <!--          <el-button v-waves class="filter-item" type="success" icon="el-icon-plus" size="mini" round>新增</el-button>-->
      <!--        </template>-->
      <!--      </el-table-column>-->
    </el-table>
  </div>
</template>


<style>
  .el-tag + .el-tag {
    margin-left: 10px;
  }
  .button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
  }
  .input-new-tag {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;
  }
</style>

<script>
    import {menuList, MenuListRequest} from '@/sdk/api/system/menu/list'

    export default {
        name: 'MenuList',
        data() {
            return {
                tableKey: 0,
                list: null,
                listLoading: true,
                tableData: null,
                dynamicTags: ['标签一', '标签二', '标签三'],
                inputVisible: false,
                inputValue: ''
            }
        },
        created() {
            this.loadData()
        },
        methods: {
            loadData() {
                this.listLoading = true
                var request = new MenuListRequest()
                request.setUserId(7919)
                menuList(request).then(res => {
                    this.listLoading = false
                    console.log("res", res)
                    this.tableData = res;
                })
            },

            handleClose(tag) {
                this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
            },

            showInput() {
                this.inputVisible = true;
                this.$nextTick(_ => {
                    this.$refs.saveTagInput.$refs.input.focus();
                });
            },

            handleInputConfirm() {
                let inputValue = this.inputValue;
                if (inputValue) {
                    this.dynamicTags.push(inputValue);
                }
                this.inputVisible = false;
                this.inputValue = '';
            }
        }
    }
</script>
