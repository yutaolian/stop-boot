package com.stopboot.admin.service.help.generator;

import com.stopboot.admin.model.help.generator.dowm.DownLoadVO;
import com.stopboot.admin.utils.FreemarkerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


/**
 *
 */
@Slf4j
@Service
public class SbGeneratorServiceImpl implements SbGeneratorService {

    /**
     * 生成代码下载地址
     * <p>
     * 1、使用模板引擎生成各端代码
     * 2.将代码压缩保存到指定路径并返回对应的路径
     *
     * @return
     */
    @Override
    public DownLoadVO downLoad() {
        try {
            //代码片段
            String templatePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            System.out.println("templatePath=========="+templatePath);
            Map<String, Object> map = new HashMap<>(10);
            map.put("name","lyt");
            StringWriter writer = FreemarkerUtil.process("admin/Controller.ftl", map);
            StringBuffer buffer = writer.getBuffer();
            System.out.println("aaaa:"+writer);

        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }
}
