import variables from '@/styles/element-variables.scss'
import defaultSettings from '@/config/settings'

const {title, logo, showSettings, tagsView, fixedHeader, sidebarLogo, routerParentPrifix} = defaultSettings

const state = {
  title: title,
  logo: logo,
  theme: variables.theme,
  showSettings: showSettings,
  tagsView: tagsView,
  fixedHeader: fixedHeader,
  sidebarLogo: sidebarLogo,
  routerParentPrifix: routerParentPrifix
}

const mutations = {
  CHANGE_SETTING: (state, {key, value}) => {
    if (state.hasOwnProperty(key)) {
      state[key] = value
    }
  }
}

const actions = {
  changeSetting({commit}, data) {
    commit('CHANGE_SETTING', data)
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
