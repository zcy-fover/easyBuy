/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50704
Source Host           : 127.0.0.1:3306
Source Database       : easybuy

Target Server Type    : MYSQL
Target Server Version : 50704
File Encoding         : 65001

Date: 2016-07-09 10:03:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbadmin
-- ----------------------------
DROP TABLE IF EXISTS `tbadmin`;
CREATE TABLE `tbadmin` (
  `ADMINID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(64) DEFAULT NULL,
  `PASSWORD` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ADMINID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbadmin
-- ----------------------------
INSERT INTO `tbadmin` VALUES ('1', 'zhangchongyi', '123456');
INSERT INTO `tbadmin` VALUES ('2', 'admin', '123456');
INSERT INTO `tbadmin` VALUES ('3', '管理员', '123456');

-- ----------------------------
-- Table structure for tbcategory
-- ----------------------------
DROP TABLE IF EXISTS `tbcategory`;
CREATE TABLE `tbcategory` (
  `CID` int(11) NOT NULL AUTO_INCREMENT,
  `CNAME` varchar(64) DEFAULT NULL,
  `SUMMARY` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbcategory
-- ----------------------------
INSERT INTO `tbcategory` VALUES ('1', 'food', '13');
INSERT INTO `tbcategory` VALUES ('2', 'cloth', '20');
INSERT INTO `tbcategory` VALUES ('8', '玩具', '挺好的挺好的');
INSERT INTO `tbcategory` VALUES ('19', '书籍', '各种书籍，欢迎大家订购');

-- ----------------------------
-- Table structure for tbgoods
-- ----------------------------
DROP TABLE IF EXISTS `tbgoods`;
CREATE TABLE `tbgoods` (
  `GID` int(11) NOT NULL AUTO_INCREMENT,
  `CID` int(11) DEFAULT NULL,
  `GNAME` varchar(256) DEFAULT NULL,
  `PRICE` float DEFAULT NULL,
  `OFFSET` float DEFAULT NULL,
  `STORAGE` int(11) DEFAULT NULL,
  `GTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`GID`),
  KEY `FK_REFERENCE_1` (`CID`),
  CONSTRAINT `FK_REFERENCE_1` FOREIGN KEY (`CID`) REFERENCES `tbcategory` (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbgoods
-- ----------------------------
INSERT INTO `tbgoods` VALUES ('2', '1', '土豆', '3', '0.9', '100', '2016-06-29 22:02:19');
INSERT INTO `tbgoods` VALUES ('3', '2', '短袖', '100', '0.9', '50', '2016-06-30 22:02:19');
INSERT INTO `tbgoods` VALUES ('4', '2', '短袖', '50', '0.9', '100', '2016-07-01 00:00:00');

-- ----------------------------
-- Table structure for tbimgs
-- ----------------------------
DROP TABLE IF EXISTS `tbimgs`;
CREATE TABLE `tbimgs` (
  `IMGID` int(11) NOT NULL AUTO_INCREMENT,
  `GID` int(11) DEFAULT NULL,
  `PATH` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`IMGID`),
  KEY `FK_REFERENCE_2` (`GID`),
  CONSTRAINT `FK_REFERENCE_2` FOREIGN KEY (`GID`) REFERENCES `tbgoods` (`GID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbimgs
-- ----------------------------

-- ----------------------------
-- Table structure for tborders
-- ----------------------------
DROP TABLE IF EXISTS `tborders`;
CREATE TABLE `tborders` (
  `OID` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` int(11) DEFAULT NULL,
  `GID` int(11) DEFAULT NULL,
  `ORDERNO` varchar(64) DEFAULT NULL,
  `ORDERTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `COUNT` int(11) DEFAULT NULL,
  `STATE` int(11) DEFAULT NULL,
  `TOTAL` float DEFAULT NULL,
  PRIMARY KEY (`OID`),
  KEY `FK_REFERENCE_4` (`GID`),
  KEY `FK_REFERENCE_3` (`USERID`),
  CONSTRAINT `FK_REFERENCE_3` FOREIGN KEY (`USERID`) REFERENCES `tbuser` (`USERID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_REFERENCE_4` FOREIGN KEY (`GID`) REFERENCES `tbgoods` (`GID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tborders
-- ----------------------------
INSERT INTO `tborders` VALUES ('1', '1', '2', '1', '2016-07-03 02:22:21', '1', '1', '2.7');
INSERT INTO `tborders` VALUES ('2', '3', '3', '2', '2016-07-03 02:23:03', '2', '2', '180');

-- ----------------------------
-- Table structure for tbuser
-- ----------------------------
DROP TABLE IF EXISTS `tbuser`;
CREATE TABLE `tbuser` (
  `USERID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(64) DEFAULT NULL,
  `PASSWORD` varchar(128) DEFAULT NULL,
  `PHONE` varchar(32) DEFAULT NULL,
  `ADDRESS` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbuser
-- ----------------------------
INSERT INTO `tbuser` VALUES ('1', 'user', '123456', '15207189057', '升升公寓');
INSERT INTO `tbuser` VALUES ('3', '张崇羿', 'zhang', '15625445545', '武汉理工大学');
INSERT INTO `tbuser` VALUES ('4', 'group', '123456', '15207189058', '鉴湖');
INSERT INTO `tbuser` VALUES ('6', 'abc', '123456', '15207189058', 'zxcv');
