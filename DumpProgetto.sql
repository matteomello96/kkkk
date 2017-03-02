CREATE DATABASE  IF NOT EXISTS `centropolisportivo` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `centropolisportivo`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: centropolisportivo
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `calendario`
--

DROP TABLE IF EXISTS `calendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendario` (
  `NomeCalendario` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `AnnoValidita` year(4) NOT NULL,
  PRIMARY KEY (`NomeCalendario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendario`
--

LOCK TABLES `calendario` WRITE;
/*!40000 ALTER TABLE `calendario` DISABLE KEYS */;
INSERT INTO `calendario` VALUES ('Calendario del Centro Polisportivo',2017);
/*!40000 ALTER TABLE `calendario` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER inizializza_annovalidità BEFORE INSERT ON `calendario` 
FOR EACH ROW SET NEW.annovalidita = IFNULL(NEW.annovalidita, year(now())) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disciplina` (
  `NomeDisciplina` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Descrizione` mediumtext CHARACTER SET utf8 NOT NULL,
  `Immagine` blob NOT NULL,
  `Calendario` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`NomeDisciplina`,`Calendario`),
  KEY `raccoglie(2)` (`Calendario`),
  CONSTRAINT `raccoglie(2)` FOREIGN KEY (`Calendario`) REFERENCES `calendario` (`NomeCalendario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES ('atletica','l \'atletica leggera è un insieme di discipline che possono essere sommariamente suddivise in :corse su pista,concorsi,prove multiple,corsa campestre. Può essere praticata dai 12 anni in su','PROGETTOimmagini progettoatletica.jpg','Calendario del Centro Polisportivo'),('calcio','Il calcio è uno sport di squadra,praticato da squadre composte da 11 giocatori.L\'obiettivo del gioco è quello di segnare più gol nella squadra avversaria. Le partite si disputano nella zona antistante l\'edificio. Possono giocare coloro che hanno dai 5 ai 20 anni','PROGETTOimmagini progettocalcio.jpg','Calendario del Centro Polisportivo'),('pallavolo','La pallavolo,o detta anche volley,è uno sport che si svolge tra due squadre di 6 giocatori ciascuna.Lo scopo della disciplina è realizzare punti facendo cadere la palla nel campo avversario.Ogni squadra può essere composta da 13 giocatori,ma solo in 6 entrano in campo.Il gioco in questione è adatto a coloro che hanno un\'età maggiore di 6 anni','PROGETTOimmagini progettopallavolo.jpg','Calendario del Centro Polisportivo'),('pesistica','La pesistica è una disciplina atletica nella quale gli atleti tentano di sollevare pesi montati su un bilanciere d\'acciaio.Le gare di pesistica sono diffuse sin dai tempi antichi. La disciplina è  adatta a coloro che hanno età maggiore di 15 anni','PROGETTOimmagini progettopesi.jpg','Calendario del Centro Polisportivo');
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gara`
--

DROP TABLE IF EXISTS `gara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gara` (
  `CodiceGara` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `NomeEvento` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `DataEvento` date NOT NULL,
  `Descrizione` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `InfoPagamento` enum('Gratuito','A pagamento') COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Gratuito',
  `CostoEvento` float NOT NULL,
  `Istruttore` int(10) unsigned zerofill NOT NULL,
  `combinazionelivdis` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`CodiceGara`,`Istruttore`,`combinazionelivdis`),
  UNIQUE KEY `uniquee` (`NomeEvento`,`Istruttore`,`combinazionelivdis`,`DataEvento`),
  KEY `dvv_idx` (`Istruttore`),
  KEY `combi_idx` (`combinazionelivdis`),
  CONSTRAINT `combi` FOREIGN KEY (`combinazionelivdis`) REFERENCES `livellidisciplina` (`Combinazionelivdis`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gara`
--

LOCK TABLES `gara` WRITE;
/*!40000 ALTER TABLE `gara` DISABLE KEYS */;
INSERT INTO `gara` VALUES (0000000003,'gara di pesistica','2017-03-06','la gara di pesistica avverrà il giorno sovrascritto dalle ore 15:30 alle ore 18:30','A pagamento',35,0000000001,0000000004),(0000000004,'gara di pallavolo','2017-03-06','la gara di pallavolo avverrà il giorno sovrascritto dalle ore 08:30 alle ore 13:30','A pagamento',25,0000000002,0000000011);
/*!40000 ALTER TABLE `gara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iscrizionedisciplina`
--

DROP TABLE IF EXISTS `iscrizionedisciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iscrizionedisciplina` (
  `codiceiscrizionedisciplina` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `dataazione` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tesserato` int(10) unsigned zerofill NOT NULL,
  `modalitapagamento` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `combinazionelivdis` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`codiceiscrizionedisciplina`,`tesserato`,`modalitapagamento`,`combinazionelivdis`),
  KEY `ttttttttttt_fk_idx` (`tesserato`),
  KEY `mmmmmmmmm_fk_idx` (`modalitapagamento`),
  KEY `dededdsss_fk_idx` (`combinazionelivdis`),
  CONSTRAINT `dededdsss_fk` FOREIGN KEY (`combinazionelivdis`) REFERENCES `livellidisciplina` (`Combinazionelivdis`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mmmmmmmmm_fk` FOREIGN KEY (`modalitapagamento`) REFERENCES `modalitapagamento` (`NomeModalità`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ttttttttttt_fk` FOREIGN KEY (`tesserato`) REFERENCES `tesserato` (`Matricolatesserato`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iscrizionedisciplina`
--

LOCK TABLES `iscrizionedisciplina` WRITE;
/*!40000 ALTER TABLE `iscrizionedisciplina` DISABLE KEYS */;
INSERT INTO `iscrizionedisciplina` VALUES (0000000001,'2017-02-27 21:09:22',0000000001,'contanti',0000000001),(0000000002,'2017-02-27 21:09:22',0000000002,'contanti',0000000005);
/*!40000 ALTER TABLE `iscrizionedisciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iscrizionegara`
--

DROP TABLE IF EXISTS `iscrizionegara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iscrizionegara` (
  `CodiceIscrizioneGara` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `DataAzione` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CertificatoRC` blob,
  `Gara` int(10) unsigned zerofill NOT NULL,
  `ModalitaPagamento` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Tesserato` int(10) unsigned zerofill NOT NULL,
  `Note` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`CodiceIscrizioneGara`),
  UNIQUE KEY `Gara` (`Gara`),
  KEY `tesserato_fk_idx` (`Tesserato`),
  KEY `attraverso(10)` (`ModalitaPagamento`),
  CONSTRAINT `a(9)` FOREIGN KEY (`Gara`) REFERENCES `gara` (`CodiceGara`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attraverso(10)` FOREIGN KEY (`ModalitaPagamento`) REFERENCES `modalitapagamento` (`NomeModalità`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `effettua(11)` FOREIGN KEY (`Tesserato`) REFERENCES `tesserato` (`Matricolatesserato`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iscrizionegara`
--

LOCK TABLES `iscrizionegara` WRITE;
/*!40000 ALTER TABLE `iscrizionegara` DISABLE KEYS */;
/*!40000 ALTER TABLE `iscrizionegara` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER inizializza_dataazione5 BEFORE INSERT ON `iscrizionegara` 
FOR EACH ROW SET NEW.dataazione = IFNULL(NEW.dataazione, NOW()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `iscrizionestage`
--

DROP TABLE IF EXISTS `iscrizionestage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iscrizionestage` (
  `CodiceIscrizioneStage` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `DataAzione` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Stage` int(10) unsigned zerofill NOT NULL,
  `ModalitaPagamento` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Tesserato` int(10) unsigned zerofill NOT NULL,
  `Note` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`CodiceIscrizioneStage`),
  UNIQUE KEY `Stage` (`Stage`),
  KEY `tesserato2_fk_idx` (`Tesserato`),
  KEY `attraverso(13)` (`ModalitaPagamento`),
  CONSTRAINT `a(12)` FOREIGN KEY (`Stage`) REFERENCES `stage` (`CodiceStage`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attraverso(13)` FOREIGN KEY (`ModalitaPagamento`) REFERENCES `modalitapagamento` (`NomeModalità`) ON UPDATE CASCADE,
  CONSTRAINT `effettua(14)` FOREIGN KEY (`Tesserato`) REFERENCES `tesserato` (`Matricolatesserato`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iscrizionestage`
--

LOCK TABLES `iscrizionestage` WRITE;
/*!40000 ALTER TABLE `iscrizionestage` DISABLE KEYS */;
/*!40000 ALTER TABLE `iscrizionestage` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER inizializza_dataazione6 BEFORE INSERT ON `iscrizionestage` 
FOR EACH ROW SET NEW.dataazione = IFNULL(NEW.dataazione, NOW()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `istruttore`
--

DROP TABLE IF EXISTS `istruttore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `istruttore` (
  `Codicefiscale` varchar(16) CHARACTER SET utf8 NOT NULL,
  `Nome` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Cognome` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Matricolaistruttore` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Via` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Numerocivico` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Cittaresidenza` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Username` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Pass` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Numerotelefono` varchar(10) CHARACTER SET utf8 NOT NULL,
  `Indirizzomail` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Matricolaistruttore`),
  UNIQUE KEY `Codicefiscale_UNIQUE` (`Codicefiscale`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  UNIQUE KEY `Indirizzomail_UNIQUE` (`Indirizzomail`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `istruttore`
--

LOCK TABLES `istruttore` WRITE;
/*!40000 ALTER TABLE `istruttore` DISABLE KEYS */;
INSERT INTO `istruttore` VALUES ('CNTLRZ90T18D897L','Lorenzo','Cantini',0000000001,'Viale Lo Re ','108','Lecce','istlorenzocantini90','bbbbbb8','3897484751','latinlover90@libero.it'),('PLLMRT69T18H795O','Martino','Pollino',0000000002,'Viale della Repubblica ','10','Castri di Lecce','istrmartinopollino69','bbbbbb9','3278495780','pollinom69@libero.it'),('RMILRA85B60H793L','Laura','Romei',0000000003,'Via Dante Alighieri','96','Lecce','istlauraromei85','oooopplllp9','3897548751','giulietta34@libero.it');
/*!40000 ALTER TABLE `istruttore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `istruttoredisciplina`
--

DROP TABLE IF EXISTS `istruttoredisciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `istruttoredisciplina` (
  `combinazioneistrdis` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `istruttore` int(10) unsigned zerofill NOT NULL,
  `combinazionelivdis` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`combinazioneistrdis`,`istruttore`,`combinazionelivdis`),
  KEY `KPKKOKO_idx` (`istruttore`),
  KEY `rgrrsrrttr_idx` (`combinazionelivdis`),
  CONSTRAINT `KPKKOKO` FOREIGN KEY (`istruttore`) REFERENCES `istruttore` (`Matricolaistruttore`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rgrrsrrttr` FOREIGN KEY (`combinazionelivdis`) REFERENCES `livellidisciplina` (`Combinazionelivdis`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `istruttoredisciplina`
--

LOCK TABLES `istruttoredisciplina` WRITE;
/*!40000 ALTER TABLE `istruttoredisciplina` DISABLE KEYS */;
INSERT INTO `istruttoredisciplina` VALUES (0000000001,0000000001,0000000004),(0000000002,0000000001,0000000008),(0000000003,0000000002,0000000001),(0000000004,0000000002,0000000005),(0000000005,0000000002,0000000009),(0000000006,0000000003,0000000002),(0000000007,0000000003,0000000010);
/*!40000 ALTER TABLE `istruttoredisciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livellidisciplina`
--

DROP TABLE IF EXISTS `livellidisciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livellidisciplina` (
  `Combinazionelivdis` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Livello` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Disciplina` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `MaxIscrittiTurno` int(5) NOT NULL,
  `CostoMensile` int(5) NOT NULL,
  PRIMARY KEY (`Combinazionelivdis`,`Livello`,`Disciplina`),
  KEY `ddsssssaa_idx` (`Livello`),
  KEY `llkklkkokoko_idx` (`Disciplina`),
  CONSTRAINT `ddsssssaa` FOREIGN KEY (`Livello`) REFERENCES `livello` (`NomeLivello`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `llkklkkokoko` FOREIGN KEY (`Disciplina`) REFERENCES `disciplina` (`NomeDisciplina`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livellidisciplina`
--

LOCK TABLES `livellidisciplina` WRITE;
/*!40000 ALTER TABLE `livellidisciplina` DISABLE KEYS */;
INSERT INTO `livellidisciplina` VALUES (0000000001,'principiante','calcio',8,50),(0000000002,'principiante','pallavolo',12,60),(0000000003,'principiante','atletica',4,50),(0000000004,'intermedio','pesistica',6,45),(0000000005,'intermedio','calcio',7,55),(0000000006,'intermedio','pallavolo',12,65),(0000000007,'intermedio','atletica',4,55),(0000000008,'avanzato','pesistica',5,50),(0000000009,'avanzato','calcio',4,60),(0000000010,'avanzato','pallavolo',12,70),(0000000011,'avanzato','atletica',3,60),(0000000012,'esperto','pesistica',4,55),(0000000013,'esperto','calcio',5,65),(0000000014,'esperto','pallavolo',12,75),(0000000015,'esperto','atletica',3,65);
/*!40000 ALTER TABLE `livellidisciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livello`
--

DROP TABLE IF EXISTS `livello`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livello` (
  `NomeLivello` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`NomeLivello`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livello`
--

LOCK TABLES `livello` WRITE;
/*!40000 ALTER TABLE `livello` DISABLE KEYS */;
INSERT INTO `livello` VALUES ('avanzato'),('esperto'),('intermedio'),('principiante');
/*!40000 ALTER TABLE `livello` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalitapagamento`
--

DROP TABLE IF EXISTS `modalitapagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modalitapagamento` (
  `NomeModalità` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`NomeModalità`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalitapagamento`
--

LOCK TABLES `modalitapagamento` WRITE;
/*!40000 ALTER TABLE `modalitapagamento` DISABLE KEYS */;
INSERT INTO `modalitapagamento` VALUES ('assegno circolare'),('bonifico bancario'),('carta di credito'),('contanti'),('gratuito');
/*!40000 ALTER TABLE `modalitapagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsabilecentro`
--

DROP TABLE IF EXISTS `responsabilecentro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsabilecentro` (
  `Matricolaresponsabile` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Cognome` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Codicefiscale` varchar(16) CHARACTER SET utf8 NOT NULL,
  `Via` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Numerocivico` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Cittaresidenza` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Username` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Pass` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Numerotelefono` varchar(10) CHARACTER SET utf8 NOT NULL,
  `Indirizzomail` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`Matricolaresponsabile`),
  UNIQUE KEY `Codicefiscale_UNIQUE` (`Codicefiscale`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  UNIQUE KEY `Indirizzomail_UNIQUE` (`Indirizzomail`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsabilecentro`
--

LOCK TABLES `responsabilecentro` WRITE;
/*!40000 ALTER TABLE `responsabilecentro` DISABLE KEYS */;
INSERT INTO `responsabilecentro` VALUES (0000000001,'Marco','Stella','STLMRC79C18D874K','Viale delle rose ','101','Lequile','respmarcostella79','cccccc9','3325484751','stellinomark@gmail.com');
/*!40000 ALTER TABLE `responsabilecentro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sceltaorari`
--

DROP TABLE IF EXISTS `sceltaorari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sceltaorari` (
  `preferenzafascia` enum('08:30-09:30','09:30-10:30','10:30-11:30','11:30-12:30','12:30-13:30','15:30-16:30','16:30-17:30','17:30-18:30','18:30','19:30','19:30-20:30','20:30-21:30') COLLATE utf8_unicode_ci NOT NULL,
  `codiceiscrizionedisciplina` int(10) unsigned zerofill NOT NULL,
  KEY `tesserasto_fk_idx` (`codiceiscrizionedisciplina`),
  CONSTRAINT `tesserasxddsto_fk` FOREIGN KEY (`codiceiscrizionedisciplina`) REFERENCES `iscrizionedisciplina` (`codiceiscrizionedisciplina`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sceltaorari`
--

LOCK TABLES `sceltaorari` WRITE;
/*!40000 ALTER TABLE `sceltaorari` DISABLE KEYS */;
INSERT INTO `sceltaorari` VALUES ('08:30-09:30',0000000001),('15:30-16:30',0000000001),('12:30-13:30',0000000002),('10:30-11:30',0000000002);
/*!40000 ALTER TABLE `sceltaorari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spazio`
--

DROP TABLE IF EXISTS `spazio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spazio` (
  `NomeSpazio` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`NomeSpazio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spazio`
--

LOCK TABLES `spazio` WRITE;
/*!40000 ALTER TABLE `spazio` DISABLE KEYS */;
INSERT INTO `spazio` VALUES ('piscina'),('sala cardio'),('sala fitness'),('sala gare 1'),('sala gare 2'),('sala gare 3'),('sala gare piscina'),('sala stage 1'),('sala stage 2'),('sala stage 3');
/*!40000 ALTER TABLE `spazio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stage`
--

DROP TABLE IF EXISTS `stage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stage` (
  `CodiceStage` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `NomeEvento` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `DataEvento` date NOT NULL,
  `Descrizione` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `InfoPagamento` enum('Gratuito','A pagamento') COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Gratuito',
  `CostoEvento` float NOT NULL,
  `Istruttore` int(10) unsigned zerofill NOT NULL,
  `combinazionelivdis` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`CodiceStage`,`Istruttore`,`combinazionelivdis`),
  KEY `wwww_idx` (`Istruttore`),
  KEY `JHIHUUHUHOHI_idx` (`combinazionelivdis`),
  CONSTRAINT `JHIHUUHUHOHI` FOREIGN KEY (`combinazionelivdis`) REFERENCES `livellidisciplina` (`Combinazionelivdis`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `wwww` FOREIGN KEY (`Istruttore`) REFERENCES `istruttore` (`Matricolaistruttore`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stage`
--

LOCK TABLES `stage` WRITE;
/*!40000 ALTER TABLE `stage` DISABLE KEYS */;
INSERT INTO `stage` VALUES (0000000001,'stage di atletica','2017-03-01','Lo stage si terrà il giorno sovrascritto dalle ore 16:30  alle ore 19:30.Consigliato per principianti','Gratuito',0,0000000002,0000000003),(0000000002,'stage di pesistica','2017-03-06','Lo stage si terrà il giorno sovrascritto dalle ore 11:30  alle ore 13:30.Consigliato per avanzati','A pagamento',10,0000000001,0000000008);
/*!40000 ALTER TABLE `stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tesserato`
--

DROP TABLE IF EXISTS `tesserato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tesserato` (
  `Matricolatesserato` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Cognome` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Codicefiscale` varchar(16) CHARACTER SET utf8 NOT NULL,
  `Via` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Numerocivico` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Cittaresidenza` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Pass` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Numerotelefono` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Indirizzomail` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Matricolatesserato`),
  UNIQUE KEY `Codicefiscale_UNIQUE` (`Codicefiscale`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  UNIQUE KEY `Indirizzomail_UNIQUE` (`Indirizzomail`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tesserato`
--

LOCK TABLES `tesserato` WRITE;
/*!40000 ALTER TABLE `tesserato` DISABLE KEYS */;
INSERT INTO `tesserato` VALUES (0000000001,'Marco','Rossi','RSSMRI94C20HT93K','Via Imperatore Adriano ','9','Lecce','marcorossi94','aaaaa5','3886395842','mrossi@gmail.com'),(0000000002,'Maria','Toffa','TFFMRI79A41A866F','Via Dante Alighieri ','15','Cavallino','mariatoffa79','aaaaa6','3687458951','titti79@yahoo.it'),(0000000003,'Luca','Marino','MRNLCU89B21E506F','Viale Europa ','98','Lecce','marinoluca89','aaaaa7','3409874514','luke87@yahoo.it'),(0000000004,'Lucrezia','Conti','CNTLCR98T68E874J','Via Spagna ','18','Merine','contilucrezia98','aaaaa8','3451478495','lucreziabella98@yahoo.it');
/*!40000 ALTER TABLE `tesserato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testimonianza`
--

DROP TABLE IF EXISTS `testimonianza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `testimonianza` (
  `CodiceTestimonianza` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Commento` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `DataAzione` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Tesserato` int(10) unsigned zerofill NOT NULL,
  `combinazionelivdis` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`CodiceTestimonianza`,`combinazionelivdis`,`Tesserato`),
  KEY `inserisce(33)` (`Tesserato`),
  KEY `FFDFFSF_idx` (`combinazionelivdis`),
  CONSTRAINT `FFDFFSF` FOREIGN KEY (`combinazionelivdis`) REFERENCES `livellidisciplina` (`Combinazionelivdis`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `inserisce(33)` FOREIGN KEY (`Tesserato`) REFERENCES `tesserato` (`Matricolatesserato`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testimonianza`
--

LOCK TABLES `testimonianza` WRITE;
/*!40000 ALTER TABLE `testimonianza` DISABLE KEYS */;
INSERT INTO `testimonianza` VALUES (0000000001,'disciplina meravigliosa,con livello adeguato alle mie esigenze','2017-02-27 21:56:35',0000000001,0000000004),(0000000002,'da rifareeee','2017-02-27 21:56:35',0000000001,0000000009),(0000000003,'unico nel suo genere','2017-02-27 21:56:36',0000000002,0000000003);
/*!40000 ALTER TABLE `testimonianza` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER inizializza_dataazione13 BEFORE INSERT ON `testimonianza` 
FOR EACH ROW SET NEW.dataazione = IFNULL(NEW.dataazione, NOW()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `tipologiaspazio`
--

DROP TABLE IF EXISTS `tipologiaspazio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipologiaspazio` (
  `NomeTipologia` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Spazio` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`NomeTipologia`),
  KEY `appartiene(35)` (`Spazio`),
  CONSTRAINT `appartiene(35)` FOREIGN KEY (`Spazio`) REFERENCES `spazio` (`NomeSpazio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipologiaspazio`
--

LOCK TABLES `tipologiaspazio` WRITE;
/*!40000 ALTER TABLE `tipologiaspazio` DISABLE KEYS */;
INSERT INTO `tipologiaspazio` VALUES ('sala con attrezzi','sala cardio'),('sala adibita ad altri usi','sala gare 1'),('sala con attrezzi per agonisti','sala gare 2');
/*!40000 ALTER TABLE `tipologiaspazio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turnodisciplina`
--

DROP TABLE IF EXISTS `turnodisciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turnodisciplina` (
  `NumeroTurno` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Giornosettimana` enum('Lunedi','Martedi','Mercoledi','Giovedi','Venerdi','Sabato') CHARACTER SET utf8 NOT NULL,
  `fasciaoraria` enum('08:30-09:30','09:30-10:30','10:30-11:30','11:30-12:30','12:30-13:30','15:30-16:30','16:30-17:30','17:30-18:30','18:30','19:30','19:30-20:30','20:30-21:30') COLLATE utf8_unicode_ci NOT NULL,
  `combinazionelivdis` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`NumeroTurno`,`combinazionelivdis`),
  UNIQUE KEY `njjjk` (`Giornosettimana`,`fasciaoraria`,`combinazionelivdis`),
  KEY `FDDSSS_idx` (`combinazionelivdis`),
  CONSTRAINT `FDDSSS` FOREIGN KEY (`combinazionelivdis`) REFERENCES `livellidisciplina` (`Combinazionelivdis`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turnodisciplina`
--

LOCK TABLES `turnodisciplina` WRITE;
/*!40000 ALTER TABLE `turnodisciplina` DISABLE KEYS */;
INSERT INTO `turnodisciplina` VALUES (0000000001,'Lunedi','08:30-09:30',0000000002),(0000000002,'Lunedi','09:30-10:30',0000000002),(0000000003,'Lunedi','10:30-11:30',0000000005),(0000000004,'Lunedi','11:30-12:30',0000000008),(0000000007,'Martedi','10:30-11:30',0000000010),(0000000008,'Martedi','11:30-12:30',0000000001),(0000000005,'Martedi','11:30-12:30',0000000004),(0000000006,'Martedi','15:30-16:30',0000000009);
/*!40000 ALTER TABLE `turnodisciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turnogara`
--

DROP TABLE IF EXISTS `turnogara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turnogara` (
  `NumeroTurno` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Giornosettimana` enum('Lunedi','Martedi','Mercoledi','Giovedi','Venerdi','Sabato') CHARACTER SET utf8 NOT NULL,
  `fasciaoraria` enum('08:30-09:30','09:30-10:30','10:30-11:30','11:30-12:30','12:30-13:30','15:30-16:30','16:30-17:30','17:30-18:30','18:30','19:30','19:30-20:30','20:30-21:30') COLLATE utf8_unicode_ci NOT NULL,
  `Gara` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`NumeroTurno`,`Gara`),
  UNIQUE KEY `kljjioijo` (`Giornosettimana`,`fasciaoraria`,`Gara`),
  KEY `gares_fk_idx` (`Gara`),
  CONSTRAINT `gares_fk` FOREIGN KEY (`Gara`) REFERENCES `gara` (`CodiceGara`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turnogara`
--

LOCK TABLES `turnogara` WRITE;
/*!40000 ALTER TABLE `turnogara` DISABLE KEYS */;
/*!40000 ALTER TABLE `turnogara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turnoistruttore`
--

DROP TABLE IF EXISTS `turnoistruttore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turnoistruttore` (
  `NumeroTurno` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Giornosettimana` enum('Lunedi','Martedi','Mercoledi','Giovedi','Venerdi','Sabato') CHARACTER SET utf8 NOT NULL,
  `fasciaoraria` enum('08:30-09:30','09:30-10:30','10:30-11:30','11:30-12:30','12:30-13:30','15:30-16:30','16:30-17:30','17:30-18:30','18:30','19:30','19:30-20:30','20:30-21:30') COLLATE utf8_unicode_ci NOT NULL,
  `combinazioneistrdis` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`NumeroTurno`,`combinazioneistrdis`),
  KEY `istruttoore_fk_idx` (`combinazioneistrdis`),
  CONSTRAINT `istruttoore_fk` FOREIGN KEY (`combinazioneistrdis`) REFERENCES `istruttoredisciplina` (`combinazioneistrdis`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turnoistruttore`
--

LOCK TABLES `turnoistruttore` WRITE;
/*!40000 ALTER TABLE `turnoistruttore` DISABLE KEYS */;
/*!40000 ALTER TABLE `turnoistruttore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turnostage`
--

DROP TABLE IF EXISTS `turnostage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turnostage` (
  `NumeroTurno` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Giornosettimana` enum('Lunedi','Martedi','Mercoledi','Giovedi','Venerdi','Sabato') CHARACTER SET utf8 NOT NULL,
  `fasciaoraria` enum('08:30-09:30','09:30-10:30','10:30-11:30','11:30-12:30','12:30-13:30','15:30-16:30','16:30-17:30','17:30-18:30','18:30','19:30','19:30-20:30','20:30-21:30') COLLATE utf8_unicode_ci NOT NULL,
  `Stage` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`NumeroTurno`,`Stage`),
  KEY `stages_fk_idx` (`Stage`),
  CONSTRAINT `stages_fk` FOREIGN KEY (`Stage`) REFERENCES `stage` (`CodiceStage`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turnostage`
--

LOCK TABLES `turnostage` WRITE;
/*!40000 ALTER TABLE `turnostage` DISABLE KEYS */;
/*!40000 ALTER TABLE `turnostage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turnotesserato`
--

DROP TABLE IF EXISTS `turnotesserato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turnotesserato` (
  `NumeroTurno` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Giornosettimana` enum('Lunedi','Martedi','Mercoledi','Giovedi','Venerdi','Sabato') CHARACTER SET utf8 NOT NULL,
  `fasciaoraria` enum('08:30-09:30','09:30-10:30','10:30-11:30','11:30-12:30','12:30-13:30','15:30-16:30','16:30-17:30','17:30-18:30','18:30','19:30','19:30-20:30','20:30-21:30') COLLATE utf8_unicode_ci NOT NULL,
  `Tesserato` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`NumeroTurno`,`Tesserato`),
  KEY `tex_fk_idx` (`Tesserato`),
  CONSTRAINT `tex_fk` FOREIGN KEY (`Tesserato`) REFERENCES `tesserato` (`Matricolatesserato`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turnotesserato`
--

LOCK TABLES `turnotesserato` WRITE;
/*!40000 ALTER TABLE `turnotesserato` DISABLE KEYS */;
/*!40000 ALTER TABLE `turnotesserato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenteinattesa`
--

DROP TABLE IF EXISTS `utenteinattesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utenteinattesa` (
  `CodiceRegistrazione` int(10) unsigned zerofill NOT NULL,
  `Nome` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Cognome` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Codicefiscale` varchar(16) CHARACTER SET utf8 NOT NULL,
  `Via` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Numerocivico` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Cittaresidenza` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Username` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Pass` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Numerotelefono` varchar(10) CHARACTER SET utf8 NOT NULL,
  `Indirizzomail` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Tipoutente` enum('Tesserato','Istruttore','Responsabile') COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`CodiceRegistrazione`),
  UNIQUE KEY `Codicefiscale_UNIQUE` (`Codicefiscale`),
  UNIQUE KEY `Indirizzomail_UNIQUE` (`Indirizzomail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenteinattesa`
--

LOCK TABLES `utenteinattesa` WRITE;
/*!40000 ALTER TABLE `utenteinattesa` DISABLE KEYS */;
/*!40000 ALTER TABLE `utenteinattesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'centropolisportivo'
--

--
-- Dumping routines for database 'centropolisportivo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-02 18:41:20
