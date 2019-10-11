import {api} from '@/sdk/api/httpConfig'

export class TestPageRequest {
  constructor() {
    this.data = {
      pageSize: undefined,
      pageNum: undefined
    }
  }

  setPageSize(pageSize) {
    this.data.pageSize = pageSize
  }

  setPageNum(pageNum) {
    this.data.pageNum = pageNum
  }
}

export function testPage(request) {
  let data = request.data
  const path = 'test/test1/page'
  return new Promise(resolve => {
    api(path, data)
      .then(response => {
        resolve(response)
      })
  })
}

//import {TestPageRequest, testPage} from '@/sdk/api/test/test1/page'

// let request = new TestPageRequest()
// request.setPageNum(this.listQuery.pageNum)
// request.setPageSize(this.listQuery.pageSize)
// testPage(request).then(res => {
//   this.listLoading = false
//   console.log("res:", res)
//   console.log("data:", res.getData())
//   this.list = res.getData()['list']
//   this.total = res.getData()['total']
// })
