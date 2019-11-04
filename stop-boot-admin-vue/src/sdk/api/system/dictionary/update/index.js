import {api} from '@/sdk/api/httpConfig'

/**
 * projectName：stop-boot jssdk
 * author: Lianyutao
 * date: 2019/11/04 19:54
 * version: 1.0.1
 * desc: 更新
 */
export class DictionaryUpdateRequest {

    constructor() {
        this.params = {
            // 主键ID
            id: undefined,
            // 字典名称
            dicName: undefined,
            // 字典key
            dicKey: undefined,
            // 字典值
            dicValue: undefined,
            // 字典描述
            dicDesc: undefined,
            // 状态1激活，0冻结
            status: undefined,
            // 删除标识（1正常，0删除）
            deleteFlag: undefined,
            // 创建时间
            createTime: undefined,
            // 修改时间
            updateTime: undefined,
        }
    }


    setId(id) {
        this.params.id = id
        return this;
    }

    setDicName(dicName) {
        this.params.dicName = dicName
        return this;
    }

    setDicKey(dicKey) {
        this.params.dicKey = dicKey
        return this;
    }

    setDicValue(dicValue) {
        this.params.dicValue = dicValue
        return this;
    }

    setDicDesc(dicDesc) {
        this.params.dicDesc = dicDesc
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
        const path = '/system/dictionary/update'
        return new Promise(resolve => {
            api(path, this.params)
            .then(response => {
                resolve(response)
            })
        })
    }
}

//引用链接
//import {DictionaryUpdateRequest} from '@/sdk/api/system/dictionary/update'
/*
    //快捷参数使用方式（params需满足如下格式,可设置在Vue的data()中）
    data() {
        return {
            dictionaryUpdateParams: {
                    // 主键ID
                    id: undefined,
                    // 字典名称
                    dicName: undefined,
                    // 字典key
                    dicKey: undefined,
                    // 字典值
                    dicValue: undefined,
                    // 字典描述
                    dicDesc: undefined,
                    // 状态1激活，0冻结
                    status: undefined,
                    // 删除标识（1正常，0删除）
                    deleteFlag: undefined,
                    // 创建时间
                    createTime: undefined,
                    // 修改时间
                    updateTime: undefined,
            },
        }
    },

    let request = new DictionaryUpdateRequest();
    request.setParams(dictionaryUpdateParams).api().then(res => {
        console.log("DictionaryUpdateRequest res:", res)
    })

    //单独设置参数方式一
    let request = new DictionaryUpdateRequest();
    request.
            setId(id).
            setDicName(dicName).
            setDicKey(dicKey).
            setDicValue(dicValue).
            setDicDesc(dicDesc).
            setStatus(status).
            setDeleteFlag(deleteFlag).
            setCreateTime(createTime).
            setUpdateTime(updateTime).
            api().then(res => {
                console.log("DictionaryUpdateRequest res:", res)
    })

    //单独设置参数方式二
    let request = new DictionaryUpdateRequest();
    request.setId(id);
    request.setDicName(dicName);
    request.setDicKey(dicKey);
    request.setDicValue(dicValue);
    request.setDicDesc(dicDesc);
    request.setStatus(status);
    request.setDeleteFlag(deleteFlag);
    request.setCreateTime(createTime);
    request.setUpdateTime(updateTime);
    request.api().then(res => {
        console.log("DictionaryUpdateRequest res:", res)
    })

*/
