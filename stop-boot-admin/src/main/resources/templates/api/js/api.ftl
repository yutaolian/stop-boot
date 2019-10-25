import {api} from '@${jsSdkConfigPath}/httpConfig'

/**
 * projectName：${projectName} jssdk
 * author: ${author}
 * date: ${date?string("yyyy/MM/dd HH:mm")}
 * version: ${version}
<#if currentType =='page'>
 * desc: 分页
</#if>
<#if currentType =='list'>
 * desc: 列表
</#if>
<#if currentType =='add'>
 * desc: 新增
</#if>
<#if currentType =='update'>
 * desc: 更新
</#if>
<#if currentType =='one'>
 * desc: 详情
</#if>
<#if currentType =='delete'>
    * desc: 详情
</#if>
 */
export class ${model?cap_first}${currentType?cap_first}Request {

    constructor() {
        this.params = {
<#if currentType =='page'>
            // 第几页
            pageNum: undefined,
            // 页面大小
            pageSize: undefined,
</#if>
<#list tableColumnsData as colum>
            // ${colum.columnComment}
            ${colum.camelColumnName}: undefined,
</#list>
        }
    }

<#if currentType =='page'>
    //设置分页参数
    setPageSize(pageSize) {
        this.params.pageSize = pageSize
        return this;
    }

    setPageNum(pageNum) {
        this.params.pageNum = pageNum
        return this;
    }
</#if>
<#list tableColumnsData as colum>

    set${colum.camelColumnName?cap_first}(${colum.camelColumnName}) {
        this.params.${colum.camelColumnName} = ${colum.camelColumnName}
        return this;
    }
</#list>

    //参数快捷设置
    setParams(params) {
        this.params = params
        return this;
    }

    api() {
        const path = '${fullPath}/${currentType}'
        return new Promise(resolve => {
            api(path, this.params)
            .then(response => {
                resolve(response)
            })
        })
    }
}

//引用链接
//import {${model?cap_first}${currentType?cap_first}Request} from '@${jsSdkConfigPath}${fullPath}/${currentType}'
/*
    //快捷参数使用方式（params需满足如下格式,可设置在Vue的data()中）
    data() {
        return {
            ${model}${currentType?cap_first}Params: {
            <#list tableColumnsData as colum>
                    // ${colum.columnComment}
                    ${colum.camelColumnName}: undefined,
            </#list>
            },
        }
    },

    let request = new ${model?cap_first}${currentType?cap_first}Request();
    request.setParams(${model}${currentType?cap_first}Params).api().then(res => {
        console.log("${model?cap_first}${currentType?cap_first}Request res:", res)
    })

    //单独设置参数方式一
    let request = new ${model?cap_first}${currentType?cap_first}Request();
    request.<#list tableColumnsData as colum>
            set${colum.camelColumnName?cap_first}(${colum.camelColumnName}).</#list>
            api().then(res => {
                console.log("${model?cap_first}${currentType?cap_first}Request res:", res)
    })

    //单独设置参数方式二
    let request = new ${model?cap_first}${currentType?cap_first}Request();
    <#list tableColumnsData as colum>
    request.set${colum.camelColumnName?cap_first}(${colum.camelColumnName});
    </#list>
    request.api().then(res => {
        console.log("${model?cap_first}${currentType?cap_first}Request res:", res)
    })

*/
