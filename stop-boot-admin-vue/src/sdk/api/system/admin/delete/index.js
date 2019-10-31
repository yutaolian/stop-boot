import {api} from '@/sdk/api/httpConfig'

/**
 * projectName：stop-boot jssdk
 * author: Lianyutao
 * date: 2019/10/31 16:45
 * version: 1.0.1
    * desc: 详情
 */
export class AdminDeleteRequest {

    constructor() {
        this.params = {
            // 
            id: undefined,
            // 姓名
            name: undefined,
            // 手机号
            mobile: undefined,
            // 密码
            password: undefined,
            // 邮箱
            email: undefined,
            // 状态（1正常使用，0不使用）
            status: undefined,
            // 删除标识（0删除，1未删除）
            deleteFlag: undefined,
            // 创建时间
            createTime: undefined,
            // 更新时间
            updateTime: undefined,
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

    setMobile(mobile) {
        this.params.mobile = mobile
        return this;
    }

    setPassword(password) {
        this.params.password = password
        return this;
    }

    setEmail(email) {
        this.params.email = email
        return this;
    }

    setStatus(status) {
        this.params.status = status
        return this;
    }

    setDeleteFlag(deleteFlag) {
        this.params.deleteFlag = deleteFlag
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

    //参数快捷设置
    setParams(params) {
        this.params = params
        return this;
    }

    api() {
        const path = '/system/admin/delete'
        return new Promise(resolve => {
            api(path, this.params)
            .then(response => {
                resolve(response)
            })
        })
    }
}

//引用链接
//import {AdminDeleteRequest} from '@/sdk/api/system/admin/delete'
/*
    //快捷参数使用方式（params需满足如下格式,可设置在Vue的data()中）
    data() {
        return {
            adminDeleteParams: {
                    // 
                    id: undefined,
                    // 姓名
                    name: undefined,
                    // 手机号
                    mobile: undefined,
                    // 密码
                    password: undefined,
                    // 邮箱
                    email: undefined,
                    // 状态（1正常使用，0不使用）
                    status: undefined,
                    // 删除标识（0删除，1未删除）
                    deleteFlag: undefined,
                    // 创建时间
                    createTime: undefined,
                    // 更新时间
                    updateTime: undefined,
            },
        }
    },

    let request = new AdminDeleteRequest();
    request.setParams(adminDeleteParams).api().then(res => {
        console.log("AdminDeleteRequest res:", res)
    })

    //单独设置参数方式一
    let request = new AdminDeleteRequest();
    request.
            setId(id).
            setName(name).
            setMobile(mobile).
            setPassword(password).
            setEmail(email).
            setStatus(status).
            setDeleteFlag(deleteFlag).
            setCreateTime(createTime).
            setUpdateTime(updateTime).
            api().then(res => {
                console.log("AdminDeleteRequest res:", res)
    })

    //单独设置参数方式二
    let request = new AdminDeleteRequest();
    request.setId(id);
    request.setName(name);
    request.setMobile(mobile);
    request.setPassword(password);
    request.setEmail(email);
    request.setStatus(status);
    request.setDeleteFlag(deleteFlag);
    request.setCreateTime(createTime);
    request.setUpdateTime(updateTime);
    request.api().then(res => {
        console.log("AdminDeleteRequest res:", res)
    })

*/
