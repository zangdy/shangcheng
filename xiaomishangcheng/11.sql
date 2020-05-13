/*
SQLyog v10.2 
MySQL - 5.0.96-community-nt : Database - xiaomi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xiaomi` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xiaomi`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `state` int(1) default NULL,
  `order_number` int(5) default NULL,
  `description` varchar(100) default NULL,
  `create_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`name`,`state`,`order_number`,`description`,`create_time`) values (1,'手机',0,1,'手机和电脑的设备都在这里','2020-01-08 09:48:04'),(2,'电脑',0,2,'		    		随便来点啥吧\r\n		    专门挑刺来的','2020-01-08 14:24:32'),(3,'电视',0,3,'电视','2020-01-08 14:31:55'),(5,'智能家电',0,4,'智能家居','2019-11-26 10:44:23'),(6,'配件',0,5,'手机电脑的配件','2019-11-26 10:44:23'),(7,'耳机音箱',0,6,'小音箱','2019-11-26 10:44:23'),(8,'保护套手机膜',0,7,'膜','2019-11-26 10:44:23'),(9,'周边耗材',0,8,'周边耗材','2019-11-26 10:44:23'),(10,'流行单品',0,9,'流行单品','2019-11-26 10:44:23'),(11,'生活周边',0,10,'生活周边','2019-11-26 10:44:23'),(12,'珠宝翡翠',0,0,'魔翡翠','2020-03-18 20:28:25'),(13,'给个机会',1,99,'测试添加后的页面跳转','2020-03-18 20:31:58');

/*Table structure for table `commodity` */

DROP TABLE IF EXISTS `commodity`;

