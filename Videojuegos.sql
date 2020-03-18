CREATE DATABASE videojuegosdb;

USE videojuegosdb;

CREATE TABLE `videojuegosdb`.`tbl_juegos` (
  `id_juego` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NULL,
  `plataforma` VARCHAR(45) NULL,
  `multijugador` VARCHAR(3) NOT NULL DEFAULT 'No',
  PRIMARY KEY (`id_juego`));
  
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('World of Warcraft', 'MMORPG', 'PC', 'Sí');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('God of War', 'Aventuras', 'PS4', 'No');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Gears of War', 'Shooter', 'XBOX', 'Sí');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('StarCraf 2', 'Estrategia', 'PC', 'Sí');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('BloodBorne', 'Aventuras', 'PS4', 'No');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Forza Horizon 4', 'Motor', 'XBOX', 'Sí');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Escape From Tarkov', 'Shooter', 'PC', 'Sí');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Final Fantasy 15', 'Rol', 'PS4', 'No');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Halo Reach', 'Shooter', 'XBOX', 'Sí');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Baldurs Gate 2', 'Rol', 'PC', 'No');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Gran Turismo 5', 'Motor', 'PS4', 'Sí');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Ori and the Blind Forest', 'Rol', 'XBOX', 'No');

