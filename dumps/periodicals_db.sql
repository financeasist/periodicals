-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: periodicals_db
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `bucket`
--

DROP TABLE IF EXISTS `bucket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bucket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `periodical_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `isPaid` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `periodical_id` (`periodical_id`),
  CONSTRAINT `bucket_ibfk_2` FOREIGN KEY (`periodical_id`) REFERENCES `periodical` (`id`),
  CONSTRAINT `bucket_ibfk_3` FOREIGN KEY (`periodical_id`) REFERENCES `periodical` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bucket`
--

LOCK TABLES `bucket` WRITE;
/*!40000 ALTER TABLE `bucket` DISABLE KEYS */;
INSERT INTO `bucket` VALUES (4,2,1,'2016-10-04 19:06:15',0),(7,10,2,'2016-10-04 19:11:05',0),(8,10,2,'2016-10-04 19:11:58',0);
/*!40000 ALTER TABLE `bucket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodical`
--

DROP TABLE IF EXISTS `periodical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `periodical` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `discription` mediumtext CHARACTER SET utf8,
  `isadded` tinyint(1) NOT NULL,
  `ispaided` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodical`
--

LOCK TABLES `periodical` WRITE;
/*!40000 ALTER TABLE `periodical` DISABLE KEYS */;
INSERT INTO `periodical` VALUES (2,'Updated World',18.5,'sdfghj',0,'\0'),(9,'Java',10,'all about JAVA',0,'\0'),(10,'Java',10,'all about JAVA',0,'\0'),(13,'New Periodical',5,'poiu',1,'\0'),(14,'New Periodical',5,'poiu',1,'\0');
/*!40000 ALTER TABLE `periodical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `lastName` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(45) CHARACTER SET utf8 NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `isbanned` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'Roman','bogdan','financeasist@gmail.com','www','hgfdfgh','ADMINISTRATOR',0),(3,'sfsg','sgsg','dfgh@hh.com','','hgfdfgh','USER',1),(10,'Roman','null','sadhfj@vcb.kom','','hgfdfgh','GUEST',0),(12,'Roman','null','sadhfp@vcb.kom','','hgfdfgh','GUEST',0),(14,'Roman','null','sadh@vcb.kom','','hgfdfgh','GUEST',0),(16,'Roman','null','sadhp@vcb.kom','','hgfdfgh','GUEST',0),(20,'Roman','null','sadgg@vcb.kom','','hgfdfgh','GUEST',0),(23,'Roman','null','sadg@vcb.kom','','hgfdfgh','GUEST',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-07 17:33:58
