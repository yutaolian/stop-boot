package com.stopboot.admin.exception;

import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019-10-12 18:25
 * @version:
 **/

@Data
public class BizException extends RuntimeException {

    private String failCode;

    private String failMsg;

    public BizException(String failCode, String failMsg) {
        this.failCode = failCode;
        this.failMsg = failMsg;
    }
}
