import {post} from '../http'
//自定义api地址
const baseURL = 'http://localhost:8087/api'

// const baseURL = 'http://10.39.1.16:8087/api'


export function api(url, params = {}) {
  return new Promise((resolve, reject) => {
    post(baseURL + url, params).then(response => {
      resolve(response)
    }, error => {
      reject(error)
    })
  })
}
