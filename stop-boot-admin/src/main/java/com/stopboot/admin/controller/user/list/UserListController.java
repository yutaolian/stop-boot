package com.stopboot.admin.controller.user.list;

import com.stopboot.admin.base.controller.DefaultController;
import com.stopboot.admin.model.user.list.add.UserListAddParams;
import com.stopboot.admin.model.user.list.list.UserListListParams;
import com.stopboot.admin.model.user.list.list.UserListListVO;
import com.stopboot.admin.model.user.list.one.UserListOneParams;
import com.stopboot.admin.model.user.list.one.UserListOneVO;
import com.stopboot.admin.model.user.list.page.UserListPageParams;
import com.stopboot.admin.model.user.list.page.UserListPageVO;
import com.stopboot.admin.model.user.list.update.UserListUpdateParams;
import com.stopboot.admin.model.user.list.delete.UserListDeleteParams;
import com.stopboot.admin.service.user.list.UserListServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Lianyutao
 * @create: 2019/11/01 14:59
 * @version: 1.0.1
 **/

@Slf4j
@RestController
@RequestMapping("/user/list")
public class UserListController extends DefaultController<UserListServiceI,
        UserListPageVO,UserListListVO,UserListOneVO,
        UserListPageParams, UserListListParams,  UserListOneParams,
        UserListAddParams, UserListUpdateParams, UserListDeleteParams> {


}
