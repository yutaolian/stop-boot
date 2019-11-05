<template>
  <div class="app-container">

    <el-tabs v-model="activeName">
      <el-tab-pane label="后代管理逻辑代码生成" name="first">
        <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-divider>菜单信息</el-divider>
          <el-row>
            <el-col :span="12">
              <el-form-item label="菜单标题" prop="menuInfo.title">
                <el-input disabled v-model="ruleForm.menuInfo.title"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="组件位置" prop="menuInfo.component">
                <el-input disabled placeholder="组件位置" v-model="ruleForm.menuInfo.component">
                  <template slot="prepend">项目/src/</template>
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="模块名称" prop="menuInfo.name">
                <el-input disabled v-model="ruleForm.menuInfo.name" placeholder=""></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="菜单path" prop="menuInfo.path">
                <el-input disabled v-model="ruleForm.menuInfo.path" placeholder=""></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="菜单fullpath" prop="menuInfo.fullPath">
                <el-input disabled v-model="ruleForm.menuInfo.fullPath" placeholder=""></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-divider>基础信息</el-divider>
          <el-row>
            <el-col :span="8">
              <el-form-item label="项目名称" prop="projectName">
                <el-input v-model="ruleForm.projectName"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="项目作者" prop="author">
                <el-input v-model="ruleForm.author"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="8">
              <el-form-item label="代码版本号" prop="version">
                <el-input v-model="ruleForm.version"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="项目描述" prop="projectDesc">
                <el-input type="textarea" v-model="ruleForm.projectDesc"></el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-divider>配置信息</el-divider>
          <el-row>
            <el-col :span="12">
              <el-form-item label="基础包名" prop="basePackage">
                <el-input v-model="ruleForm.basePackage"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="controller">
                <el-input disabled placeholder="" :value="model('controller')">
                </el-input>
              </el-form-item>
            </el-col>

            <el-col :span="12">
              <el-form-item label="service">
                <el-input disabled :value="model('service')">
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="model">
                <el-input disabled placeholder="" :value="model('model')">
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="Entity包路径" prop="entityPackage">
                <el-input prop="entityMapperPackage" v-model="ruleForm.entityPackage">
                </el-input>
              </el-form-item>
            </el-col>

            <el-col :span="12">
              <el-form-item label="Example包路径" prop="entityExamplePackage">
                <el-input placeholder="" v-model="ruleForm.entityExamplePackage">
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="Mapper包路径" prop="entityMapperPackage">
                <el-input placeholder="" v-model="ruleForm.entityMapperPackage">
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="admin代码路径" prop="adminPath">
                <el-input placeholder="" v-model="ruleForm.adminPath">
                </el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="sdk路径" prop="sdkPath">
                <el-input prop="entityMapperPackage" v-model="ruleForm.sdkPath">
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="vue路径" prop="viewPath">
                <el-input placeholder="" v-model="ruleForm.viewPath">
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="12">
              <el-form-item label="功能类型" prop="viewPath1">
                <template>
                  <el-checkbox :indeterminate="isIndeterminate" v-model="checkAllFunction"
                               @change="handleCheckAllChange">全选
                  </el-checkbox>
                  <div style="margin: 15px 0;"></div>
                  <el-checkbox-group v-model="checkedFunctionOptions" @change="handleCheckedCitiesChange">
                    <el-checkbox v-for="type in ruleForm.functionTypes" :label="type" :key="type">{{type}}</el-checkbox>
                  </el-checkbox-group>
                </template>
              </el-form-item>
            </el-col>

            <el-col :span="12">
              <el-form-item label="业务类型" prop="viewPath1">
                <template>
                  <!-- <el-checkbox :indeterminate="isIndeterminate" v-model="checkAllBiz" @change="handleCheckAllChange">全选
                  </el-checkbox>
                  <div style="margin: 15px 0;"></div>
                  <el-checkbox-group v-model="checkedBizOptions" @change="handleCheckedCitiesChange">
                    <el-checkbox v-for="type in ruleForm.bizTypes" :label="type" :key="type">{{type}}</el-checkbox>
                  </el-checkbox-group> -->
                </template>
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
              :data="ruleForm.tableColumnsData"
              tooltip-effect="dark"
              style="width: 100%"
              border
              @selection-change="handleSelectionChange">
              <el-table-column
                type="selection"
                width="55">
              </el-table-column>

              <el-table-column
                fixed
                label="表字段名"
                prop="columnName"
                width="100">
              </el-table-column>

              <el-table-column
                fixed
                label="字段类型"
                prop="dataType"
                width="100"
              >
              </el-table-column>
              <el-table-column
                fixed
                label="注释"
                prop="columnComment"
                width="150"
              >
              </el-table-column>

              <el-table-column
                label="字段名称(英)"
                prop="camelColumnName"
                width="150"
              >
                <template slot-scope="scope">
                  <el-input v-model="scope.row.camelColumnName"></el-input>
                </template>
              </el-table-column>

              <el-table-column
                label="字段名称(汉字)"
                prop="camelColumnName"
                width="150"
              >
                <template slot-scope="scope">
                  <el-input v-model="scope.row.columnComment"></el-input>
                </template>
              </el-table-column>

              <el-table-column
                label="必填"
                prop="nullable"
                width="70"
              >
                <template slot-scope="scope">
                  <el-switch v-model="scope.row.nullable" active-value='NO' inactive-value="YES">
                  </el-switch>
                </template>
              </el-table-column>
              <el-table-column
                label="列表显示"
                prop="pageShow"
                width="70"
              >
                <template slot-scope="scope">
                  <el-switch v-model="scope.row.pageShow">
                  </el-switch>
                </template>
              </el-table-column>
              <el-table-column
                label="搜索显示"
                prop="searchShow"
                width="70"
              >
                <template slot-scope="scope">
                  <el-switch v-model="scope.row.searchShow" active-value=true inactive-value=false>
                  </el-switch>
                </template>
              </el-table-column>
              <el-table-column
                label="创建显示"
                prop="createShow"
                width="70"
              >
                <template slot-scope="scope">
                  <el-switch v-model="scope.row.createShow" active-value=true inactive-value=false>
                  </el-switch>
                </template>
              </el-table-column>
              <el-table-column
                label="编辑显示"
                prop="editShow"
                width="70"
              >
                <template slot-scope="scope">
                  <el-switch v-model="scope.row.editShow" :active-value='true' :inactive-value='false'>
                  </el-switch>
                </template>
              </el-table-column>

              <el-table-column
                label="组件类型"
                prop="editShow"
                min-width="150"
              >
                <template slot-scope="scope">
                  <el-select v-model="scope.row.selectedComponent" placeholder="请选择使用的组件">
                    <el-option
                      v-for="item in componentOptions"
                      :key="item.value+scope.row.camelColumnName"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </template>
              </el-table-column>
              <el-table-column
                label="字典表key"
                prop="editShow"
                min-width="150"
              >
                <template slot-scope="scope">
                  <el-select v-model="selectedDictionary" placeholder="请选择字典key">
                    <el-option
                      v-for="item in dictionaryOptions"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </template>
              </el-table-column>


            </el-table>
          </el-row>


          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>

      </el-tab-pane>
      <el-tab-pane label="多语言SDK代码生成" name="second">
        <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-divider>基本信息</el-divider>
          <el-row>
            <el-col :span="12">
              <el-form-item label="全部控制器" prop="menuInfo.title">
                <el-select v-model="ruleForm.region" placeholder="请选择活动区域">
                  <el-option label="区域一" value="shanghai"></el-option>
                  <el-option label="区域二" value="beijing"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <!--                <el-form-item label="组件位置" prop="menuInfo.component">-->
              <!--                  <el-input disabled placeholder="组件位置" v-model="ruleForm.menuInfo.component">-->
              <!--                    <template slot="prepend">项目/src/</template>-->
              <!--                  </el-input>-->
              <!--                </el-form-item>-->
            </el-col>
          </el-row>
          <!--            <el-row>-->
          <!--              <el-col :span="8">-->
          <!--                <el-form-item label="模块名称" prop="menuInfo.name">-->
          <!--                  <el-input disabled v-model="ruleForm.menuInfo.name" placeholder=""></el-input>-->
          <!--                </el-form-item>-->
          <!--              </el-col>-->
          <!--              <el-col :span="8">-->
          <!--                <el-form-item label="菜单path" prop="menuInfo.path">-->
          <!--                  <el-input disabled v-model="ruleForm.menuInfo.path" placeholder=""></el-input>-->
          <!--                </el-form-item>-->
          <!--              </el-col>-->
          <!--              <el-col :span="8">-->
          <!--                <el-form-item label="菜单fullpath" prop="menuInfo.fullPath">-->
          <!--                  <el-input disabled v-model="ruleForm.menuInfo.fullPath" placeholder=""></el-input>-->
          <!--                </el-form-item>-->
          <!--              </el-col>-->
          <!--            </el-row>-->
        </el-form>
      </el-tab-pane>
    </el-tabs>


  </div>
