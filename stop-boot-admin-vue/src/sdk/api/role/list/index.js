import {api} from '@/sdk/api/httpConfig'

export class RoleListRequest {
  constructor() {
    this.data = {
      userId: undefined
    }
  }

  setUserId(userId) {
    this.data.userId = userId
  }
}

export function roleList(request) {
  var data = request.data
  // eslint-disable-next-line eqeqeq
  if (data['userId'] == undefined) {
    console.error('userId 参数不能为空')
  }
  const path = '/role/list'
  return new Promise(resolve => {
    api(path, data)
      .then(response => {
        resolve(response)
      })
  })
}
