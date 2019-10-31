package ${basePackage}.service${fullPathToPackage};

import ${basePackage}.base.service.DefaultServiceI;
import ${basePackage}.model${fullPathToPackage}.add.${model?cap_first}AddParams;
import ${basePackage}.model${fullPathToPackage}.list.${model?cap_first}ListVO;
import ${basePackage}.model${fullPathToPackage}.list.${model?cap_first}ListParams;
import ${basePackage}.model${fullPathToPackage}.one.${model?cap_first}OneParams;
import ${basePackage}.model${fullPathToPackage}.one.${model?cap_first}OneVO;
import ${basePackage}.model${fullPathToPackage}.page.${model?cap_first}PageParams;
import ${basePackage}.model${fullPathToPackage}.page.${model?cap_first}PageVO;
import ${basePackage}.model${fullPathToPackage}.update.${model?cap_first}UpdateParams;
import ${basePackage}.model${fullPathToPackage}.delete.${model?cap_first}DeleteParams;


public interface ${model?cap_first}ServiceI extends DefaultServiceI<${model?cap_first}PageVO, ${model?cap_first}ListVO, ${model?cap_first}OneVO,
        ${model?cap_first}PageParams, ${model?cap_first}ListParams, ${model?cap_first}OneParams,
        ${model?cap_first}AddParams, ${model?cap_first}UpdateParams, ${model?cap_first}DeleteParams> {

}
