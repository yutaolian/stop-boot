import {api} from '@/sdk/api/httpConfig'

/**
 * projectName：stop-boot jssdk
 * author: Lianyutao
 * date: 2019/10/30 14:06
 * version: 1.0.1
 * desc: 保存角色的权限
 */
export class RoleSaveRequest {

  constructor() {

    this.params = {
      // 角色id
      roleId: undefined,

      menuIds: undefined,

      permissionIds: undefined

    }
  }

  setRoleId(roleId) {
    this.params.roleId = roleId
    return this;
  }

  setMenuIds(menuIds) {
    this.params.menuIds = menuIds
    return this;
  }

  setPermissionIds(permissionIds) {
    this.params.permissionIds = permissionIds
    return this;
  }

  //参数快捷设置
  setParams(params) {
    this.params = params
    return this;
  }

  api() {
    const path = '/system/role/save'
    return new Promise(resolve => {
      api(path, this.params)
        .then(response => {
          resolve(response)
        })
    })
  }
}
