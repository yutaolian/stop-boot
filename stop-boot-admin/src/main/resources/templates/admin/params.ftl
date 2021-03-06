package com.stopboot.admin.model${fullPathToPackage}.${currentType};

<#if currentType =='page'>
import com.stopboot.admin.base.params.BasePageParams;
</#if>
<#if currentType =='list'>
import com.stopboot.admin.base.params.BaseListParams;
</#if>
<#if currentType =='one'>
import com.stopboot.admin.base.params.BaseOneParams;
</#if>
<#if currentType =='add'>
import com.stopboot.admin.base.params.BaseAddParams;
</#if>
<#if currentType =='update'>
import com.stopboot.admin.base.params.BaseUpdateParams;
</#if>
<#if currentType =='delete'>
import com.stopboot.admin.base.params.BaseDeleteParams;
</#if>
import lombok.Data;

/**
 * @description:
 * @author: ${author}
 * @create: ${date?string("yyyy/MM/dd HH:mm")}
 * @version: ${version}
 **/

<#if currentType =='page'>
@Data
public class ${model?cap_first}${currentType?cap_first}Params extends BasePageParams{
</#if>
<#if currentType =='list'>
@Data
public class ${model?cap_first}${currentType?cap_first}Params extends BaseListParams{
</#if>
<#if currentType =='one'>
@Data
public class ${model?cap_first}${currentType?cap_first}Params extends BaseOneParams{
</#if>
<#if currentType =='add'>
@Data
public class ${model?cap_first}${currentType?cap_first}Params extends BaseAddParams{
</#if>
<#if currentType =='update'>
@Data
public class ${model?cap_first}${currentType?cap_first}Params extends BaseUpdateParams{
</#if>
<#if currentType =='delete'>
@Data
public class ${model?cap_first}${currentType?cap_first}Params extends BaseDeleteParams{
</#if>
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
