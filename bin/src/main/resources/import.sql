DROP DATABASE IF EXISTS `PROYECTO-RRHH1`;
CREATE DATABASE `PROYECTO-RRHH1`;
USE `PROYECTO-RRHH1`;


DROP TABLE IF EXISTS `tiposoftskills`;
CREATE TABLE `tiposoftskills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipoSkill` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `tiposoftskills` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `entrevistas`;
CREATE TABLE `entrevistas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha_contacto` date DEFAULT NULL,
  `medio_contacto` varchar(100) DEFAULT NULL,
  `pretension_salarial` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `entrevistas` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `equipos`;
CREATE TABLE `equipos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `id_busqueda` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `equipos` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `estadocivil`;
CREATE TABLE `estadocivil` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `estadocivil` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `experiencias`;
CREATE TABLE `experiencias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_empresa` int DEFAULT NULL,
  `id_candidato` int DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `descripcion` varchar(900) DEFAULT NULL,
  `actual` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `experiencias` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `instituciones`;
CREATE TABLE `instituciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombreInstitucion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `instituciones` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `idiomas`;
CREATE TABLE `idiomas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `idiomas` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `nivelidioma`;
CREATE TABLE `nivelidioma` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `nivelidioma` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `prioridad`;
CREATE TABLE `prioridad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `prioridad` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `provincia`;
CREATE TABLE `provincia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombreProv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `provincia` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `localidades`;
CREATE TABLE `localidades` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `id_provincia` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Provincia_idx` (`id_provincia`),
  CONSTRAINT `FK_Provincia` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `localidades` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `roles` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `empresas`;
CREATE TABLE `empresas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `id_localidad` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Empresa_Localidad_idx` (`id_localidad`),
  CONSTRAINT `FK_Empresa_Localidad` FOREIGN KEY (`id_localidad`) REFERENCES `localidades` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `empresas` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `origencontacto`;
CREATE TABLE `origencontacto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `origencontacto` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `puesto`;
CREATE TABLE `puesto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `puesto` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `seniority`;
CREATE TABLE `seniority` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `seniority` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `tipoestudios`;
CREATE TABLE `tipoestudios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `tipoestudios` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `tipohardskills`;
CREATE TABLE `tipohardskills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `tipohardskills` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `email` varchar(50) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `imagen_url` varchar(100) DEFAULT NULL,
  `token` varchar(900) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `usuarios` WRITE;
UNLOCK TABLES;




DROP TABLE IF EXISTS `usuarioxrol`;
CREATE TABLE `usuarioxrol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `id_rol` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `FK_Rol_idx` (`id_rol`),
  CONSTRAINT `FK_Rol` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id`),
  CONSTRAINT `FK_Usuario` FOREIGN KEY (`email`) REFERENCES `usuarios` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `usuarioxrol` WRITE;
UNLOCK TABLES;



DROP TABLE IF EXISTS `puestoxequipo`;
CREATE TABLE `puestoxequipo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_puesto` int DEFAULT NULL,
  `id_equipo` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Puesto1_idx` (`id_puesto`),
  KEY `FK_Equipo1_idx` (`id_equipo`),
  CONSTRAINT `FK_Equipo1` FOREIGN KEY (`id_equipo`) REFERENCES `equipos` (`id`),
  CONSTRAINT `FK_Puesto1` FOREIGN KEY (`id_puesto`) REFERENCES `puesto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `puestoxequipo` WRITE;
UNLOCK TABLES;




DROP TABLE IF EXISTS `busquedas`;
CREATE TABLE `busquedas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_empresa` int DEFAULT NULL,
  `id_prioridad` int DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_limite` date DEFAULT NULL,
  `pendiente` tinyint(1) DEFAULT NULL,
  `id_provincia` int DEFAULT NULL,
  `id_equipo` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Busqueda_Empresa_idx` (`id_empresa`),
  KEY `FK_Busqueda_Prioridad_idx` (`id_prioridad`),
  KEY `FK_Busqueda_Provincia_idx` (`id_provincia`),
  KEY `FK_Busqueda_Equipo_idx` (`id_equipo`),
  CONSTRAINT `FK_Busqueda_Empresa` FOREIGN KEY (`id_empresa`) REFERENCES `empresas` (`id`),
  CONSTRAINT `FK_Busqueda_Equipo` FOREIGN KEY (`id_equipo`) REFERENCES `equipos` (`id`),
  CONSTRAINT `FK_Busqueda_Prioridad` FOREIGN KEY (`id_prioridad`) REFERENCES `prioridad` (`id`),
  CONSTRAINT `FK_Busqueda_Provincia` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `busquedas` WRITE;
