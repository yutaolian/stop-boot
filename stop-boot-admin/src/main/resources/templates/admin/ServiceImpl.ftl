package ${basePackage}.service${fullPathToPackage};

import ${entityMapperPackage}.${tableName?cap_first}Mapper;
import ${entityPackage}.${tableName?cap_first};
import ${entityExamplePackage}.${tableName?cap_first}Example;
import ${basePackage}.base.service.DefaultServiceImpl;
import ${basePackage}.model${fullPathToPackage}.add.${model?cap_first}AddParams;
import ${basePackage}.model${fullPathToPackage}.one.${model?cap_first}OneParams;
import ${basePackage}.model${fullPathToPackage}.one.${model?cap_first}OneVO;
import ${basePackage}.model${fullPathToPackage}.page.${model?cap_first}PageParams;
import ${basePackage}.model${fullPathToPackage}.page.${model?cap_first}PageVO;
import ${basePackage}.model${fullPathToPackage}.update.${model?cap_first}UpdateParams;
import ${basePackage}.model${fullPathToPackage}.delete.${model?cap_first}DeleteParams;
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
public class ${model?cap_first}ServiceImpl extends DefaultServiceImpl<${tableName?cap_first}Mapper, ${tableName?cap_first}, ${tableName?cap_first}Example,
                                ${model?cap_first}PageVO, ${model?cap_first}OneVO,
                                ${model?cap_first}PageParams, ${model?cap_first}OneParams,
                                ${model?cap_first}AddParams, ${model?cap_first}UpdateParams, ${model?cap_first}DeleteParams>
                                implements ${model?cap_first}ServiceI {



}
