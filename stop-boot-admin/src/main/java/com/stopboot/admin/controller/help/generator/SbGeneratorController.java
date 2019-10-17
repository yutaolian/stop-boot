package com.stopboot.admin.controller.help.generator;

import com.stopboot.admin.common.ResultData;
import com.stopboot.admin.model.help.generator.dowm.DownLoadVO;
import com.stopboot.admin.service.help.generator.SbGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-16 16:32
 * @version:
 **/


@Slf4j
@RestController
@RequestMapping("help/generator")
public class SbGeneratorController {


    @Resource
    private SbGeneratorService generatorService;
    /**
     * 调用生成代码接口生成前端，后端的全部代码的zip包下载地址
     *
     * @return
     */
    @PostMapping("downLoad")
    public ResultData<DownLoadVO> downLoad() {
        ResultData resultData = ResultData.build();
        DownLoadVO vo = generatorService.downLoad();
        if (!ObjectUtils.isEmpty(vo)) {
            resultData.success().setData(vo);
        } else {
            resultData.empty();
        }
        return resultData;
    }



}
