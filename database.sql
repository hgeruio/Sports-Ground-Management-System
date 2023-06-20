/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50731 (5.7.31)
 Source Host           : 127.0.0.1:3308
 Source Schema         : database

 Target Server Type    : MySQL
 Target Server Version : 50731 (5.7.31)
 File Encoding         : 65001

 Date: 01/06/2023 23:07:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alembic_version
-- ----------------------------
DROP TABLE IF EXISTS `alembic_version`;
CREATE TABLE `alembic_version`  (
  `version_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`version_num`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of alembic_version
-- ----------------------------
INSERT INTO `alembic_version` VALUES ('e1c934d51906');

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `area_range` float NULL DEFAULT NULL,
  `number` int(10) NULL DEFAULT NULL,
  `money` float NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 9 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES (1, '羽毛球场', 175.74, 5, 60);
INSERT INTO `area` VALUES (2, '乒乓球场', 175.74, 5, 40);
INSERT INTO `area` VALUES (3, '篮球场', 608, 2, 65);

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data`  (
  `id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `area_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fellow` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` float NULL DEFAULT NULL,
  `time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `end_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 64 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of data
-- ----------------------------
INSERT INTO `data` VALUES (1, '张三', '18652369512', '乒乓球场', '否', 40, '1', '2023-04-24 08:31:05');
INSERT INTO `data` VALUES (2, '李四', '18953264256', '羽毛球场', '否', 60, '1', '2023-04-24 08:31:42');
INSERT INTO `data` VALUES (3, '王五', '19854623562', '乒乓球场', '否', 40, '1', '2023-04-25 08:21:29');
INSERT INTO `data` VALUES (4, '赵六', '15632568452', '羽毛球场', '否', 60, '1', '2023-04-25 08:17:32');
INSERT INTO `data` VALUES (5, 'chen', '19862420255', '乒乓球场', '是', 40, '1', '2023-04-25 08:18:11');
INSERT INTO `data` VALUES (6, '小红', '13345678912', '乒乓球场', '否', 32, '1', '2023-04-25 08:19:15');

-- ----------------------------
-- Table structure for fellow
-- ----------------------------
DROP TABLE IF EXISTS `fellow`;
CREATE TABLE `fellow`  (
  `id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `fellow_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `fellow_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `fellow_sex` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci NULL DEFAULT NULL,
  `fellow_date` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_croatian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fellow
-- ----------------------------
INSERT INTO `fellow` VALUES (1, 'chen', '19862420255', '男', '2023-01-19 17:20:19');
INSERT INTO `fellow` VALUES (2, '小红', '19812345678', '女', '2023-06-01 23:06:34');
INSERT INTO `fellow` VALUES (3, '小明', '19123456789', '男', '2023-06-01 23:06:31');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_admin` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'a123456', '123456@123.com', '管理员');
INSERT INTO `user` VALUES (2, 'faefa', '123456', 'fea@e.ea', '管理员');
INSERT INTO `user` VALUES (3, 'root', '123456', '123@qq.com', '普通员工');

SET FOREIGN_KEY_CHECKS = 1;
