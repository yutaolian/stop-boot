/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : stop_boot

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 01/11/2019 19:55:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sb_admin
-- ----------------------------
DROP TABLE IF EXISTS `sb_admin`;
CREATE TABLE `sb_admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '姓名',
  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  `status` int(1) DEFAULT NULL COMMENT '状态（1正常使用，0不使用）',
  `delete_flag` int(1) DEFAULT NULL COMMENT '删除标识（0删除，1未删除）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='管理员表';

-- ----------------------------
-- Records of sb_admin
-- ----------------------------
BEGIN;
INSERT INTO `sb_admin` VALUES (1, 'adminddddddd', '13716151311', '123123', '675376983@qq.com', 1, 1, '2019-10-12 14:59:28', '2019-10-12 14:59:31');
INSERT INTO `sb_admin` VALUES (2, 'admin2', '13716151312', '123123', '675376983@qq.com', 1, 1, '2019-10-12 14:59:28', '2019-10-12 14:59:31');
INSERT INTO `sb_admin` VALUES (3, 'ad', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sb_admin_config
-- ----------------------------
DROP TABLE IF EXISTS `sb_admin_config`;
CREATE TABLE `sb_admin_config` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `ui_config` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT 'Ui配置json',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='管理配置管理表';

-- ----------------------------
-- Table structure for sb_admin_roles
-- ----------------------------
DROP TABLE IF EXISTS `sb_admin_roles`;
CREATE TABLE `sb_admin_roles` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `admin_id` int(20) NOT NULL COMMENT '管理员ID',
  `role_id` int(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='管理员角色表';

-- ----------------------------
-- Records of sb_admin_roles
-- ----------------------------
BEGIN;
INSERT INTO `sb_admin_roles` VALUES (1, 1, 1);
INSERT INTO `sb_admin_roles` VALUES (2, 1, 2);
COMMIT;

-- ----------------------------
-- Table structure for sb_dept
-- ----------------------------
DROP TABLE IF EXISTS `sb_dept`;
CREATE TABLE `sb_dept` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `op_user_id` int(11) DEFAULT NULL COMMENT '操作者id',
  `status` int(2) DEFAULT NULL COMMENT '状态（1正常使用，0不使用）',
  `delete_flag` int(2) DEFAULT NULL COMMENT '删除标识（0删除，1未删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='组织表';

-- ----------------------------
-- Records of sb_dept
-- ----------------------------
BEGIN;
INSERT INTO `sb_dept` VALUES (1, '2019-10-25 12:19:11', '2019-10-25 12:19:15', 1, 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for sb_dept_admin
-- ----------------------------
DROP TABLE IF EXISTS `sb_dept_admin`;
CREATE TABLE `sb_dept_admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='管理员与组织绑定关系表';

-- ----------------------------
-- Table structure for sb_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sb_dictionary`;
CREATE TABLE `sb_dictionary` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `dic_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典key',
  `dic_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典值',
  `dic_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典描述',
  `status` int(2) DEFAULT NULL COMMENT '状态1激活，0冻结',
  `delete_flag` int(2) DEFAULT NULL COMMENT '删除标识（1正常，0删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for sb_menu
