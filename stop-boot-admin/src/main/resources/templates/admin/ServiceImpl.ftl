package ${basePackage}.service.${pathToPackage};

import ${basePackage}.common.PageResult;
import ${entityMapperPackage};
import ${entityPackage};
import ${entityExamplePackage}
import ${basePackage}.base.service.DefaultServiceImpl;
import ${basePackage}.model${pathToPackage}.add.${model?cap_first}AddParams;
import ${basePackage}.model${pathToPackage}.one.${model?cap_first}OneParams;
import ${basePackage}.model${pathToPackage}.one.${model?cap_first}OneVO;
import ${basePackage}.model${pathToPackage}.page.${model?cap_first}PageParams;
import ${basePackage}.model${pathToPackage}.page.${model?cap_first}PageVO;
import ${basePackage}.model${pathToPackage}.update.${model?cap_first}UpdateParams;
import ${basePackage}.model${pathToPackage}.delete.${model?cap_first}DeleteParams;
import ${basePackage}.service${pathToPackage}.${model?cap_first}ServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @description:  ${model?cap_first} service
 * @author: ${author}
 * @create: ${date?string("yyyy/MM/dd HH:mm")}
 * @version: ${version}
**/

@Slf4j
@Service
public class ${model?cap_first}ServiceImpl extends DefaultServiceImpl<${entityMapperName}, ${entityName}, ${entityExampleName},
                                ${model?cap_first}PageVO, ${model?cap_first}OneVO,
                                ${model?cap_first}PageParams, ${model?cap_first}OneParams,
                                ${model?cap_first}AddParams, ${model?cap_first}UpdateParams, ${model?cap_first}DeleteParams>
                                implements ${model?cap_first}ServiceI {



}
