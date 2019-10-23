import {api} from '@/sdk/api/httpConfig'

export class GeneratorPreRequest {
  constructor () {
    this.data = {
      menuId: undefined,
    }
  }

  setMenuId (menuId) {
    this.data.menuId = menuId
  }
}

export function generatorPre(request) {
  let data = request.data
  const path = 'generator/pre'
  return new Promise(resolve => {
    api(path, data)
      .then(response => {
        resolve(response)
      })
  })
}
//import {GeneratorPreRequest, generatorPre} from '@/sdk/api/generator/pre'
