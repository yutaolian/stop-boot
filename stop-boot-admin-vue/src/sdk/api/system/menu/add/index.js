import {api} from '@/sdk/api/httpConfig'

/**
 * projectName：stop-boot jssdk
 * author: Lianyutao
 * date: 2019/11/01 16:50
 * version: 1.0.1
 * desc: 新增
 */
export class MenuAddRequest {

    constructor() {
        this.params = {
            // 主键ID
            id: undefined,
            // 父id
            pid: undefined,
            // 菜单名称(显示名字)
            title: undefined,
            // 菜单名称
            name: undefined,
            // 组件名称
            component: undefined,
            // 菜单点击路径
            path: undefined,
            // icon
            icon: undefined,
            // 类型 （1内部菜单，-1外部链接）
            type: undefined,
            // 链接地址
            link: undefined,
            // 菜单编码
            code: undefined,
            // 是否显示 1 显示 0 隐藏
            hidden: undefined,
            // 状态（1正常使用，0不使用）
            status: undefined,
            // 排序按从小到大排序（0最靠前）
            sort: undefined,
            // 删除标识（0删除，1正常）
            deleteFlag: undefined,
            // 操作者id
            opUserId: undefined,
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

    setPid(pid) {
        this.params.pid = pid
        return this;
    }

    setTitle(title) {
        this.params.title = title
        return this;
    }

    setName(name) {
        this.params.name = name
        return this;
    }

    setComponent(component) {
        this.params.component = component
        return this;
    }

    setPath(path) {
        this.params.path = path
        return this;
    }

    setIcon(icon) {
        this.params.icon = icon
        return this;
    }

    setType(type) {
        this.params.type = type
        return this;
    }

    setLink(link) {
        this.params.link = link
        return this;
    }

    setCode(code) {
        this.params.code = code
        return this;
    }

    setHidden(hidden) {
        this.params.hidden = hidden
        return this;
    }

    setStatus(status) {
        this.params.status = status
        return this;
    }

    setSort(sort) {
        this.params.sort = sort
        return this;
    }

    setDeleteFlag(deleteFlag) {
        this.params.deleteFlag = deleteFlag
        return this;
    }

    setOpUserId(opUserId) {
        this.params.opUserId = opUserId
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
        const path = '/system/menu/add'
        return new Promise(resolve => {
            api(path, this.params)
            .then(response => {
                resolve(response)
            })
        })
    }
}

//引用链接
//import {MenuAddRequest} from '@/sdk/api/system/menu/add'
/*
    //快捷参数使用方式（params需满足如下格式,可设置在Vue的data()中）
    data() {
        return {
            menuAddParams: {
                    // 主键ID
                    id: undefined,
                    // 父id
                    pid: undefined,
                    // 菜单名称(显示名字)
                    title: undefined,
                    // 菜单名称
                    name: undefined,
                    // 组件名称
                    component: undefined,
                    // 菜单点击路径
                    path: undefined,
                    // icon
                    icon: undefined,
                    // 类型 （1内部菜单，-1外部链接）
                    type: undefined,
                    // 链接地址
                    link: undefined,
                    // 菜单编码
                    code: undefined,
                    // 是否显示 1 显示 0 隐藏
                    hidden: undefined,
                    // 状态（1正常使用，0不使用）
                    status: undefined,
                    // 排序按从小到大排序（0最靠前）
                    sort: undefined,
                    // 删除标识（0删除，1正常）
                    deleteFlag: undefined,
                    // 操作者id
                    opUserId: undefined,
                    // 创建时间
                    createTime: undefined,
                    // 更新时间
                    updateTime: undefined,
            },
        }
    },

    let request = new MenuAddRequest();
    request.setParams(menuAddParams).api().then(res => {
        console.log("MenuAddRequest res:", res)
    })

    //单独设置参数方式一
    let request = new MenuAddRequest();
    request.
            setId(id).
            setPid(pid).
            setTitle(title).
            setName(name).
            setComponent(component).
            setPath(path).
            setIcon(icon).
            setType(type).
            setLink(link).
            setCode(code).
            setHidden(hidden).
            setStatus(status).
            setSort(sort).
            setDeleteFlag(deleteFlag).
            setOpUserId(opUserId).
            setCreateTime(createTime).
            setUpdateTime(updateTime).
            api().then(res => {
                console.log("MenuAddRequest res:", res)
    })

    //单独设置参数方式二
    let request = new MenuAddRequest();
    request.setId(id);
    request.setPid(pid);
    request.setTitle(title);
    request.setName(name);
    request.setComponent(component);
    request.setPath(path);
    request.setIcon(icon);
    request.setType(type);
    request.setLink(link);
    request.setCode(code);
    request.setHidden(hidden);
    request.setStatus(status);
    request.setSort(sort);
    request.setDeleteFlag(deleteFlag);
    request.setOpUserId(opUserId);
    request.setCreateTime(createTime);
    request.setUpdateTime(updateTime);
    request.api().then(res => {
        console.log("MenuAddRequest res:", res)
    })

*/
