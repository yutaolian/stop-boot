import axios from 'axios'
import {Message} from 'element-ui'
//自定义日志
import store from '@/store'
import resetRouter from "../router";

axios.defaults.baseURL = 'http://localhost:10010/api'
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

export function post (url, params = {}) {
  return new Promise((resolve, reject) => {
    axios.post(url, params)
      .then(response => {
        if (store.state.logDebuger) {
          console.info('url:', response.config.url)
          console.info('request headers:', response.config.headers)
          console.info('request body:', response.config.data)
          console.info('response:', response.data)
          console.info('full response:', response)
        }
        if (response.data["code"] == "SUCCESS"){
          resolve(response.data.data)
        }else{
          Message.error(response.data["failMsg"])
          // router.push("/login")
        }
      }, error => {
        reject(error)
      })
  })
}


