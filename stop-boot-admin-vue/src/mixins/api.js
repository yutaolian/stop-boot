import {MessageBox, Message} from 'element-ui'
import {DictionaryListRequest} from '@/sdk/api/system/dictionary/list'

export default {
  data() {
    return {
      tableData: [],
      total: 0,
      loading: true,
      pageNum: 1,
      pageSize: 10,
      dictValueList: []
    }
  },
  methods: {
    //分页数据
    page(request) {
      return new Promise((resolve, reject) => {
        this.loading = true
        request.setPageNum(this.pageNum).setPageSize(this.pageSize)
          .api().then(res => {
          this.tableData = res['list']
          this.total = res['total']
          this.loading = false
          // resolve(res)
        }, error => {
          console.error(request, ' page error:', error)
        })
      })
    },
    // pageQuery(request) {
    //   return new Promise((resolve, reject) => {
    //     this.loading = true
    //     this.pageNum = 1
    //     request.setPageNum(this.pageNum).setPageSize(this.pageSize)
    //       .api().then(res => {
    //       this.tableData = res['list']
    //       this.total = res['total']
    //       this.loading = false
    //       // resolve(res)
    //     }, error => {
    //       console.error(request, ' page error:', error)
    //     })
    //   })
    // },
    //列表数据
    list(request) {
      return new Promise((resolve, reject) => {
        this.loading = true
        request.api().then(res => {
          this.tableData = res
          this.loading = false
          // resolve(res)
        }, error => {
          console.error(request, ' list error:', error)
        })
      })
    },
    //添加
    add(request) {
      return handler(request, '添加')
    },
    //修改
    update(request) {
      return handler(request, '修改')
    },
    //删除
    delete(request) {
      return handler(request, '删除')
    },
    dict(dictKey) {
      if (dictKey) {
        let request = new DictionaryListRequest()
        request.setDicKey(dictKey).api().then(res => {
          this.dictValueList = res
        })
      }
    }
  }
};

function handler(request, tag) {
  return new Promise((resolve, reject) => {
    MessageBox.confirm('确认' + tag + ', 是否继续?', '提示', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    }).then(() => {
      request.api().then(res => {
        Message.success({
          type: 'success',
          message: tag + '成功!'
        });
        resolve(res)
      }, error => {
        console.error(request, tag + ' error:', error)
      })
    }).catch(() => {
      Message.info({
        type: 'info',
        message: '已取消'
      });
    });
  })
}
