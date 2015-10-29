-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 5.35.247.12    Database: sporty
-- ------------------------------------------------------
-- Server version	5.5.44-0ubuntu0.14.04.1

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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `departmentId` int(11) NOT NULL AUTO_INCREMENT,
  `sport` varchar(45) DEFAULT NULL,
  `head` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `memberId` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `gender` enum('M','F') DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL COMMENT 'department == sport??',
  `sport` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL COMMENT 'roles: \nplayer (Spieler), trainer (Trainer), management (Vorstand), departmentHead (Abteilungsleiter) ',
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`memberId`)
) ENGINE=InnoDB AUTO_INCREMENT=1115 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1000,'Marion','Kennedy','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1001,'George','Alexander','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1002,'Johanna','Howard','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1003,'Myra','Fox','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1004,'Tina','Pirelli','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1005,'Patrick','Lyons','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1006,'Patricia','Delgado','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1007,'Kirk','Summers','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1008,'Arthur','Mcdaniel','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1009,'Clayton','Perez','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1010,'Claudia','Mckenzie','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1011,'Randal','Carr','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1012,'Opal','Carpenter','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1013,'Mildred','Mccormick','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1014,'Julian','Price','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1015,'Patrick','Gomez','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1016,'Sheldon','Gonzales','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1017,'Minnie','Torres','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1018,'Kelly','Herrera','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1019,'Rufus','Griffith','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1020,'Josefina','Banks','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1021,'Rafael','Adkins','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1022,'Andre','Bowers','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1023,'Jeanette','Goodman','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1024,'Wendell','Myers','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1025,'Julia','Rodriquez','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1026,'Jamie','Diaz','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1027,'Eula','Hudson','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1028,'Isabel','Ortiz','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1029,'Albert','Barnett','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1030,'Josephine','Crawford','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1031,'Milton','Poole','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1032,'Eileen','Gordon','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1033,'Judy','Riley','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1034,'Brian','Nichols','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1035,'Joel','Arnold','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1036,'Kristin','Burke','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1037,'Lydia','Page','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1038,'Stephanie','Lopez','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1039,'Dianne','Padilla','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1040,'Vernon','Ramsey','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1041,'Stella','Colon','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1042,'Norman','Ballard','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1043,'Dora','Mendez','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1044,'Krystal','Daniels','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1045,'Lindsey','Lamb','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1046,'Delbert','Becker','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1047,'Tanya','Cummings','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1048,'Gregory','Luna','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1049,'Elisa','Potter','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1050,'Marie','Ellis','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1051,'Hugo','Ramirez','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1052,'Wilbur','Houston','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1053,'Howard','Henderson','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1054,'Loretta','Cooper','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1055,'Eugene','Kelley','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1056,'Darrell','Day','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1057,'Tracy','Wheeler','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1058,'Lorenzo','Wilkerson','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1059,'Alberta','Riley','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1060,'Edward','Cross','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1061,'Edwina','Patterson','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1062,'Carlos','Singleton','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1063,'Silvia','Sanders','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1064,'Julia','Lyons','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1065,'Lorena','Swanson','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1066,'Darlene','Underwood','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1067,'Elijah','Miller','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1068,'Nino','Padilla','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1069,'Edmund','Jacobs','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1070,'Sylvester','Turner','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1071,'Meryl','Roy','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1072,'Andrew','Holland','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1073,'Jaqueline','Mack','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1074,'Alexandra','Collier','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1075,'Carl','Ryan','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1076,'Jermaine','Collins','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1077,'Bill','Marshall','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1078,'Sylvia','Warner','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1079,'Emilio','Wilkins','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1080,'Einar','Carroll','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1081,'Roland','Casey','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1082,'Trevor','Jefferson','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1083,'Sally','Schultz','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1084,'Charlotte','Mackenzie','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1085,'Keith','Williams','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1086,'Shawna','Rivera','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1087,'Irina','Castro','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1088,'Martha','Dunn','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1089,'Rosie','Phillips','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1090,'Diana','Cole','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1091,'Vincento','Lombardi','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1092,'Muriel','Kim','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1093,'Annie','Stevens','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1094,'Gina','Hudson','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1095,'Tara','Sherman','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1096,'Sharon','Logan','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1097,'Stewart','Hale','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1098,'Janis','Ball','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1099,'Gaia','Sesto','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1100,'Leonarda','Albano','F',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1101,'Andrej','Borna','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1102,'Kristofor','Jadrankovic','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1103,'Branko','Stevan','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1104,'Franjo','Antovic','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1105,'Javor','Milenko','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1106,'Björn','Petersson','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1107,'Valdemar','Melker','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1108,'Hannes','Konrad','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1109,'Theodor','Stellan','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1110,'Nils','Magnussen','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1111,'Miron','Avramenko','M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1112,'Test Member #1 FIRST Name','Test Member #1 LAST Name',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1113,'Test Member #2 Fname','Test Member #3 Lname',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1114,'Test Member #2 Fname','Test Member #3 Lname',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-28 11:18:55