import {api} from '@/sdk/api/httpConfig'

export class TestPageRequest {
  constructor() {
    this.data = {
      userId: undefined,
      pageSize: undefined,
      pageNum: undefined
    }
  }

  setUserId(userId) {
    this.data.userId = userId
  }

  setPageSize(pageSize) {
    this.data.pageSize = pageSize
  }

  setPageNum(pageNum) {
    this.data.pageNum = pageNum
  }
}

export function testPage(request) {
  var data = request.data
  // eslint-disable-next-line eqeqeq
  if (data['userId'] == undefined) {
    console.error('userId 参数不能为空')
  }
  const path = 'test/page'
  return new Promise(resolve => {
    api(path, data)
      .then(response => {
        resolve(response)
      })
  })
}

//import {TestPageRequest, testPage} from '@/sdk/api/test/page'

// var request = new TestPageRequest()
// request.setPageNum(this.listQuery.pageNum)
// request.setPageSize(this.listQuery.pageSize)
// request.setUserId(7919)
// testPage(request).then(res => {
//   this.listLoading = false
//   console.log("res:", res)
//   console.log("data:", res.getData())
//   this.list = res.getData()['list']
//   this.total = res.getData()['total']
// })
