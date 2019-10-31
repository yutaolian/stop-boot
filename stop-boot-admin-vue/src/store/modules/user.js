import {getToken, removeToken, setToken} from '@/utils/cookieUtil'
import {resetRouter} from '@/router'
import {login, LoginRequest} from '@/sdk/api/login'
import {logout, LogoutRequest} from '@/sdk/api/logout'
import {MenuListRequest} from '@/sdk/api/system/menu/list'

const user = {
  state: {
    token: getToken(),
    name: '',
    avatar: '',
    introduction: '',
    roles: [],
  },
  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_ROLES: (state, roles) => {
      state.roles = roles
    }
  },
  actions: {
    // login
    login({commit}, userInfo) {
      const {username, password} = userInfo
      return new Promise((resolve, reject) => {
        var request = new LoginRequest()
        request.setMobile(username)
        request.setPassword(password)
        request.setCourseId(2675)
        login(request).then(res => {
          // 登录获取用户基本信息和角色信息
          // 设置store
          commit('SET_TOKEN', res.getName())
          commit('SET_ROLES', ['admin'])
          commit('SET_PERMISSIONS', ['TEST_ADD', 'TEST_UPDATE', 'TEST_CREATE'])
          // 设置cookies
          setToken(res.getToken())
          resolve()
        })
      })
    },
    // logout
    logout({commit, state}) {
      return new Promise((resolve, reject) => {
        var request = new LogoutRequest()
        request.setUserId(7919)
        logout(request).then(res => {
          commit('SET_TOKEN', '')
          commit('SET_ROLES', [])
          removeToken()
          resetRouter()
          resolve()
        })
      })
    },
    // updateLoadMenus({commit}) {
    //   return new Promise((resolve, reject) => {
    //     commit('SET_LOAD_MENUS', false)
    //   })
    // }
  }
}

export default user
