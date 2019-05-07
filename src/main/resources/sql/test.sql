/*
 Navicat Premium Data Transfer

 Source Server         : bj测试
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 188.131.144.112
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : utf-8

 Date: 04/24/2019 15:50:44 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `log_info`
-- ----------------------------
DROP TABLE IF EXISTS `log_info`;
CREATE TABLE `log_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `val` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) TYPE=InnoDB AUTO_INCREMENT=4;

-- ----------------------------
--  Records of `log_info`
-- ----------------------------
BEGIN;
INSERT INTO `log_info` VALUES ('1', '111'), ('2', '111'), ('3', '111');
COMMIT;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) TYPE=InnoDB;

SET FOREIGN_KEY_CHECKS = 1;
