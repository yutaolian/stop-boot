import {api} from '@/sdk/api/httpConfig'

/**
 *
 */
export class TestPageRequest {
  constructor() {
    this.params = {
      pageSize: undefined,
      pageNum: undefined,
      // 姓名
      name: undefined,
      // 年龄
      age: undefined,
    }
  }

  setPageSize(pageSize) {
    this.params.pageSize = pageSize
  }

  setPageNum(pageNum) {
    this.params.pageNum = pageNum
  }
  setName(name) {
    this.params.name = name
  }

  setAge(age) {
    this.params.age = age
    return this;
  }
  //参数快捷设置
  setParams(params) {
    this.params = params
    return this;
  }

  api() {
    const path = '/test/test11/page'
    return new Promise(resolve => {
      api(path, this.params)
        .then(response => {
          resolve(response)
        })
    })
  }
}

//导入方法
//import {TestPageRequest, testPage} from '@/sdk/api/test/test1/page'
