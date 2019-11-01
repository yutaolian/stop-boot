package com.stopboot.admin.service.user.list;

import com.stopboot.admin.base.service.DefaultServiceI;
import com.stopboot.admin.model.user.list.add.UserListAddParams;
import com.stopboot.admin.model.user.list.list.UserListListVO;
import com.stopboot.admin.model.user.list.list.UserListListParams;
import com.stopboot.admin.model.user.list.one.UserListOneParams;
import com.stopboot.admin.model.user.list.one.UserListOneVO;
import com.stopboot.admin.model.user.list.page.UserListPageParams;
import com.stopboot.admin.model.user.list.page.UserListPageVO;
import com.stopboot.admin.model.user.list.update.UserListUpdateParams;
import com.stopboot.admin.model.user.list.delete.UserListDeleteParams;


public interface UserListServiceI extends DefaultServiceI<UserListPageVO, UserListListVO, UserListOneVO,
        UserListPageParams, UserListListParams, UserListOneParams,
        UserListAddParams, UserListUpdateParams, UserListDeleteParams> {

}
