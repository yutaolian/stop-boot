package com.stopboot.admin.controller.generator;

import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsParams;
import com.stopboot.admin.model.help.datasource.table.columns.TableColumnsVO;
import com.stopboot.admin.model.help.datasource.table.list.TableListVO;
import com.stopboot.admin.model.help.generator.dowm.GeneratorParams;
import com.stopboot.admin.model.help.generator.dowm.GeneratorVO;
import com.stopboot.admin.model.help.generator.pre.GeneratorPreParams;
import com.stopboot.admin.model.help.generator.pre.GeneratorPreVO;
import com.stopboot.admin.service.generator.SbGeneratorServiceI;
import com.stopboot.admin.service.help.datasource.SbDataSourceServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-16 16:32
 * @version:
 **/


@Slf4j
@RestController
@RequestMapping("generator")
public class SbGeneratorController {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Resource
    private SbGeneratorServiceI generatorService;

    /**
     * 生成代码加载基本信息
     *
     * @return
     */
    @PostMapping("pre")
    public ResultData<GeneratorPreVO> pre(@RequestBody GeneratorPreParams params) {
        ResultData resultData = ResultData.build();
        GeneratorPreVO vo = generatorService.pre(params);
        if (!ObjectUtils.isEmpty(vo)) {
            resultData.success().setData(vo);
        } else {
            resultData.empty();
        }
        return resultData;
    }


    /**
     * 调用生成代码接口生成前端，后端的全部代码的zip包下载地址
     *
     * @return
     */
    @PostMapping("done")
    public ResultData<GeneratorVO> done(GeneratorParams params) {
        ResultData resultData = ResultData.build();
        GeneratorVO vo = generatorService.done(params);
        if (!ObjectUtils.isEmpty(vo)) {
            resultData.success().setData(vo);
        } else {
            resultData.empty();
        }
        return resultData;
    }

    @PostMapping("mapping")
    public ResultData mapping() {
        ResultData resultData = ResultData.build();
        List<HashMap<String, String>> urlList = new ArrayList<HashMap<String, String>>();

        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            RequestMappingInfo info = m.getKey();
            HandlerMethod method = m.getValue();
            PatternsRequestCondition p = info.getPatternsCondition();
            for (String url : p.getPatterns()) {
                hashMap.put("url", url);
            }
            hashMap.put("className", method.getMethod().getDeclaringClass().getName()); // 类名
            hashMap.put("method", method.getMethod().getName()); // 方法名
            RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
            String type = methodsCondition.toString();
            if (type != null && type.startsWith("[") && type.endsWith("]")) {
                type = type.substring(1, type.length() - 1);
                hashMap.put("type", type); // 方法名
            }
            urlList.add(hashMap);
        }
        return resultData.success(urlList);
    }


    /**
     * 获得数据库的全部表名
     *
     * @return
     */
    @PostMapping("table/list")
    public ResultData<TableListVO> tableList() {
        ResultData resultData = ResultData.build();
        List<TableListVO> list = generatorService.getTableList();
        if (!ObjectUtils.isEmpty(list)) {
            resultData.success().setData(list);
        } else {
            resultData.empty();
        }
        return resultData;
    }


    /**
     * 根据表名获得表的全部字段
     *
     * @param params
     * @return
     */
    @PostMapping("table/columns")
    public ResultData<TableColumnsVO> tableColumns(@RequestBody TableColumnsParams params) {
        ResultData resultData = ResultData.build();
        List<TableColumnsVO> list = generatorService.getTableColumns(params);
        if (!ObjectUtils.isEmpty(list)) {
            resultData.success().setData(list);
        } else {
            resultData.empty();
        }
        return resultData;
    }




}