UNLOCK TABLES;



DROP TABLE IF EXISTS `candidatos`;
CREATE TABLE `candidatos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dni` int DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `id_estado_civil` int DEFAULT NULL,
  `domicilio` varchar(200) DEFAULT NULL,
  `id_localidad` int DEFAULT NULL,
  `pretension_economica` decimal(15,2) DEFAULT NULL,
  `disponibilidad_viaje` tinyint(1) DEFAULT NULL,
  `disponibilidad_remoto` tinyint(1) DEFAULT NULL,
  `disponibilidad_reubicacion` tinyint(1) DEFAULT NULL,
  `linkedin` varchar(100) DEFAULT NULL,
  `curriculum` varchar(600) DEFAULT NULL,
  `observacion` varchar(600) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `anios_experiencia` int DEFAULT NULL,
  `id_origen_contacto` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_OrigenContacto_idx` (`id_origen_contacto`),
  KEY `FK_Localidad_idx` (`id_localidad`),
  KEY `FK_EstadoCivil_idx` (`id_estado_civil`),
  CONSTRAINT `FK_EstadoCivil` FOREIGN KEY (`id_estado_civil`) REFERENCES `estadocivil` (`id`),
  CONSTRAINT `FK_Localidad` FOREIGN KEY (`id_localidad`) REFERENCES `localidades` (`id`),
  CONSTRAINT `FK_OrigenContacto` FOREIGN KEY (`id_origen_contacto`) REFERENCES `origencontacto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `candidatos` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `candidatoxhardskill`;
CREATE TABLE `candidatoxhardskill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_candidato` int DEFAULT NULL,
  `id_hardskill` int DEFAULT NULL,
  `observacion` varchar(600) DEFAULT NULL,
  `anios` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_candidato_tecnologia_idx` (`id_candidato`),
  KEY `FK_tecnologia_idx` (`id_hardskill`),
  CONSTRAINT `FK_candidato` FOREIGN KEY (`id_candidato`) REFERENCES `candidatos` (`id`),
  CONSTRAINT `FK_tecnologia` FOREIGN KEY (`id_hardskill`) REFERENCES `hardskills` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `candidatoxhardskill` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `candidatoxsoftskill`;
CREATE TABLE `candidatoxsoftskill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_softskill` int DEFAULT NULL,
  `id_candidato` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_softskill` (`id_softskill`),
  KEY `id_candidato` (`id_candidato`),
  CONSTRAINT `candidatoxsoftskill_ibfk_1` FOREIGN KEY (`id_softskill`) REFERENCES `tiposoftskills` (`id`),
  CONSTRAINT `candidatoxsoftskill_ibfk_2` FOREIGN KEY (`id_candidato`) REFERENCES `candidatos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `candidatoxsoftskill` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `educaciones`;
CREATE TABLE `educaciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_tipo_estudio` int DEFAULT NULL,
  `id_institucion` int DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(900) DEFAULT NULL,
  `certificacion` tinyint(1) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `id_candidato` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Institucion_idx` (`id_institucion`),
  KEY `FK_TipoEstudio_idx` (`id_tipo_estudio`),
  KEY `FK_Candidato_idx` (`id_candidato`),
  CONSTRAINT `FK_Candidato_Educacion` FOREIGN KEY (`id_candidato`) REFERENCES `candidatos` (`id`),
  CONSTRAINT `FK_Institucion` FOREIGN KEY (`id_institucion`) REFERENCES `instituciones` (`id`),
  CONSTRAINT `FK_TipoEstudio` FOREIGN KEY (`id_tipo_estudio`) REFERENCES `tipoestudios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `educaciones` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `entrevistadores`;
CREATE TABLE `entrevistadores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `id_puesto` int DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Puesto_Entrevistadores_idx` (`id_puesto`),
  KEY `FK_Entrevistador_Usuario_idx` (`email`),
  CONSTRAINT `FK_Entrevistador_Usuario` FOREIGN KEY (`email`) REFERENCES `usuarios` (`email`),
  CONSTRAINT `FK_Puesto_Entrevistadores` FOREIGN KEY (`id_puesto`) REFERENCES `puesto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `entrevistadores` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `entrevistadorxentrevista`;