-- ----------------------------
DROP TABLE IF EXISTS `sb_menu`;
CREATE TABLE `sb_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `pid` int(11) DEFAULT NULL COMMENT '父id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单名称(显示名字)',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单名称',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '组件名称',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单点击路径',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'icon',
  `type` int(3) DEFAULT NULL COMMENT '类型 （1内部菜单，-1外部链接）',
  `link` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '链接地址',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单编码',
  `hidden` int(1) DEFAULT NULL COMMENT '是否显示 1 显示 0 隐藏',
  `status` int(2) DEFAULT NULL COMMENT '状态（1正常使用，0不使用）',
  `sort` int(2) DEFAULT NULL COMMENT '排序按从小到大排序（0最靠前）',
  `delete_flag` int(2) DEFAULT NULL COMMENT '删除标识（0删除，1正常）',
  `op_user_id` int(11) DEFAULT NULL COMMENT '操作者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='菜单表';

-- ----------------------------
-- Records of sb_menu
-- ----------------------------
BEGIN;
INSERT INTO `sb_menu` VALUES (1, 0, 'root', '', '', '', '', 1, NULL, NULL, 1, 1, 0, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (2, 1, '首页', 'dashboard', 'views/dashboard', '/dashboard', 'index', 1, NULL, NULL, 0, 1, 101, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (3, 1, '用户管理', 'user', 'Layout', '/user', 'index', 1, NULL, '1568953352873', 0, 1, 104, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (4, 1, '课程管理', 'course', 'Layout', '/course', 'index', 1, NULL, NULL, 0, 1, 103, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (6, 3, '用户列表', 'userList', 'views/user/list', 'list', 'index', 1, NULL, NULL, 0, 1, 301, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (7, 3, '个人中心1', 'userCenter', 'views/user/center', 'center', 'index', 1, NULL, NULL, 0, 1, 302, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (8, 4, '课程列表', 'courseList', 'views/course/list', 'list', 'index', 1, NULL, NULL, 0, 1, 401, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (9, 4, '课程详情', 'courseDetail', 'views/course/detail', 'detail', 'index', 1, NULL, NULL, 1, 1, 402, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (10, 1, '系统管理', 'system', 'Layout', '/system', 'index', 1, NULL, NULL, 0, 1, 103, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (11, 10, '菜单管理', 'menu', 'views/system/menu', 'menu', 'index', 1, NULL, NULL, 0, 1, 1001, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (12, 10, '角色管理', 'role', 'views/system/role', 'role', 'index', 1, NULL, NULL, 0, 1, 1003, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (13, 10, '权限管理', 'permission', 'views/system/permission', 'permission', 'index', 1, NULL, NULL, 0, 1, 1002, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (14, 10, '机构管理', 'dept', 'views/system/dept', 'dept', 'index', 1, NULL, NULL, 0, 1, 1005, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (15, 10, '管理员管理', 'admin', 'views/system/admin', 'admin', 'index', 1, NULL, NULL, 0, 1, 1004, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (16, 1, '测试管理', 'test', 'Layout', '/test', 'index', 1, NULL, NULL, 0, 1, 105, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (17, 16, '测试管理1', 'test1', 'views/test/test1', 'test1', 'index', 1, NULL, NULL, 0, 1, 1601, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (18, 16, '测试管理2', 'test2', 'Empty', 'test2', 'index', 1, NULL, NULL, 0, 1, 1602, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (19, 18, '测试管理21', 'test21', 'Empty', 'test21', 'index', 1, NULL, NULL, 0, 1, 801, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (20, 18, '测试管理22', 'test22', 'views/test/test2/test22', 'test22', 'index', 1, NULL, NULL, 0, 1, 1802, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (21, 19, '测试管理211', 'test211', 'views/test/test2/test21/test211', 'test211', 'index', 1, NULL, NULL, 0, 1, 1901, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (23, 1, '工具管理', 'utils', 'Layout', '/utils', 'index', 1, NULL, NULL, 0, 1, 106, 1, NULL, '2019-10-16 06:50:28', '2019-10-16 06:50:28');
INSERT INTO `sb_menu` VALUES (24, 23, '代码管理', 'generator', 'views/generator', 'generator', 'index', 1, NULL, NULL, 0, 1, 2301, 1, NULL, '2019-10-16 06:50:28', '2019-10-16 06:50:28');
INSERT INTO `sb_menu` VALUES (25, 10, '字典表管理', 'dictionary', 'views/system/dictionary', 'dictionary', 'dictionary', 1, NULL, NULL, 0, 1, 1009, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (33, 16, '测试菜单3', 'test3', 'views/test/test1', 'test3', 'test3', 1, NULL, NULL, 0, 1, 1603, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (34, 16, '测试菜单4', 'test4', 'views/test/test4', 'test4', 'test4', 1, NULL, NULL, 0, 1, 1604, 1, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sb_menu_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sb_menu_permissions`;
CREATE TABLE `sb_menu_permissions` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `menu_id` int(255) DEFAULT NULL COMMENT '菜单id',
  `tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限tag',
  `tag_desc` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限tag描述',
  `tag_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限tag名称',
  `url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '接口地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='权限表';

-- ----------------------------
-- Records of sb_menu_permissions
-- ----------------------------
BEGIN;
INSERT INTO `sb_menu_permissions` VALUES (26, 2, 'P_DASHBOARD_ADD', 'asdfsfd', '首页_添加', NULL);
INSERT INTO `sb_menu_permissions` VALUES (28, 2, 'P_DASHBOARD_UPDATE', '首页修改按钮', '首页_修改', NULL);
INSERT INTO `sb_menu_permissions` VALUES (29, 17, 'P_TEST_TEST1_ADD', '测试管理1添加按钮', '测试管理1_添加', NULL);
INSERT INTO `sb_menu_permissions` VALUES (30, 17, 'P_TEST_TEST1_DELETE', '测试管理1_删除按钮', '测试管理1_删除', NULL);
INSERT INTO `sb_menu_permissions` VALUES (31, 15, 'P_SYSTEM_ADMIN_ADD', '管理员管理添加按钮', '管理员管理_添加', NULL);
INSERT INTO `sb_menu_permissions` VALUES (32, 15, 'P_SYSTEM_ADMIN_DELETE', '管理员管理删除按钮', '管理员管理_删除', NULL);
INSERT INTO `sb_menu_permissions` VALUES (33, 8, 'P_COURSE_LIST_ADD', 'asdfasdf', '课程列表_新增', '/course/list/add');
INSERT INTO `sb_menu_permissions` VALUES (34, 8, 'P_COURSE_LIST_UPDATE', '课程列表_更新', '课程列表_更新', '/course/list/update');
INSERT INTO `sb_menu_permissions` VALUES (77, 6, 'P_USER_LIST_PAGE', '默认生成用户列表_page权限标签', '用户列表_分页', '/user/list/page');
INSERT INTO `sb_menu_permissions` VALUES (78, 6, 'P_USER_LIST_LIST', '默认生成用户列表_list权限标签', '用户列表_列表', '/user/list/list');
INSERT INTO `sb_menu_permissions` VALUES (79, 6, 'P_USER_LIST_ONE', '默认生成用户列表_one权限标签', '用户列表_详情', '/user/list/one');
INSERT INTO `sb_menu_permissions` VALUES (80, 6, 'P_USER_LIST_ADD', '默认生成用户列表_add权限标签', '用户列表_添加', '/user/list/add');
INSERT INTO `sb_menu_permissions` VALUES (81, 6, 'P_USER_LIST_UPDATE', '默认生成用户列表_update权限标签', '用户列表_修改', '/user/list/update');
INSERT INTO `sb_menu_permissions` VALUES (82, 6, 'P_USER_LIST_DELETE', '默认生成用户列表_delete权限标签', '用户列表_删除', '/user/list/delete');
INSERT INTO `sb_menu_permissions` VALUES (83, 11, 'P_SYSTEM_MENU_PAGE', '默认生成菜单管理_page权限标签', '菜单管理_分页', '/system/menu/page');
INSERT INTO `sb_menu_permissions` VALUES (84, 11, 'P_SYSTEM_MENU_LIST', '默认生成菜单管理_list权限标签', '菜单管理_列表', '/system/menu/list');
INSERT INTO `sb_menu_permissions` VALUES (85, 11, 'P_SYSTEM_MENU_ONE', '默认生成菜单管理_one权限标签', '菜单管理_详情', '/system/menu/one');
INSERT INTO `sb_menu_permissions` VALUES (86, 11, 'P_SYSTEM_MENU_ADD', '默认生成菜单管理_add权限标签', '菜单管理_添加', '/system/menu/add');
INSERT INTO `sb_menu_permissions` VALUES (87, 11, 'P_SYSTEM_MENU_UPDATE', '默认生成菜单管理_update权限标签', '菜单管理_修改', '/system/menu/update');
INSERT INTO `sb_menu_permissions` VALUES (88, 11, 'P_SYSTEM_MENU_DELETE', '默认生成菜单管理_delete权限标签', '菜单管理_删除', '/system/menu/delete');
INSERT INTO `sb_menu_permissions` VALUES (89, 20, 'P_TEST_TEST2_TEST22_PAGE', '默认生成测试管理22_page权限标签', '测试管理22_分页', '/test/test2/test22/page');
INSERT INTO `sb_menu_permissions` VALUES (90, 20, 'P_TEST_TEST2_TEST22_LIST', '默认生成测试管理22_list权限标签', '测试管理22_列表', '/test/test2/test22/list');
INSERT INTO `sb_menu_permissions` VALUES (91, 20, 'P_TEST_TEST2_TEST22_ONE', '默认生成测试管理22_one权限标签', '测试管理22_详情', '/test/test2/test22/one');
INSERT INTO `sb_menu_permissions` VALUES (92, 20, 'P_TEST_TEST2_TEST22_ADD', '默认生成测试管理22_add权限标签', '测试管理22_添加', '/test/test2/test22/add');
INSERT INTO `sb_menu_permissions` VALUES (93, 20, 'P_TEST_TEST2_TEST22_UPDATE', '默认生成测试管理22_update权限标签', '测试管理22_修改', '/test/test2/test22/update');
INSERT INTO `sb_menu_permissions` VALUES (94, 20, 'P_TEST_TEST2_TEST22_DELETE', '默认生成测试管理22_delete权限标签', '测试管理22_删除', '/test/test2/test22/delete');
INSERT INTO `sb_menu_permissions` VALUES (101, 34, 'P_TEST_TEST4_PAGE', '默认生成测试菜单4_page权限标签', '测试菜单4_分页', '/test/test4/page');
INSERT INTO `sb_menu_permissions` VALUES (102, 34, 'P_TEST_TEST4_LIST', '默认生成测试菜单4_list权限标签', '测试菜单4_列表', '/test/test4/list');
INSERT INTO `sb_menu_permissions` VALUES (103, 34, 'P_TEST_TEST4_ONE', '默认生成测试菜单4_one权限标签', '测试菜单4_详情', '/test/test4/one');
INSERT INTO `sb_menu_permissions` VALUES (104, 34, 'P_TEST_TEST4_ADD', '默认生成测试菜单4_add权限标签', '测试菜单4_添加', '/test/test4/add');
INSERT INTO `sb_menu_permissions` VALUES (105, 34, 'P_TEST_TEST4_UPDATE', '默认生成测试菜单4_update权限标签', '测试菜单4_修改', '/test/test4/update');
INSERT INTO `sb_menu_permissions` VALUES (106, 34, 'P_TEST_TEST4_DELETE', '默认生成测试菜单4_delete权限标签', '测试菜单4_删除', '/test/test4/delete');
COMMIT;

-- ----------------------------
-- Table structure for sb_role
-- ----------------------------
DROP TABLE IF EXISTS `sb_role`;
CREATE TABLE `sb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `tag` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色标签',
  `status` int(2) DEFAULT NULL COMMENT '状态（1正常使用，0不使用）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_flag` int(2) DEFAULT NULL COMMENT '删除标识（0删除，1未删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色表';

