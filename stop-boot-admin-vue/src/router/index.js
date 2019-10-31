import Vue from 'vue'
import Router from 'vue-router'
import store from '@/store'
import {getToken, setToken, removeToken} from '@/utils/cookieUtil'
import {Message} from 'element-ui'
import NProgress from 'nprogress' // progress bar
import {constantRoutes} from './routes'
import defaultSettings from '@/config/settings'

import Layout from '@/components/Layout'
import Empty from '@/components/Empty'

import da from "element-ui/src/locale/lang/da";
import menu from "../store/modules/menu";

Vue.use(Router)

const createRouter = () => new Router({
  mode: 'history', // require service support
  scrollBehavior: () => ({y: 0}),
  routes: constantRoutes
})

const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

// eslint-disable-next-line no-unused-vars
const whiteList = ['/login']

const title = defaultSettings.title || 'Vue Element Admin'

router.beforeEach(async (to, from, next) => {
  // console.log('to------' + to) // 即将要进入路由的对象
  // console.log('from------' + from) // 当前导航要离开的路由对象
  // console.log('next------' + next) // 调用next该方法，才能进入下一个路由
  // start progress bar
  NProgress.start()
  // set page title
  document.title = getPageTitle(to.meta.title)
  // determine whether the user has logged in
  const hasToken = getToken()
  // 已登录
  if (hasToken) {
    if (to.path === '/login') {
      // if is logged in, redirect to the home page
      next({path: '/'})
      NProgress.done()
    } else {
      if (!store.getters.loadMenus) {
        try {
          let menuList = await store.dispatch('menus')
          //router去除root节点
          let subMenuList = menuList[0]["children"];
          //重置menu（将单节点添加父节点）
          let newMenuList = resetMenuList(subMenuList);
          //menu转为router
          let accessRoutes = menuTree2Routes(newMenuList);
          //合并router
          let allAccessRoutes = await store.dispatch('router/generateRoutes', accessRoutes)
          // 动态添加可访问路由表
          router.addRoutes(allAccessRoutes)
          next({...to, replace: true})
        } catch (e) {
          console.error("e:", e)
          store.dispatch('logout').then(() => {
            // location.reload() // 为了重新实例化vue-router对象 避免bug
          })
        }
      } else {
        next()
      }
    }
  } else {
    // 未登录
    /* has no token */
    if (whiteList.indexOf(to.path) !== -1) {
      // in the free login whitelist, go directly
      next()
    } else {
      // other pages that do not have permission to access are redirected to the login page.
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})


//将单节点menu改为带有父节点的menu
function resetMenuList(menuList) {
  let newMenuList = []
  let routerParentPrifix = defaultSettings.routerParentPrifix;
  for (let i = 0; i < menuList.length; i++) {
    let menu = menuList[i];
    let menuChildren = menu['children']
    //是单节点带单
    if (menuChildren == undefined || menuChildren.length == 0) {
      let children = []
      children.push({
        path: menu['path'],
        name: menu["name"],
        title: menu['title'],
        icon: menu['icon'],
        hidden: menu["hidden"],
        component: menu['component']
      })
      newMenuList.push({
        path: "/",
        name: routerParentPrifix + menu["name"],
        title: routerParentPrifix + menu['title'],
        icon: routerParentPrifix + menu['icon'],
        hidden: 0,
        component: 'Layout',
        children
      })
    } else {
      newMenuList.push(menu)
    }
  }
  return newMenuList
}

function menuTree2Routes(menuTree) {
  let routes = []
  for (let i = 0; i < menuTree.length; i++) {
    let children = []
    let submenu = menuTree[i]['children'];
    if (submenu != undefined && submenu.length > 0) {
      children = menuTree2Routes(submenu);
    }
    let menu = menuTree[i];
    if (menu['component'] == 'Layout') {
      routes.push({
        path: menu["path"],
        name: menu["name"],
        meta: {
          title: menu['title'],
          icon: menu['icon'],
        },
        hidden: menu["hidden"] == 1,
        component: Layout,
        children
      })
    } else if (menu['component'] == 'Empty') {
      routes.push({
        path: menu["path"],
        name: menu["name"],
        meta: {
          title: menu['title'],
          icon: menu['icon']
        },
        hidden: menu["hidden"] == 1,
        component: Empty,
        children
      })
    } else {
      routes.push({
        path: menu["path"],
        name: menu["name"],
        meta: {
          title: menu['title'],
          icon: menu['icon'],
          permission: menu['permissions']
        },
        hidden: menu["hidden"] == 1 ? true : false,
        component: loadView(menu['component']),
        children
      })
    }
  }
  return routes
}

export const loadView = (view) => { // 路由懒加载
  // console.log("view-----", view)
  return () => import(`@/${view}`)
}

//
// export const tempRoutes1 = [{
//     path: '/test',
//     component: Layout,
//     name: 'test',
//     meta: {
//       title: '测试菜单',
//       icon: 'component'
//     },
//     children: [
//       {
//         path: 'test1',
//         component: () => import('@/views/test/test1'),
//         name: 'test1',
//         meta: {title: '测试菜单1', icon: 'guide', noCache: true}
//       },
//       {
//         path: 'test2',
//         component: () => import('@/views/test/test2'),
//         name: 'test2',
//         meta: {title: '测试菜单2', icon: 'guide', noCache: true},
//         children: [
//           {
//             path: 'test21',
//             component: () => import('@/views/test/test2/test21'),
//             name: 'test21',
//             meta: {title: '测试菜单21', icon: 'guide', noCache: true},
//             children: [
//               {
//                 path: 'test211',
//                 component: () => import('@/views/test/test2/test21/test211'),
//                 name: 'test211',
//                 meta: {title: '测试菜单211', icon: 'guide', noCache: true}
//               }
//             ]
//           },
//           {
//             path: 'test22',
//             component: () => import('@/views/test/test2/test22'),
//             name: 'test22',
//             meta: {title: '测试菜单22', icon: 'guide', noCache: true},
//           }
//         ]
//       }
//     ]
//   }
// ]

function getPageTitle(pageTitle) {
  if (pageTitle) {
    return `${pageTitle} - ${title}`
  }
  return `${title}`
}

router.afterEach(() => {
  NProgress.done()
})

export default router
