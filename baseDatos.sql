CREATE DATABASE  IF NOT EXISTS `paginacursos` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `paginacursos`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: paginacursos
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contrasena` varchar(60) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ko52i5e5dce817rixde2twtdf` (`nombre_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'$2a$12$CHe1gduSP2dM7QPWdQ2D9e5AL.SsjcxXuj56VbIojH20irydmD4tm','admin');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido1` varchar(30) NOT NULL,
  `apellido2` varchar(30) NOT NULL,
  `contrasena` varchar(60) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `edad` int NOT NULL,
  `email` varchar(50) NOT NULL,
  `nombre1` varchar(25) NOT NULL,
  `nombre2` varchar(25) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `curso` bigint DEFAULT NULL,
  `region` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dlqu0nadbeiwn48uty3rus51y` (`email`),
  KEY `FKv1my09upfw924ep4g6eaem3g` (`curso`),
  KEY `FKj5ksg20oph6puowbkfpxjy0l` (`region`),
  CONSTRAINT `FKj5ksg20oph6puowbkfpxjy0l` FOREIGN KEY (`region`) REFERENCES `region` (`id`),
  CONSTRAINT `FKv1my09upfw924ep4g6eaem3g` FOREIGN KEY (`curso`) REFERENCES `curso` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'Menares','Donoso','$2a$10$kvPQFNaMLSllCdJkzH3bKe9Mw2ysyGLMENL7qg45y.W3My3Dw1Bhu','Volcán Osorno 0212, Villarrica',41,'usuario1@gmail.com','Carolina','Norma','+56988776655',NULL,12),(2,'Uribe','Almonacid','$2a$10$Q8p2tyTqINeuiTczCAUhR.hYFERlVlAvWQ5jru5QI.dcH2HPmd3Mi','Luis Durand 1122, Temuco',21,'usuario2@gmail.com','Sebastián','Alejandro','+56977662211',NULL,12);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `contenidos` varchar(500) NOT NULL,
  `cupos_disponibles` int NOT NULL,
  `cupos_iniciales` int NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `fecha_final` datetime(6) NOT NULL,
  `fecha_inicio` datetime(6) NOT NULL,
  `imagen` varchar(255) NOT NULL,
  `nombre` varchar(75) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (4,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu accumsan felis. Curabitur ac nisl nec mi porttitor dapibus non eu justo. Ut vestibulum quam ac lorem tempor tristique viverra fusce.',20,20,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin vel eros sit amet nibh pulvinar mattis. Proin fringilla ipsum justo, id imperdiet sapien pretium id. Phasellus sapien dolor, lobortis id tempus et, pretium ut nisi. Donec ultrices urna quis vestibulum elementum. Sed volutpat orci tortor.','2022-10-31 00:00:00.000000','2022-06-10 00:00:00.000000','https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_512x512.png','Fundamentos de Programación en Java'),(5,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam semper aliquet magna, sit amet lacinia lorem dictum ut. Etiam tristique leo a ante pretium interdum. Integer rutrum suscipit turpis, sit amet venenatis dolor. Nullam a purus sed lacus egestas placerat vel sit amet ante. Curabitur aenean.',50,50,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam semper aliquet magna, sit amet lacinia lorem dictum ut. Etiam tristique leo a ante pretium interdum. Integer rutrum suscipit turpis, sit amet venenatis dolor. Nullam a purus sed lacus egestas placerat vel sit amet ante. Curabitur aenean.','2022-10-31 00:00:00.000000','2022-07-01 00:00:00.000000','https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/python/python_512x512.png','Fullstack Python Trainee');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `region` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'Región de Arica y Parinacota'),(2,'Región de Tarapacá'),(3,'Región de Antofagasta'),(4,'Región de Atacama'),(5,'Región de Coquimbo'),(6,'Región de Valparaíso'),(7,'Región Metropolitana de Santiago'),(8,'Región del Libertador General Bernardo O\'Higgins'),(9,'Región del Maule'),(10,'Región de Ñuble'),(11,'Región del Biobío'),(12,'Región de La Araucanía'),(13,'Región de Los Ríos'),(14,'Región de Los Lagos'),(15,'Región de Aysén del General Carlos Ibáñez del Campo'),(16,'Región de Magallanes y de la Antártica Chilena');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-10 23:40:11
