/*
SQLyog Ultimate v9.02 
MySQL - 5.5.5-10.4.10-MariaDB : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test`;

/*Table structure for table `ab_users` */

DROP TABLE IF EXISTS `ab_users`;

CREATE TABLE `ab_users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'It is the key of the users',
  `sName` varchar(50) DEFAULT NULL,
  `sLastname` varchar(50) DEFAULT NULL,
  `sEmail` varchar(50) NOT NULL COMMENT 'This is the used too login to the system',
  `sPhone` text DEFAULT NULL,
  `sPwd` text DEFAULT '\'password\'',
  `createdAt` varchar(14) DEFAULT NULL COMMENT 'The instant when the user is created',
  `isActive` tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT 'If the user is active',
  `isDelete` tinyint(1) unsigned NOT NULL DEFAULT 1 COMMENT 'If the user is deleted',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `ab_users` */

/*Table structure for table `prj` */

DROP TABLE IF EXISTS `prj`;

CREATE TABLE `prj` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sName` varchar(150) NOT NULL,
  `sAcron` varchar(10) NOT NULL COMMENT 'IOt is the acronimus of the proyect, itiis unique and the reference to the tables of the project',
  `sDesc` text DEFAULT NULL,
  `isActive` tinyint(1) unsigned NOT NULL DEFAULT 1,
  `isDeleted` tinyint(1) unsigned DEFAULT 0,
  `createAt` bigint(20) unsigned NOT NULL,
  `modifyAt` bigint(20) NOT NULL,
  `sIcon` text DEFAULT '\'default.png\'',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `prj` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
