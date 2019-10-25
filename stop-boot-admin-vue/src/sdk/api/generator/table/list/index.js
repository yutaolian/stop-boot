import {api} from '@/sdk/api/httpConfig'


export function generatorTable() {
  let data = undefined
  const path = '/generator/table/list'
  return new Promise(resolve => {
    api(path, data)
      .then(response => {
        resolve(response)
      })
  })
}
//import {generatorTable} from '@/sdk/api/generator/table/list'
