/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50561
 Source Host           : localhost:3306
 Source Schema         : db2020

 Target Server Type    : MySQL
 Target Server Version : 50561
 File Encoding         : 65001

 Date: 16/09/2020 16:51:30
*/
create database db2020;
use db2020;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '中文名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别(0男，1女）',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('hufeng', '胡风', 5, 0, '湖北武汉');
INSERT INTO `user` VALUES ('huli', '胡丽否', 20, 1, '湖北十堰');
INSERT INTO `user` VALUES ('zhaoli', '赵丽', 23, 1, '广东深圳');
INSERT INTO `user` VALUES ('lihui', '李慧', 20, 1, '湖北宜昌');

SET FOREIGN_KEY_CHECKS = 1;
