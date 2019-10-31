import {api} from '@/sdk/api/httpConfig'

/**
 * projectName：stop-boot jssdk
 * author: Lianyutao
 * date: 2019/10/29 19:16
 * version: 1.0.1
 * desc: 分页
 */
export class PermissionPageRequest {

  constructor() {
    this.params = {
      // 第几页
      pageNum: undefined,
      // 页面大小
      pageSize: undefined,
      //
      id: undefined,
      // 菜单id
      menuId: undefined,
      // 权限tag
      tag: undefined,
      // 权限tagName
      tagName: undefined,
      // 权限tag描述
      tagDesc: undefined,
    }
  }

  //设置分页参数
  setPageSize(pageSize) {
    this.params.pageSize = pageSize
    return this;
  }

  setPageNum(pageNum) {
    this.params.pageNum = pageNum
    return this;
  }

  setId(id) {
    this.params.id = id
    return this;
  }

  setMenuId(menuId) {
    this.params.menuId = menuId
    return this;
  }

  setTag(tag) {
    this.params.tag = tag
    return this;
  }

  setTagDesc(tagDesc) {
    this.params.tagDesc = tagDesc
    return this;
  }

  //参数快捷设置
  setParams(params) {
    this.params = params
    return this;
  }

  api() {
    const path = '/system/permission/page'
    return new Promise(resolve => {
      api(path, this.params)
        .then(response => {
          resolve(response)
        })
    })
  }
}

//引用链接
//import {PermissionPageRequest} from '@/sdk/api/system/permission/page'
/*
    //快捷参数使用方式（params需满足如下格式,可设置在Vue的data()中）
    data() {
        return {
            permissionPageParams: {
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

    let request = new PermissionPageRequest();
    request.setParams(permissionPageParams).api().then(res => {
        console.log("PermissionPageRequest res:", res)
    })

    //单独设置参数方式一
    let request = new PermissionPageRequest();
    request.
            setId(id).
            setMenuId(menuId).
            setTag(tag).
            setTagDesc(tagDesc).
            api().then(res => {
                console.log("PermissionPageRequest res:", res)
    })

    //单独设置参数方式二
    let request = new PermissionPageRequest();
    request.setId(id);
    request.setMenuId(menuId);
    request.setTag(tag);
    request.setTagDesc(tagDesc);
    request.api().then(res => {
        console.log("PermissionPageRequest res:", res)
    })

*/
