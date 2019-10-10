import {api} from '@/sdk/api/httpConfig'

export class MenuListRequest {
  constructor() {
    this.data = {
      userId: undefined,
      courseId: undefined
    }
  }

  setUserId(userId) {
    this.data.userId = userId
  }

  setCourseId(courseId) {
    this.data.courseId = courseId
  }
}

export function menuList(request) {
  var data = request.data
  // eslint-disable-next-line eqeqeq
  if (data['userId'] == undefined) {
    console.error('userId 参数不能为空')
  }
  const path = 'system/menu/list'
  return new Promise(resolve => {
    api(path, data)
      .then(response => {
        resolve(response)
      })
  })
}
