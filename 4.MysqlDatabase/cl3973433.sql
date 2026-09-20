-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: cl3973433
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `cl3973433`
--

/*!40000 DROP DATABASE IF EXISTS `cl3973433`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `cl3973433` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `cl3973433`;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'swiper1','file/swiperPicture1.jpg'),(2,'swiper2','file/swiperPicture2.jpg'),(3,'swiper3','file/swiperPicture3.jpg');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussfuwujilu`
--

DROP TABLE IF EXISTS `discussfuwujilu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussfuwujilu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务记录评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussfuwujilu`
--

LOCK TABLES `discussfuwujilu` WRITE;
/*!40000 ALTER TABLE `discussfuwujilu` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussfuwujilu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fuwufenpai`
--

DROP TABLE IF EXISTS `fuwufenpai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuwufenpai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fuwumingcheng` varchar(200) NOT NULL COMMENT '服务名称',
  `fuwushijian` datetime NOT NULL COMMENT '服务时间',
  `fuwudidian` varchar(200) NOT NULL COMMENT '服务地点',
  `yuyueriqi` varchar(200) DEFAULT NULL COMMENT '预约日期',
  `laorenzhanghao` varchar(200) DEFAULT NULL COMMENT '老人账号',
  `laorenxingming` varchar(200) DEFAULT NULL COMMENT '老人姓名',
  `jianhurenzhanghao` varchar(200) DEFAULT NULL COMMENT '监护人账号',
  `jianhurenxingming` varchar(200) DEFAULT NULL COMMENT '监护人姓名',
  `zhiyuanzhezhanghao` varchar(200) DEFAULT NULL COMMENT '志愿者账号',
  `zhiyuanzhexingming` varchar(200) DEFAULT NULL COMMENT '志愿者姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8 COMMENT='服务分派';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fuwufenpai`
--

LOCK TABLES `fuwufenpai` WRITE;
/*!40000 ALTER TABLE `fuwufenpai` DISABLE KEYS */;
INSERT INTO `fuwufenpai` VALUES (131,'2024-01-10 03:18:02','服务名称1','2024-01-10 11:18:02','服务地点1','预约日期1','老人账号1','老人姓名1','监护人账号1','监护人姓名1','志愿者账号1','志愿者姓名1'),(132,'2024-01-10 03:18:02','服务名称2','2024-01-10 11:18:02','服务地点2','预约日期2','老人账号2','老人姓名2','监护人账号2','监护人姓名2','志愿者账号2','志愿者姓名2'),(133,'2024-01-10 03:18:02','服务名称3','2024-01-10 11:18:02','服务地点3','预约日期3','老人账号3','老人姓名3','监护人账号3','监护人姓名3','志愿者账号3','志愿者姓名3'),(134,'2024-01-10 03:18:02','服务名称4','2024-01-10 11:18:02','服务地点4','预约日期4','老人账号4','老人姓名4','监护人账号4','监护人姓名4','志愿者账号4','志愿者姓名4'),(135,'2024-01-10 03:18:02','服务名称5','2024-01-10 11:18:02','服务地点5','预约日期5','老人账号5','老人姓名5','监护人账号5','监护人姓名5','志愿者账号5','志愿者姓名5'),(136,'2024-01-10 03:18:02','服务名称6','2024-01-10 11:18:02','服务地点6','预约日期6','老人账号6','老人姓名6','监护人账号6','监护人姓名6','志愿者账号6','志愿者姓名6');
/*!40000 ALTER TABLE `fuwufenpai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fuwujilu`
--

DROP TABLE IF EXISTS `fuwujilu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuwujilu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fuwumingcheng` varchar(200) NOT NULL COMMENT '服务名称',
  `fuwudidian` varchar(200) NOT NULL COMMENT '服务地点',
  `fuwuriqi` date DEFAULT NULL COMMENT '服务日期',
  `zhaopian` longtext COMMENT '照片',
  `shipin` longtext COMMENT '视频',
  `neirong` longtext COMMENT '内容',
  `zhiyuanzhezhanghao` varchar(200) DEFAULT NULL COMMENT '志愿者账号',
  `zhiyuanzhexingming` varchar(200) DEFAULT NULL COMMENT '志愿者姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8 COMMENT='服务记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fuwujilu`
--

LOCK TABLES `fuwujilu` WRITE;
/*!40000 ALTER TABLE `fuwujilu` DISABLE KEYS */;
INSERT INTO `fuwujilu` VALUES (141,'2024-01-10 03:18:02','服务名称1','服务地点1','2024-01-10','file/fuwujiluZhaopian1.jpg,file/fuwujiluZhaopian2.jpg,file/fuwujiluZhaopian3.jpg','','内容1','志愿者账号1','志愿者姓名1'),(142,'2024-01-10 03:18:02','服务名称2','服务地点2','2024-01-10','file/fuwujiluZhaopian2.jpg,file/fuwujiluZhaopian3.jpg,file/fuwujiluZhaopian4.jpg','','内容2','志愿者账号2','志愿者姓名2'),(143,'2024-01-10 03:18:02','服务名称3','服务地点3','2024-01-10','file/fuwujiluZhaopian3.jpg,file/fuwujiluZhaopian4.jpg,file/fuwujiluZhaopian5.jpg','','内容3','志愿者账号3','志愿者姓名3'),(144,'2024-01-10 03:18:02','服务名称4','服务地点4','2024-01-10','file/fuwujiluZhaopian4.jpg,file/fuwujiluZhaopian5.jpg,file/fuwujiluZhaopian6.jpg','','内容4','志愿者账号4','志愿者姓名4'),(145,'2024-01-10 03:18:02','服务名称5','服务地点5','2024-01-10','file/fuwujiluZhaopian5.jpg,file/fuwujiluZhaopian6.jpg,file/fuwujiluZhaopian7.jpg','','内容5','志愿者账号5','志愿者姓名5'),(146,'2024-01-10 03:18:02','服务名称6','服务地点6','2024-01-10','file/fuwujiluZhaopian6.jpg,file/fuwujiluZhaopian7.jpg,file/fuwujiluZhaopian8.jpg','','内容6','志愿者账号6','志愿者姓名6');
/*!40000 ALTER TABLE `fuwujilu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fuwuleixing`
--

DROP TABLE IF EXISTS `fuwuleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuwuleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fuwuleixing` varchar(200) DEFAULT NULL COMMENT '服务类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='服务类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fuwuleixing`
--

LOCK TABLES `fuwuleixing` WRITE;
/*!40000 ALTER TABLE `fuwuleixing` DISABLE KEYS */;
INSERT INTO `fuwuleixing` VALUES (91,'2024-01-10 03:18:02','服务类型1'),(92,'2024-01-10 03:18:02','服务类型2'),(93,'2024-01-10 03:18:02','服务类型3'),(94,'2024-01-10 03:18:02','服务类型4'),(95,'2024-01-10 03:18:02','服务类型5'),(96,'2024-01-10 03:18:02','服务类型6');
/*!40000 ALTER TABLE `fuwuleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fuwuxinxi`
--

DROP TABLE IF EXISTS `fuwuxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuwuxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fuwumingcheng` varchar(200) NOT NULL COMMENT '服务名称',
  `tupian` longtext COMMENT '图片',
  `fuwuleixing` varchar(200) DEFAULT NULL COMMENT '服务类型',
  `fuwushijian` datetime NOT NULL COMMENT '服务时间',
  `fuwudidian` varchar(200) NOT NULL COMMENT '服务地点',
  `fuwuneirong` longtext COMMENT '服务内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 COMMENT='服务信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fuwuxinxi`
--

LOCK TABLES `fuwuxinxi` WRITE;
/*!40000 ALTER TABLE `fuwuxinxi` DISABLE KEYS */;
INSERT INTO `fuwuxinxi` VALUES (101,'2024-01-10 03:18:02','服务名称1','file/fuwuxinxiTupian1.jpg,file/fuwuxinxiTupian2.jpg,file/fuwuxinxiTupian3.jpg','服务类型1','2024-01-10 11:18:02','服务地点1','服务内容1'),(102,'2024-01-10 03:18:02','服务名称2','file/fuwuxinxiTupian2.jpg,file/fuwuxinxiTupian3.jpg,file/fuwuxinxiTupian4.jpg','服务类型2','2024-01-10 11:18:02','服务地点2','服务内容2'),(103,'2024-01-10 03:18:02','服务名称3','file/fuwuxinxiTupian3.jpg,file/fuwuxinxiTupian4.jpg,file/fuwuxinxiTupian5.jpg','服务类型3','2024-01-10 11:18:02','服务地点3','服务内容3'),(104,'2024-01-10 03:18:02','服务名称4','file/fuwuxinxiTupian4.jpg,file/fuwuxinxiTupian5.jpg,file/fuwuxinxiTupian6.jpg','服务类型4','2024-01-10 11:18:02','服务地点4','服务内容4'),(105,'2024-01-10 03:18:02','服务名称5','file/fuwuxinxiTupian5.jpg,file/fuwuxinxiTupian6.jpg,file/fuwuxinxiTupian7.jpg','服务类型5','2024-01-10 11:18:02','服务地点5','服务内容5'),(106,'2024-01-10 03:18:02','服务名称6','file/fuwuxinxiTupian6.jpg,file/fuwuxinxiTupian7.jpg,file/fuwuxinxiTupian8.jpg','服务类型6','2024-01-10 11:18:02','服务地点6','服务内容6');
/*!40000 ALTER TABLE `fuwuxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fuwuyuyue`
--

DROP TABLE IF EXISTS `fuwuyuyue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fuwuyuyue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fuwumingcheng` varchar(200) NOT NULL COMMENT '服务名称',
  `fuwushijian` datetime NOT NULL COMMENT '服务时间',
  `fuwudidian` varchar(200) NOT NULL COMMENT '服务地点',
  `yuyueriqi` datetime DEFAULT NULL COMMENT '预约日期',
  `laorenzhanghao` varchar(200) DEFAULT NULL COMMENT '老人账号',
  `laorenxingming` varchar(200) DEFAULT NULL COMMENT '老人姓名',
  `jianhurenzhanghao` varchar(200) DEFAULT NULL COMMENT '监护人账号',
  `jianhurenxingming` varchar(200) DEFAULT NULL COMMENT '监护人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COMMENT='服务预约';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fuwuyuyue`
--

LOCK TABLES `fuwuyuyue` WRITE;
/*!40000 ALTER TABLE `fuwuyuyue` DISABLE KEYS */;
INSERT INTO `fuwuyuyue` VALUES (111,'2024-01-10 03:18:02','服务名称1','2024-01-10 11:18:02','服务地点1','2024-01-10 11:18:02','老人账号1','老人姓名1','监护人账号1','监护人姓名1'),(112,'2024-01-10 03:18:02','服务名称2','2024-01-10 11:18:02','服务地点2','2024-01-10 11:18:02','老人账号2','老人姓名2','监护人账号2','监护人姓名2'),(113,'2024-01-10 03:18:02','服务名称3','2024-01-10 11:18:02','服务地点3','2024-01-10 11:18:02','老人账号3','老人姓名3','监护人账号3','监护人姓名3'),(114,'2024-01-10 03:18:02','服务名称4','2024-01-10 11:18:02','服务地点4','2024-01-10 11:18:02','老人账号4','老人姓名4','监护人账号4','监护人姓名4'),(115,'2024-01-10 03:18:02','服务名称5','2024-01-10 11:18:02','服务地点5','2024-01-10 11:18:02','老人账号5','老人姓名5','监护人账号5','监护人姓名5'),(116,'2024-01-10 03:18:02','服务名称6','2024-01-10 11:18:02','服务地点6','2024-01-10 11:18:02','老人账号6','老人姓名6','监护人账号6','监护人姓名6');
/*!40000 ALTER TABLE `fuwuyuyue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huodongquyu`
--

DROP TABLE IF EXISTS `huodongquyu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huodongquyu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `huodongquyu` varchar(200) DEFAULT NULL COMMENT '活动区域',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8 COMMENT='活动区域';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huodongquyu`
--

LOCK TABLES `huodongquyu` WRITE;
/*!40000 ALTER TABLE `huodongquyu` DISABLE KEYS */;
INSERT INTO `huodongquyu` VALUES (161,'2024-01-10 03:18:02','活动区域1'),(162,'2024-01-10 03:18:02','活动区域2'),(163,'2024-01-10 03:18:02','活动区域3'),(164,'2024-01-10 03:18:02','活动区域4'),(165,'2024-01-10 03:18:02','活动区域5'),(166,'2024-01-10 03:18:02','活动区域6');
/*!40000 ALTER TABLE `huodongquyu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huodongxinxi`
--

DROP TABLE IF EXISTS `huodongxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huodongxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `huodongmingcheng` varchar(200) NOT NULL COMMENT '活动名称',
  `huodongtupian` longtext COMMENT '活动图片',
  `huodongshijian` datetime DEFAULT NULL COMMENT '活动时间',
  `huodongquyu` varchar(200) DEFAULT NULL COMMENT '活动区域',
  `huodongdidian` varchar(200) DEFAULT NULL COMMENT '活动地点',
  `huodongneirong` longtext COMMENT '活动内容',
  `fabushijian` datetime DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8 COMMENT='活动信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huodongxinxi`
--

LOCK TABLES `huodongxinxi` WRITE;
/*!40000 ALTER TABLE `huodongxinxi` DISABLE KEYS */;
INSERT INTO `huodongxinxi` VALUES (151,'2024-01-10 03:18:02','活动名称1','file/huodongxinxiHuodongtupian1.jpg,file/huodongxinxiHuodongtupian2.jpg,file/huodongxinxiHuodongtupian3.jpg','2024-01-10 11:18:02','活动区域1','活动地点1','活动内容1','2024-01-10 11:18:02'),(152,'2024-01-10 03:18:02','活动名称2','file/huodongxinxiHuodongtupian2.jpg,file/huodongxinxiHuodongtupian3.jpg,file/huodongxinxiHuodongtupian4.jpg','2024-01-10 11:18:02','活动区域2','活动地点2','活动内容2','2024-01-10 11:18:02'),(153,'2024-01-10 03:18:02','活动名称3','file/huodongxinxiHuodongtupian3.jpg,file/huodongxinxiHuodongtupian4.jpg,file/huodongxinxiHuodongtupian5.jpg','2024-01-10 11:18:02','活动区域3','活动地点3','活动内容3','2024-01-10 11:18:02'),(154,'2024-01-10 03:18:02','活动名称4','file/huodongxinxiHuodongtupian4.jpg,file/huodongxinxiHuodongtupian5.jpg,file/huodongxinxiHuodongtupian6.jpg','2024-01-10 11:18:02','活动区域4','活动地点4','活动内容4','2024-01-10 11:18:02'),(155,'2024-01-10 03:18:02','活动名称5','file/huodongxinxiHuodongtupian5.jpg,file/huodongxinxiHuodongtupian6.jpg,file/huodongxinxiHuodongtupian7.jpg','2024-01-10 11:18:02','活动区域5','活动地点5','活动内容5','2024-01-10 11:18:02'),(156,'2024-01-10 03:18:02','活动名称6','file/huodongxinxiHuodongtupian6.jpg,file/huodongxinxiHuodongtupian7.jpg,file/huodongxinxiHuodongtupian8.jpg','2024-01-10 11:18:02','活动区域6','活动地点6','活动内容6','2024-01-10 11:18:02');
/*!40000 ALTER TABLE `huodongxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jianhuren`
--

DROP TABLE IF EXISTS `jianhuren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jianhuren` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jianhurenzhanghao` varchar(200) NOT NULL COMMENT '监护人账号',
  `jianhurenmima` varchar(200) NOT NULL COMMENT '监护人密码',
  `jianhurenxingming` varchar(200) NOT NULL COMMENT '监护人姓名',
  `touxiang` longtext COMMENT '头像',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shoujihaoma` varchar(200) DEFAULT NULL COMMENT '手机号码',
  `laorenzhanghao` varchar(200) DEFAULT NULL COMMENT '老人账号',
  `laorenxingming` varchar(200) DEFAULT NULL COMMENT '老人姓名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `jianhurenzhanghao` (`jianhurenzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='监护人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jianhuren`
--

LOCK TABLES `jianhuren` WRITE;
/*!40000 ALTER TABLE `jianhuren` DISABLE KEYS */;
INSERT INTO `jianhuren` VALUES (41,'2024-01-10 03:18:02','监护人账号1','e10adc3949ba59abbe56e057f20f883e','监护人姓名1','file/jianhurenTouxiang1.jpg','男','19819881111','老人账号1','老人姓名1'),(42,'2024-01-10 03:18:02','监护人账号2','e10adc3949ba59abbe56e057f20f883e','监护人姓名2','file/jianhurenTouxiang2.jpg','男','19819881112','老人账号2','老人姓名2'),(43,'2024-01-10 03:18:02','监护人账号3','e10adc3949ba59abbe56e057f20f883e','监护人姓名3','file/jianhurenTouxiang3.jpg','男','19819881113','老人账号3','老人姓名3'),(44,'2024-01-10 03:18:02','监护人账号4','e10adc3949ba59abbe56e057f20f883e','监护人姓名4','file/jianhurenTouxiang4.jpg','男','19819881114','老人账号4','老人姓名4'),(45,'2024-01-10 03:18:02','监护人账号5','e10adc3949ba59abbe56e057f20f883e','监护人姓名5','file/jianhurenTouxiang5.jpg','男','19819881115','老人账号5','老人姓名5'),(46,'2024-01-10 03:18:02','监护人账号6','e10adc3949ba59abbe56e057f20f883e','监护人姓名6','file/jianhurenTouxiang6.jpg','男','19819881116','老人账号6','老人姓名6');
/*!40000 ALTER TABLE `jianhuren` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiankangkepu`
--

DROP TABLE IF EXISTS `jiankangkepu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jiankangkepu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) NOT NULL COMMENT '标题',
  `tupian` longtext COMMENT '图片',
  `jianjie` longtext COMMENT '简介',
  `neirong` longtext COMMENT '内容',
  `shipin` longtext COMMENT '视频',
  `fabiaoriqi` date NOT NULL COMMENT '发表日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='健康科普';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiankangkepu`
--

LOCK TABLES `jiankangkepu` WRITE;
/*!40000 ALTER TABLE `jiankangkepu` DISABLE KEYS */;
INSERT INTO `jiankangkepu` VALUES (61,'2024-01-10 03:18:02','标题1','file/jiankangkepuTupian1.jpg,file/jiankangkepuTupian2.jpg,file/jiankangkepuTupian3.jpg','简介1','内容1','','2024-01-10'),(62,'2024-01-10 03:18:02','标题2','file/jiankangkepuTupian2.jpg,file/jiankangkepuTupian3.jpg,file/jiankangkepuTupian4.jpg','简介2','内容2','','2024-01-10'),(63,'2024-01-10 03:18:02','标题3','file/jiankangkepuTupian3.jpg,file/jiankangkepuTupian4.jpg,file/jiankangkepuTupian5.jpg','简介3','内容3','','2024-01-10'),(64,'2024-01-10 03:18:02','标题4','file/jiankangkepuTupian4.jpg,file/jiankangkepuTupian5.jpg,file/jiankangkepuTupian6.jpg','简介4','内容4','','2024-01-10'),(65,'2024-01-10 03:18:02','标题5','file/jiankangkepuTupian5.jpg,file/jiankangkepuTupian6.jpg,file/jiankangkepuTupian7.jpg','简介5','内容5','','2024-01-10'),(66,'2024-01-10 03:18:02','标题6','file/jiankangkepuTupian6.jpg,file/jiankangkepuTupian7.jpg,file/jiankangkepuTupian8.jpg','简介6','内容6','','2024-01-10');
/*!40000 ALTER TABLE `jiankangkepu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiankangshuju`
--

DROP TABLE IF EXISTS `jiankangshuju`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jiankangshuju` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `laorenzhanghao` varchar(200) DEFAULT NULL COMMENT '老人账号',
  `laorenxingming` varchar(200) DEFAULT NULL COMMENT '老人姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` varchar(200) DEFAULT NULL COMMENT '年龄',
  `jianhurenzhanghao` varchar(200) DEFAULT NULL COMMENT '监护人账号',
  `jianhurenxingming` varchar(200) DEFAULT NULL COMMENT '监护人姓名',
  `shengao` varchar(200) DEFAULT NULL COMMENT '身高',
  `tizhong` varchar(200) DEFAULT NULL COMMENT '体重',
  `xueya` varchar(200) DEFAULT NULL COMMENT '血压',
  `xuetang` varchar(200) DEFAULT NULL COMMENT '血糖',
  `xinlv` varchar(200) DEFAULT NULL COMMENT '心率',
  `dengjishijian` datetime DEFAULT NULL COMMENT '登记时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='健康数据';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiankangshuju`
--

LOCK TABLES `jiankangshuju` WRITE;
/*!40000 ALTER TABLE `jiankangshuju` DISABLE KEYS */;
INSERT INTO `jiankangshuju` VALUES (71,'2024-01-10 03:18:02','老人账号1','老人姓名1','性别1','年龄1','监护人账号1','监护人姓名1','身高1','体重1','血压1','血糖1','心率1','2024-01-10 11:18:02'),(72,'2024-01-10 03:18:02','老人账号2','老人姓名2','性别2','年龄2','监护人账号2','监护人姓名2','身高2','体重2','血压2','血糖2','心率2','2024-01-10 11:18:02'),(73,'2024-01-10 03:18:02','老人账号3','老人姓名3','性别3','年龄3','监护人账号3','监护人姓名3','身高3','体重3','血压3','血糖3','心率3','2024-01-10 11:18:02'),(74,'2024-01-10 03:18:02','老人账号4','老人姓名4','性别4','年龄4','监护人账号4','监护人姓名4','身高4','体重4','血压4','血糖4','心率4','2024-01-10 11:18:02'),(75,'2024-01-10 03:18:02','老人账号5','老人姓名5','性别5','年龄5','监护人账号5','监护人姓名5','身高5','体重5','血压5','血糖5','心率5','2024-01-10 11:18:02'),(76,'2024-01-10 03:18:02','老人账号6','老人姓名6','性别6','年龄6','监护人账号6','监护人姓名6','身高6','体重6','血压6','血糖6','心率6','2024-01-10 11:18:02');
/*!40000 ALTER TABLE `jiankangshuju` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiankangxinxi`
--

DROP TABLE IF EXISTS `jiankangxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jiankangxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `laorenzhanghao` varchar(200) DEFAULT NULL COMMENT '老人账号',
  `laorenxingming` varchar(200) DEFAULT NULL COMMENT '老人姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` varchar(200) DEFAULT NULL COMMENT '年龄',
  `jianhurenzhanghao` varchar(200) DEFAULT NULL COMMENT '监护人账号',
  `jianhurenxingming` varchar(200) DEFAULT NULL COMMENT '监护人姓名',
  `jiankangzhuangkuang` longtext COMMENT '健康状况',
  `manxingbing` varchar(200) DEFAULT NULL COMMENT '慢性病',
  `jiazubingshi` varchar(200) DEFAULT NULL COMMENT '家族病史',
  `dengjishijian` datetime DEFAULT NULL COMMENT '登记时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='健康信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiankangxinxi`
--

LOCK TABLES `jiankangxinxi` WRITE;
/*!40000 ALTER TABLE `jiankangxinxi` DISABLE KEYS */;
INSERT INTO `jiankangxinxi` VALUES (81,'2024-01-10 03:18:02','老人账号1','老人姓名1','性别1','年龄1','监护人账号1','监护人姓名1','健康状况1','慢性病1','家族病史1','2024-01-10 11:18:02'),(82,'2024-01-10 03:18:02','老人账号2','老人姓名2','性别2','年龄2','监护人账号2','监护人姓名2','健康状况2','慢性病2','家族病史2','2024-01-10 11:18:02'),(83,'2024-01-10 03:18:02','老人账号3','老人姓名3','性别3','年龄3','监护人账号3','监护人姓名3','健康状况3','慢性病3','家族病史3','2024-01-10 11:18:02'),(84,'2024-01-10 03:18:02','老人账号4','老人姓名4','性别4','年龄4','监护人账号4','监护人姓名4','健康状况4','慢性病4','家族病史4','2024-01-10 11:18:02'),(85,'2024-01-10 03:18:02','老人账号5','老人姓名5','性别5','年龄5','监护人账号5','监护人姓名5','健康状况5','慢性病5','家族病史5','2024-01-10 11:18:02'),(86,'2024-01-10 03:18:02','老人账号6','老人姓名6','性别6','年龄6','监护人账号6','监护人姓名6','健康状况6','慢性病6','家族病史6','2024-01-10 11:18:02');
/*!40000 ALTER TABLE `jiankangxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laoren`
--

DROP TABLE IF EXISTS `laoren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laoren` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `laorenzhanghao` varchar(200) NOT NULL COMMENT '老人账号',
  `laorenmima` varchar(200) NOT NULL COMMENT '老人密码',
  `laorenxingming` varchar(200) NOT NULL COMMENT '老人姓名',
  `touxiang` longtext COMMENT '头像',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `nianling` varchar(200) DEFAULT NULL COMMENT '年龄',
  `shoujihaoma` varchar(200) DEFAULT NULL COMMENT '手机号码',
  `jianhurenzhanghao` varchar(200) DEFAULT NULL COMMENT '监护人账号',
  `jianhurenxingming` varchar(200) DEFAULT NULL COMMENT '监护人姓名',
  `lianxifangshi` varchar(200) DEFAULT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`),
  UNIQUE KEY `laorenzhanghao` (`laorenzhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='老人';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laoren`
--

LOCK TABLES `laoren` WRITE;
/*!40000 ALTER TABLE `laoren` DISABLE KEYS */;
INSERT INTO `laoren` VALUES (31,'2024-01-10 03:18:02','老人账号1','e10adc3949ba59abbe56e057f20f883e','老人姓名1','file/laorenTouxiang1.jpg','男','年龄1','19819881111','监护人账号1','监护人姓名1','19819881111'),(32,'2024-01-10 03:18:02','老人账号2','e10adc3949ba59abbe56e057f20f883e','老人姓名2','file/laorenTouxiang2.jpg','男','年龄2','19819881112','监护人账号2','监护人姓名2','19819881112'),(33,'2024-01-10 03:18:02','老人账号3','e10adc3949ba59abbe56e057f20f883e','老人姓名3','file/laorenTouxiang3.jpg','男','年龄3','19819881113','监护人账号3','监护人姓名3','19819881113'),(34,'2024-01-10 03:18:02','老人账号4','e10adc3949ba59abbe56e057f20f883e','老人姓名4','file/laorenTouxiang4.jpg','男','年龄4','19819881114','监护人账号4','监护人姓名4','19819881114'),(35,'2024-01-10 03:18:02','老人账号5','e10adc3949ba59abbe56e057f20f883e','老人姓名5','file/laorenTouxiang5.jpg','男','年龄5','19819881115','监护人账号5','监护人姓名5','19819881115'),(36,'2024-01-10 03:18:02','老人账号6','e10adc3949ba59abbe56e057f20f883e','老人姓名6','file/laorenTouxiang6.jpg','男','年龄6','19819881116','监护人账号6','监护人姓名6','19819881116');
/*!40000 ALTER TABLE `laoren` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext COMMENT '菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2024-01-10 03:18:02','[{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-goods\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"轮播图\",\"menuJump\":\"列表\",\"tableName\":\"config\"}],\"fontClass\":\"icon-common29\",\"menu\":\"轮播图管理\",\"unicode\":\"&#xee2e;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-present\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"老人\",\"menuJump\":\"列表\",\"tableName\":\"laoren\"},{\"appFrontIcon\":\"cuIcon-copy\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"监护人\",\"menuJump\":\"列表\",\"tableName\":\"jianhuren\"},{\"appFrontIcon\":\"cuIcon-newshot\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\"],\"menu\":\"志愿者\",\"menuJump\":\"列表\",\"tableName\":\"zhiyuanzhe\"},{\"appFrontIcon\":\"cuIcon-full\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"管理员\",\"menuJump\":\"列表\",\"tableName\":\"users\"}],\"fontClass\":\"icon-common14\",\"menu\":\"系统用户管理\",\"unicode\":\"&#xedfb;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健康科普\",\"menuJump\":\"列表\",\"tableName\":\"jiankangkepu\"}],\"fontClass\":\"icon-common18\",\"menu\":\"健康科普管理\",\"unicode\":\"&#xedff;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"活动信息\",\"menuJump\":\"列表\",\"tableName\":\"huodongxinxi\"},{\"appFrontIcon\":\"cuIcon-attentionfavor\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"活动区域\",\"menuJump\":\"列表\",\"tableName\":\"huodongquyu\"}],\"fontClass\":\"icon-common32\",\"menu\":\"活动信息管理\",\"unicode\":\"&#xee66;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"预约取消\",\"menuJump\":\"列表\",\"tableName\":\"yuyuequxiao\"},{\"appFrontIcon\":\"cuIcon-medal\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"服务类型\",\"menuJump\":\"列表\",\"tableName\":\"fuwuleixing\"},{\"appFrontIcon\":\"cuIcon-skin\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"服务信息\",\"menuJump\":\"列表\",\"tableName\":\"fuwuxinxi\"},{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"服务分派\"],\"menu\":\"服务预约\",\"menuJump\":\"列表\",\"tableName\":\"fuwuyuyue\"}],\"fontClass\":\"icon-common20\",\"menu\":\"服务信息管理\",\"unicode\":\"&#xee02;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-skin\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"服务分派\",\"menuJump\":\"列表\",\"tableName\":\"fuwufenpai\"},{\"appFrontIcon\":\"cuIcon-attentionfavor\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"查看评论\"],\"menu\":\"服务记录\",\"menuJump\":\"列表\",\"tableName\":\"fuwujilu\"}],\"fontClass\":\"icon-common13\",\"menu\":\"服务记录管理\",\"unicode\":\"&#xedf7;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健康信息\",\"menuJump\":\"列表\",\"tableName\":\"jiankangxinxi\"},{\"appFrontIcon\":\"cuIcon-wenzi\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"健康数据\",\"menuJump\":\"列表\",\"tableName\":\"jiankangshuju\"}],\"fontClass\":\"icon-common16\",\"menu\":\"健康信息管理\",\"unicode\":\"&#xedfd;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"提醒功能\",\"menuJump\":\"列表\",\"tableName\":\"tixinggongneng\"}],\"fontClass\":\"icon-common30\",\"menu\":\"提醒功能管理\",\"unicode\":\"&#xee30;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\"],\"menu\":\"健康科普\",\"menuJump\":\"列表\",\"tableName\":\"jiankangkepu\"}],\"menu\":\"健康科普管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"查看\"],\"menu\":\"活动信息\",\"menuJump\":\"列表\",\"tableName\":\"huodongxinxi\"}],\"menu\":\"活动信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"查看\",\"服务预约\"],\"menu\":\"服务信息\",\"menuJump\":\"列表\",\"tableName\":\"fuwuxinxi\"}],\"menu\":\"服务信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-skin\",\"buttons\":[\"查看\"],\"menu\":\"服务记录\",\"menuJump\":\"列表\",\"tableName\":\"fuwujilu\"}],\"menu\":\"服务记录管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"查看\",\"预约取消\"],\"menu\":\"服务预约\",\"menuJump\":\"列表\",\"tableName\":\"fuwuyuyue\"},{\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\"],\"menu\":\"预约取消\",\"menuJump\":\"列表\",\"tableName\":\"yuyuequxiao\"}],\"fontClass\":\"icon-common20\",\"menu\":\"服务信息管理\",\"unicode\":\"&#xee02;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-wenzi\",\"buttons\":[\"查看\"],\"menu\":\"健康数据\",\"menuJump\":\"列表\",\"tableName\":\"jiankangshuju\"},{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"menu\":\"健康信息\",\"menuJump\":\"列表\",\"tableName\":\"jiankangxinxi\"}],\"fontClass\":\"icon-common16\",\"menu\":\"健康信息管理\",\"unicode\":\"&#xedfd;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"查看\"],\"menu\":\"提醒功能\",\"menuJump\":\"列表\",\"tableName\":\"tixinggongneng\"}],\"fontClass\":\"icon-common30\",\"menu\":\"提醒功能管理\",\"unicode\":\"&#xee30;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\"],\"menu\":\"健康科普\",\"menuJump\":\"列表\",\"tableName\":\"jiankangkepu\"}],\"menu\":\"健康科普管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"查看\"],\"menu\":\"活动信息\",\"menuJump\":\"列表\",\"tableName\":\"huodongxinxi\"}],\"menu\":\"活动信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"查看\",\"服务预约\"],\"menu\":\"服务信息\",\"menuJump\":\"列表\",\"tableName\":\"fuwuxinxi\"}],\"menu\":\"服务信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-skin\",\"buttons\":[\"查看\"],\"menu\":\"服务记录\",\"menuJump\":\"列表\",\"tableName\":\"fuwujilu\"}],\"menu\":\"服务记录管理\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"roleName\":\"老人\",\"tableName\":\"laoren\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"查看\"],\"menu\":\"服务预约\",\"menuJump\":\"列表\",\"tableName\":\"fuwuyuyue\"},{\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\"],\"menu\":\"预约取消\",\"menuJump\":\"列表\",\"tableName\":\"yuyuequxiao\"}],\"fontClass\":\"icon-common20\",\"menu\":\"服务信息管理\",\"unicode\":\"&#xee02;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-wenzi\",\"buttons\":[\"查看\"],\"menu\":\"健康数据\",\"menuJump\":\"列表\",\"tableName\":\"jiankangshuju\"},{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"menu\":\"健康信息\",\"menuJump\":\"列表\",\"tableName\":\"jiankangxinxi\"}],\"fontClass\":\"icon-common16\",\"menu\":\"健康信息管理\",\"unicode\":\"&#xedfd;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-pay\",\"buttons\":[\"新增\",\"查看\"],\"menu\":\"提醒功能\",\"menuJump\":\"列表\",\"tableName\":\"tixinggongneng\"}],\"fontClass\":\"icon-common30\",\"menu\":\"提醒功能管理\",\"unicode\":\"&#xee30;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\"],\"menu\":\"健康科普\",\"menuJump\":\"列表\",\"tableName\":\"jiankangkepu\"}],\"menu\":\"健康科普管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"查看\"],\"menu\":\"活动信息\",\"menuJump\":\"列表\",\"tableName\":\"huodongxinxi\"}],\"menu\":\"活动信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"查看\",\"服务预约\"],\"menu\":\"服务信息\",\"menuJump\":\"列表\",\"tableName\":\"fuwuxinxi\"}],\"menu\":\"服务信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-skin\",\"buttons\":[\"查看\"],\"menu\":\"服务记录\",\"menuJump\":\"列表\",\"tableName\":\"fuwujilu\"}],\"menu\":\"服务记录管理\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"roleName\":\"监护人\",\"tableName\":\"jianhuren\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-skin\",\"buttons\":[\"查看\"],\"menu\":\"服务分派\",\"menuJump\":\"列表\",\"tableName\":\"fuwufenpai\"},{\"appFrontIcon\":\"cuIcon-attentionfavor\",\"buttons\":[\"查看\",\"新增\",\"查看评论\"],\"menu\":\"服务记录\",\"menuJump\":\"列表\",\"tableName\":\"fuwujilu\"}],\"fontClass\":\"icon-common13\",\"menu\":\"服务记录管理\",\"unicode\":\"&#xedf7;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\"],\"menu\":\"健康科普\",\"menuJump\":\"列表\",\"tableName\":\"jiankangkepu\"}],\"menu\":\"健康科普管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"查看\"],\"menu\":\"活动信息\",\"menuJump\":\"列表\",\"tableName\":\"huodongxinxi\"}],\"menu\":\"活动信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"查看\",\"服务预约\"],\"menu\":\"服务信息\",\"menuJump\":\"列表\",\"tableName\":\"fuwuxinxi\"}],\"menu\":\"服务信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-skin\",\"buttons\":[\"查看\"],\"menu\":\"服务记录\",\"menuJump\":\"列表\",\"tableName\":\"fuwujilu\"}],\"menu\":\"服务记录管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"是\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"志愿者\",\"tableName\":\"zhiyuanzhe\"}]');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tixinggongneng`
--

DROP TABLE IF EXISTS `tixinggongneng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tixinggongneng` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `riqi` datetime DEFAULT NULL COMMENT '日期',
  `tixingbiaoti` varchar(200) DEFAULT NULL COMMENT '提醒标题',
  `tixingneirong` longtext COMMENT '提醒内容',
  `jianhurenzhanghao` varchar(200) DEFAULT NULL COMMENT '监护人账号',
  `jianhurenxingming` varchar(200) DEFAULT NULL COMMENT '监护人姓名',
  `laorenzhanghao` varchar(200) DEFAULT NULL COMMENT '老人账号',
  `laorenxingming` varchar(200) DEFAULT NULL COMMENT '老人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8 COMMENT='提醒功能';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tixinggongneng`
--

LOCK TABLES `tixinggongneng` WRITE;
/*!40000 ALTER TABLE `tixinggongneng` DISABLE KEYS */;
INSERT INTO `tixinggongneng` VALUES (171,'2024-01-10 03:18:02','2024-01-10 11:18:02','提醒标题1','提醒内容1','监护人账号1','监护人姓名1','老人账号1','老人姓名1'),(172,'2024-01-10 03:18:02','2024-01-10 11:18:02','提醒标题2','提醒内容2','监护人账号2','监护人姓名2','老人账号2','老人姓名2'),(173,'2024-01-10 03:18:02','2024-01-10 11:18:02','提醒标题3','提醒内容3','监护人账号3','监护人姓名3','老人账号3','老人姓名3'),(174,'2024-01-10 03:18:02','2024-01-10 11:18:02','提醒标题4','提醒内容4','监护人账号4','监护人姓名4','老人账号4','老人姓名4'),(175,'2024-01-10 03:18:02','2024-01-10 11:18:02','提醒标题5','提醒内容5','监护人账号5','监护人姓名5','老人账号5','老人姓名5'),(176,'2024-01-10 03:18:02','2024-01-10 11:18:02','提醒标题6','提醒内容6','监护人账号6','监护人姓名6','老人账号6','老人姓名6');
/*!40000 ALTER TABLE `tixinggongneng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) NOT NULL COMMENT '用户名',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `role` varchar(200) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2024-01-10 03:18:02','admin','admin','管理员');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yuyuequxiao`
--

DROP TABLE IF EXISTS `yuyuequxiao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yuyuequxiao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fuwumingcheng` varchar(200) NOT NULL COMMENT '服务名称',
  `fuwushijian` datetime NOT NULL COMMENT '服务时间',
  `fuwudidian` varchar(200) NOT NULL COMMENT '服务地点',
  `yuyueriqi` datetime DEFAULT NULL COMMENT '预约日期',
  `laorenzhanghao` varchar(200) DEFAULT NULL COMMENT '老人账号',
  `laorenxingming` varchar(200) DEFAULT NULL COMMENT '老人姓名',
  `jianhurenzhanghao` varchar(200) DEFAULT NULL COMMENT '监护人账号',
  `jianhurenxingming` varchar(200) DEFAULT NULL COMMENT '监护人姓名',
  `quxiaoshijian` datetime DEFAULT NULL COMMENT '取消时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8 COMMENT='预约取消';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yuyuequxiao`
--

LOCK TABLES `yuyuequxiao` WRITE;
/*!40000 ALTER TABLE `yuyuequxiao` DISABLE KEYS */;
INSERT INTO `yuyuequxiao` VALUES (121,'2024-01-10 03:18:02','服务名称1','2024-01-10 11:18:02','服务地点1','2024-01-10 11:18:02','老人账号1','老人姓名1','监护人账号1','监护人姓名1','2024-01-10 11:18:02'),(122,'2024-01-10 03:18:02','服务名称2','2024-01-10 11:18:02','服务地点2','2024-01-10 11:18:02','老人账号2','老人姓名2','监护人账号2','监护人姓名2','2024-01-10 11:18:02'),(123,'2024-01-10 03:18:02','服务名称3','2024-01-10 11:18:02','服务地点3','2024-01-10 11:18:02','老人账号3','老人姓名3','监护人账号3','监护人姓名3','2024-01-10 11:18:02'),(124,'2024-01-10 03:18:02','服务名称4','2024-01-10 11:18:02','服务地点4','2024-01-10 11:18:02','老人账号4','老人姓名4','监护人账号4','监护人姓名4','2024-01-10 11:18:02'),(125,'2024-01-10 03:18:02','服务名称5','2024-01-10 11:18:02','服务地点5','2024-01-10 11:18:02','老人账号5','老人姓名5','监护人账号5','监护人姓名5','2024-01-10 11:18:02'),(126,'2024-01-10 03:18:02','服务名称6','2024-01-10 11:18:02','服务地点6','2024-01-10 11:18:02','老人账号6','老人姓名6','监护人账号6','监护人姓名6','2024-01-10 11:18:02');
/*!40000 ALTER TABLE `yuyuequxiao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zhiyuanzhe`
--

DROP TABLE IF EXISTS `zhiyuanzhe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zhiyuanzhe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhiyuanzhezhanghao` varchar(200) NOT NULL COMMENT '志愿者账号',
  `zhiyuanzhemima` varchar(200) NOT NULL COMMENT '志愿者密码',
  `touxiang` longtext COMMENT '头像',
  `zhiyuanzhexingming` varchar(200) NOT NULL COMMENT '志愿者姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `shenfenzhenghao` varchar(200) DEFAULT NULL COMMENT '身份证号',
  `sfsh` varchar(200) DEFAULT NULL COMMENT '是否审核',
  `shhf` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhiyuanzhezhanghao` (`zhiyuanzhezhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='志愿者';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhiyuanzhe`
--

LOCK TABLES `zhiyuanzhe` WRITE;
/*!40000 ALTER TABLE `zhiyuanzhe` DISABLE KEYS */;
INSERT INTO `zhiyuanzhe` VALUES (51,'2024-01-10 03:18:02','志愿者账号1','e10adc3949ba59abbe56e057f20f883e','file/zhiyuanzheTouxiang1.jpg','志愿者姓名1','男','19819881111','441622200101010001','是',''),(52,'2024-01-10 03:18:02','志愿者账号2','e10adc3949ba59abbe56e057f20f883e','file/zhiyuanzheTouxiang2.jpg','志愿者姓名2','男','19819881112','441622200202020002','是',''),(53,'2024-01-10 03:18:02','志愿者账号3','e10adc3949ba59abbe56e057f20f883e','file/zhiyuanzheTouxiang3.jpg','志愿者姓名3','男','19819881113','441622200303030003','是',''),(54,'2024-01-10 03:18:02','志愿者账号4','e10adc3949ba59abbe56e057f20f883e','file/zhiyuanzheTouxiang4.jpg','志愿者姓名4','男','19819881114','441622200404040004','是',''),(55,'2024-01-10 03:18:02','志愿者账号5','e10adc3949ba59abbe56e057f20f883e','file/zhiyuanzheTouxiang5.jpg','志愿者姓名5','男','19819881115','441622200505050005','是',''),(56,'2024-01-10 03:18:02','志愿者账号6','e10adc3949ba59abbe56e057f20f883e','file/zhiyuanzheTouxiang6.jpg','志愿者姓名6','男','19819881116','441622200606060006','是','');
/*!40000 ALTER TABLE `zhiyuanzhe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-10 14:17:29
