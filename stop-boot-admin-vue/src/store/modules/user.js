import {getToken, removeToken, setToken} from '@/utils/cookieUtil'
import {resetRouter} from '@/router'
import {login, LoginRequest} from '@/sdk/api/login'
import {logout, LogoutRequest} from '@/sdk/api/logout'
import {menuList, MenuListRequest} from '@/sdk/api/menu/list'
const user = {
  state: {
    token: getToken(),
    name: '',
    avatar: '',
    introduction: '',
    roles: [],
    loadMenus: false,
    menus:[]
  },
  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_ROLES: (state, roles) => {
      state.roles = roles
    },
    SET_LOAD_MENUS: (state, loadMenus) => {
      state.loadMenus = loadMenus
    },
    SET_MENUS: (state, menus) => {
      state.menus = menus
    }
  },
  actions: {
    // login
    login ({commit}, userInfo) {
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
          // 设置cookies
          setToken(res.getToken())
          resolve()
        })
      })
    },

    // login
    roles ({commit}) {
      // const {username, password} = userInfo
      return new Promise((resolve, reject) => {
        var request = new LoginRequest()
        // request.setMobile(username)
        // request.setPassword(password)
        request.setCourseId(2675)
        login(request).then(res => {
          commit('SET_ROLES', ['admin'])
          // commit('SET_NAME', 'lyt')
          // 设置store
          commit('SET_TOKEN', res.getName())
          // 设置cookies
          setToken(res.getToken())
          resolve()
        })
      })
    },
    // login
    menus ({commit}) {
      return new Promise((resolve, reject) => {
        var request = new MenuListRequest()
        request.setUserId(7919)
        menuList(request).then(res => {
          commit('SET_LOAD_MENUS', true)
          commit('SET_MENUS', res)
          resolve(res)
        })
      })
    },
    // logout
    logout ({commit, state}) {
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
    updateLoadMenus ({ commit }) {
      return new Promise((resolve, reject) => {
        commit('SET_LOAD_MENUS', false)
      })
    }
  }
}

export default user
