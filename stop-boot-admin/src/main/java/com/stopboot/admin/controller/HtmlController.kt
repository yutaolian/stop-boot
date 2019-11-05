package com.stopboot.admin.controller

import com.stopboot.admin.model.test.one.Test2OneParams
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody

/**
 * @version:0.0.1
 * @author: Lianyutao
 * @create: 2019-11-05 10:02
 * @description:
 **/

@Controller
class HtmlController {

    @ResponseBody
    @GetMapping("/blog")
    fun blog(@RequestBody params: Test2OneParams): String {

        return "blog"
    }

}
