package ${basePackage}.service.${pathToPackage};

import ${basePackage}.base.service.DefaultServiceI;
import ${basePackage}.model${pathToPackage}.add.${model?cap_first}AddParams;
import ${basePackage}.model${pathToPackage}.one.${model?cap_first}OneParams;
import ${basePackage}.model${pathToPackage}.one.${model?cap_first}OneVO;
import ${basePackage}.model${pathToPackage}.page.${model?cap_first}PageParams;
import ${basePackage}.model${pathToPackage}.page.${model?cap_first}PageVO;
import ${basePackage}.model${pathToPackage}.update.${model?cap_first}UpdateParams;
import ${basePackage}.model${pathToPackage}.delete.${model?cap_first}DeleteParams;
import ${basePackage}.service${pathToPackage}.${model?cap_first}ServiceI;


public interface ${model?cap_first}ServiceI extends DefaultServiceI<${model?cap_first}PageVO,${model?cap_first}OneVO,
                ${model?cap_first}PageParams, ${model?cap_first}OneParams,
                ${model?cap_first}AddParams,${model?cap_first}UpdateParams, ${model?cap_first}DeleteParams> {

}
