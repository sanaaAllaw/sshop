-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: stock
-- ------------------------------------------------------
-- Server version	5.7.14

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
-- Table structure for table `movements`
--

DROP TABLE IF EXISTS `movements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movements` (
  `idmovements` int(11) NOT NULL AUTO_INCREMENT,
  `itemcode` varchar(45) DEFAULT NULL,
  `itemname` varchar(45) DEFAULT NULL,
  `qty` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `supplier` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `movtype` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmovements`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movements`
--

LOCK TABLES `movements` WRITE;
/*!40000 ALTER TABLE `movements` DISABLE KEYS */;
INSERT INTO `movements` VALUES (1,'000001','chirt1','10','20000','maysaa','2017-11-14','PIV'),(2,'000002','chirt2','5','35000','maysaa','2017-11-14','PIV'),(3,'000003','t-chirt1','20','100000','maysaa','2017-11-14','PIV'),(4,'000004','t-chirt2','50','60000','maysaa','2017-11-14','PIV'),(5,'000005','t-chirt3','30','150000','maysaa','2017-11-14','PIV'),(6,'000006','dress1','12','50000','maysaa','2017-11-14','PIV'),(7,'000007','dress2','50','60000','maysaa','2017-11-14','PIV'),(8,'000008','dress3','60','60000','maysaa','2017-11-14','PIV'),(9,'000009','kid1','10','35000','maysaa','2017-11-14','PIV'),(10,'000010','kid2','20','60000','maysaa','2017-11-14','PIV'),(11,'000011','watch1','10','600000','maysaa','2017-11-14','PIV'),(12,'000012','watche2','50','900000','maysaa','2017-11-14','PIV'),(13,'000001','chirt1','20','20000','','2017-11-14','PIV'),(14,'000001','chirt1','40','20000','','2017-11-14','PIV');
/*!40000 ALTER TABLE `movements` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-14 13:30:33
