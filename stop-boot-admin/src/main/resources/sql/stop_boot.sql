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

 Date: 18/10/2019 19:33:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sb_admin
-- ----------------------------
DROP TABLE IF EXISTS `sb_admin`;
CREATE TABLE `sb_admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `status` int(1) DEFAULT NULL COMMENT '状态（1正常使用，0不使用）',
  `delete_flag` int(1) DEFAULT NULL COMMENT '删除标识（0删除，1未删除）',
  `op_user_id` int(11) DEFAULT NULL COMMENT '操作者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员表';

-- ----------------------------
-- Records of sb_admin
-- ----------------------------
BEGIN;
INSERT INTO `sb_admin` VALUES (1, 'admin', '13716151311', '123123', '675376983@qq.com', 1, 1, NULL, '2019-10-12 14:59:28', '2019-10-12 14:59:31');
INSERT INTO `sb_admin` VALUES (2, 'admin2', '13716151312', '123123', '675376983@qq.com', 1, 1, NULL, '2019-10-12 14:59:28', '2019-10-12 14:59:31');
COMMIT;

-- ----------------------------
-- Table structure for sb_admin_config
-- ----------------------------
DROP TABLE IF EXISTS `sb_admin_config`;
CREATE TABLE `sb_admin_config` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `ui_config` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT 'Ui配置json',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理配置管理表';

-- ----------------------------
-- Table structure for sb_admin_roles
-- ----------------------------
DROP TABLE IF EXISTS `sb_admin_roles`;
CREATE TABLE `sb_admin_roles` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员角色表';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='组织表';

-- ----------------------------
-- Table structure for sb_dept_admin
-- ----------------------------
DROP TABLE IF EXISTS `sb_dept_admin`;
CREATE TABLE `sb_dept_admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员与组织绑定关系表';

-- ----------------------------
-- Table structure for sb_menu
-- ----------------------------
DROP TABLE IF EXISTS `sb_menu`;
CREATE TABLE `sb_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL COMMENT '父id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单名称(显示名字)',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `component` varchar(255) DEFAULT NULL COMMENT '组件名称',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单点击路径',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'icon',
  `type` int(3) DEFAULT NULL COMMENT '类型 （1内部菜单，-1外部链接）',
  `link` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '链接地址',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单编码',
  `hidden` int(1) DEFAULT NULL COMMENT '是否显示 1 显示 0 隐藏',
  `status` int(2) DEFAULT NULL COMMENT '状态（1正常使用，0不使用）',
  `sort` int(2) DEFAULT NULL COMMENT '排序按从小到大排序（0最靠前）',
  `delete_flag` int(2) DEFAULT NULL COMMENT '删除标识（0删除，1正常）',
  `op_user_id` int(11) DEFAULT NULL COMMENT '操作者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单表';

-- ----------------------------
-- Records of sb_menu
-- ----------------------------
BEGIN;
INSERT INTO `sb_menu` VALUES (1, 0, 'root', '', '', '', '', 1, NULL, NULL, 1, 1, 0, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (2, 1, '首页', 'dashboard', 'views/dashboard/index', '/dashboard', 'index', 1, NULL, NULL, 0, 1, 101, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (3, 1, '用户管理', 'user', 'Layout', '/user', 'index', 1, NULL, '1568953352873', 0, 1, 104, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (4, 1, '课程管理', 'course', 'Layout', '/course', 'index', 1, NULL, NULL, 0, 1, 103, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (6, 3, '角色管理', 'userRole', 'views/user/role', 'role', 'index', 1, NULL, NULL, 0, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (7, 3, '个人中心1', 'userCenter', 'views/user/center', 'center', 'index', 1, NULL, NULL, 0, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (8, 4, '课程列表', 'courseList', 'views/course/list', 'list', 'index', 1, NULL, NULL, 0, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (9, 4, '课程详情', 'courseDetail', 'views/course/detail', 'detail', 'index', 1, NULL, NULL, 1, 1, 1, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (10, 1, '系统管理', 'system', 'Layout', '/system', 'index', 1, NULL, NULL, 0, 1, 103, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (11, 10, '菜单管理', 'menu', 'views/system/menu', 'menu', 'index', 1, NULL, NULL, 0, 1, 1001, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (12, 10, '角色管理', 'role', 'views/system/role', 'role', 'index', 1, NULL, NULL, 0, 1, 1003, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (13, 10, '权限管理', 'permission', 'views/system/permission', 'permission', 'index', 1, NULL, NULL, 0, 1, 1005, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (14, 10, '机构管理', 'dept', 'views/system/dept', 'dept', 'index', 1, NULL, NULL, 0, 1, 1002, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (15, 10, '管理员管理', 'admin', 'views/system/admin', 'admin', 'index', 1, NULL, NULL, 0, 1, 1401, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (16, 1, '测试管理', 'test', 'Layout', '/test', 'index', 1, NULL, NULL, 0, 1, 1006, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (17, 16, '测试管理1', 'test1', 'views/test/test1', 'test1', 'index', 1, NULL, NULL, 0, 1, 1007, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (18, 16, '测试管理2', 'test2', 'Empty', 'test2', 'index', 1, NULL, NULL, 0, 1, 1008, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (19, 18, '测试管理21', 'test21', 'Empty', 'test21', 'index', 1, NULL, NULL, 0, 1, 1008, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (20, 18, '测试管理22', 'test22', 'views/test/test2/test22', 'test22', 'index', 1, NULL, NULL, 0, 1, 1008, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (21, 19, '测试管理211', 'test211', 'views/test/test2/test21/test211', 'test211', 'index', 1, NULL, NULL, 0, 1, 1008, 1, NULL, NULL, NULL);
INSERT INTO `sb_menu` VALUES (23, 1, '工具管理', 'utils', 'Layout', '/utils', 'index', 1, NULL, NULL, 0, 1, 2301, 1, NULL, '2019-10-16 06:50:28', '2019-10-16 06:50:28');
INSERT INTO `sb_menu` VALUES (24, 23, '代码管理', 'generator', 'components/Generator', 'generator', 'index', 1, NULL, NULL, 0, 1, 2401, 1, NULL, '2019-10-16 06:50:28', '2019-10-16 06:50:28');
COMMIT;

-- ----------------------------
-- Table structure for sb_permission
-- ----------------------------
DROP TABLE IF EXISTS `sb_permission`;
CREATE TABLE `sb_permission` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `menu_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜单id',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `tag` varchar(255) DEFAULT NULL COMMENT '权限tag',
  `description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `op_user_id` int(11) DEFAULT NULL COMMENT '操作者id',
  `status` int(2) DEFAULT NULL COMMENT '状态（1正常使用，0不使用）',
  `delete_flag` int(2) DEFAULT NULL COMMENT '删除标识（0删除，1未删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限表';

-- ----------------------------
-- Records of sb_permission
-- ----------------------------
BEGIN;
INSERT INTO `sb_permission` VALUES (1, '0-10-11', NULL, 'P_SYSTEM_MENU_ALL', '系统管理菜单管理全部权限', NULL, NULL, NULL, 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for sb_role
-- ----------------------------
DROP TABLE IF EXISTS `sb_role`;
CREATE TABLE `sb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色标签',
  `status` int(2) DEFAULT NULL COMMENT '状态（1正常使用，0不使用）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `op_user_id` int(11) DEFAULT NULL COMMENT '操作者id',
  `delete_flag` int(2) DEFAULT NULL COMMENT '删除标识（0删除，1未删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';

