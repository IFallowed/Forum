/*
Navicat MySQL Data Transfer

Source Server         : Tencent
Source Server Version : 50626
Source Host           : 49.234.120.252:3306
Source Database       : Forum

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2019-11-07 15:23:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_replypost`
-- ----------------------------
DROP TABLE IF EXISTS `t_replypost`;
CREATE TABLE `t_replypost` (
  `rp_id` int(11) NOT NULL AUTO_INCREMENT,
  `rp_userId` int(11) NOT NULL,
  `rp_replyToId` int(11) NOT NULL,
  `rp_content` varchar(500) NOT NULL,
  `rp_state` varchar(5) NOT NULL,
  `rp_likeNum` int(11) NOT NULL DEFAULT '0',
  `rp_replyNum` int(11) NOT NULL DEFAULT '0',
  `rp_createTime` datetime NOT NULL,
  PRIMARY KEY (`rp_id`),
  KEY `fk_reply_user` (`rp_userId`),
  KEY `fk_reply_theme` (`rp_replyToId`),
  CONSTRAINT `fk_reply_theme` FOREIGN KEY (`rp_replyToId`) REFERENCES `t_themepost` (`tp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_reply_user` FOREIGN KEY (`rp_userId`) REFERENCES `t_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_replypost
-- ----------------------------

-- ----------------------------
-- Table structure for `t_themepost`
-- ----------------------------
DROP TABLE IF EXISTS `t_themepost`;
CREATE TABLE `t_themepost` (
  `tp_id` int(11) NOT NULL AUTO_INCREMENT,
  `tp_title` varchar(15) NOT NULL,
  `tp_content` varchar(500) NOT NULL,
  `tp_userId` int(11) NOT NULL,
  `tp_type` varchar(15) NOT NULL,
  `tp_state` varchar(5) NOT NULL,
  `tp_gold` int(11) NOT NULL DEFAULT '0',
  `tp_browseNum` int(11) NOT NULL DEFAULT '0',
  `tp_replyNum` int(11) NOT NULL DEFAULT '0',
  `tp_collectNum` int(11) NOT NULL DEFAULT '0',
  `tp_createTime` datetime NOT NULL,
  PRIMARY KEY (`tp_id`),
  KEY `fk_theme_user` (`tp_userId`),
  CONSTRAINT `fk_theme_user` FOREIGN KEY (`tp_userId`) REFERENCES `t_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_themepost
-- ----------------------------
INSERT INTO `t_themepost` VALUES ('21', '主题0', '内容0', '1', 'html', '未结', '100', '5', '0', '2', '2019-11-07 11:52:42');
INSERT INTO `t_themepost` VALUES ('22', '主题1', '内容1', '1', 'html', '未结', '100', '5', '0', '2', '2019-11-07 11:52:43');
INSERT INTO `t_themepost` VALUES ('23', '主题2', '内容2', '1', 'html', '未结', '100', '5', '0', '2', '2019-11-07 11:52:43');
INSERT INTO `t_themepost` VALUES ('24', '主题3', '内容3', '1', 'html', '未结', '100', '5', '0', '2', '2019-11-07 11:52:43');
INSERT INTO `t_themepost` VALUES ('25', '主题4', '内容4', '1', 'html', '未结', '100', '5', '0', '2', '2019-11-07 11:52:44');
INSERT INTO `t_themepost` VALUES ('26', '主题5', '内容5', '1', 'css', '未结', '100', '5', '0', '2', '2019-11-07 11:52:44');
INSERT INTO `t_themepost` VALUES ('27', '主题6', '内容6', '1', 'css', '未结', '100', '5', '0', '2', '2019-11-07 11:52:44');
INSERT INTO `t_themepost` VALUES ('28', '主题7', '内容7', '1', 'css', '未结', '100', '5', '0', '2', '2019-11-07 11:52:45');
INSERT INTO `t_themepost` VALUES ('29', '主题8', '内容8', '1', 'css', '未结', '100', '5', '0', '2', '2019-11-07 11:52:45');
INSERT INTO `t_themepost` VALUES ('30', '主题9', '内容9', '1', 'css', '未结', '100', '5', '0', '2', '2019-11-07 11:52:45');
INSERT INTO `t_themepost` VALUES ('31', '主题10', '内容10', '1', 'javascript', '未结', '100', '5', '0', '2', '2019-11-07 11:52:46');
INSERT INTO `t_themepost` VALUES ('32', '主题11', '内容11', '1', 'javascript', '未结', '100', '5', '0', '2', '2019-11-07 11:52:46');
INSERT INTO `t_themepost` VALUES ('33', '主题12', '内容12', '1', 'javascript', '未结', '100', '5', '0', '2', '2019-11-07 11:52:46');
INSERT INTO `t_themepost` VALUES ('34', '主题13', '内容13', '1', 'javascript', '未结', '100', '5', '0', '2', '2019-11-07 11:52:46');
INSERT INTO `t_themepost` VALUES ('35', '主题14', '内容14', '1', 'javascript', '未结', '100', '5', '0', '2', '2019-11-07 11:52:47');
INSERT INTO `t_themepost` VALUES ('36', '主题15', '内容15', '1', 'jquery', '未结', '100', '5', '0', '2', '2019-11-07 11:52:47');
INSERT INTO `t_themepost` VALUES ('37', '主题16', '内容16', '1', 'jquery', '未结', '100', '5', '0', '2', '2019-11-07 11:52:47');
INSERT INTO `t_themepost` VALUES ('38', '主题17', '内容17', '1', 'jquery', '未结', '100', '5', '0', '2', '2019-11-07 11:52:47');
INSERT INTO `t_themepost` VALUES ('39', '主题18', '内容18', '1', 'jquery', '未结', '100', '5', '0', '2', '2019-11-07 11:52:47');
INSERT INTO `t_themepost` VALUES ('40', '主题19', '内容19', '1', 'jquery', '未结', '100', '5', '0', '2', '2019-11-07 11:52:47');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_mail` varchar(25) NOT NULL,
  `u_password` varchar(20) NOT NULL,
  `u_nickName` varchar(10) DEFAULT '',
  `u_sex` int(1) DEFAULT NULL,
  `u_phone` varchar(11) DEFAULT NULL,
  `u_gold` int(11) NOT NULL DEFAULT '100',
  `u_city` varchar(5) DEFAULT NULL,
  `u_signature` varchar(50) DEFAULT NULL,
  `u_avatar` varchar(50) DEFAULT '0.jpg',
  `u_createTime` datetime NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1178885073@qq.com', 'kc12345678987', 'kc', '0', '13852978307', '100', '南京', 'abcdefg', 'timg.jpg', '2019-11-01 14:08:18');
INSERT INTO `t_user` VALUES ('25', '1639782681@qq.com', 'kc13815167887', 'kfc', '1', '13852978307', '100', '北京', '来自北京', 't01a031da1d94a11dd1.jpg', '2019-11-04 16:47:13');
INSERT INTO `t_user` VALUES ('26', '0499748509@qq.com', 'kc12345678987', '', '1', null, '100', null, null, '0.jpg', '2019-11-07 14:12:26');
