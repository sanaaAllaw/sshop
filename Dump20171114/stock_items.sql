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
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `iditem` int(33) NOT NULL AUTO_INCREMENT,
  `itemcode` varchar(45) DEFAULT NULL,
  `name` varchar(33) NOT NULL,
  `description` varchar(333) DEFAULT NULL,
  `qty` int(33) NOT NULL,
  `price` decimal(33,0) NOT NULL,
  `barcode` varchar(33) DEFAULT NULL,
  `fond` int(33) DEFAULT NULL,
  `expiry` varchar(33) DEFAULT NULL,
  `salesman` varchar(33) DEFAULT NULL,
  `supplier` varchar(33) NOT NULL,
  `item_group` varchar(45) DEFAULT NULL,
  `itemscol` varchar(45) DEFAULT NULL,
  `itemscateg` varchar(45) DEFAULT NULL,
  `itempic` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`iditem`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'000001','chirt1','chirt1',70,20000,'123',3,'','','maysaa','Clothes','Men','shirt','pictures/11490616430294-Duke-Men-Peach-Printed-Round-Neck-T-Shirt-1551490616430109-1.jpg'),(2,'000002','chirt2','chirt2',5,35000,'2223',2,'','','maysaa','Clothes','Men','shirt','pictures/SD_03_T28_5250M_Z0_X_EC_0.jpg'),(3,'000003','t-chirt1','t-chirt1',20,100000,'3335',5,'','','maysaa','Clothes','Men','T-shirt','pictures/511OYkTL6cL._AC_UL260_SR200,260_.jpg'),(4,'000004','t-chirt2','t-chirt2',50,60000,'66663',10,'','','maysaa','Clothes','Men','T-shirt','pictures/4024f5d2b984696609da44b31e09f9fe--casual-shirts-mens-shirts.jpg'),(5,'000005','t-chirt3','t-chirt3',30,150000,'12536',2,'','','maysaa','Clothes','Men','T-shirt','pictures/9657dc2c-e43a-4719-8320-8a7880c318c2.jpeg'),(6,'000006','dress1','dress1',12,50000,'123586',3,'','','maysaa','Clothes','Women','Dresses','pictures/p3.jpg'),(7,'000007','dress2','dress2',50,60000,'125689',6,'','','maysaa','Clothes','Women','Dresses','pictures/p9.jpg'),(8,'000008','dress3','dress3',60,60000,'12587964',10,'','','maysaa','Clothes','Women','Beauty','pictures/l2.jpg'),(9,'000009','kid1','kid1',10,35000,'12544445',2,'','','maysaa','Clothes','Kids','Dresses','pictures/e9ccf8df36f922382fb2feaef3693927.jpg'),(10,'000010','kid2','kid2',20,60000,'3666698',5,'','','maysaa','Clothes','Kids','shirt','pictures/2-1.jpg'),(11,'000011','watch1','watch1',10,600000,'12555554889',2,'','','maysaa','Watches','Men','cultural','pictures/new-mens-daniel-watches-40mm-men-watches.jpg'),(12,'000012','watche2','watche2',50,900000,'125469888',10,'','','maysaa','Watches','Men','cultural','pictures/citizen-eco-drive-chronograph-men_s-strap-watch-at0200-05e_1.jpg');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
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