-- ----------------------------
-- Records of sb_role
-- ----------------------------
BEGIN;
INSERT INTO `sb_role` VALUES (1, '超级管理员', '角色超级管理员描述', 'R_SUPER_ADMIN', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1);
INSERT INTO `sb_role` VALUES (2, '高级管理员1', '角色超级管理员描述', 'R_HIGH_ADMIN', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1);
INSERT INTO `sb_role` VALUES (3, '财务', '角色超级管理员描述', 'R_CAIWU', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1);
INSERT INTO `sb_role` VALUES (4, '客服', '角色超级管理员描述', 'R_KEFU', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1);
INSERT INTO `sb_role` VALUES (5, '客服2', '角色超级管理员描述', 'ROLE_KEFU', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1);
INSERT INTO `sb_role` VALUES (6, '客服3', '角色超级管理员描述', 'ROLE_KEFU', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1);
INSERT INTO `sb_role` VALUES (7, '客服4', '角色超级管理员描述', 'ROLE_KEFU', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1);
INSERT INTO `sb_role` VALUES (8, '客服5', '角色超级管理员描述', 'ROLE_KEFU', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1);
INSERT INTO `sb_role` VALUES (9, '客服6', '角色超级管理员描述', 'ROLE_KEFU', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1);
INSERT INTO `sb_role` VALUES (12, '客服9', '角色超级管理员描述', 'ROLE_KEFU', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1);
INSERT INTO `sb_role` VALUES (13, '客服10', '角色超级管理员描述', 'ROLE_KEFU', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1);
COMMIT;

