// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import store from './store'
// css兼容
import 'normalize.css/normalize.css' // a modern alternative to CSS resets
// 进度条
import 'nprogress/nprogress.css' // progress bar style

import '@/styles/element-variables.scss'

import './icons' // icon

import ElementUI from 'element-ui'

import '@/styles/index.scss' // global css

// import locale from 'element-ui/lib/locale/lang/en'
import locale from 'element-ui/lib/locale/lang/zh-CN' // lang i18n

import Log from './utils/log'

Vue.use(Log);

Vue.config.productionTip = false

Vue.use(ElementUI, { locale })
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
