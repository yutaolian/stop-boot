import {api} from '@/sdk/api/httpConfig'

export class TableColumnsRequest {
  constructor () {
    this.data = {
      tableName: undefined,
    }
  }

  setTableName (tableName) {
    this.data.tableName = tableName
  }
}

export function tableColumns(request) {
  let data = request.data
  const path = '/generator/table/columns'
  return new Promise(resolve => {
    api(path, data)
      .then(response => {
        resolve(response)
      })
  })
}
//import {TableColumnsRequest, tableColumns} from '@/sdk/api/generator/table/columns'
