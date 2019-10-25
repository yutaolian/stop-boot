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
    /**
    *${colum.columnComment}
    *
    */
    private ${colum.realType} ${colum.camelColumnName};
</#list>



}
