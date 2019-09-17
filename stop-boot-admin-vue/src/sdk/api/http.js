import axios from 'axios'
import {Message} from 'element-ui'
//自定义日志
import store from '@/store'

// axios.defaults.baseURL = 'https://axxol-api.aixuexi.com/api'
axios.defaults.baseURL = 'http://localhost:8087/api'
axios.defaults.timeout = 10000
// 请求头信息是为post请求设置
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8'

axios.interceptors.request.use(
  config => {
    let token = 'asdfsdfasdfsd'
    token && (config.headers.Authorization = token)
    return config
  },
  error => {
    return Promise.reject(error)
  }
)

axios.interceptors.response.use(
  response => {
    if (response.status === 200) {
      return Promise.resolve(response)
    } else {
      return Promise.reject(response)
    }
  }, error => {
    return Promise.reject(error)
  }
)

export function post (url, data = {}) {
  return new Promise((resolve, reject) => {
    axios.post(url, data)
      .then(response => {
        if (store.state.logDebuger) {
          // console.info('url:', response.config.url)
          // console.info('request headers:', response.config.headers)
          // console.info('request body:', response.config.data)
          // console.info('response:', response.data)
          console.info('full response:', response)
        }
        resolve(response.data.data)
      }, error => {
        reject(error)
      })
  })
}


