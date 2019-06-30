/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : ssmweb

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-06-18 22:31:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for h_user
-- ----------------------------
DROP TABLE IF EXISTS `h_user`;
CREATE TABLE `h_user` (
  `uuid` char(24) NOT NULL COMMENT '用户唯一标识',
  `uname` varchar(255) NOT NULL COMMENT '用户名',
  `upass` char(32) NOT NULL COMMENT '用户密码',
  `umap` char(32) NOT NULL COMMENT '用户名映射',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of h_user
-- ----------------------------
INSERT INTO `h_user` VALUES ('d7f7e28bdd4743a5be9d', 'mark', 'ac488b4b54db9d016a9324fc238065f8', 'ac488b4b54db9d016a9324fc238065f8');
