/*
 Navicat Premium Data Transfer

 Source Server         : bj测试
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 188.131.144.112
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : utf-8

 Date: 06/04/2019 13:40:02 PM
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
) TYPE=InnoDB AUTO_INCREMENT=42;

-- ----------------------------
--  Records of `log_info`
-- ----------------------------
BEGIN;
INSERT INTO `log_info` VALUES ('1', '111'), ('2', '111'), ('3', '111'), ('4', '111'), ('5', '111'), ('6', '111'), ('7', '111'), ('8', '111'), ('9', '111'), ('10', '111'), ('11', '111'), ('12', '111'), ('13', '111'), ('14', '111'), ('15', '111'), ('16', '111'), ('17', '111'), ('18', '111'), ('19', '111'), ('20', '111'), ('21', '111'), ('22', '111'), ('23', '111'), ('24', '111'), ('25', '111'), ('26', '111'), ('27', '111'), ('28', '111'), ('29', '111'), ('30', '111'), ('31', '111'), ('32', '111'), ('33', '111'), ('34', '111'), ('35', '111'), ('36', '111'), ('37', '111'), ('38', '111'), ('39', '111'), ('40', '111'), ('41', '111');
COMMIT;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_uuid` varchar(70) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `role` int(10) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `last_ip` varchar(255) DEFAULT NULL,
  `last_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) TYPE=InnoDB AUTO_INCREMENT=2 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Records of `user_info`
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES ('1', 'd242ae49-4734-411e-8c8d-d2b09e87c3c8', 'zhengy', '$2a$04$petEXpgcLKfdLN4TYFxK0u8ryAzmZDHLASWLX/XXm8hgQar1C892W', 'SSSSS', 'ssssssssss', '1', 'g', '0:0:0:0:0:0:0:1', '2018-07-11 11:26:27');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
