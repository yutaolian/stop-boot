import {api} from '@/sdk/api/httpConfig'

export class LogoutRequest {
  constructor () {
    this.data = {
      userId: undefined
    }
  }
  setUserId (userId) {
    this.data.userId = userId
  }
}

export class LogoutResponse {
  constructor (data) {
    this.data = data
  }
  getData () {
    return this.data
  }
}

export function logout (request) {
  var data = request.data
  // eslint-disable-next-line eqeqeq
  if (data['userId'] == undefined) {
    console.error('mobile 参数不能为空')
  }
  const path = '/menu/list'
  return new Promise(resolve => {
    api(path, data)
      .then(response => {
        resolve(new LogoutResponse(response))
      })
  })
}
