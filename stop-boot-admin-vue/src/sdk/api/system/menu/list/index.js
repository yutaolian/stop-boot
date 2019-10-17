import {api} from '@/sdk/api/httpConfig'

export class MenuListRequest {
  constructor() {
    this.data = {
      userId: undefined
    }
  }

  setUserId(userId) {
    this.data.userId = userId
  }
}

export function menuList(request) {
  let data = request.data
  const path = 'system/menu/list'
  return new Promise(resolve => {
    api(path, data)
      .then(response => {
        resolve(response)
      })
  })
}
