CREATE DATABASE  IF NOT EXISTS `ShareDB` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ShareDB`;
-- MySQL dump 10.13  Distrib 5.6.19, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: ShareDB
-- ------------------------------------------------------
-- Server version	5.6.19-0ubuntu0.14.04.1

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
-- Table structure for table `Administradores`
--

DROP TABLE IF EXISTS `Administradores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Administradores` (
  `mail` varchar(50) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Administradores`
--

LOCK TABLES `Administradores` WRITE;
/*!40000 ALTER TABLE `Administradores` DISABLE KEYS */;
INSERT INTO `Administradores` VALUES ('andino@gmail.com','123456'),('asdasd','123456'),('baldengro@gmail.com','123456'),('erere','123456'),('josesito@gmail.com','123456'),('monitoreo@gmail.com','123456'),('nacho@gmail.com','123456'),('pepe','123456'),('pepep','123456'),('RETER','123456'),('sandino@gmail.com','123456'),('yeni','123456');
/*!40000 ALTER TABLE `Administradores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Catastrofe`
--

DROP TABLE IF EXISTS `Catastrofe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Catastrofe` (
  `idCatastrofe` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) DEFAULT NULL,
  `Dominio` varchar(100) DEFAULT NULL,
  `Css` longtext,
  `CarpetaImagenes` longtext,
  `StringConeccion` varchar(300) DEFAULT NULL,
  `Activa` bit(1) DEFAULT NULL,
  `ZonaAfectada` varchar(500) DEFAULT NULL,
  `Informacion` longtext,
  `FechaCreacion` datetime DEFAULT NULL,
  `FuentesDatos` varchar(400) DEFAULT NULL,
  `PalabrasClaves` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`idCatastrofe`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Catastrofe`
--

LOCK TABLES `Catastrofe` WRITE;
/*!40000 ALTER TABLE `Catastrofe` DISABLE KEYS */;
INSERT INTO `Catastrofe` VALUES (1,'Terremoto','terremoto.uy','TEMA 4','','jdbc:mysql://localhost:3306/Terremoto','','[[\"-6488974.6321061 -4612706.3073299\",\"-6518326.450963501 -4426811.4545663\",\"-6704221.303727101 -4456163.273423701\",\"-6674869.4848697 -4642058.1261873\",\"-6488974.6321061 -4612706.3073299\"]]','Informacion :','2014-11-18 20:02:23','nullTwitterRSS','nulltierrase pudrio todo'),(2,'tsunami','tsunami.uy','TEMA 3','','jdbc:mysql://localhost:3306/tsunami','','[[\"-6572138.1188688 -4478666.2897604\",\"-6493866.6019157 -4263419.6181393005\",\"-6709113.2735367995 -4185148.101186201\",\"-6787384.790489899 -4400394.7728073\",\"-6572138.1188688 -4478666.2897604\"]]','Informacion :','2014-11-18 20:03:02','nullyouTubeTwitter','nullvamooasdasd'),(3,'tsunami','tsunami.uy','TEMA 3','','jdbc:mysql://localhost:3306/tsunami','','[[\"-7071119.039445 -5484455.4617573\",\"-6836304.4885857 -3762482.0887885997\",\"-8558277.861554401 -3527667.5379293\",\"-8793092.412413701 -5249640.910898001\",\"-7071119.039445 -5484455.4617573\"]]','Informacion :','2014-11-18 20:06:39','youTube;Twitter;','uno;null;tres;');
/*!40000 ALTER TABLE `Catastrofe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EjecutoresPasosPlanEmergencia`
--

DROP TABLE IF EXISTS `EjecutoresPasosPlanEmergencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EjecutoresPasosPlanEmergencia` (
  `IdPaso` int(11) NOT NULL,
  `IdTipoEjecutor` int(11) NOT NULL,
  `Cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdPaso`,`IdTipoEjecutor`),
  KEY `fk_EjecutoresPasosPlanEmergencia_TipoEjecutor_idx` (`IdTipoEjecutor`),
  CONSTRAINT `fk_EjecutoresPasosPlanEmergencia_Pasos` FOREIGN KEY (`IdPaso`) REFERENCES `PasosPlanEmergenca` (`idPaso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_EjecutoresPasosPlanEmergencia_TipoEjecutor` FOREIGN KEY (`IdTipoEjecutor`) REFERENCES `TipoRescatista` (`idTipoRescatista`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EjecutoresPasosPlanEmergencia`
--

LOCK TABLES `EjecutoresPasosPlanEmergencia` WRITE;
/*!40000 ALTER TABLE `EjecutoresPasosPlanEmergencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `EjecutoresPasosPlanEmergencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GestionRiesgo`
--

DROP TABLE IF EXISTS `GestionRiesgo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GestionRiesgo` (
  `idGestionRiesgo` int(11) NOT NULL,
  `IdPlan` int(11) DEFAULT NULL,
  `IdTipoRiesgo` int(11) DEFAULT NULL,
  `Titulo` varchar(100) DEFAULT NULL,
  `Descripcion` longtext,
  `ZonaAfectada` varchar(500) DEFAULT NULL,
  `Plan` blob,
  `Ciudad` varchar(50) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `FechaOcurrencia` date DEFAULT NULL,
  `NroOcurrencias` smallint(6) DEFAULT NULL,
  `NroAfectados` int(11) DEFAULT NULL,
  `Perdidas` decimal(9,2) DEFAULT NULL,
  `Costo` decimal(9,2) DEFAULT NULL,
  PRIMARY KEY (`idGestionRiesgo`),
  KEY `fk_GestionRiesgo_Plan_idx` (`IdPlan`),
  KEY `fk_GestionRiesgo_TipoRiesgo_idx` (`IdTipoRiesgo`),
  CONSTRAINT `fk_GestionRiesgo_Plan` FOREIGN KEY (`IdPlan`) REFERENCES `PlanEmergencia` (`idPlanEmergencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_GestionRiesgo_TipoRiesgo` FOREIGN KEY (`IdTipoRiesgo`) REFERENCES `TipoRiesgo` (`idTipoRiesgo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GestionRiesgo`
--

LOCK TABLES `GestionRiesgo` WRITE;
/*!40000 ALTER TABLE `GestionRiesgo` DISABLE KEYS */;
/*!40000 ALTER TABLE `GestionRiesgo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ONGs`
--

DROP TABLE IF EXISTS `ONGs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ONGs` (
  `idONGs` int(11) NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Direccion` varchar(200) DEFAULT NULL,
  `Telefono` varchar(50) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Web` varchar(50) DEFAULT NULL,
  `Origen` varchar(45) DEFAULT NULL,
  `DatosPayPal` longtext,
  PRIMARY KEY (`idONGs`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ONGs`
--

LOCK TABLES `ONGs` WRITE;
/*!40000 ALTER TABLE `ONGs` DISABLE KEYS */;
/*!40000 ALTER TABLE `ONGs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PasosPlanEmergenca`
--

DROP TABLE IF EXISTS `PasosPlanEmergenca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PasosPlanEmergenca` (
  `idPaso` int(11) NOT NULL,
  `IdPlan` int(11) NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Descripcion` longtext,
  `IdTipoEjecutor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPaso`,`IdPlan`),
  KEY `fk_PasosPlanEmergenca_Plan_idx` (`IdPlan`),
  KEY `fk_PasosPlanEmergenca_Ejecutor_idx` (`IdTipoEjecutor`),
  CONSTRAINT `fk_PasosPlanEmergenca_Ejecutor` FOREIGN KEY (`IdTipoEjecutor`) REFERENCES `TipoRescatista` (`idTipoRescatista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PasosPlanEmergenca_Plan` FOREIGN KEY (`IdPlan`) REFERENCES `PlanEmergencia` (`idPlanEmergencia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PasosPlanEmergenca`
--

LOCK TABLES `PasosPlanEmergenca` WRITE;
/*!40000 ALTER TABLE `PasosPlanEmergenca` DISABLE KEYS */;
/*!40000 ALTER TABLE `PasosPlanEmergenca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PlanEmergencia`
--

DROP TABLE IF EXISTS `PlanEmergencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PlanEmergencia` (
  `idPlanEmergencia` int(11) NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Descripcion` longtext,
  `Plan` blob,
  `Costo` decimal(9,2) DEFAULT NULL,
  PRIMARY KEY (`idPlanEmergencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PlanEmergencia`
--

LOCK TABLES `PlanEmergencia` WRITE;
/*!40000 ALTER TABLE `PlanEmergencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `PlanEmergencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Rescatista`
--

DROP TABLE IF EXISTS `Rescatista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Rescatista` (
  `idRescatista` int(11) NOT NULL,
  `IdUsuarios` int(11) NOT NULL,
  `IdTipoRescatista` int(11) NOT NULL,
  `Residencia` varchar(500) DEFAULT NULL,
  `LatLongRecidencia` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`idRescatista`),
  KEY `fk_Rescatista_Usuarios_idx` (`IdUsuarios`),
  CONSTRAINT `fk_Rescatista_TipoRescatista` FOREIGN KEY (`idRescatista`) REFERENCES `TipoRescatista` (`idTipoRescatista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rescatista_Usuarios` FOREIGN KEY (`IdUsuarios`) REFERENCES `Usuarios` (`idUsuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Rescatista`
--

LOCK TABLES `Rescatista` WRITE;
/*!40000 ALTER TABLE `Rescatista` DISABLE KEYS */;
/*!40000 ALTER TABLE `Rescatista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoRescatista`
--

DROP TABLE IF EXISTS `TipoRescatista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TipoRescatista` (
  `idTipoRescatista` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Descripcion` varchar(500) NOT NULL,
  PRIMARY KEY (`idTipoRescatista`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoRescatista`
--

LOCK TABLES `TipoRescatista` WRITE;
/*!40000 ALTER TABLE `TipoRescatista` DISABLE KEYS */;
INSERT INTO `TipoRescatista` VALUES (1,'Medico','Doctor'),(2,'Bombero','FIreman');
/*!40000 ALTER TABLE `TipoRescatista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoRiesgo`
--

DROP TABLE IF EXISTS `TipoRiesgo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TipoRiesgo` (
  `idTipoRiesgo` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idTipoRiesgo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoRiesgo`
--

LOCK TABLES `TipoRiesgo` WRITE;
/*!40000 ALTER TABLE `TipoRiesgo` DISABLE KEYS */;
/*!40000 ALTER TABLE `TipoRiesgo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuarios` (
  `idUsuarios` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Nick` varchar(50) DEFAULT NULL,
  `Email` varchar(100) NOT NULL,
  `Nacimiento` date DEFAULT NULL,
  `Sexo` char(1) DEFAULT NULL,
  `Celular` varchar(50) NOT NULL,
  `Direccion` varchar(200) DEFAULT NULL,
  `TipoUsuario` int(11) NOT NULL COMMENT '1-Administrador, 2-Rescatista',
  `Creacion` datetime DEFAULT NULL,
  `Borrado` bit(1) DEFAULT b'0',
  `Password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUsuarios`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuarios`
--

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
INSERT INTO `Usuarios` VALUES (0,'sa','asd','asddsas','sad','2014-11-19','M','077','ssd',0,'2014-11-19 13:50:42','\0','as');
/*!40000 ALTER TABLE `Usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WorkFlow`
--

DROP TABLE IF EXISTS `WorkFlow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WorkFlow` (
  `idWorkFlow` int(11) NOT NULL,
  `IdPlan` int(11) DEFAULT NULL,
  `IdCatastrofe` int(11) DEFAULT NULL,
  `IdResponzable` int(11) DEFAULT NULL,
  `Estado` smallint(6) DEFAULT NULL COMMENT ' [1-Pendienta, 2-EnProceso, 3-Finalizado, 4- Cancelado]',
  `Comentarios` longtext,
  `Fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`idWorkFlow`),
  KEY `fk_WorkFlow_Plan_idx` (`IdPlan`),
  KEY `fk_WorkFlow_Catastrofe_idx` (`IdCatastrofe`),
  KEY `fk_WorkFlow_Responzable_idx` (`IdResponzable`),
  CONSTRAINT `fk_WorkFlow_Plan` FOREIGN KEY (`IdPlan`) REFERENCES `PlanEmergencia` (`idPlanEmergencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_WorkFlow_Responzable` FOREIGN KEY (`IdResponzable`) REFERENCES `Rescatista` (`idRescatista`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WorkFlow`
--

LOCK TABLES `WorkFlow` WRITE;
/*!40000 ALTER TABLE `WorkFlow` DISABLE KEYS */;
/*!40000 ALTER TABLE `WorkFlow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WorkFlowPasos`
--

DROP TABLE IF EXISTS `WorkFlowPasos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WorkFlowPasos` (
  `IdWF` int(11) NOT NULL,
  `IdPaso` int(11) NOT NULL,
  `IdEjecutor` int(11) NOT NULL,
  `Estado` smallint(6) DEFAULT NULL COMMENT '1-Pendienta, 2-EnProceso, 3-Finalizado, 4- Cancelado',
  `Fecha` datetime DEFAULT NULL,
  `Comentario` longtext,
  PRIMARY KEY (`IdWF`,`IdPaso`,`IdEjecutor`),
  KEY `fk_WorkFlowPasos_Pasos_idx` (`IdPaso`),
  KEY `fk_WorkFlowPasos_Rescatista_idx` (`IdEjecutor`),
  CONSTRAINT `fk_WorkFlowPasos_Pasos` FOREIGN KEY (`IdPaso`) REFERENCES `PasosPlanEmergenca` (`idPaso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_WorkFlowPasos_Rescatista` FOREIGN KEY (`IdEjecutor`) REFERENCES `Rescatista` (`idRescatista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_WorkFlowPasos_Workflow` FOREIGN KEY (`IdWF`) REFERENCES `WorkFlow` (`idWorkFlow`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WorkFlowPasos`
--

LOCK TABLES `WorkFlowPasos` WRITE;
/*!40000 ALTER TABLE `WorkFlowPasos` DISABLE KEYS */;
/*!40000 ALTER TABLE `WorkFlowPasos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pruba`
--

DROP TABLE IF EXISTS `pruba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pruba` (
  `pruebName` varchar(500) NOT NULL,
  PRIMARY KEY (`pruebName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pruba`
--

LOCK TABLES `pruba` WRITE;
/*!40000 ALTER TABLE `pruba` DISABLE KEYS */;
INSERT INTO `pruba` VALUES ('USE db_name; \n DROP TABLE IF EXISTS `Ayuda`; CREATE TABLE `Ayuda` (`idAyuda` int(11) NOT NULL,) ENGINE=InnoDB DEFAULT CHARSET=latin1;'),('USE db_name; \nDROP TABLE IF EXISTS `Ayuda` ; CREATE TABLE `Ayuda` (`idAyuda` int(11) NOT NULL,) ENGINE=InnoDB DEFAULT CHARSET=latin1;'),('USE db_name; \nDROP TABLE IF EXISTS `Ayuda`;\nCREATE TABLE `Ayuda` (\n  `idAyuda` int(11) NOT NULL,\n \n) ENGINE=InnoDB DEFAULT CHARSET=latin1;'),('USE db_name;  DROP TABLE IF EXISTS `Ayuda`; CREATE TABLE `Ayuda` (`idAyuda` int(11) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1;'),('USE db_name; DROP TABLE IF EXISTS `Ayuda`;\nCREATE TABLE `Ayuda` (\n  `idAyuda` int(11) NOT NULL,\n \n) ENGINE=InnoDB DEFAULT CHARSET=latin1;');
/*!40000 ALTER TABLE `pruba` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-19 17:31:28
