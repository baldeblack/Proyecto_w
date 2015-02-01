CREATE DATABASE  IF NOT EXISTS `sharedb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sharedb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: sharedb
-- ------------------------------------------------------
-- Server version	5.6.22-log

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
-- Table structure for table `catastrofe`
--

DROP TABLE IF EXISTS `catastrofe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catastrofe` (
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
  `Logo` longblob,
  PRIMARY KEY (`idCatastrofe`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `catastrofetipo`
--

DROP TABLE IF EXISTS `catastrofetipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catastrofetipo` (
  `idcatastrofe` int(11) NOT NULL,
  `idTipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcatastrofe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ongs`
--

DROP TABLE IF EXISTS `ongs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ongs` (
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
-- Table structure for table `pasos`
--

DROP TABLE IF EXISTS `pasos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pasos` (
  `idpasos` int(11) NOT NULL,
  `idPlan` int(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpasos`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan` (
  `idPlan` int(11) NOT NULL,
  `idTipoPlan` int(11) DEFAULT NULL,
  `idTipoCatastrofe` int(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `cantidadPasos` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPlan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rescatista`
--

DROP TABLE IF EXISTS `rescatista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rescatista` (
  `idRescatista` int(11) NOT NULL,
  `IdUsuarios` int(11) NOT NULL,
  `IdTipoRescatista` int(11) NOT NULL,
  `Residencia` varchar(500) DEFAULT NULL,
  `LatLongRecidencia` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`idRescatista`),
  KEY `fk_Rescatista_Usuarios_idx` (`IdUsuarios`),
  KEY `fk_Rescatista_Tipo_idx` (`IdTipoRescatista`),
  CONSTRAINT `fk_Rescatista_Tipo` FOREIGN KEY (`IdTipoRescatista`) REFERENCES `tiporescatista` (`idTipoRescatista`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rescatista_Usuarios` FOREIGN KEY (`IdUsuarios`) REFERENCES `usuarios` (`idUsuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rescatistacatastrofe`
--

DROP TABLE IF EXISTS `rescatistacatastrofe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rescatistacatastrofe` (
  `idrescatista` int(11) NOT NULL,
  `idcatastrofe` int(11) NOT NULL,
  PRIMARY KEY (`idrescatista`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rptdata`
--

DROP TABLE IF EXISTS `rptdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rptdata` (
  `idTenant` int(11) NOT NULL,
  `ongs` int(11) DEFAULT NULL,
  `desaparecidos` int(11) DEFAULT NULL,
  `usuarios` int(11) DEFAULT NULL,
  `pedidos` int(11) DEFAULT NULL,
  `coneccion` varchar(200) NOT NULL,
  PRIMARY KEY (`idTenant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipocatastrofe`
--

DROP TABLE IF EXISTS `tipocatastrofe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipocatastrofe` (
  `idtipocatastrofe` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipocatastrofe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tiporescatista`
--

DROP TABLE IF EXISTS `tiporescatista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiporescatista` (
  `idTipoRescatista` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Descripcion` varchar(500) NOT NULL,
  PRIMARY KEY (`idTipoRescatista`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
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
-- Dumping routines for database 'sharedb'
--
/*!50003 DROP PROCEDURE IF EXISTS `altaSitio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `altaSitio`(IN tenatName varchar(20))
BEGIN
SET @tenantN = tenatName;

SET @query = CONCAT('CREATE DATABASE ', @tenantN);
PREPARE stmt1 FROM @query;
EXECUTE stmt1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-01 19:15:44