</template>
<script>
    import {GeneratorPreRequest} from '@/sdk/api/generator/pre'
    import {generatorTable} from '@/sdk/api/generator/table/list'
    import {TableColumnsRequest, tableColumns} from '@/sdk/api/generator/table/columns'
    import {GeneratorSubmitRequest} from '@/sdk/api/generator/submit'

    const functionOptionsData = ['page', 'list', 'one', 'add', 'update', 'delete'];
    const bizOptionsData = ['admin', 'js', 'vue'];
    export default {
        name: 'abc',
        watch() {
            // typeSelect(){
            //     this.checkedFunctionOptions = this.ruleForm.functionTypes;
            //     this.checkedBizOptions = this.ruleForm.bizTypes;
            // }
        },
        data() {
            return {
                ruleForm: {
                    author: '',
                    projectName: '',
                    projectDesc: '',
                    version: '',
                    entityPackage: '',
                    entityExamplePackage: '',
                    entityMapperPackage: '',
                    menuInfo: {},
                    selectedTableName: '',
                    tableColumnsData: [],
                    functionTypes: [],
                    bizTypes: [],
                },
                activeName: 'first',
                checkAllFunction: true,//全选状态
                checkAllBiz: true,
                isIndeterminate: false,//
                checkedFunctionOptions: [],
                checkedBizOptions: [],
                multipleSelection: [],
                componentOptions: [{
                    value: '1',
                    label: 'Radio 单选框'
                }, {
                    value: '2',
                    label: 'Checkbox 多选框'
                }, {
                    value: '3',
                    label: 'Input 输入框'
                }, {
                    value: '4',
                    label: 'Select 选择器'
                }, {
                    value: '5',
                    label: 'Switch 开关'
                }],
                selectedComponent: '',
                dictionaryOptions: [{
                    value: '1',
                    label: '性别'
                }, {
                    value: '2',
                    label: '时间段'
                }, {
                    value: '3',
                    label: '状态'
                }],
                selectedDictionary: ''
            };
        },
        created() {
            this.init();
        },
        methods: {
            init() {
                let menuId = this.$route.query.menuId;
                let request = new GeneratorPreRequest();
                request.setMenuId(menuId).api().then(res => {
                    console.log("generatorPre res:", res)
                    this.ruleForm = res
                    this.checkedFunctionOptions = this.ruleForm.functionTypes;//默认全选数据
                })
            },
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!');
                        let request = new GeneratorSubmitRequest();
                        request.setParams(this.ruleForm).api().then(res => {
                            console.log("GeneratorSubmitRequest res", res)
                        })
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
            selectedTable() {
                let request = new TableColumnsRequest();
                request.setTableName(this.ruleForm.selectedTableName)
                tableColumns(request).then((res) => {
                    this.$set(this.ruleForm, 'tableColumnsData', res)
                    console.log(res)
                    // this.checked()
                })
            },
            checked() {
                //首先el-table添加ref="table"引用标识
                for (let i = 0; i < this.ruleForm.tableColumnsData.length; i++) {
                    this.$refs.table.toggleRowSelection(this.ruleForm.tableColumnsData[i], true);
                }
            },
            handleCheckAllChange(val) {
                this.checkedFunctionOptions = val ? this.ruleForm.functionTypes : [];
                this.isIndeterminate = false;
            },
            handleCheckedCitiesChange(value) {
                let checkedCount = value.length;
                let functionTypes = this.ruleForm.functionTypes
                this.checkAllFunction = checkedCount === functionTypes.length;
                this.isIndeterminate = checkedCount > 0 && checkedCount < functionTypes.length;
            }
        },
        computed: {
            model() {
                return (type) => {
                    if (this.ruleForm.basePackage && this.ruleForm.menuInfo) {
                        return this.ruleForm.basePackage + `.${type}` + this.ruleForm.menuInfo.fullPath.replace(/\//g, '\.')
                    } else {
                        return ''
                    }
                }
            },
            handletableData() {
                return (name) => {
                    if (this.ruleForm.tableList) {
                        return JSON.stringify(Object.values(this.ruleForm.tableList.filter((v) => {
                            return v.tableName == name
                        }))) || ''
                    }
                }
            },
        }
    }
</script>
<style>
</style>
