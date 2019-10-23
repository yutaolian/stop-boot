import {api} from '@${httpConfigPath}/httpConfig'

/**
 * projectName：${projectName} jssdk
 * author: ${author}
 * date: ${date?string("yyyy/MM/dd HH:mm")}
 * version: ${version}
<#if apiType =='page'>
 * desc: 分页
</#if>
<#if apiType =='list'>
 * desc: 列表
</#if>
<#if apiType =='add'>
 * desc: 新增
</#if>
<#if apiType =='update'>
 * desc: 更新
</#if>
<#if apiType =='one'>
 * desc: 详情
</#if>
 */
export class ${model}${apiType?cap_first}Request {

    constructor() {
        this.data = {
<#if apiType =='page'>
            // 第几页
            pageNum: undefined,
            // 页面大小
            pageSize: undefined,
</#if>
<#list columsInfoList as colum>
            // ${colum.title}
            ${colum.columnName}: undefined,
</#list>
        }
    }

<#if apiType =='page'>
    setPageSize(pageSize) {
        this.data.pageSize = pageSize
    }

    setPageNum(pageNum) {
        this.data.pageNum = pageNum
    }
</#if>
<#list columsInfoList as colum>

    set${colum.columnName?cap_first}(${colum.columnName}) {
        this.data.${colum.columnName} = ${colum.columnName}
    }
</#list>
}

export function ${model}${apiType?cap_first}(request) {

    let data = request.data
<#list columsInfoList as colum>
<#if colum.nullable =='YES'>

    if (data['${colum.columnName}'] == undefined) {
        console.error('${colum.columnName} 参数不能为空')
    }
</#if>
</#list>
    const path = '${path}/${apiType}'

    return new Promise(resolve => {
        api(path, data).then(response => {
            resolve(response)
        })
    })
}

/*
//引用链接
import {${model}${apiType?cap_first}Request, ${model}${apiType?cap_first}} from '@${httpConfigPath}/${path}/${apiType}'

//使用方法
let request = new ${model}${apiType?cap_first}Request()

<#if apiType =='page'>
request.setPageNum(this.listQuery.pageNum)
request.setPageSize(this.listQuery.pageSize)
</#if>
<#list columsInfoList as colum>
request.set${colum.columnName?cap_first}(this.listQuery.${colum.columnName})
</#list>

${model}${apiType?cap_first}(request).then(res => {
<#if apiType =='page'>
    this.list = res['list']
    this.total = res['total']
</#if>
<#list columsInfoList as colum>
    this.${colum.columnName} = res['${colum.columnName}']
</#list>

})

*/



