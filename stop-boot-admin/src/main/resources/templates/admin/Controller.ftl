package ${basePackage}.controller.${pathToPackage};

import ${basePackage}.base.controller.BaseController;
import ${basePackage}.model${pathToPackage}.add.${model?cap_first}AddParams;
import ${basePackage}.model${pathToPackage}.one.${model?cap_first}OneParams;
import ${basePackage}.model${pathToPackage}.one.${model?cap_first}OneVO;
import ${basePackage}.model${pathToPackage}.page.${model?cap_first}PageParams;
import ${basePackage}.model${pathToPackage}.page.${model?cap_first}PageVO;
import ${basePackage}.model${pathToPackage}.update.${model?cap_first}UpdateParams;
import ${basePackage}.model${pathToPackage}.delete.${model?cap_first}DeleteParams;
import ${basePackage}.service${pathToPackage}.${model?cap_first}ServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: ${author}
 * @create: ${date?string("yyyy/MM/dd HH:mm")}
 * @version: ${version}
 **/

@Slf4j
@RestController
@RequestMapping("${path}")
public class ${model?cap_first}Controller extends BaseController<${model?cap_first}ServiceI,
                ${model?cap_first}PageVO,${model?cap_first}OneVO,
                ${model?cap_first}PageParams, ${model?cap_first}OneParams,
                ${model?cap_first}AddParams, ${model?cap_first}UpdateParams, ${model?cap_first}DeleteParams> {


}
