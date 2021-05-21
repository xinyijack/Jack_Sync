/*
Navicat MySQL Data Transfer

Source Server         : jackxin
Source Server Version : 50733
Source Host           : localhost:3306
Source Database       : playboy

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2021-05-21 15:53:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for recover_info
-- ----------------------------
DROP TABLE IF EXISTS `recover_info`;
CREATE TABLE `recover_info` (
  `rc_id` varchar(35) NOT NULL,
  `tdb_name` varchar(25) DEFAULT NULL,
  `tdb_tablename` varchar(25) DEFAULT NULL,
  `tdb_recoverdate` varchar(25) DEFAULT NULL,
  `tdb_recovertype` varchar(25) DEFAULT NULL,
  `tdb_recoverstatus` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`rc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of recover_info
-- ----------------------------
