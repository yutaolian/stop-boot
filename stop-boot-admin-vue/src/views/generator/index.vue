<template>
  <div class="app-container">

    <el-tabs v-model="activeName">
      <el-tab-pane label="后代管理逻辑代码生成" name="first">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-divider>基础信息</el-divider>
          <el-row>
            <el-col :span="6">
              <el-form-item label="项目名称" prop="projectName">
                <el-input v-model="ruleForm.projectName"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="项目作者" prop="author">
                <el-input v-model="ruleForm.author"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="项目描述" prop="projectDesc">
                <el-input v-model="ruleForm.projectDesc"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="代码版本号" prop="version">
                <el-input v-model="ruleForm.version"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-divider>菜单信息</el-divider>
          <el-row>
            <el-col :span="12">
              <el-form-item label="菜单标题" prop="menuInfo.title">
                <el-input v-model="ruleForm.menuInfo.title"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="组件位置" prop="menuInfo.component">
                <el-input placeholder="组件位置" v-model="ruleForm.menuInfo.component">
                  <template slot="prepend">项目/src/</template>
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="模块名称" prop="menuInfo.name">
                <el-input v-model="ruleForm.menuInfo.name" placeholder=""></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="菜单path" prop="menuInfo.path">
                <el-input v-model="ruleForm.menuInfo.path" placeholder=""></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="菜单fullpath" prop="menuInfo.fullPath">
                <el-input v-model="ruleForm.menuInfo.fullPath" placeholder=""></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-divider>配置信息</el-divider>
          <el-row>
            <el-col :span="8">
              <el-form-item label="基础包名" prop="basePackage">
                <el-input v-model="ruleForm.basePackage" ></el-input>
              </el-form-item>
            </el-col>
             <el-col :span="12">
              <el-form-item label="controller">
                <el-input disabled placeholder="" :value="model('controller')">
                </el-input>
              </el-form-item>
            </el-col>
               </el-row>
                <el-row>

            <el-col :span="12">
              <el-form-item label="service">
                <el-input disabled :value="model('service')">
                </el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="model">
                <el-input disabled placeholder="" :value="model('model')">
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-divider>表信息</el-divider>
          <el-row>
            <el-col :span="6">
              <el-form-item label="选择表">
                <el-select v-model="ruleForm.selectedTableName" placeholder="请选择" @change="selectedTable">
                  <el-option
                    v-for="item in ruleForm.tableList"
                    :key="item.tableName"
                    :label="item.tableName"
                    :value="item.tableName">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="18">
              <el-form-item label="表信息">
                <el-input :value="handletableData(ruleForm.selectedTableName)"></el-input>
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
                prop="columnName"
                width="120">
              </el-table-column>
              <el-table-column
                label="字段类型"
                prop="dataType"
              >
              </el-table-column>
              <el-table-column
                label="注释"
                prop="columnComment"
              >
              </el-table-column>
              <el-table-column
                label="是否必填"
              >
                <template slot-scope="scope">
                  <el-switch v-model="scope.row.nullable" active-value='YES' inactive-value="NO" >
                  </el-switch>
                </template>
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
    import {TableColumnsRequest, tableColumns} from '@/sdk/api/generator/table/columns'
    export default {
      name:'abc',
        data() {
            return {
                activeName: 'first',
                ruleForm: {
                    author: '',
                    projectName: '',
                    projectDesc: '',
                    version: '',
                    menuInfo:{},
                    selectedTableName:''
                },
                tableData: [],
                selsct_switch:false,
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
                    this.ruleForm = {...this.ruleForm,res}
                })

                generatorTable().then(res => {
                    console.log("generatorTable res:", res)
                    this.ruleForm = {...this.ruleForm,tableList:res}
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
            },
            selectedTable(){
              let request = new TableColumnsRequest();
              request.setTableName(this.ruleForm.selectedTableName)
              tableColumns(request).then((res)=>{
                this.tableData = res
                console.log(res)
              })
            },
        },
        computed:{
          model(){
            return (type) =>{
              if(this.ruleForm.basePackage && this.ruleForm.menuInfo){
                return this.ruleForm.basePackage + `.${type}` + this.ruleForm.menuInfo.fullPath.replace(/\//g,'\.')
              }else{
                return ''
              }
            }
          },
          handletableData(){
            return (name) => {
              if(this.ruleForm.tableList){
                return JSON.stringify(this.ruleForm.tableList.filter((v)=>{
                    return v.tableName == name
                })) || ''
              }
            }
          },
        }
    }
</script>
<style>
</style>
