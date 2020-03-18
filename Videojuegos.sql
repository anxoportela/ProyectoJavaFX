CREATE DATABASE videojuegosdb;

USE videojuegosdb;

CREATE TABLE `videojuegosdb`.`tbl_juegos` (
  `id_juego` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL,
  `genero` VARCHAR(45) NULL,
  `plataforma` VARCHAR(45) NULL,
  `multijugador` TINYINT NULL DEFAULT '0',
  PRIMARY KEY (`id_juego`),
  UNIQUE INDEX `id_juego_UNIQUE` (`id_juego` ASC) VISIBLE);

ALTER TABLE tbl_juegos ADD CONSTRAINT ck_tbl_juegos_multijugador CHECK (multijugador IN ('0', '1') );

INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('World of Warcraft', 'MMORPG', 'PC', '1');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('God of War', 'Aventuras', 'PS4', '0');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Gears of War', 'Shooter', 'XBOX', '1');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('StarCraf 2', 'Estrategia', 'PC', '1');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('BloodBorne', 'Aventuras', 'PS4', '0');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Forza Horizon 4', 'Motor', 'XBOX', '1');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Escape From Tarkov', 'Shooter', 'PC', '1');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Final Fantasy 15', 'Rol', 'PS4', '0');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Halo Reach', 'Shooter', 'XBOX', '1');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Baldurs Gate 2', 'Rol', 'PC', '0');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Gran Turismo 5', 'Motor', 'PS4', '1');
INSERT INTO `videojuegosdb`.`tbl_juegos` (`titulo`, `genero`, `plataforma`, `multijugador`) VALUES ('Ori and the Blind Forest', 'Rol', 'XBOX', '0');