-- ----------------------------
-- Records of sb_role
-- ----------------------------
BEGIN;
INSERT INTO `sb_role` VALUES (1, '超级管理员', '角色超级管理员描述', 'ROLE_SUPER_ADMIN', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1, 1);
INSERT INTO `sb_role` VALUES (2, '高级管理员1', '角色超级管理员描述', 'ROLE_HIGH_ADMIN', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1, 1);
INSERT INTO `sb_role` VALUES (3, '财务', '角色超级管理员描述', 'ROLE_CAIWU', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1, 1);
INSERT INTO `sb_role` VALUES (4, '客服', '角色超级管理员描述', 'ROLE_KEFU', 1, '2019-08-14 15:55:28', '2019-08-14 15:55:32', 1, 1);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色菜单表';

-- ----------------------------
-- Table structure for sb_role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sb_role_permissions`;
CREATE TABLE `sb_role_permissions` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色权限表';

-- ----------------------------
-- Table structure for sb_test
-- ----------------------------
DROP TABLE IF EXISTS `sb_test`;
CREATE TABLE `sb_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `info` text COMMENT '信息',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `head_img` varchar(512) DEFAULT NULL COMMENT '头像',
  `delete_flag` int(1) DEFAULT NULL COMMENT '删除标记（1正常，0删除）',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sb_test
-- ----------------------------
BEGIN;
INSERT INTO `sb_test` VALUES (1, 'test1', 12, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:15');
INSERT INTO `sb_test` VALUES (3, 'test3333334444', 14, '2019-10-08', '2019-10-08 18:51:31', 'ewe', 1, 'https://img.91haoke.com/upload/picture/1555383822537_2734.png', 1, '2019-10-11 11:07:21');
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
COMMIT;

-- ----------------------------
-- Table structure for sb_user
-- ----------------------------
DROP TABLE IF EXISTS `sb_user`;
CREATE TABLE `sb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `info` text COMMENT '信息',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `head_img` varchar(512) DEFAULT NULL COMMENT '头像',
  `delete_flag` int(1) DEFAULT NULL COMMENT '删除标记（1正常，0删除）',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
