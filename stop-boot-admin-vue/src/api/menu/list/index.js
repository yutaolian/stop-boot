import {post} from '@/utils/http'

export class MenuListRequest {
  constructor () {
    this.data = {
      userId: undefined,
      courseId: undefined
    }
  }
  setUserId (userId) {
    this.data.userId = userId
  }
  setCourseId (courseId) {
    this.data.courseId = courseId
  }
}

export class MenuListResponse {
  constructor (data) {
    this.data = data
  }
  getData () {
    return this.data
  }
  getTitle () {
    return this.data['title']
  }
  getPath () {
    return this.data['path']
  }
  getComponent () {
    return this.data['component']
  }
  getIcon () {
    return this.data['icon']
  }
}

export function menuList (request) {
  var data = request.data
  // eslint-disable-next-line eqeqeq
  if (data['userId'] == undefined) {
    console.error('userId 参数不能为空')
  }
  const path = 'menu/list'
  return new Promise(resolve => {
    post(path, data)
      .then(response => {
        let data = []
        response.forEach(res => {
          data.push(new MenuListResponse(res))
        })
        resolve(data)
      })
  })
}