CREATE TABLE `commodity` (
  `id` int(10) NOT NULL auto_increment,
  `cid` int(10) default NULL,
  `name` varchar(50) NOT NULL,
  `color` varchar(50) default NULL,
  `size` varchar(50) default NULL,
  `price` double NOT NULL,
  `description` varchar(500) default NULL,
  `full_description` varchar(1000) default NULL,
  `pic` varchar(200) default NULL,
  `state` int(5) default '0',
  `version` varchar(50) default NULL,
  `product_date` date default NULL,
  PRIMARY KEY  (`id`),
  KEY `cid` (`cid`),
  CONSTRAINT `commodity_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `commodity` */

insert  into `commodity`(`id`,`cid`,`name`,`color`,`size`,`price`,`description`,`full_description`,`pic`,`state`,`version`,`product_date`) values (4,1,'小米CC9e','黑色1','4.7',1999,'					value=\"焕然一新的设计\r\n注入温柔与浪漫的新配色\"\r\n				','					value=\"白色恋人的清新，仿佛是手中的一捧盈盈白雪，纯净天成。\r\n神秘的深蓝星球，微光滑过便如星河般耀目生辉。\r\n还有深沉的暗夜王子，光线之下难掩锋芒。三款配色，\r\n汇聚于3D全曲面玻璃机身之上，搭配高亮金属质感中框，\r\n温润触感款款心仪\"\r\n				','https://mall-wyan.oss-cn-beijing.aliyuncs.com/07884d30-4c0c-4462-adb0-99f310432d3f.png',1,'cce','2020-01-10'),(5,1,'小米RedMI Notee','黑色','4.7',2999,'焕然一新的设计\r\n注入温柔与浪漫的新配色','白色恋人的清新，仿佛是手中的一捧盈盈白雪，纯净天成。\r\n神秘的深蓝星球，微光滑过便如星河般耀目生辉。\r\n还有深沉的暗夜王子，光线之下难掩锋芒。三款配色，\r\n汇聚于3D全曲面玻璃机身之上，搭配高亮金属质感中框，\r\n温润触感款款心仪','https://img20.360buyimg.com/babel/s320x320_jfs/t4237/46/2291756292/61722/e460401a/58cf74e3Naf499b70.jpg!cc_320x320.webp',1,'cce','2020-01-10'),(6,1,'小米P30','黑色','4.7',3999,'焕然一新的设计\r\n注入温柔与浪漫的新配色','白色恋人的清新，仿佛是手中的一捧盈盈白雪，纯净天成。\r\n神秘的深蓝星球，微光滑过便如星河般耀目生辉。\r\n还有深沉的暗夜王子，光线之下难掩锋芒。三款配色，\r\n汇聚于3D全曲面玻璃机身之上，搭配高亮金属质感中框，\r\n温润触感款款心仪','https://img20.360buyimg.com/babel/s320x320_jfs/t4237/46/2291756292/61722/e460401a/58cf74e3Naf499b70.jpg!cc_320x320.webp',2,'cce','2020-01-10'),(7,1,'小米RedMi8A','黑色','4.7',4999,'焕然一新的设计\r\n注入温柔与浪漫的新配色','白色恋人的清新，仿佛是手中的一捧盈盈白雪，纯净天成。\r\n神秘的深蓝星球，微光滑过便如星河般耀目生辉。\r\n还有深沉的暗夜王子，光线之下难掩锋芒。三款配色，\r\n汇聚于3D全曲面玻璃机身之上，搭配高亮金属质感中框，\r\n温润触感款款心仪','https://img20.360buyimg.com/babel/s320x320_jfs/t4237/46/2291756292/61722/e460401a/58cf74e3Naf499b70.jpg!cc_320x320.webp',2,'cce','2020-01-10'),(8,1,'小米概念机','黑色','4.7',599,'焕然一新的设计\r\n注入温柔与浪漫的新配色','白色恋人的清新，仿佛是手中的一捧盈盈白雪，纯净天成。\r\n神秘的深蓝星球，微光滑过便如星河般耀目生辉。\r\n还有深沉的暗夜王子，光线之下难掩锋芒。三款配色，\r\n汇聚于3D全曲面玻璃机身之上，搭配高亮金属质感中框，\r\n温润触感款款心仪','https://img20.360buyimg.com/babel/s320x320_jfs/t4237/46/2291756292/61722/e460401a/58cf74e3Naf499b70.jpg!cc_320x320.webp',5,'cce','2020-01-10'),(9,5,'智能家电1','黑色','4.7',22,'焕然一新的设计\r\n注入温柔与浪漫的新配色','白色恋人的清新，仿佛是手中的一捧盈盈白雪，纯净天成。\r\n神秘的深蓝星球，微光滑过便如星河般耀目生辉。\r\n还有深沉的暗夜王子，光线之下难掩锋芒。三款配色，\r\n汇聚于3D全曲面玻璃机身之上，搭配高亮金属质感中框，\r\n温润触感款款心仪','https://img20.360buyimg.com/babel/s320x320_jfs/t4237/46/2291756292/61722/e460401a/58cf74e3Naf499b70.jpg!cc_320x320.webp',3,'cce','2020-01-10'),(10,5,'智能家电2','黑色','4.7',33,'焕然一新的设计\r\n注入温柔与浪漫的新配色','白色恋人的清新，仿佛是手中的一捧盈盈白雪，纯净天成。\r\n神秘的深蓝星球，微光滑过便如星河般耀目生辉。\r\n还有深沉的暗夜王子，光线之下难掩锋芒。三款配色，\r\n汇聚于3D全曲面玻璃机身之上，搭配高亮金属质感中框，\r\n温润触感款款心仪','https://img20.360buyimg.com/babel/s320x320_jfs/t4237/46/2291756292/61722/e460401a/58cf74e3Naf499b70.jpg!cc_320x320.webp',3,'cce','2020-01-10'),(11,5,'智能家电3','黑色','4.7',543,'焕然一新的设计\r\n注入温柔与浪漫的新配色','白色恋人的清新，仿佛是手中的一捧盈盈白雪，纯净天成。\r\n神秘的深蓝星球，微光滑过便如星河般耀目生辉。\r\n还有深沉的暗夜王子，光线之下难掩锋芒。三款配色，\r\n汇聚于3D全曲面玻璃机身之上，搭配高亮金属质感中框，\r\n温润触感款款心仪','https://img14.360buyimg.com/babel/s320x320_jfs/t2656/295/34058120/362134/d92995e5/56fc835dNe349b797.jpg!cc_320x320.webp',3,'cce','2020-01-10'),(12,5,'智能家电4','黑色','4.7',123,'焕然一新的设计\r\n注入温柔与浪漫的新配色','白色恋人的清新，仿佛是手中的一捧盈盈白雪，纯净天成。\r\n神秘的深蓝星球，微光滑过便如星河般耀目生辉。\r\n还有深沉的暗夜王子，光线之下难掩锋芒。三款配色，\r\n汇聚于3D全曲面玻璃机身之上，搭配高亮金属质感中框，\r\n温润触感款款心仪','https://img14.360buyimg.com/babel/s320x320_jfs/t2656/295/34058120/362134/d92995e5/56fc835dNe349b797.jpg!cc_320x320.webp',2,'cce','2020-01-10'),(13,5,'智能家电5','黑色','4.7',2443,'焕然一新的设计\r\n注入温柔与浪漫的新配色','白色恋人的清新，仿佛是手中的一捧盈盈白雪，纯净天成。\r\n神秘的深蓝星球，微光滑过便如星河般耀目生辉。\r\n还有深沉的暗夜王子，光线之下难掩锋芒。三款配色，\r\n汇聚于3D全曲面玻璃机身之上，搭配高亮金属质感中框，\r\n温润触感款款心仪','https://img14.360buyimg.com/babel/s320x320_jfs/t2656/295/34058120/362134/d92995e5/56fc835dNe349b797.jpg!cc_320x320.webp',3,'cce','2020-01-10'),(14,5,'智能家电6','黑色','4.7',877,'焕然一新的设计\r\n注入温柔与浪漫的新配色','白色恋人的清新，仿佛是手中的一捧盈盈白雪，纯净天成。\r\n神秘的深蓝星球，微光滑过便如星河般耀目生辉。\r\n还有深沉的暗夜王子，光线之下难掩锋芒。三款配色，\r\n汇聚于3D全曲面玻璃机身之上，搭配高亮金属质感中框，\r\n温润触感款款心仪','https://img14.360buyimg.com/babel/s320x320_jfs/t2656/295/34058120/362134/d92995e5/56fc835dNe349b797.jpg!cc_320x320.webp',3,'cce','2020-01-10'),(15,5,'智能家电7','黑色','4.7',345,'焕然一新的设计\r\n注入温柔与浪漫的新配色','白色恋人的清新，仿佛是手中的一捧盈盈白雪，纯净天成。\r\n神秘的深蓝星球，微光滑过便如星河般耀目生辉。\r\n还有深沉的暗夜王子，光线之下难掩锋芒。三款配色，\r\n汇聚于3D全曲面玻璃机身之上，搭配高亮金属质感中框，\r\n温润触感款款心仪','https://img14.360buyimg.com/babel/s320x320_jfs/t2656/295/34058120/362134/d92995e5/56fc835dNe349b797.jpg!cc_320x320.webp',5,'cce','2020-01-10');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(10) NOT NULL auto_increment,
  `order_num` varchar(100) NOT NULL,
  `uid` int(10) default NULL,
  `order_money` double(10,2) default NULL,
  `state` int(1) default NULL,
  `create_time` datetime default NULL,
  `c_count` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`order_num`,`uid`,`order_money`,`state`,`create_time`,`c_count`) values (4,'7d53d5fc-762e-4b06-b3bc-00782e3208c5',13,2999.00,1,'2020-01-14 11:34:07',1),(5,'49057b06-9123-4948-82c3-41bfc8c36e57',13,1999.00,1,'2020-01-14 11:39:35',1),(6,'14bb70b1-f7bd-43c9-ab1a-48f30d9de4f4',13,1999.00,1,'2020-01-14 14:09:26',1),(7,'0c21fa04-a559-45f7-8c20-8b9fc142f4e6',13,1999.00,1,'2020-01-14 14:11:06',1),(8,'606a8844-a3ca-4aee-9c4c-0c55985a8e85',13,1999.00,1,'2020-01-14 14:11:09',1),(9,'39c2aba2-a266-47ed-8aee-7caf11d394e6',13,1999.00,1,'2020-01-14 14:11:11',1),(10,'b507391f-bbb6-4772-b9b2-0a224cc8841c',13,1999.00,1,'2020-01-14 14:11:21',1),(11,'a3ffda45-5884-4dea-a0a2-fa32ac2e7eee',13,1999.00,1,'2020-01-14 14:11:48',1),(12,'bf765e83-d9e4-47a7-a4e5-9715e322ae75',13,1999.00,1,'2020-01-14 14:12:08',1),(13,'d2950814-1b79-495a-8095-1df09c1ee8fa',13,1999.00,1,'2020-01-14 14:12:38',1),(14,'4aaf0e1c-19d5-4f2f-98e5-83b3ac22d0bd',13,1999.00,1,'2020-01-14 14:29:27',1),(15,'5c37face-44cb-4220-a213-be66fbad6753',13,1999.00,1,'2020-01-14 16:18:21',1),(16,'ee477e56-778d-4d09-b2a6-ea04af4eefa5',13,2999.00,1,'2020-01-14 16:22:19',1),(17,'c2fd24a9-8f66-4c6a-a32b-1905a5da27dd',13,1999.00,2,'2020-01-14 16:36:26',1),(18,'3f4499bb-50fb-4bfa-8510-86e4b5c2c35b',13,1999.00,2,'2020-01-14 16:37:14',1),(19,'90c703b9-5dba-41d2-bcf6-05bfc6c65abd',13,2999.00,2,'2020-01-14 16:46:39',1),(20,'be1850e4-3c0a-47ae-af61-a5996223c737',13,2999.00,1,'2020-01-14 16:52:37',1),(21,'0393d815-a974-48d6-86de-194033092f55',13,1999.00,1,'2020-01-14 16:55:36',1),(22,'a951410f-5fe3-44be-a66e-5c556f4830bc',13,1999.00,1,'2020-01-14 16:59:26',1),(23,'a0e977f2-ac0b-4707-a488-94c0b2766791',13,1999.00,1,'2020-01-14 16:59:50',1),(24,'565a883f-72fa-4101-a5c5-80154636cb05',13,3999.00,2,'2020-01-14 17:12:24',1),(25,'dea7b8bd-b674-4bce-be55-fa151553890d',13,4999.00,1,'2020-01-14 17:21:27',1);

/*Table structure for table `trolley` */

DROP TABLE IF EXISTS `trolley`;

CREATE TABLE `trolley` (
  `id` int(10) NOT NULL auto_increment,
  `cid` int(10) default NULL,
  `uid` int(10) default NULL,
  `c_count` int(10) default NULL,
  `order_num` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `trolley` */

insert  into `trolley`(`id`,`cid`,`uid`,`c_count`,`order_num`) values (14,5,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(15,4,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(16,4,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(17,4,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(18,4,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(19,5,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(20,4,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(21,4,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(22,5,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(23,5,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(24,4,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(25,4,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(26,4,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(27,6,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d'),(28,7,13,1,'dea7b8bd-b674-4bce-be55-fa151553890d');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `sex` int(1) default NULL,
  `phone_number` varchar(20) default NULL,
  `area` varchar(100) default NULL,
  `manager` int(1) default '1',
  `username` varchar(50) default NULL,
  `password` varchar(50) NOT NULL,
  `photo` varchar(100) default NULL,
  `create_time` datetime default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `phone_number` (`phone_number`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`sex`,`phone_number`,`area`,`manager`,`username`,`password`,`photo`,`create_time`) values (1,'12',1,'werftg','wer',2,'test','123456','wrr','2020-03-17 20:30:44'),(13,'offcn',1,'199888822222','bj',0,'admin','123456','https://hbimg.huabanimg.com/352e31e8dd060604a967d4204c94ab19eda0e9a386f00-WPDJiq_fw658','2020-01-06 09:47:34'),(19,'ujiuye',1,'098765','7654',1,'user','123456','https://hbimg.huabanimg.com/80119ea5a3d898925309153fcad4aa584f3586f0276ce-gfW5x4_fw658','2020-01-06 11:30:44');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
