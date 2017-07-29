/*
Navicat MySQL Data Transfer

Source Server         : 啊哈哈
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_check

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-29 16:03:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_administer`
-- ----------------------------
DROP TABLE IF EXISTS `t_administer`;
CREATE TABLE `t_administer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户表ID',
  `department_id` int(11) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管辖分配表';

-- ----------------------------
-- Records of t_administer
-- ----------------------------

-- ----------------------------
-- Table structure for `t_department`
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `is_deleted` tinyint(3) DEFAULT '1' COMMENT '是否删除 1可用 2删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------

-- ----------------------------
-- Table structure for `t_power`
-- ----------------------------
DROP TABLE IF EXISTS `t_power`;
CREATE TABLE `t_power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '权限名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_power
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `power_id` int(11) DEFAULT NULL COMMENT '权限表ID',
  `is_deleted` tinyint(3) DEFAULT '1' COMMENT '1可用 2删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_stuff`
-- ----------------------------
DROP TABLE IF EXISTS `t_stuff`;
CREATE TABLE `t_stuff` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `department_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `is_join_check` tinyint(3) DEFAULT NULL COMMENT '是否考核他人 0-否 1-是',
  `is_be_checked` tinyint(3) DEFAULT NULL COMMENT '是否被考核 0-否 1-是',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `status` tinyint(3) DEFAULT '0' COMMENT '审核状态 0未审核 1审核通过 2审核未通过',
  `is_deleted` tinyint(3) DEFAULT '1' COMMENT '是否删除 1可用 2删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stuff
-- ----------------------------

-- ----------------------------
-- Table structure for `t_test_plan`
-- ----------------------------
DROP TABLE IF EXISTS `t_test_plan`;
CREATE TABLE `t_test_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '考核表ID',
  `test_type_id` int(11) DEFAULT NULL COMMENT '考核类型表ID',
  `start_time` varchar(100) DEFAULT NULL COMMENT '开始时间',
  `finish_time` varchar(100) DEFAULT NULL COMMENT '结束时间',
  `test_name` varchar(100) DEFAULT NULL COMMENT '测评名字',
  `is_available` int(3) DEFAULT '1' COMMENT '是否可用 1可用 2删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_test_plan
-- ----------------------------

-- ----------------------------
-- Table structure for `t_test_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_test_type`;
CREATE TABLE `t_test_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '考核类型名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_test_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_work_plan`
-- ----------------------------
DROP TABLE IF EXISTS `t_work_plan`;
CREATE TABLE `t_work_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `be_checked_user_id` int(11) DEFAULT NULL COMMENT '被考核用户表',
  `check_user_id` int(11) DEFAULT NULL COMMENT '考核人员ID',
  `year` varchar(5) DEFAULT NULL,
  `month` varchar(5) DEFAULT NULL,
  `month_score` int(11) DEFAULT NULL COMMENT '月度得分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_work_plan
-- ----------------------------
