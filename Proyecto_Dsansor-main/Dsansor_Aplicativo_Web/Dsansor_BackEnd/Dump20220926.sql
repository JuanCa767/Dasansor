-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: empresa (3)
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `credenciales`
--

DROP TABLE IF EXISTS `credenciales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credenciales` (
  `usuario` char(30) DEFAULT NULL,
  `password` char(12) DEFAULT NULL,
  `new_pass` char(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credenciales`
--

LOCK TABLES `credenciales` WRITE;
/*!40000 ALTER TABLE `credenciales` DISABLE KEYS */;
INSERT INTO `credenciales` VALUES ('ing2111@yahoo.es','123456','123456');
/*!40000 ALTER TABLE `credenciales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejecucion`
--

DROP TABLE IF EXISTS `ejecucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ejecucion` (
  `Num_orden` int NOT NULL,
  `valor_orden` float DEFAULT NULL,
  `fecha_asignacion` date DEFAULT NULL,
  `actividad` char(40) DEFAULT NULL,
  `nombre_sitio` char(30) DEFAULT NULL,
  `fecha_instalacion` date DEFAULT NULL,
  `fecha_integracion` date DEFAULT NULL,
  `fecha_documentacion` date DEFAULT NULL,
  PRIMARY KEY (`Num_orden`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejecucion`
--

LOCK TABLES `ejecucion` WRITE;
/*!40000 ALTER TABLE `ejecucion` DISABLE KEYS */;
INSERT INTO `ejecucion` VALUES (1,15000000,'2022-09-01','MODERNIZACION','BOG-CENTRO-3','2022-09-03','2022-09-07','2022-09-04'),(2,15000000,'2022-09-05','MODERNIZACION','BOG-NORTE','2022-09-07','2022-09-07','2022-09-08'),(3,16000000,'2022-09-10','ADECUACION','IBAGUE','2022-09-11','2022-09-12','2022-09-10');
/*!40000 ALTER TABLE `ejecucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informe_cliente`
--

DROP TABLE IF EXISTS `informe_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informe_cliente` (
  `ref_cliente` int DEFAULT NULL,
  `fecha_radicacion_cliente` char(15) DEFAULT NULL,
  `Num_orden` int DEFAULT NULL,
  KEY `Num_orden` (`Num_orden`),
  CONSTRAINT `informe_cliente_ibfk_1` FOREIGN KEY (`Num_orden`) REFERENCES `ejecucion` (`Num_orden`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informe_cliente`
--

LOCK TABLES `informe_cliente` WRITE;
/*!40000 ALTER TABLE `informe_cliente` DISABLE KEYS */;
INSERT INTO `informe_cliente` VALUES (11001,'2022-09-01',1),(11001,'2022-09-02',2),(11002,'2022-09-02',3);
/*!40000 ALTER TABLE `informe_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_de_compra`
--

DROP TABLE IF EXISTS `orden_de_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden_de_compra` (
  `num_orden_de_compra` int NOT NULL AUTO_INCREMENT,
  `fecha_registro` char(15) DEFAULT NULL,
  `Num_orden` int DEFAULT NULL,
  PRIMARY KEY (`num_orden_de_compra`),
  KEY `Num_orden` (`Num_orden`),
  CONSTRAINT `orden_de_compra_ibfk_1` FOREIGN KEY (`Num_orden`) REFERENCES `ejecucion` (`Num_orden`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_de_compra`
--

LOCK TABLES `orden_de_compra` WRITE;
/*!40000 ALTER TABLE `orden_de_compra` DISABLE KEYS */;
INSERT INTO `orden_de_compra` VALUES (1,'2022-09-02',1),(2,'2022-09-03',3);
/*!40000 ALTER TABLE `orden_de_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL,
  `nombre` char(10) DEFAULT NULL,
  `apellido` char(10) DEFAULT NULL,
  `email` char(30) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (10211345,'andrea','camacho','acamachob9009@gmail.com'),(802090011,'armando','varela','arvarela22@hotmail.com');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-26 11:41:17
