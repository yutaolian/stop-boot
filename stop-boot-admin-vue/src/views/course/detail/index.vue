<template>
  <div class="app-container">
    <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="70px"
             style="width: 400px; margin-left:50px;">
      <el-form-item label="Type" prop="type">
        <el-select v-model="temp.type" class="filter-item" placeholder="Please select">
          <el-option v-for="item in calendarTypeOptions" :key="item.key" :label="item.display_name"
                     :value="item.key"/>
        </el-select>
      </el-form-item>
      <el-form-item label="Type" prop="type">
        <el-radio-group v-model="temp.radio2">
          <el-radio :label="3">备选项</el-radio>
          <el-radio :label="6">备选项</el-radio>
          <el-radio :label="9">备选项</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="Date" prop="timestamp">
        <el-date-picker type="datetime" v-model="temp.timestamp" placeholder="Please pick a date"/>
      </el-form-item>
      <el-form-item label="Title" prop="title">
        <el-input v-model="temp.title"/>
      </el-form-item>
      <!--      <el-form-item label="Status">-->
      <!--        <el-select v-model="temp.status" class="filter-item" placeholder="Please select">-->
      <!--          <el-option v-for="item in statusOptions" :key="item" :label="item" :value="item"/>-->
      <!--        </el-select>-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="Imp">-->
      <!--        <el-rate v-model="temp.importance" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" :max="3"-->
      <!--                 style="margin-top:8px;"/>-->
      <!--      </el-form-item>-->
      <el-form-item label="Remark" prop="remark">
        <el-input v-model="temp.remark" :autosize="{ minRows: 2, maxRows: 4}" type="textarea"
                  placeholder="Please input"/>
      </el-form-item>

      <el-form-item label="城市" prop="city">
        <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
        <div style="margin: 15px 0;"></div>
        <el-checkbox-group v-model="checkedCities" @change="handleCheckedCitiesChange">
          <el-checkbox v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button>
        Cancel
      </el-button>
      <el-button type="primary" @click="dialogStatus==='create'?createData():updateData()">
        Confirm
      </el-button>
    </div>
  </div>
</template>

<script>
    const cityOptions = ['上海', '北京', '广州', '深圳'];
    const calendarTypeOptions = [
        {key: 'CN', display_name: 'China'},
        {key: 'US', display_name: 'USA'},
        {key: 'JP', display_name: 'Japan'},
        {key: 'EU', display_name: 'Eurozone'}
    ]
    export default {
        name: 'HelloWorld',
        data() {
            return {
                temp: {
                    id: undefined,
                    importance: 1,
                    remark: '',
                    timestamp: new Date(),
                    title: '',
                    type: '',
                    status: 'published',
                    radio2: 3
                },
                checkAll: false,
                checkedCities: ['上海', '北京'],
                cities: cityOptions,
                isIndeterminate: true,
                calendarTypeOptions,
                msg: 'Welcome to Your Vue.js App',
                rules: {
                    type: [{required: true, message: 'type is required', trigger: 'change'}],
                    timestamp: [{type: 'date', required: true, message: 'timestamp is required', trigger: 'change'}],
                    title: [{required: true, message: 'title is required', trigger: 'blur'}]
                }
            }
        },
        mounted() {
            console.log(this.$router)
        },
        methods: {
            handleCheckAllChange(val) {
                this.checkedCities = val ? cityOptions : [];
                this.isIndeterminate = false;
            },
            handleCheckedCitiesChange(value) {
                let checkedCount = value.length;
                this.checkAll = checkedCount === this.cities.length;
                this.isIndeterminate = checkedCount > 0 && checkedCount < this.cities.length;
            },
            goBack() {
                console.log('go back');
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
