<template>
  <div class="app-container">

    <el-tabs v-model="activeName">
      <el-tab-pane label="后代管理逻辑代码生成" name="first">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-divider>基础信息</el-divider>
          <el-row>
            <el-col :span="6">
              <el-form-item label="项目名称" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="项目作者" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="项目描述" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="代码版本号" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-divider>菜单信息</el-divider>
          <el-row>
            <el-col :span="12">
              <el-form-item label="模块名称" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="组件位置" prop="name">
                <el-input placeholder="组件位置" v-model="ruleForm.name">
                  <template slot="prepend">项目/src/</template>
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="menu name" prop="name">
                <el-input v-model="ruleForm.name" placeholder="来源于menu"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="menu path" prop="name">
                <el-input v-model="ruleForm.name" placeholder="来源于menu"></el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="8">
              <el-form-item label="后端包名" prop="name">
                <el-input v-model="ruleForm.name" placeholder="com.xxx.yyy"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="controller" prop="name">
                <el-input placeholder="com.xxx.yyy.controller" v-model="ruleForm.name">
                </el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="service" prop="name">
                <el-input placeholder="com.xxx.yyy.service" v-model="ruleForm.name">
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-divider>表信息</el-divider>
          <el-row>
            <el-col :span="6">

              <el-form-item label="选择表" prop="region">
                <el-select v-model="ruleForm.region" placeholder="请选择活动区域">
                  <el-option label="区域一" value="shanghai"></el-option>
                  <el-option label="区域二" value="beijing"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="18">
              <el-form-item label="表信息" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-table
              ref="multipleTable"
              :data="tableData"
              tooltip-effect="dark"
              style="width: 100%"
              border
              @selection-change="handleSelectionChange">
              <el-table-column
                type="selection"
                width="55">
              </el-table-column>

              <el-table-column
                label="字段名"
                width="120">
              </el-table-column>
              <el-table-column
                label="字段类型"
              >
              </el-table-column>
              <el-table-column
                label="地址"
              >
              </el-table-column>
              <el-table-column
                label="地址"
              >
              </el-table-column>
              <el-table-column
                label="地址"
              >
              </el-table-column>

              <el-table-column
                label="地址"
              >
              </el-table-column>
              <el-table-column
                label="地址"
              >
              </el-table-column>
              <el-table-column
                label="地址"
              >
              </el-table-column>
              <!--          <el-table-column-->
              <!--            label="地址"-->
              <!--          >-->
              <!--            <template  scope="scope">-->
              <!--              <el-input v-model="input" placeholder="请输入内容"></el-input>-->
              <!--            </template>-->
              <!--          </el-table-column>-->
              <!--          <el-table-column-->
              <!--            label="地址"-->
              <!--          >-->
              <!--            <template scope="scope">-->
              <!--              <el-button size="small" type="success" @click="handleUpdate(scope.row)">修改-->
              <!--              </el-button>-->
              <!--            </template>-->
              <!--          </el-table-column>-->
            </el-table>
          </el-row>


          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>

      </el-tab-pane>
      <el-tab-pane label="多语言SDK代码生成" name="second">

        多语言SDK代码生成 待开发。。。。。
      </el-tab-pane>
    </el-tabs>


  </div>
</template>
<script>
    import {GeneratorPreRequest, generatorPre} from '@/sdk/api/generator/pre'
    import {generatorTable} from '@/sdk/api/generator/table/list'

    export default {
        data() {
            return {
                activeName: 'first',
                ruleForm: {
                    name: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                }, tableData: [{
                    date: '2016-05-03',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    date: '2016-05-02',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }],
                multipleSelection: [],
                rules: {
                    name: [
                        {required: true, message: '请输入活动名称', trigger: 'blur'},
                        {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                    ],
                    region: [
                        {required: true, message: '请选择活动区域', trigger: 'change'}
                    ],
                    date1: [
                        {type: 'date', required: true, message: '请选择日期', trigger: 'change'}
                    ],
                    date2: [
                        {type: 'date', required: true, message: '请选择时间', trigger: 'change'}
                    ],
                    type: [
                        {type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change'}
                    ],
                    resource: [
                        {required: true, message: '请选择活动资源', trigger: 'change'}
                    ],
                    desc: [
                        {required: true, message: '请填写活动形式', trigger: 'blur'}
                    ]
                },

            };
        },
        created() {
            this.init();
        },
        methods: {
            init() {
                let menuId = this.$route.query.menuId;
                let request = new GeneratorPreRequest();
                request.setMenuId(menuId);
                generatorPre(request).then(res => {
                    console.log("generatorPre res:", res)
                })

                generatorTable().then(res => {
                    console.log("generatorTable res:", res)
                })


            },
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            toggleSelection(rows) {
                if (rows) {
                    rows.forEach(row => {
                        this.$refs.multipleTable.toggleRowSelection(row);
                    });
                } else {
                    this.$refs.multipleTable.clearSelection();
                }
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            }
        }
    }
</script>
<style>
</style>
