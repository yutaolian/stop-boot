import {MenuListRequest} from '@/sdk/api/system/menu/list'
const menu = {
  state: {
    loadMenus: false,
  },
  mutations: {

    SET_LOAD_MENUS: (state, loadMenus) => {
      state.loadMenus = loadMenus
    },
  },
  actions: {
    // menus
    menus({commit}) {
      return new Promise((resolve, reject) => {
        let request = new MenuListRequest()
        request.api().then(res => {
          commit('SET_LOAD_MENUS', true)
          resolve(res)
        })
      })
    },

  }
}

export default menu
