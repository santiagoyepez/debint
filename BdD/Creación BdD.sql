CREATE TABLE `Carrera` (
`IdCarrera` int NOT NULL AUTO_INCREMENT,
`Carrera` varchar(100) NOT NULL,
PRIMARY KEY (`IdCarrera`) 
)
AUTO_INCREMENT = 1;

CREATE TABLE `Categoria` (
`IdCategoria` int NOT NULL AUTO_INCREMENT,
`IdMateria` int NOT NULL,
`IdPeriodo` int NOT NULL,
PRIMARY KEY (`IdCategoria`) 
)
AUTO_INCREMENT = 1;

CREATE TABLE `Comentario` (
`IdComentario` int NOT NULL AUTO_INCREMENT,
`IdUsuario` int NOT NULL,
`IdRecurso` int NOT NULL,
`Comentario` varchar(250) NOT NULL,
`Puntos` int NOT NULL,
PRIMARY KEY (`IdComentario`) 
)
AUTO_INCREMENT = 1;

CREATE TABLE `Materia` (
`IdMateria` int NOT NULL AUTO_INCREMENT,
`IdCarrera` int NOT NULL,
`Materia` varchar(50) NOT NULL,
PRIMARY KEY (`IdMateria`) 
)
AUTO_INCREMENT = 1;

CREATE TABLE `Periodo` (
`IdPeriodo` int NOT NULL AUTO_INCREMENT,
`Año` int NULL,
`Parte` varchar(2) NULL,
PRIMARY KEY (`IdPeriodo`) 
)
AUTO_INCREMENT = 1;

CREATE TABLE `Recurso` (
`IdRecurso` int NOT NULL AUTO_INCREMENT,
`IdUsuario` int NOT NULL,
`IdCategoría` int NOT NULL,
`Titulo` varchar(50) NOT NULL,
`Descripción` varchar(100) NOT NULL,
`Visible` tinyint NOT NULL,
`IdSolicitud` int NULL,
PRIMARY KEY (`IdRecurso`) 
)
AUTO_INCREMENT = 1;

CREATE TABLE `SolicitudRecurso` (
`IdSolicitud` int NOT NULL AUTO_INCREMENT,
`RecursoSolicitado` varchar(100) NOT NULL,
`Comentario` longblob NULL,
`Puntos` int NULL,
PRIMARY KEY (`IdSolicitud`) 
)
AUTO_INCREMENT = 1;

CREATE TABLE `Usuario` (
`IdUsuario` int NOT NULL AUTO_INCREMENT,
`FechaRegistro` date NOT NULL,
`Nombre` varchar(50) NOT NULL,
`Apellido` varchar(50) NOT NULL,
`Alias` varchar(50) NOT NULL,
`Contraseña` varchar(50) NOT NULL,
PRIMARY KEY (`IdUsuario`) 
)
AUTO_INCREMENT = 1;


ALTER TABLE `Categoria` ADD CONSTRAINT `FK_Categoria_Materia` FOREIGN KEY (`IdMateria`) REFERENCES `Materia` (`IdMateria`) ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE `Categoria` ADD CONSTRAINT `FK_Categoria_Periodo` FOREIGN KEY (`IdPeriodo`) REFERENCES `Periodo` (`IdPeriodo`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE `Comentario` ADD CONSTRAINT `FK_Comentario_Recurso` FOREIGN KEY (`IdRecurso`) REFERENCES `Recurso` (`IdRecurso`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE `Comentario` ADD CONSTRAINT `FK_Comentario_Usuario` FOREIGN KEY (`IdUsuario`) REFERENCES `Usuario` (`IdUsuario`) ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE `Materia` ADD CONSTRAINT `FK_Materia_Carrera` FOREIGN KEY (`IdCarrera`) REFERENCES `Carrera` (`IdCarrera`) ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE `Recurso` ADD CONSTRAINT `FK_Recurso_Categoria` FOREIGN KEY (`IdCategoría`) REFERENCES `Categoria` (`IdCategoria`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `Recurso` ADD CONSTRAINT `FK_Recurso_SolicitudRecurso` FOREIGN KEY (`IdSolicitud`) REFERENCES `SolicitudRecurso` (`IdSolicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE `Recurso` ADD CONSTRAINT `FK_Recurso_Usuario` FOREIGN KEY (`IdUsuario`) REFERENCES `Usuario` (`IdUsuario`) ON DELETE CASCADE ON UPDATE NO ACTION;

