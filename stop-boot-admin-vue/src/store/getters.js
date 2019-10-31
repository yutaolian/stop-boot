const getters = {
  sidebar: state => state.app.sidebar,
  size: state => state.app.size,
  device: state => state.app.device,
  visitedViews: state => state.tagsView.visitedViews,
  cachedViews: state => state.tagsView.cachedViews,
  token: state => state.user.token,
  avatar: state => state.user.avatar,
  name: state => state.user.name,
  introduction: state => state.user.introduction,
  roles: state => state.user.roles,
  loadMenus: state => state.menu.loadMenus,
  permissions: state => state.user.permissions,
  permission_routes: state => state.router.routes,
  menuRoutes: state => state.router.menuRoutes,
  errorLogs: state => state.errorLog.logs
}
export default getters
