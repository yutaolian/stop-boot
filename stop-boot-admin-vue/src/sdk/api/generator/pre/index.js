import {api} from '@/sdk/api/httpConfig'

export class GeneratorPreRequest {
  constructor() {
    this.data = {
      menuId: undefined,
    }
  }

  setMenuId(menuId) {
    this.data.menuId = menuId
    return this;
  }

  api() {
    const path = '/generator/pre'
    return new Promise(resolve => {
      api(path, this.data)
        .then(response => {
          resolve(response)
        })
    })
  }
}

// export function generatorPre(request) {
//   let data = request.data
//   const path = 'generator/pre'
//   return new Promise(resolve => {
//     api(path, data)
//       .then(response => {
//         resolve(response)
//       })
//   })
// }
//import {GeneratorPreRequest} from '@/sdk/api/generator/pre'
