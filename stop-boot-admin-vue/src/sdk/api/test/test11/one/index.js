import {api} from '@/sdk/api/httpConfig'

/**
 *  jssdk
 * author: lyt
 * date: 2019/10/17 16:40
 * version: 1.0.1
 * desc: 描述
 */
export class testPageRequest {
  constructor() {
    this.data = {
      pageSize: undefined,
      pageNum: undefined,
      id: undefined,
      name: undefined,
    }
  }

  setPageSize(pageSize) {
    this.data.pageSize = pageSize
  }

  setPageNum(pageNum) {
    this.data.pageNum = pageNum
  }

  setId(id) {
    this.data.id = id
  }
  setName(name) {
    this.data.name = name
  }
}

export function test(request) {
  let data = request.data
  const path = '/test/test1/test11/page'
  return new Promise(resolve => {
    api(path, data)
      .then(response => {
        resolve(response)
      })
  })
}
