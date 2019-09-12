import {post} from '@/utils/http'

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
  const path = 'course/detail'
  return new Promise(resolve => {
    post(path, data)
      .then(response => {
        resolve(new LogoutResponse(response))
      })
  })
}
