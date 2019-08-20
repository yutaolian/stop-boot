import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/login'
import Dashboard from '@/views/dashboard'

import Table from  '@/views/table'
import Layout from '@/layout'

Vue.use(Router)

export const constantRoutes = [
  // {
  //   path: '/',
  //   name: 'login',
  //   redirect: '/login'
  // },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        name: 'Dashboard',
        component: Dashboard,
        meta: {title: 'Dashboard', icon: 'dashboard'}
      }
    ]
  },
  {
    path: '/example',
    component: Layout,
    redirect: '/example/table',
    name: 'Example',
    meta: { title: 'Example', icon: 'example' },
    children: [
      {
        path: 'table',
        name: 'Table',
        component: Table,
        meta: { title: 'Table', icon: 'table' }
      },
      {
        path: 'tree',
        name: 'Tree',
        component: Login,
        meta: { title: 'Tree', icon: 'tree' }
      }
    ]
  }, {
    path: '/example2',
    component: Layout,
    redirect: '/example/table',
    name: 'Example23',
    meta: { title: 'Example24', icon: 'example' },
    children: [
      {
        path: 'table',
        name: 'Table2',
        component: Login,
        meta: { title: 'Table2', icon: 'table' }
      },
      {
        path: 'tree',
        name: 'Tree2',
        component: Login,
        meta: { title: 'Tree2', icon: 'tree' }
      }
    ]
  }
]

const createRouter = () => new Router({
  mode: 'history',
  routes: constantRoutes
})

const router = createRouter()

export default router
