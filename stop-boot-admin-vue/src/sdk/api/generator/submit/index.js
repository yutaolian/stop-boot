import {api} from '@/sdk/api/httpConfig'

export class GeneratorSubmitRequest {
  constructor() {
    this.params = {}
  }

  setParams(params) {
    this.params = params
    return this;
  }

  api() {
    const path = '/generator/submit'
    return new Promise(resolve => {
      api(path, this.params)
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
//import {GeneratorSubmitRequest} from '@/sdk/api/generator/submit'
