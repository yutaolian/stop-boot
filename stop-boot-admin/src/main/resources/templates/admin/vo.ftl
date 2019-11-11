package com.stopboot.admin.model${fullPathToPackage}.${currentType};

import com.stopboot.admin.base.vo.BaseVO;
import lombok.Data;


/**
 * @description:  ${model?cap_first} service
 * @author: ${author}
 * @create: ${date?string("yyyy/MM/dd HH:mm")}
 * @version: ${version}
 **/

@Data
public class ${model?cap_first}${currentType?cap_first}VO extends BaseVO {
<#list tableColumnsData as colum>
<#if currentType =='page'>
<#if colum.pageShow ==true || colum.searchShow ==true>
    /**
    *${colum.columnComment}
    *
    */
    private ${colum.realType} ${colum.camelColumnName};
</#if>
</#if>
<#if currentType =='list'>
<#if colum.pageShow ==true || colum.searchShow ==true>
    /**
    *${colum.columnComment}
    *
    */
    private ${colum.realType} ${colum.camelColumnName};
</#if>
</#if>
<#if currentType =='one'>
<#if colum.editShow ==true>
    /**
    *${colum.columnComment}
    *
    */
    private ${colum.realType} ${colum.camelColumnName};
</#if>
</#if>
<#if currentType =='add'>
<#if colum.createShow ==true>
    /**
    *${colum.columnComment}
    *
    */
    private ${colum.realType} ${colum.camelColumnName};
</#if>
</#if>
<#if currentType =='update'>
<#if colum.editShow ==true>
    /**
    *${colum.columnComment}
    *
    */
    private ${colum.realType} ${colum.camelColumnName};
</#if>
</#if>
<#if currentType =='delete'>
    /**
    *${colum.columnComment}
    *
    */
    private ${colum.realType} ${colum.camelColumnName};
</#if>
</#list>



}
