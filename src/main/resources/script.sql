-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pedidos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pedidos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pedidos` DEFAULT CHARACTER SET utf8 ;
USE `pedidos` ;

-- -----------------------------------------------------
-- Table `pedidos`.`comprador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos`.`comprador` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NULL,
  `idade` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pedidos`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos`.`pedido` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `comprador` BIGINT NULL,
  `data` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pedido_comprador_idx` (`comprador` ASC) VISIBLE,
  CONSTRAINT `fk_pedido_comprador`
    FOREIGN KEY (`comprador`)
    REFERENCES `pedidos`.`comprador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pedidos`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos`.`estado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pedidos`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos`.`cidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `estado` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `estado_idx` (`estado` ASC) VISIBLE,
  CONSTRAINT `fk_cidade_estado`
    FOREIGN KEY (`estado`)
    REFERENCES `pedidos`.`estado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pedidos`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(45) NULL,
  `cep` VARCHAR(45) NULL,
  `numero` INT NULL,
  `cidade` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `cidade_idx` (`cidade` ASC) VISIBLE,
  CONSTRAINT `fk_endereco_cidade`
    FOREIGN KEY (`cidade`)
    REFERENCES `pedidos`.`cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pedidos`.`comprador_endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos`.`comprador_endereco` (
  `comprador` BIGINT NOT NULL,
  `endereco` INT NOT NULL,
  PRIMARY KEY (`comprador`, `endereco`),
  INDEX `endereco_idx` (`endereco` ASC) VISIBLE,
  CONSTRAINT `fk_comprador`
    FOREIGN KEY (`comprador`)
    REFERENCES `pedidos`.`comprador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco`
    FOREIGN KEY (`endereco`)
    REFERENCES `pedidos`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pedidos`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  `valor` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pedidos`.`pedido_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pedidos`.`pedido_item` (
  `pedido` BIGINT NOT NULL,
  `item` INT NOT NULL,
  PRIMARY KEY (`pedido`, `item`),
  INDEX `fk_pedido_has_item_item1_idx` (`item` ASC) VISIBLE,
  INDEX `fk_pedido_has_item_pedido1_idx` (`pedido` ASC) VISIBLE,
  CONSTRAINT `fk_pedido`
    FOREIGN KEY (`pedido`)
    REFERENCES `pedidos`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item`
    FOREIGN KEY (`item`)
    REFERENCES `pedidos`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
