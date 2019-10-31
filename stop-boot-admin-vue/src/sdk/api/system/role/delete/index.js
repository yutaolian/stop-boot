import {api} from '@/sdk/api/httpConfig'

/**
 * projectName：stop-boot jssdk
 * author: Lianyutao
 * date: 2019/10/30 14:06
 * version: 1.0.1
    * desc: 详情
 */
export class RoleDeleteRequest {

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
        }
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

    //参数快捷设置
    setParams(params) {
        this.params = params
        return this;
    }

    api() {
        const path = '/system/role/delete'
        return new Promise(resolve => {
            api(path, this.params)
            .then(response => {
                resolve(response)
            })
        })
    }
}

//引用链接
//import {RoleDeleteRequest} from '@/sdk/api/system/role/delete'
/*
    //快捷参数使用方式（params需满足如下格式,可设置在Vue的data()中）
    data() {
        return {
            roleDeleteParams: {
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

    let request = new RoleDeleteRequest();
    request.setParams(roleDeleteParams).api().then(res => {
        console.log("RoleDeleteRequest res:", res)
    })

    //单独设置参数方式一
    let request = new RoleDeleteRequest();
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
                console.log("RoleDeleteRequest res:", res)
    })

    //单独设置参数方式二
    let request = new RoleDeleteRequest();
    request.setId(id);
    request.setName(name);
    request.setDescription(description);
    request.setTag(tag);
    request.setStatus(status);
    request.setCreateTime(createTime);
    request.setUpdateTime(updateTime);
    request.setDeleteFlag(deleteFlag);
    request.api().then(res => {
        console.log("RoleDeleteRequest res:", res)
    })

*/
