import {api} from '@/sdk/api/httpConfig'

export class MenuListRequest {
  constructor() {
    this.params = {

    }
  }

  api() {
    const path = '/system/menu/list'
    return new Promise(resolve => {
      api(path, this.params)
        .then(response => {
          resolve(response)
        })
    })
  }
}

