import {post} from '@/utils/http'

export class LoginRequest {
  constructor () {
    this.data = {
      mobile: undefined,
      password: undefined,
      courseId: undefined
    }
  }

  setMobile (userId) {
    this.data.mobile = userId
  }

  setPassword (password) {
    this.data.password = password
  }
  setCourseId (courseId) {
    this.data.courseId = courseId
  }
}

export class LoginResponse {
  constructor (data) {
    this.data = data
  }
  getData () {
    return this.data
  }
  getName () {
    return this.data['name']
  }
  getId () {
    return this.data['id']
  }
  getToken () {
    return 'asdhfkasdhfklahsdklfhsakldhflksa'
  }
}

export function login (request) {
  var data = request.data
  // eslint-disable-next-line eqeqeq
  if (data['mobile'] == undefined) {
    console.error('mobile 参数不能为空')
  }
  // eslint-disable-next-line eqeqeq
  if (data['password'] == undefined) {
    console.error('password 参数不能为空')
  }
  const path = 'course/detail'
  return new Promise(resolve => {
    post(path, data)
      .then(response => {
        resolve(new LoginResponse(response))
      })
  })
}
