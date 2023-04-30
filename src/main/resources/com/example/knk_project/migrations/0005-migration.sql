USE notimi;

ALTER TABLE nxenesit ADD COLUMN userid varchar(100) NOT NULL UNIQUE AFTER id,  
ADD COLUMN salt varchar(256) NOT NULL AFTER userid,
ADD COLUMN salted_password varchar(256) NOT NULL AFTER salt;

ALTER TABLE profesoret ADD COLUMN userid varchar(100) NOT NULL UNIQUE AFTER id,  
ADD COLUMN salt varchar(256) NOT NULL AFTER userid,
ADD COLUMN salted_password varchar(256) NOT NULL AFTER salt;

CREATE TABLE IF NOT EXISTS klasat (
  id INT NOT NULL AUTO_INCREMENT,
  klasa INT NOT NULL,
  paralelja INT NOT NULL,
  viti YEAR NOT NULL,
  PRIMARY KEY (id));
  
ALTER TABLE nxenesit ADD COLUMN klasa_id INT NOT NULL AFTER prindi_id;


ALTER TABLE nxenesit ADD CONSTRAINT fk_nxenesit_klasat1
FOREIGN KEY (klasa_id)
REFERENCES klasat (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

CREATE TABLE IF NOT EXISTS profesoret_klasat (
  profesori_id INT NOT NULL,
  klasa_id INT NOT NULL,
  PRIMARY KEY (profesori_id, klasa_id),
  INDEX fk_profesoret_has_klasat_klasat1_idx (klasa_id ASC) VISIBLE,
  INDEX fk_profesoret_has_klasat_profesoret1_idx (profesori_id ASC) VISIBLE,
  CONSTRAINT fk_profesoret_has_klasat_profesoret1
    FOREIGN KEY (profesori_id)
    REFERENCES profesoret (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_profesoret_has_klasat_klasat1
    FOREIGN KEY (klasa_id)
    REFERENCES klasat (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    CREATE TABLE IF NOT EXISTS admin (
  id INT NOT NULL AUTO_INCREMENT,
  userid VARCHAR(100) UNIQUE NOT NULL,
  salt VARCHAR(256) NOT NULL,
  salted_password VARCHAR(256) NOT NULL,
  PRIMARY KEY (id));
  
  drop table profesoret_lendet;
  
  CREATE TABLE IF NOT EXISTS profesoret_lendet (
  profesori_id INT NOT NULL,
  lenda_id INT NOT NULL,
  PRIMARY KEY (profesori_id, lenda_id),
  INDEX fk_lendet_has_profesoret_profesoret1_idx (profesori_id ASC) VISIBLE,
  INDEX fk_lendet_has_profesoret_lendet_idx (lenda_id ASC) VISIBLE,
  CONSTRAINT fk_lendet_has_profesoret_lendet
    FOREIGN KEY (lenda_id)
    REFERENCES lendet (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_lendet_has_profesoret_profesoret1
    FOREIGN KEY (profesori_id)
    REFERENCES profesoret (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;
