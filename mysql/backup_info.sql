/*
Navicat MySQL Data Transfer

Source Server         : jackxin
Source Server Version : 50733
Source Host           : localhost:3306
Source Database       : playboy

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2021-05-21 15:52:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for backup_info
-- ----------------------------
DROP TABLE IF EXISTS `backup_info`;
CREATE TABLE `backup_info` (
  `bp_id` varchar(35) NOT NULL,
  `tdb_name` varchar(25) DEFAULT NULL,
  `tdb_tablename` varchar(25) DEFAULT NULL,
  `tdb_backupdate` varchar(25) DEFAULT NULL,
  `tdb_backuptype` varchar(25) DEFAULT NULL,
  `tdb_backupstatus` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`bp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of backup_info
-- ----------------------------
