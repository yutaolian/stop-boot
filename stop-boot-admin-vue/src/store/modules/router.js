import {constantRoutes} from '@/router/routes'

const state = {
  menuRoutes: [],
  addRoutes: []
}

const mutations = {
  SET_ROUTES: (state, routes) => {
    state.addRoutes = routes
    state.menuRoutes = constantRoutes.concat(routes)
  }
}

const actions = {
  generateRoutes({commit}, routes) {
    return new Promise(resolve => {
      commit('SET_ROUTES', routes)
      resolve(routes)
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