-- ----------------------------
-- Table structure for sb_role_menu_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sb_role_menu_permissions`;
CREATE TABLE `sb_role_menu_permissions` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(20) DEFAULT NULL COMMENT '角色ID',
  `menu_permission_id` int(20) DEFAULT NULL COMMENT '权限Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=400 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色权限表';

-- ----------------------------
-- Records of sb_role_menu_permissions
-- ----------------------------
BEGIN;
INSERT INTO `sb_role_menu_permissions` VALUES (375, 1, 26);
INSERT INTO `sb_role_menu_permissions` VALUES (376, 1, 28);
INSERT INTO `sb_role_menu_permissions` VALUES (377, 1, 29);
INSERT INTO `sb_role_menu_permissions` VALUES (378, 1, 30);
INSERT INTO `sb_role_menu_permissions` VALUES (379, 1, 32);
INSERT INTO `sb_role_menu_permissions` VALUES (380, 1, 31);
INSERT INTO `sb_role_menu_permissions` VALUES (381, 1, 47);
INSERT INTO `sb_role_menu_permissions` VALUES (382, 1, 77);
INSERT INTO `sb_role_menu_permissions` VALUES (383, 1, 83);
INSERT INTO `sb_role_menu_permissions` VALUES (384, 1, 84);
INSERT INTO `sb_role_menu_permissions` VALUES (385, 1, 85);
INSERT INTO `sb_role_menu_permissions` VALUES (386, 1, 86);
INSERT INTO `sb_role_menu_permissions` VALUES (387, 1, 87);
INSERT INTO `sb_role_menu_permissions` VALUES (388, 1, 88);
INSERT INTO `sb_role_menu_permissions` VALUES (389, 1, 89);
INSERT INTO `sb_role_menu_permissions` VALUES (390, 1, 91);
INSERT INTO `sb_role_menu_permissions` VALUES (391, 1, 90);
INSERT INTO `sb_role_menu_permissions` VALUES (392, 1, 92);
INSERT INTO `sb_role_menu_permissions` VALUES (393, 1, 93);
INSERT INTO `sb_role_menu_permissions` VALUES (394, 1, 94);
INSERT INTO `sb_role_menu_permissions` VALUES (395, 1, 101);
INSERT INTO `sb_role_menu_permissions` VALUES (396, 1, 103);
INSERT INTO `sb_role_menu_permissions` VALUES (397, 1, 104);
INSERT INTO `sb_role_menu_permissions` VALUES (398, 1, 106);
INSERT INTO `sb_role_menu_permissions` VALUES (399, 1, 105);
COMMIT;

-- ----------------------------
-- Table structure for sb_role_menus
-- ----------------------------
DROP TABLE IF EXISTS `sb_role_menus`;
CREATE TABLE `sb_role_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rold_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=442 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色菜单表';

