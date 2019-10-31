import {api} from '@/sdk/api/httpConfig'

/**
 * projectName：stop-boot jssdk
 * author: Lianyutao
 * date: 2019/10/30 14:06
 * version: 1.0.1
 * desc: 列表
 */
export class RolePermissionRequest {

  constructor() {
    this.params = {
      // 角色id
      roleId: undefined
    }
  }

  setRoleId(roleId) {
    this.params.roleId = roleId
    return this;
  }

  //参数快捷设置
  setParams(params) {
    this.params = params
    return this;
  }

  api() {
    const path = '/system/role/permission'
    return new Promise(resolve => {
      api(path, this.params)
        .then(response => {
          resolve(response)
        })
    })
  }
}

//引用链接
//import {RolePermissiontRequest} from '@/sdk/api/system/role/permission'
/*
    //快捷参数使用方式（params需满足如下格式,可设置在Vue的data()中）
    data() {
        return {
            roleListParams: {
                    //
                    id: undefined,
                    // 角色名称
                    name: undefined,
                    // 描述
                    description: undefined,
                    // 角色标签
                    tag: undefined,
                    // 状态（1正常使用，0不使用）
                    status: undefined,
                    // 创建时间
                    createTime: undefined,
                    // 更新时间
                    updateTime: undefined,
                    // 删除标识（0删除，1未删除）
                    deleteFlag: undefined,
            },
        }
    },

    let request = new RolePermissiontRequest();
    request.setParams(roleListParams).api().then(res => {
        console.log("RolePermissiontRequest res:", res)
    })

    //单独设置参数方式一
    let request = new RolePermissiontRequest();
    request.
            setId(id).
            setName(name).
            setDescription(description).
            setTag(tag).
            setStatus(status).
            setCreateTime(createTime).
            setUpdateTime(updateTime).
            setDeleteFlag(deleteFlag).
            api().then(res => {
                console.log("RoleListRequest res:", res)
    })

    //单独设置参数方式二
    let request = new RoleListRequest();
    request.setId(id);
    request.setName(name);
    request.setDescription(description);
    request.setTag(tag);
    request.setStatus(status);
    request.setCreateTime(createTime);
    request.setUpdateTime(updateTime);
    request.setDeleteFlag(deleteFlag);
    request.api().then(res => {
        console.log("RoleListRequest res:", res)
    })

*/
