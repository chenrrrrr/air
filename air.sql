/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : air

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2019-04-04 07:02:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_around
-- ----------------------------
DROP TABLE IF EXISTS `t_around`;
CREATE TABLE `t_around` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_around
-- ----------------------------

-- ----------------------------
-- Table structure for t_flight
-- ----------------------------
DROP TABLE IF EXISTS `t_flight`;
CREATE TABLE `t_flight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ttime` varchar(255) NOT NULL,
  `no` varchar(255) NOT NULL,
  `company` varchar(255) NOT NULL,
  `planemodel` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `plantime` varchar(255) NOT NULL,
  `tno` varchar(255) NOT NULL,
  `port` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_flight
-- ----------------------------
INSERT INTO `t_flight` VALUES ('1', '2019-04-08T16:00:00.000Z', 'ZH9384 CA3360 KY9384 3U408', '深圳航空有限责任公司', 'B738', '南宁', '09:15', 'T2', 'T2');
INSERT INTO `t_flight` VALUES ('2', '2019-04-14T16:00:00.000Z', 'A67302 LH7302', '云南红土航空公司', 'A319', '保山	', '09:15', 'T1', '11');

-- ----------------------------
-- Table structure for t_flightroute
-- ----------------------------
DROP TABLE IF EXISTS `t_flightroute`;
CREATE TABLE `t_flightroute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flightid` int(11) NOT NULL,
  `height` varchar(255) NOT NULL,
  `jing` varchar(255) NOT NULL,
  `wei` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `weather` varchar(255) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_flightroute
-- ----------------------------

-- ----------------------------
-- Table structure for t_msg
-- ----------------------------
DROP TABLE IF EXISTS `t_msg`;
CREATE TABLE `t_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `content` varchar(255) NOT NULL,
  `posterid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_msg
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `buyerid` int(11) NOT NULL,
  `flightid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `idcard` varchar(255) NOT NULL,
  `role` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin', '1', '1', '1', '1');
INSERT INTO `t_user` VALUES ('2', '1', '1', '18061205553', '陈睿', '320111199401214414', '0');
