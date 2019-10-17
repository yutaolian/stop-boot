package com.stopboot.admin.service.help.generator;

import com.stopboot.admin.model.help.generator.dowm.GeneratorParams;
import com.stopboot.admin.model.help.generator.dowm.GeneratorVO;

public interface SbGeneratorService {

    GeneratorVO done(GeneratorParams params);
}
