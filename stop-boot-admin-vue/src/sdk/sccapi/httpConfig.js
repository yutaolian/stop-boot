import {post} from '../http'
//自定义api地址
//其他参数可以作为参数设置即可
const baseURL = 'https://axxol-api.aixuexi.com/api/'

export function api(url, params = {}) {
  return new Promise((resolve, reject) => {
    post(baseURL + url, params).then(response => {
      resolve(response)
    }, error => {
      reject(error)
    })
  })
}


