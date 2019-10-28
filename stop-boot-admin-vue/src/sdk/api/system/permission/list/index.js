import {api} from '@/sdk/api/httpConfig'

export class PermissionListRequest {
  constructor() {
  }

  api() {
    const path = '/system/permission/list'
    return new Promise(resolve => {
      api(path, this.params)
        .then(response => {
          resolve(response)
        })
    })
  }
}
