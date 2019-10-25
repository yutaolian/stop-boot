import Layout from '@/components/Layout'

// 业务无关的路由
export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path*',
        component: () => import('@/components/Redirect/index')
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    hidden: true,
    component: () => import('@/views/login/index')
  },
  {
    path: '',
    component: Layout,
    hidden: true,
    redirect:'/dashboard'
  }
]