-- ----------------------------
-- Records of sb_role_menus
-- ----------------------------
BEGIN;
INSERT INTO `sb_role_menus` VALUES (48, 3, 8);
INSERT INTO `sb_role_menus` VALUES (49, 3, 9);
INSERT INTO `sb_role_menus` VALUES (53, 3, 15);
INSERT INTO `sb_role_menus` VALUES (54, 3, 14);
INSERT INTO `sb_role_menus` VALUES (55, 3, 25);
INSERT INTO `sb_role_menus` VALUES (56, 4, 8);
INSERT INTO `sb_role_menus` VALUES (57, 4, 9);
INSERT INTO `sb_role_menus` VALUES (58, 2, 11);
INSERT INTO `sb_role_menus` VALUES (425, 1, 2);
INSERT INTO `sb_role_menus` VALUES (426, 1, 8);
INSERT INTO `sb_role_menus` VALUES (427, 1, 9);
INSERT INTO `sb_role_menus` VALUES (428, 1, 11);
INSERT INTO `sb_role_menus` VALUES (429, 1, 13);
INSERT INTO `sb_role_menus` VALUES (430, 1, 12);
INSERT INTO `sb_role_menus` VALUES (431, 1, 15);
INSERT INTO `sb_role_menus` VALUES (432, 1, 14);
INSERT INTO `sb_role_menus` VALUES (433, 1, 25);
INSERT INTO `sb_role_menus` VALUES (434, 1, 6);
INSERT INTO `sb_role_menus` VALUES (435, 1, 7);
INSERT INTO `sb_role_menus` VALUES (436, 1, 17);
INSERT INTO `sb_role_menus` VALUES (437, 1, 21);
INSERT INTO `sb_role_menus` VALUES (438, 1, 20);
INSERT INTO `sb_role_menus` VALUES (439, 1, 33);
INSERT INTO `sb_role_menus` VALUES (440, 1, 34);
INSERT INTO `sb_role_menus` VALUES (441, 1, 24);
COMMIT;

