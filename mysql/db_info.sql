/*
Navicat MySQL Data Transfer

Source Server         : jackxin
Source Server Version : 50733
Source Host           : localhost:3306
Source Database       : playboy

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2021-05-21 15:52:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for db_info
-- ----------------------------
DROP TABLE IF EXISTS `db_info`;
CREATE TABLE `db_info` (
  `db_id` varchar(36) NOT NULL COMMENT 'UUID，自动递增',
  `db_host` varchar(10) DEFAULT NULL,
  `db_port` varchar(10) DEFAULT NULL,
  `db_username` varchar(20) DEFAULT NULL,
  `db_password` varchar(25) DEFAULT NULL,
  `db_name` varchar(25) DEFAULT NULL,
  `db_outputfile` varchar(25) DEFAULT NULL,
  `db_filename` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`db_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of db_info
-- ----------------------------
INSERT INTO `db_info` VALUES ('0', 'xyjvcx', '3309', 'jack', '123456', 'playboy', 'C:\\\\backup\\\\mysql', 'xyj.sql');
INSERT INTO `db_info` VALUES ('3', 'wnode201', '3306', 'root', '123456', 'playboy', 'C:\\backup\\mysql', 'wf64.sql');
INSERT INTO `db_info` VALUES ('4', 'wnode232', '3306', 'root', '123456', 'playboy', 'C:\\backup\\mysql', 'wf64.sql');
INSERT INTO `db_info` VALUES ('5', 'wnode232', '3306', 'root', '123456', 'playboy', 'C:\\backup\\mysql', 'wf64.sql');
INSERT INTO `db_info` VALUES ('6', 'wnode232', '3306', 'root', '123456', 'playboy', 'C:\\backup\\mysql', 'wf64.sql');
INSERT INTO `db_info` VALUES ('7003181317ac4ef09ccaa94ca0425d05', 'xyj123', '3307', 'jack', '123456', 'playboy', 'C:\\\\backup\\\\mysql', 'xyj.sql');
INSERT INTO `db_info` VALUES ('80e2852378c647f3b4792b8edc3d5b48', 'xyj123', '3307', 'jack', '123456', 'playboy', 'C:\\\\backup\\\\mysql', 'xyj.sql');
INSERT INTO `db_info` VALUES ('85b2911b94bb42a0987d7089cf7cc8d9', 'wnode232', '3306', 'root', '123456', 'playboy', 'C:\\backup\\mysql', 'wf64.sql');
INSERT INTO `db_info` VALUES ('90b81b83c887438b95de0a21f9639a77', 'wnode232', '3306', 'root', '123456', 'playboy', 'C:\\backup\\mysql', 'wf64.sql');
INSERT INTO `db_info` VALUES ('b67fd9671dcb47188ca5573c8455d206', 'xyj123', '3307', 'jack', '123456', 'playboy', 'C:\\\\backup\\\\mysql', 'xyj.sql');
INSERT INTO `db_info` VALUES ('b89f1c66ec8b455e92f2ebb6bf5ec6a6', 'wnode232', '3306', 'root', '123456', 'playboy', 'C:\\backup\\mysql', 'wf64.sql');
INSERT INTO `db_info` VALUES ('c121739fa9854430a3d6d766c54a820c', 'localhost', '3306', 'root', '123456', 'playboy', 'C:\\backup\\mysql', 'mysql_dump.sql');
INSERT INTO `db_info` VALUES ('cab7859a8d554961b3193e3120f98036', 'xyj123', '3307', 'jack', '123456', 'playboy', 'C:\\\\backup\\\\mysql', 'xyj.sql');
INSERT INTO `db_info` VALUES ('f2832f5af4a8492aa4d87dabf49fe3cf', 'xyj123', '3307', 'jack', '123456', 'playboy', 'C:\\\\backup\\\\mysql', 'xyj.sql');
