/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-04-08 19:52:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `about_blog`
-- ----------------------------
DROP TABLE IF EXISTS `about_blog`;
CREATE TABLE `about_blog` (
  `blog_id` mediumint(8) NOT NULL COMMENT '用户ID',
  `blog_keyword` varchar(255) NOT NULL COMMENT '博客关键字',
  `blog_description` varchar(255) NOT NULL COMMENT '博客描述',
  `blog_name` varchar(36) NOT NULL COMMENT '博客名称',
  `blog_title` varchar(128) NOT NULL COMMENT '博客标题',
  `user_id` mediumint(8) NOT NULL COMMENT '所属用户ID',
  PRIMARY KEY (`blog_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of about_blog
-- ----------------------------
INSERT INTO `about_blog` VALUES ('1', '杂七杂八', '一只没有梦想的小鸡腿', '一只小鸡腿', '鸡窝', '10001');

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` smallint(5) NOT NULL AUTO_INCREMENT COMMENT '日志自增ID号',
  `article_name` varchar(128) NOT NULL COMMENT '文章名称',
  `article_time` datetime NOT NULL COMMENT '发布时间',
  `article_ip` varchar(15) NOT NULL COMMENT '发布IP',
  `article_click` int(10) NOT NULL COMMENT '查看人数',
  `sort_article_id` mediumint(8) NOT NULL COMMENT '所属分类',
  `user_id` mediumint(8) NOT NULL COMMENT '所属用户ID',
  `type_id` tinyint(3) DEFAULT '1' COMMENT '栏目ID',
  `article_description` varchar(100) NOT NULL COMMENT '文章描述',
  `article_type` int(13) NOT NULL DEFAULT '1' COMMENT '文章的模式:0为私有，1为公开',
  `article_content` text NOT NULL COMMENT '文章内容',
  `article_up` tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否置顶:0为否，1为是',
  `article_support` tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否博主推荐:0为否，1为是',
  `article_label` varchar(100) NOT NULL,
  `article_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '文章状态',
  PRIMARY KEY (`article_id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('21', '这个是测试标题测试标题', '2019-03-03 22:17:29', '127.0.0.1', '0', '1', '10001', '1', '这个是测试标题测试标题水水水水', '1', '<p><b>这个是测试标题测试标题<u>水水水水<img src=\"http://192.168.186.251:8080/myblog/res/layuiadmin/layui/images/face/15.gif\" class=\"abcde\" alt=\"[生病]\"></u></b></p>', '0', '0', '撒旦撒,', '0');
INSERT INTO `article` VALUES ('22', '水水水水水水水水水水水水水水水水水水水', '2019-03-03 23:33:19', '127.0.0.1', '0', '1', '10001', '1', '水水水水水水水水水水水水水水水水水水水水水水水水水水水水水水', '1', '<p><b>水水水水水水水水水水水水水水水水水</b><u><b>水水水水水水水水水水水水水水水水水水水水水<img src=\"http://192.168.186.251:8080/myblog/res/layuiadmin/layui/images/face/5.gif\" class=\"abcde\" alt=\"[挖鼻]\"></b></u><b>水水水水水水水</b><u><b>水水水水水</b></u><u><b></b></u><b>水水水水水水水</b><u><b>水水水水水</b></u><b>水水水水水水水</b><u><b>水水水水水</b></u></p>', '0', '0', '搜索,', '0');
INSERT INTO `article` VALUES ('23', '测试标题测试标题测试标题测试标题', '2019-03-07 17:23:53', '127.0.0.1', '0', '2', '10001', '1', '测试内容测试内容测试内容测试内容测试内容', '1', '<p><img src=\"http://192.168.186.251:8080/myblog/res/layuiadmin/layui/images/face/1.gif\" class=\"abcde\" alt=\"[嘻嘻]\">测试内容测试内容测试内容测试内容测试内容</p>', '0', '0', '测试哦,', '2');
INSERT INTO `article` VALUES ('25', '这是标题标题标题', '2019-03-12 16:35:22', '127.0.0.1', '0', '1', '10001', '1', '文章文章文章文章', '1', '文章文章文章文章<img src=\"http://192.168.186.251:8080/myblog/res/layuiadmin/layui/images/face/1.gif\" class=\"abcde\" alt=\"[嘻嘻]\">', '1', '1', '嘻嘻,', '0');
INSERT INTO `article` VALUES ('26', '测试1', '2019-03-27 18:22:38', '127.0.0.1', '0', '1', '10001', '1', '测试1测试1测试1', '1', '<p>测试1测试1测试1<img src=\"http://127.0.0.1:9999/myblog/res/layuiadmin/layui/images/face/14.gif\" class=\"abcde\" alt=\"[亲亲]\"></p>', '0', '1', '测试1,', '0');
INSERT INTO `article` VALUES ('27', '测试2', '2019-03-27 18:22:55', '127.0.0.1', '0', '1', '10001', '1', '测试2测试2测试1', '1', '<p>测试2测试2测试1<img src=\"http://127.0.0.1:9999/myblog/res/layuiadmin/layui/images/face/14.gif\" class=\"abcde\" alt=\"[亲亲]\"></p>', '0', '0', '测试2,', '0');
INSERT INTO `article` VALUES ('28', '测试2', '2019-03-27 18:22:56', '127.0.0.1', '0', '1', '10001', '1', '测试2测试2测试1', '1', '<p>测试2测试2测试1<img src=\"http://127.0.0.1:9999/myblog/res/layuiadmin/layui/images/face/14.gif\" class=\"abcde\" alt=\"[亲亲]\"></p>', '0', '0', '测试2,', '0');
INSERT INTO `article` VALUES ('29', '测试2', '2019-03-27 18:22:56', '127.0.0.1', '0', '1', '10001', '1', '测试2测试2测试1', '1', '<p>测试2测试2测试1<img src=\"http://127.0.0.1:9999/myblog/res/layuiadmin/layui/images/face/14.gif\" class=\"abcde\" alt=\"[亲亲]\"></p>', '0', '0', '测试2,', '0');
INSERT INTO `article` VALUES ('30', '测试2', '2019-03-27 18:22:56', '127.0.0.1', '0', '1', '10001', '1', '测试2测试2测试1', '1', '<p>测试2测试2测试1<img src=\"http://127.0.0.1:9999/myblog/res/layuiadmin/layui/images/face/14.gif\" class=\"abcde\" alt=\"[亲亲]\"></p>', '0', '0', '测试2,', '0');
INSERT INTO `article` VALUES ('31', '测试2', '2019-03-27 18:22:56', '127.0.0.1', '0', '1', '10001', '1', '测试2测试2测试1', '1', '<p>测试2测试2测试1<img src=\"http://127.0.0.1:9999/myblog/res/layuiadmin/layui/images/face/14.gif\" class=\"abcde\" alt=\"[亲亲]\"></p>', '0', '0', '测试2,', '0');
INSERT INTO `article` VALUES ('32', '测试2', '2019-03-27 18:22:56', '127.0.0.1', '0', '1', '10001', '1', '测试2测试2测试1', '1', '<p>测试2测试2测试1<img src=\"http://127.0.0.1:9999/myblog/res/layuiadmin/layui/images/face/14.gif\" class=\"abcde\" alt=\"[亲亲]\"></p>', '0', '0', '测试2,', '0');
INSERT INTO `article` VALUES ('33', '测试2', '2019-03-27 18:22:57', '127.0.0.1', '0', '1', '10001', '1', '测试2测试2测试1', '1', '<p>测试2测试2测试1<img src=\"http://127.0.0.1:9999/myblog/res/layuiadmin/layui/images/face/14.gif\" class=\"abcde\" alt=\"[亲亲]\"></p>', '0', '0', '测试2,', '0');
INSERT INTO `article` VALUES ('35', '测试2', '2019-03-27 18:24:56', '127.0.0.1', '0', '1', '10001', '1', '测试1测试1', '1', '<p>测试1测试1<img src=\"http://127.0.0.1:9999/myblog/res/layuiadmin/layui/images/face/50.gif\" class=\"abcde\" alt=\"[熊猫]\"></p>', '0', '1', '山水,', '1');

-- ----------------------------
-- Table structure for `article_sort`
-- ----------------------------
DROP TABLE IF EXISTS `article_sort`;
CREATE TABLE `article_sort` (
  `sort_article_id` mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '文章自增ID',
  `user_id` mediumint(8) NOT NULL COMMENT '该分类所属用户',
  `sort_article_name` varchar(60) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`sort_article_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_sort
-- ----------------------------
INSERT INTO `article_sort` VALUES ('1', '10001', 'Java');
INSERT INTO `article_sort` VALUES ('2', '10001', 'php');
INSERT INTO `article_sort` VALUES ('3', '10001', 'java');
INSERT INTO `article_sort` VALUES ('4', '10001', 'JAVA');
INSERT INTO `article_sort` VALUES ('5', '10001', 'JAVA');

-- ----------------------------
-- Table structure for `friend`
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `f_id` smallint(5) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_id` mediumint(8) NOT NULL COMMENT '用户ID',
  `friend_id` mediumint(8) NOT NULL COMMENT '好友ID',
  PRIMARY KEY (`f_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------

-- ----------------------------
-- Table structure for `friendly_link`
-- ----------------------------
DROP TABLE IF EXISTS `friendly_link`;
CREATE TABLE `friendly_link` (
  `link_id` smallint(5) NOT NULL AUTO_INCREMENT COMMENT '友情链接自增ID',
  `link_name` varchar(60) NOT NULL COMMENT '友情链接名称',
  `link_url` varchar(255) NOT NULL COMMENT '链接地址',
  `show_order` tinyint(3) NOT NULL COMMENT '在页面显示的顺序',
  PRIMARY KEY (`link_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friendly_link
-- ----------------------------

-- ----------------------------
-- Table structure for `module_type`
-- ----------------------------
DROP TABLE IF EXISTS `module_type`;
CREATE TABLE `module_type` (
  `type_id` int(3) NOT NULL AUTO_INCREMENT COMMENT '板块ID',
  `user_name` varchar(32) NOT NULL COMMENT '板块名称',
  `user_id` mediumint(8) NOT NULL COMMENT '板块所属用户ID',
  `type_icon` varchar(32) NOT NULL COMMENT '板块名称',
  `show_order` tinyint(3) NOT NULL COMMENT '在页面显示的顺序',
  PRIMARY KEY (`type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module_type
-- ----------------------------
INSERT INTO `module_type` VALUES ('10001', '问题库', '10001', 'layui-icon-male', '1');
INSERT INTO `module_type` VALUES ('10002', '随笔', '10001', 'layui-icon-male', '2');
INSERT INTO `module_type` VALUES ('10003', '音乐', '10001', 'layui-icon-male', '3');
INSERT INTO `module_type` VALUES ('10004', '部落格', '10001', 'layui-icon-male', '4');

-- ----------------------------
-- Table structure for `phone_message`
-- ----------------------------
DROP TABLE IF EXISTS `phone_message`;
CREATE TABLE `phone_message` (
  `phone_id` mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '自增ID号',
  `phone_num` varchar(20) NOT NULL COMMENT '用户手机号码',
  `contents` varchar(255) NOT NULL COMMENT '发送内容',
  `send_time` datetime NOT NULL COMMENT '发送时间',
  `user_id` mediumint(8) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`phone_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of phone_message
-- ----------------------------

-- ----------------------------
-- Table structure for `power_list`
-- ----------------------------
DROP TABLE IF EXISTS `power_list`;
CREATE TABLE `power_list` (
  `p_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `power_id` int(10) NOT NULL COMMENT '权限ID',
  `power_name` varchar(36) NOT NULL COMMENT '权限描述',
  PRIMARY KEY (`p_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power_list
-- ----------------------------
INSERT INTO `power_list` VALUES ('1', '1', 'Administrator');
INSERT INTO `power_list` VALUES ('2', '2', 'user');

-- ----------------------------
-- Table structure for `secret_message`
-- ----------------------------
DROP TABLE IF EXISTS `secret_message`;
CREATE TABLE `secret_message` (
  `secret_id` mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '自增私信ID',
  `send_id` mediumint(8) NOT NULL COMMENT '发信者ID',
  `receive_id` mediumint(8) NOT NULL COMMENT '收信者ID',
  `message_topic` varchar(64) NOT NULL COMMENT '私信标题',
  `message_content` varchar(255) NOT NULL COMMENT '私信内容',
  `message_time` datetime NOT NULL COMMENT '私信时间',
  PRIMARY KEY (`secret_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of secret_message
-- ----------------------------

-- ----------------------------
-- Table structure for `shuoshuo`
-- ----------------------------
DROP TABLE IF EXISTS `shuoshuo`;
CREATE TABLE `shuoshuo` (
  `shuo_id` mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '说说记录ID',
  `user_id` mediumint(8) NOT NULL COMMENT '用户ID',
  `shuo_time` datetime NOT NULL COMMENT '发布时间',
  `shuo_ip` varchar(15) NOT NULL COMMENT '说说发布时的IP地址',
  `shuoshuo` varchar(255) NOT NULL COMMENT '说说内容',
  `type_id` tinyint(3) NOT NULL DEFAULT '3' COMMENT '栏目ID,默认为3',
  PRIMARY KEY (`shuo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shuoshuo
-- ----------------------------

-- ----------------------------
-- Table structure for `system_message`
-- ----------------------------
DROP TABLE IF EXISTS `system_message`;
CREATE TABLE `system_message` (
  `system_id` mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '系统通知ID',
  `send_id` mediumint(8) NOT NULL COMMENT '接受者ID',
  `group_id` tinyint(3) NOT NULL COMMENT '用户组ID',
  `send_default` mediumint(8) NOT NULL COMMENT '1时发送所有用户，0时则不采用',
  `system_topic` varchar(60) NOT NULL COMMENT '通知内容',
  `system_content` varchar(255) NOT NULL COMMENT '通知内容',
  PRIMARY KEY (`system_id`),
  KEY `FK_system_message_group_id` (`group_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_message
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `user_nikename` varchar(32) NOT NULL COMMENT '用户昵称',
  `user_pwd` varchar(32) NOT NULL COMMENT '用户密码',
  `user_phone` int(12) DEFAULT NULL COMMENT '用户手机号码',
  `user_sex` varchar(6) DEFAULT NULL COMMENT '用户性别',
  `user_qq` varchar(10) DEFAULT NULL COMMENT '用户QQ号码',
  `user_email` varchar(64) NOT NULL COMMENT '用户EMAIL地址',
  `user_address` varchar(255) DEFAULT NULL COMMENT '用户地址',
  `user_last_login_ip` varchar(15) NOT NULL COMMENT '用户上一次登录IP地址',
  `user_birthday` datetime DEFAULT NULL COMMENT '用户生日',
  `user_description` varchar(255) DEFAULT NULL COMMENT '自我描述',
  `user_image_url` varchar(255) DEFAULT NULL COMMENT '用户头像存储路径',
  `user_register_time` datetime NOT NULL COMMENT '用户注册时间',
  `user_register_ip` varchar(15) NOT NULL COMMENT '用户注册时IP地址',
  `user_last_update_time` datetime DEFAULT NULL COMMENT '用户上次更新博客时间',
  `user_weibo` varchar(255) DEFAULT NULL COMMENT '用户微博',
  `user_lock` tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否锁定，0为不锁定，1为锁定',
  `user_freeze` tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否冻结，0为不冻结，1为冻结',
  `user_power` mediumint(8) NOT NULL DEFAULT '2' COMMENT '拥有权限',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10001', 'yizhixiaojitui', '一只小鸡腿', '123456', null, '1', '123456789', '865636176@qq.com', null, '127.0.0.1', '2009-05-11 14:37:27', '每天进步一点点，1.01的365次方=37.78343433289 >>>1 1的365次方=1 0.99的365次方= 0.02551796445229 <<<1', 'ceec7d16-5016-4c7c-a2df-f86368e37289.jpg', '2018-05-31 14:38:06', '127.0.0.1', null, null, '0', '0', '2');

-- ----------------------------
-- Table structure for `user_comment`
-- ----------------------------
DROP TABLE IF EXISTS `user_comment`;
CREATE TABLE `user_comment` (
  `c_id` mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '评论自增ID号',
  `user_id` mediumint(8) NOT NULL COMMENT '收到评论的用户ID',
  `type_id` tinyint(3) NOT NULL COMMENT '评论栏目ID',
  `commit_id` mediumint(8) NOT NULL COMMENT '评论内容的ID',
  `commit_content` varchar(255) NOT NULL COMMENT '评论内容',
  `commit_time` datetime NOT NULL COMMENT '评论时间',
  `commit_ip` varchar(15) NOT NULL COMMENT '评论时的IP地址',
  PRIMARY KEY (`c_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `visitor`
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `v_id` mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '访客记录ID',
  `visitor_time` datetime NOT NULL COMMENT '来访时间',
  `user_id` mediumint(8) NOT NULL COMMENT '被访用户ID',
  `visitor_ip` varchar(15) NOT NULL COMMENT '访客IP地址',
  `type_id` int(3) NOT NULL COMMENT '访问板块ID',
  `where_id` mediumint(8) NOT NULL COMMENT '查看某板块的某个子项目，如查看相册板块的第3个相册，该ID对应该相册的ID号',
  PRIMARY KEY (`v_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visitor
-- ----------------------------
