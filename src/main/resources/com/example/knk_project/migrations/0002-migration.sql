
use notimi;

CREATE TABLE IF NOT EXISTS shtetet (
  id INT NOT NULL,
  emri VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS komunat (
  id INT NOT NULL,
  emri VARCHAR(45) NOT NULL,
  shteti_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_komunat_shtetet1
    FOREIGN KEY (shteti_id)
    REFERENCES shtetet (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;


CREATE TABLE IF NOT EXISTS prinderit (
  id INT NOT NULL,
  emri VARCHAR(50) NOT NULL,
  mbiemri VARCHAR(50) NOT NULL,
  profesioni VARCHAR(50) NULL,
  adresa VARCHAR(250) NOT NULL,
  numri_telefonit VARCHAR(20) NOT NULL,
  email VARCHAR(100) NULL,
  PRIMARY KEY (id))
;

CREATE TABLE IF NOT EXISTS nxenesit (
  id INT NOT NULL,
  emri VARCHAR(50) NOT NULL,
  mbiemri VARCHAR(50) NOT NULL,
  date_e_lindjes DATE NOT NULL,
  vendlindja_id INT ,
  komuna_id INT ,
  prind_id INT NOT NULL,
  CONSTRAINT fk_nxenesit_komunat
    FOREIGN KEY (vendlindja_id)
    REFERENCES komunat (id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT fk_nxenesit_komunat1
    FOREIGN KEY (komuna_id)
    REFERENCES komunat (id)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT fk_nxenesit_prinderit1
    FOREIGN KEY (prind_id)
    REFERENCES prinderit (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;


