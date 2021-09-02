/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : bookborrow_system

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 02/09/2021 17:59:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `book_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_typeid` int(11) NULL DEFAULT NULL,
  `isFlag` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE,
  INDEX `fbook1`(`book_typeid`) USING BTREE,
  CONSTRAINT `fbook1` FOREIGN KEY (`book_typeid`) REFERENCES `booktype` (`type_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (2, '倚天屠龙记', '罗贯中', '男', 20.10, '这个书不错', 3, 1);
INSERT INTO `book` VALUES (3, '倚天后传', '曹雪芹', '女', 20.10, '这个书不错', 3, 1);
INSERT INTO `book` VALUES (4, '屈原传奇', '鲁迅', '男', 30.70, '写了在古代的故事', 3, 0);
INSERT INTO `book` VALUES (5, '绝命毒师', '鲁迅', '男', 31.40, '写了在现代的故事', 4, 0);
INSERT INTO `book` VALUES (6, '绝命追魂', '鲁肃', '男', 30.20, '写了古代发生的故事', 3, 0);

-- ----------------------------
-- Table structure for booktype
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_typename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_typedesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES (3, '古装', '主要写的是古代的故事');
INSERT INTO `booktype` VALUES (4, '现代', '主要写的是现代世界的故事');
INSERT INTO `booktype` VALUES (5, '穿越', '主要讲解的是从现代穿越到古代的故事');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NULL DEFAULT NULL,
  `bookid` int(11) NULL DEFAULT NULL,
  `btime` datetime NULL DEFAULT NULL,
  `returntime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES (1, 1, 2, '2021-08-27 18:32:04', '2021-09-27 18:32:04');
INSERT INTO `borrow` VALUES (2, 1, 3, '2021-08-27 18:33:50', '2021-09-27 18:33:50');
INSERT INTO `borrow` VALUES (3, 1, 6, '2021-08-27 18:34:45', '2021-09-27 18:34:45');
INSERT INTO `borrow` VALUES (4, 1, 6, '2021-08-27 19:14:03', '2021-09-27 19:14:03');
INSERT INTO `borrow` VALUES (5, 1, 6, '2021-08-27 19:17:05', '2021-09-27 19:17:05');
INSERT INTO `borrow` VALUES (6, 1, 2, '2021-08-27 19:46:01', '2021-09-27 19:46:01');
INSERT INTO `borrow` VALUES (7, 1, 2, '2021-08-27 19:47:40', '2021-09-27 19:47:40');
INSERT INTO `borrow` VALUES (8, 1, 2, '2021-08-27 19:48:22', '2021-09-27 19:48:22');
INSERT INTO `borrow` VALUES (9, 1, 2, '2021-08-27 19:49:15', '2021-09-27 19:49:15');
INSERT INTO `borrow` VALUES (10, 1, 3, '2021-08-27 19:57:53', '2021-09-27 19:57:53');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `commentUserid` int(11) NULL DEFAULT NULL,
  `commentBookid` int(11) NULL DEFAULT NULL,
  `commentContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `commentTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`commentId`) USING BTREE,
  INDEX `fcomment1`(`commentUserid`) USING BTREE,
  INDEX `fcomment2`(`commentBookid`) USING BTREE,
  CONSTRAINT `fcomment1` FOREIGN KEY (`commentUserid`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fcomment2` FOREIGN KEY (`commentBookid`) REFERENCES `book` (`book_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 2, '这本书还行。。。', '2021-08-27 19:23:13');
INSERT INTO `comment` VALUES (2, 1, 2, '这本书价格太高。。。', '2021-08-27 19:32:51');
INSERT INTO `comment` VALUES (3, 1, 2, '这本书很好', '2021-08-27 21:12:34');
INSERT INTO `comment` VALUES (4, 1, 2, '我勒个去', '2021-08-27 21:18:40');
INSERT INTO `comment` VALUES (5, 1, 3, '这本书很精彩', '2021-08-27 21:12:34');

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `btime` datetime NULL DEFAULT NULL,
  `rtime` datetime NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`bookid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for lend
-- ----------------------------
DROP TABLE IF EXISTS `lend`;
CREATE TABLE `lend`  (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NULL DEFAULT NULL,
  `bookid` int(11) NULL DEFAULT NULL,
  `borrowid` int(11) NULL DEFAULT NULL,
  `ltime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`lid`) USING BTREE,
  INDEX `flend1`(`userid`) USING BTREE,
  INDEX `flend2`(`bookid`) USING BTREE,
  INDEX `flend3`(`borrowid`) USING BTREE,
  CONSTRAINT `flend1` FOREIGN KEY (`userid`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `flend2` FOREIGN KEY (`bookid`) REFERENCES `book` (`book_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `flend3` FOREIGN KEY (`borrowid`) REFERENCES `borrow` (`bid`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lend
-- ----------------------------
INSERT INTO `lend` VALUES (1, 1, 2, 1, '2021-08-27 19:05:05');
INSERT INTO `lend` VALUES (2, 1, 3, 2, '2021-08-27 19:08:24');
INSERT INTO `lend` VALUES (3, 1, 6, 3, '2021-08-27 19:09:56');
INSERT INTO `lend` VALUES (4, 1, 6, 4, '2021-08-27 19:15:43');
INSERT INTO `lend` VALUES (5, 1, 2, 6, '2021-08-27 19:46:16');
INSERT INTO `lend` VALUES (6, 1, 6, 5, '2021-08-27 19:46:33');
INSERT INTO `lend` VALUES (7, 1, 2, 7, '2021-08-27 19:47:56');
INSERT INTO `lend` VALUES (8, 1, 2, 8, '2021-08-27 19:48:36');

-- ----------------------------
-- Table structure for port
-- ----------------------------
DROP TABLE IF EXISTS `port`;
CREATE TABLE `port`  (
  `port_id` int(11) NOT NULL AUTO_INCREMENT,
  `port_senderid` int(11) NULL DEFAULT NULL,
  `port_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `port_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`port_id`) USING BTREE,
  INDEX `fport1`(`port_senderid`) USING BTREE,
  CONSTRAINT `fport1` FOREIGN KEY (`port_senderid`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of port
-- ----------------------------
INSERT INTO `port` VALUES (1, 1, '这个是1号用户发送的信息', '2021-08-27 17:19:06');
INSERT INTO `port` VALUES (3, 1, '这个是1号用户发送的信息', '2021-08-27 17:21:06');
INSERT INTO `port` VALUES (4, 2, 'hello,good afternoon', '2021-08-28 12:35:19');

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (
  `reportid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NULL DEFAULT NULL,
  `buserid` int(11) NULL DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mytime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`reportid`) USING BTREE,
  INDEX `freport1`(`userid`) USING BTREE,
  INDEX `freport2`(`buserid`) USING BTREE,
  CONSTRAINT `freport1` FOREIGN KEY (`userid`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `freport2` FOREIGN KEY (`buserid`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES (1, 2, 1, '发表不良信息', '2021-09-01 20:10:25');
INSERT INTO `report` VALUES (2, 1, 2, '非法使用账号', '2021-09-01 20:32:26');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_type` int(11) NULL DEFAULT NULL,
  `user_state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', 0, 0);
INSERT INTO `user` VALUES (2, 'lizihao', '123', 1, 0);
INSERT INTO `user` VALUES (3, 'liming', '123456', 0, 0);
INSERT INTO `user` VALUES (4, 'lihua', '3456', 1, 0);
INSERT INTO `user` VALUES (5, 'qingqing', '543', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
