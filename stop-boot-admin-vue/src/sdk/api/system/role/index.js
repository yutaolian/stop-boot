import {api} from '@/sdk/api/httpConfig'

/**
 * projectName：stop-boot jssdk
 * author: Lianyutao
 * date: 2019/10/30 14:06
 * version: 1.0.1
 * desc: 详情
 */
const paegPath = '/system/role/page'

const addPath = '/system/role/add'

const deletePath = '/system/role/delete'


export class RoleRequest {

  page() {
    return _api(paegPath, this.params)
  }

  add() {
    return _api(addPath, this.params)
  }

  delete() {
    return _api(deletePath, this.params)
  }

  constructor() {
    this.params = {
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
      // 第几页
      pageNum: undefined,
      // 页面大小
      pageSize: undefined,
    }
  }

  //参数快捷设置
  setParams(addParams) {
    this.params = addParams
    return this;
  }

  setId(id) {
    this.params.id = id
    return this;
  }

  setName(name) {
    this.params.name = name
    return this;
  }

  setDescription(description) {
    this.params.description = description
    return this;
  }

  setTag(tag) {
    this.params.tag = tag
    return this;
  }

  setStatus(status) {
    this.params.status = status
    return this;
  }

  setCreateTime(createTime) {
    this.params.createTime = createTime
    return this;
  }

  setUpdateTime(updateTime) {
    this.params.updateTime = updateTime
    return this;
  }

  setDeleteFlag(deleteFlag) {
    this.params.deleteFlag = deleteFlag
    return this;
  }

}

function _api(path, params) {
  return new Promise(resolve => {
    api(path, params)
      .then(response => {
        resolve(response)
      })
  })
}
