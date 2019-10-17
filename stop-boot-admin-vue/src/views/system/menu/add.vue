<template>

  <el-dialog
    title="新增"
    :visible.sync="dialogVisible"
    :before-close="handleClose"
  >
    <el-form
      label-position="right"
      label-width="auto"
      :model="msg"
      :rules="rules"
      ref='dialogCom'
    >
      <el-form-item
          v-for="(item,key) in dataFormat"
          :key="key"
          :label="item"
          :prop='item'
      >
        <el-input v-model="msg[item]" ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          @click="submitForm()"
        >提交</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>
<script>
import {MenuAddRequest, menuAdd} from '@/sdk/api/system/menu/add'
export default {
  name: "addDialog",
  //props: ["data", "dialogTitle", "vdata", "rules"], //接收父组件的传值
  data() {
    return {
      dialogVisible: false,
      msg: {
        pid: undefined,
        title: undefined,
        name: undefined,
        component: undefined,
        path: undefined,
        icon: undefined,
        type: undefined,
        hidden: undefined,
        sort: undefined
      },
      rules:{
        pid: [
          { required: true, message: '请输入', trigger: 'blur' },
        ],
        title: [
          { required: true, message: '请输入', trigger: 'blur' },
        ],
        name: [
          { required: true, message: '请输入', trigger: 'blur' },
        ],
        component: [
          { required: true, message: '请输入', trigger: 'blur' },
        ],
        path: [
          { required: true, message: '请输入', trigger: 'blur' },
        ],
        icon: [
          { required: true, message: '请输入', trigger: 'blur' },
        ],
        type: [
          { required: true, message: '请输入', trigger: 'blur' },
        ],
        hidden: [
          { required: true, message: '请输入', trigger: 'blur' },
        ],
        sort: [
          { required: true, message: '请输入', trigger: 'blur' },
        ]
      }
    }
  },
  computed:{
    dataFormat(){
      return Object.keys(this.msg)
    },
  },
  methods: {
    handleClose() {
      this.dialogVisible = false;
      this.$refs['dialogCom'].resetFields();
    },
    submitForm() {
      this.$refs['dialogCom'].validate((valid) => {
        if (valid) {
          let request = new MenuAddRequest()
          request.setPid(this.msg.pid)
          request.setTitle(this.msg.title)
          request.setName(this.msg.name)
          request.setComponent(this.msg.component)
          request.setPath(this.msg.path)
          request.setIcon(this.msg.icon)
          request.setType(this.msg.type)
          request.setHidden(this.msg.hidden)
          request.setSort(this.msg.sort)
          menuAdd(request).then(res => {
            if(res){
              this.$alert('新增成功','提示',{
                confirmButtonText: '确定',
                showClose:false,
                callback:action => {
                  this.$router.go(0)
                }
              })
            }
            
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm() {
        
    }
  },
  watch: {
  }
};
</script>