CREATE TABLE `entrevistadorxentrevista` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_entrevista` int DEFAULT NULL,
  `id_entrevistador` int DEFAULT NULL,
  `observacion` varchar(900) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Entrevista_idx` (`id_entrevista`),
  KEY `FK_Entrevistador_idx` (`id_entrevistador`),
  CONSTRAINT `FK_Entrevista` FOREIGN KEY (`id_entrevista`) REFERENCES `entrevistas` (`id`),
  CONSTRAINT `FK_Entrevistador` FOREIGN KEY (`id_entrevistador`) REFERENCES `entrevistadores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `entrevistadorxentrevista` WRITE;
UNLOCK TABLES;



DROP TABLE IF EXISTS `experienciaxpuesto`;
CREATE TABLE `experienciaxpuesto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_experiencia` int DEFAULT NULL,
  `id_puesto` int DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Experiencia_idx` (`id_experiencia`),
  KEY `FK_Puesto_idx` (`id_puesto`),
  CONSTRAINT `FK_Experiencia` FOREIGN KEY (`id_experiencia`) REFERENCES `experiencias` (`id`),
  CONSTRAINT `FK_Puesto` FOREIGN KEY (`id_puesto`) REFERENCES `puesto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `experienciaxpuesto` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `hardskills`;
CREATE TABLE `hardskills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `id_seniority` int DEFAULT NULL,
  `id_tipo_hardskill` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TipoHardSkill_idx` (`id_tipo_hardskill`),
  KEY `FK_Seniority_idx` (`id_seniority`),
  CONSTRAINT `FK_Seniority` FOREIGN KEY (`id_seniority`) REFERENCES `seniority` (`id`),
  CONSTRAINT `FK_TipoHardSkill` FOREIGN KEY (`id_tipo_hardskill`) REFERENCES `tipohardskills` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `hardskills` WRITE;
UNLOCK TABLES;




DROP TABLE IF EXISTS `idiomaxcandidato`;
CREATE TABLE `idiomaxcandidato` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_idioma` int DEFAULT NULL,
  `id_nivel_idioma` int DEFAULT NULL,
  `id_candidato` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_idioma_idx` (`id_idioma`),
  KEY `FK_Nivel_Idioma_idx` (`id_nivel_idioma`),
  KEY `FK_Candidato_Idioma_idx` (`id_candidato`),
  CONSTRAINT `FK_Candidato_Idioma` FOREIGN KEY (`id_candidato`) REFERENCES `candidatos` (`id`),
  CONSTRAINT `FK_Idioma` FOREIGN KEY (`id_idioma`) REFERENCES `idiomas` (`id`),
  CONSTRAINT `FK_Nivel_Idioma` FOREIGN KEY (`id_nivel_idioma`) REFERENCES `nivelidioma` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `idiomaxcandidato` WRITE;
UNLOCK TABLES;



DROP TABLE IF EXISTS `puestoxcandidato`;
CREATE TABLE `puestoxcandidato` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_puesto` int DEFAULT NULL,
  `id_candidato` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_puestoAcandidato_idx` (`id_candidato`),
  KEY `FK_PuestoPuesto1_idx` (`id_puesto`),
  CONSTRAINT `FK_CandidatoCandidato1` FOREIGN KEY (`id_candidato`) REFERENCES `candidatos` (`id`),
  CONSTRAINT `FK_PuestoPuesto1` FOREIGN KEY (`id_puesto`) REFERENCES `puesto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `puestoxcandidato` WRITE;
UNLOCK TABLES;














