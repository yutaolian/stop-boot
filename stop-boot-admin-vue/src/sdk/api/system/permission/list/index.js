import {api} from '@/sdk/api/httpConfig'

/**
 * projectName：stop-boot jssdk
 * author: Lianyutao
 * date: 2019/10/29 19:16
 * version: 1.0.1
 * desc: 列表
 */
export class PermissionListRequest {

    constructor() {
        this.params = {
          roleId:undefined
        }
    }

    setRoleId(roleId){
      this.params.roleId = roleId;
      return this;
    }

    //参数快捷设置
    setParams(params) {
        this.params = params
        return this;
    }

    api() {
        const path = '/system/permission/list'
        return new Promise(resolve => {
            api(path, this.params)
            .then(response => {
                resolve(response)
            })
        })
    }
}

//引用链接
//import {PermissionListRequest} from '@/sdk/api/system/permission/list'
/*
    //快捷参数使用方式（params需满足如下格式,可设置在Vue的data()中）
    data() {
        return {
            permissionListParams: {
                    //
                    id: undefined,
                    // 菜单id
                    menuId: undefined,
                    // 权限tag
                    tag: undefined,
                    // 权限tag描述
                    tagDesc: undefined,
            },
        }
    },

    let request = new PermissionListRequest();
    request.setParams(permissionListParams).api().then(res => {
        console.log("PermissionListRequest res:", res)
    })

    //单独设置参数方式一
    let request = new PermissionListRequest();
    request.
            setId(id).
            setMenuId(menuId).
            setTag(tag).
            setTagDesc(tagDesc).
            api().then(res => {
                console.log("PermissionListRequest res:", res)
    })

    //单独设置参数方式二
    let request = new PermissionListRequest();
    request.setId(id);
    request.setMenuId(menuId);
    request.setTag(tag);
    request.setTagDesc(tagDesc);
    request.api().then(res => {
        console.log("PermissionListRequest res:", res)
    })

*/
