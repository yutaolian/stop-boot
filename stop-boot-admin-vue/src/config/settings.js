module.exports = {

  title: '后台管理',

  logo: require("@/assets/img/144.png"),

  /**
   * @type {boolean} true | false
   * @description Whether show the settings right-panel
   */
  showSettings: true,

  /**
   * @type {boolean} true | false
   * @description Whether need tagsView
   */
  tagsView: true,

  /**
   * @type {boolean} true | false
   * @description Whether fix the header
   */
  fixedHeader: true,

  /**
   * @type {boolean} true | false
   * @description Whether show the logo in sidebar
   */
  sidebarLogo: true,

  /**
   * @type {string | array} 'production' | ['production', 'development']
   * @description Need show err logs component.
   * The default is only used in the production env
   * If you want to also use it in dev, you can pass ['production', 'development']
   */
  errorLog: 'dev',

  /**
   * 当菜单是一级的时候需要给当前菜单套一个父菜单。
   *  此常量为name,path,等前缀，防止路由冲突
   */
  routerParentPrifix: '_P_'
}