-- ----------------------------
-- Table structure for sb_test
-- ----------------------------
DROP TABLE IF EXISTS `sb_test`;
CREATE TABLE `sb_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `info` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '信息',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `head_img` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像',
  `delete_flag` int(1) DEFAULT NULL COMMENT '删除标记（1正常，0删除）',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of sb_test
-- ----------------------------
BEGIN;
INSERT INTO `sb_test` VALUES (1, 'test1', 12, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:15');
INSERT INTO `sb_test` VALUES (4, 'test4', 14, '2019-10-03', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (5, 'test5', 54, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (6, 'test6', 22, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (7, 'test7', 24, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (8, 'test8', 55, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (9, 'test9', 22, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (10, 'test10', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (11, 'test11', 66, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (12, 'test12', 73, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (13, 'test13', 32, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (14, 'test14', 3, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (15, 'test15', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (16, 'test16', 6, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (17, 'test17', 8, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (18, 'test18', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (19, 'test19', 9, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (20, 'test20', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (21, 'test21', 1, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (22, 'test22', 11, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (23, 'test23', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (24, 'test24', 12, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (25, 'test25', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (26, 'test26', 16, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test` VALUES (29, '呜呜呜呜', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sb_test` VALUES (31, '2223333', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sb_test` VALUES (32, 'asdfasdf', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sb_test2
-- ----------------------------
DROP TABLE IF EXISTS `sb_test2`;
CREATE TABLE `sb_test2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `age` bigint(11) DEFAULT NULL COMMENT '年龄',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `info` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '信息',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `head_img` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像',
  `delete_flag` int(1) DEFAULT NULL COMMENT '删除标记（1正常，0删除）',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of sb_test2
-- ----------------------------
BEGIN;
INSERT INTO `sb_test2` VALUES (1, 'test1', 12, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:15');
INSERT INTO `sb_test2` VALUES (3, 'test3333334444', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (4, 'test4', 14, '2019-10-03', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (5, 'test5', 54, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (6, 'test6', 22, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (7, 'test7', 24, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (8, 'test8', 55, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (9, 'test9', 22, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (10, 'test10', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (11, 'test11', 66, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (12, 'test12', 73, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (13, 'test13', 32, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (14, 'test14', 3, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (15, 'test15', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (16, 'test16', 6, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (17, 'test17', 8, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (18, 'test18', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (19, 'test19', 9, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (20, 'test20', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (21, 'test21', 1, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (22, 'test22', 11, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (23, 'test23', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (24, 'test24', 12, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (25, 'test25', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_test2` VALUES (26, 'test26', 16, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
COMMIT;

-- ----------------------------
-- Table structure for sb_user
-- ----------------------------
DROP TABLE IF EXISTS `sb_user`;
CREATE TABLE `sb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `info` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '信息',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `head_img` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像',
  `delete_flag` int(1) DEFAULT NULL COMMENT '删除标记（1正常，0删除）',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of sb_user
-- ----------------------------
BEGIN;
INSERT INTO `sb_user` VALUES (1, 'test1', 12, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:15');
INSERT INTO `sb_user` VALUES (2, 'test2', 13, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:19');
INSERT INTO `sb_user` VALUES (3, 'test3', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (4, 'test4', 14, '2019-10-03', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (5, 'test5', 54, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (6, 'test6', 22, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (7, 'test7', 24, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (8, 'test8', 55, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (9, 'test9', 22, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (10, 'test10', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (11, 'test11', 66, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (12, 'test12', 73, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (13, 'test13', 32, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (14, 'test14', 3, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (15, 'test15', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (16, 'test16', 6, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (17, 'test17', 8, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (18, 'test18', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (19, 'test19', 9, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (20, 'test20', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (21, 'test21', 1, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (22, 'test22', 11, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (23, 'test23', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (24, 'test24', 12, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (25, 'test25', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
INSERT INTO `sb_user` VALUES (26, 'test26', 16, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1551583487374_2527.png', 1, '2019-10-11 11:07:21');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
