package com.stopboot.admin.model.system.menu.list;

import com.stopboot.admin.base.params.BaseListParams;
import lombok.Data;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/11/01 16:50
 * @version: 1.0.1
 **/

@Data
public class MenuListParams extends BaseListParams{

    /**
     * 用户UID
     *
     */
    private Integer userId;

}
