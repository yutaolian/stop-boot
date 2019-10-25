import {api} from '@/sdk/api/httpConfig'

export class RolePageRequest {
  constructor() {
    this.data = {
      userId: undefined,
      pageNum: undefined,
      pageSize: undefined
    }
  }

  setUserId(userId) {
    this.data.userId = userId
  }

  setPageNum(pageNum) {
    this.data.pageNum = pageNum
  }

  setPageSize(pageSize) {
    this.data.pageSize = pageSize
  }
}

export function rolePage(request) {
  var data = request.data
  // eslint-disable-next-line eqeqeq
  if (data['userId'] == undefined) {
    console.error('userId 参数不能为空')
  }
  if (data['pageNum'] == undefined) {
    console.error('pageNum 参数不能为空')
  }
  if (data['pageSize'] == undefined) {
    console.error('pageSize 参数不能为空')
  }
  const path = '/role/page'
  return new Promise(resolve => {
    api(path, data)
      .then(response => {
        resolve(response)
      })
  })
}

// import {RolePageRequest, rolePage} from '@/sdk/api/role/page'
