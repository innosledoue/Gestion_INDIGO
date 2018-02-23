-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: indigopro
-- ------------------------------------------------------
-- Server version	8.0.1-dmr-log

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
-- Table structure for table `articles`
--

DROP TABLE IF EXISTS `articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles` (
  `code` varchar(6) NOT NULL,
  `code_categorie` varchar(3) NOT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `quantite` int(5) NOT NULL,
  `prix_unitaire` double NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`code`),
  KEY `code_categorie_idx` (`code_categorie`),
  CONSTRAINT `code_categorie` FOREIGN KEY (`code_categorie`) REFERENCES `categories` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articles`
--

LOCK TABLES `articles` WRITE;
/*!40000 ALTER TABLE `articles` DISABLE KEYS */;
INSERT INTO `articles` VALUES ('FAMI21','ECR','Famir 21',20,150,'2018-02-16'),('XENO25','POR','Xenon 25',15,850,'2018-02-16'),('ZENI77','TAB','Zenith 77',30,500,'2018-02-16');
/*!40000 ALTER TABLE `articles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `code` varchar(3) NOT NULL,
  `designation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES ('ECR','écran'),('POR','portable'),('TAB','tablette');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `code` varchar(6) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `carte_fidele` int(1) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `addresse` varchar(45) DEFAULT NULL,
  `code_postal` varchar(40) DEFAULT NULL,
  `ville` varchar(20) DEFAULT NULL,
  `tel_fixe` varchar(25) DEFAULT NULL,
  `mobile` varchar(25) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `remarque` longtext,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES ('AZER41','KOUAKOU','HENRI JOEL',1,'2018-02-20','ABIDJAN Trechville','BP 04 Abidjan 02','Abidjan','24151515','41414100','',''),('DRJE02','DROUAN','Jean',1,'2018-02-16',NULL,NULL,'Abidjan',NULL,'+0324758254',NULL,NULL),('GIPA01','GIELAU','Pascal',1,'2018-02-16',NULL,NULL,'Paris',NULL,'+3304452452541',NULL,NULL),('GOLH78','KOFFI','Jule martial',0,'2018-02-22','15 BP 144 Abidjan','4589','Abidjan','05214684','01007201','koffiyves@aefi.com',''),('PLSY01','PLAFONI','Sylvie',0,'2018-02-16',NULL,NULL,'nice',NULL,'+0331245201254',NULL,NULL),('SD45op','Pehi','Samuel',0,'2018-02-20','Yopougom nouveau quartier','Bp45 Abidjan 05','Abidjan','23491240','55772205','tereer@gmail.com','');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commandes`
--

DROP TABLE IF EXISTS `commandes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commandes` (
  `code` varchar(15) NOT NULL,
  `code_client` varchar(6) NOT NULL,
  `total_ttc` double DEFAULT NULL,
  `code_mode_reglement` int(1) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `code_client_idx` (`code_client`),
  KEY `code_mode_reglement_idx` (`code_mode_reglement`),
  CONSTRAINT `code_client` FOREIGN KEY (`code_client`) REFERENCES `clients` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `code_mode_reglement` FOREIGN KEY (`code_mode_reglement`) REFERENCES `mode_reglement` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commandes`
--

LOCK TABLES `commandes` WRITE;
/*!40000 ALTER TABLE `commandes` DISABLE KEYS */;
INSERT INTO `commandes` VALUES ('COM1','GIPA01',NULL,2,'2018-02-16'),('COM2','PLSY01',NULL,3,'2018-02-16');
/*!40000 ALTER TABLE `commandes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ligne_commande`
--

DROP TABLE IF EXISTS `ligne_commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ligne_commande` (
  `code_commande` varchar(15) NOT NULL,
  `code_article` varchar(6) NOT NULL,
  `quantite` int(5) DEFAULT NULL,
  `prix_unitaire` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`code_commande`,`code_article`),
  KEY `code_article_idx` (`code_article`),
  CONSTRAINT `code_article` FOREIGN KEY (`code_article`) REFERENCES `articles` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `code_commande` FOREIGN KEY (`code_commande`) REFERENCES `commandes` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ligne_commande`
--

LOCK TABLES `ligne_commande` WRITE;
/*!40000 ALTER TABLE `ligne_commande` DISABLE KEYS */;
INSERT INTO `ligne_commande` VALUES ('COM1','XENO25',1,850,1025.1),('COM1','ZENI77',1,500,630),('COM2','FAMI21',2,150,361.8);
/*!40000 ALTER TABLE `ligne_commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mode_reglement`
--

DROP TABLE IF EXISTS `mode_reglement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mode_reglement` (
  `code` int(1) NOT NULL,
  `type` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mode_reglement`
--

LOCK TABLES `mode_reglement` WRITE;
/*!40000 ALTER TABLE `mode_reglement` DISABLE KEYS */;
INSERT INTO `mode_reglement` VALUES (1,'espèce'),(2,'chéque'),(3,'carte');
/*!40000 ALTER TABLE `mode_reglement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-23  8:29:50
