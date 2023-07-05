USE notimi;

ALTER TABLE nxenesit ADD CONSTRAINT pk_nxenesit PRIMARY KEY (id);
ALTER TABLE nxenesit RENAME COLUMN prind_id TO prindi_id;
ALTER TABLE nxenesit ADD CONSTRAINT unique_prind_id UNIQUE (prindi_id);


CREATE TABLE IF NOT EXISTS lendet (
  id INT NOT NULL,
  emri VARCHAR(50) NOT NULL,
  PRIMARY KEY (id));



CREATE TABLE IF NOT EXISTS profesoret (
  id INT NOT NULL,
  emri VARCHAR(50) NOT NULL,
  mbiemri VARCHAR(50) NOT NULL,
  titulli VARCHAR(50) NOT NULL,
  PRIMARY KEY (id))
;

CREATE TABLE IF NOT EXISTS profesoret_lendet (
  lenda_id INT NOT NULL,
  profesori_id INT NOT NULL,
  PRIMARY KEY (lenda_id, profesori_id),
  INDEX fk_lendet_has_profesoret_profesoret1_idx (profesori_id ASC) VISIBLE,
  INDEX fk_lendet_has_profesoret_lendet_idx (lenda_id ASC) VISIBLE,
  CONSTRAINT fk_lendet_has_profesoret_lendet
    FOREIGN KEY (lenda_id)
    REFERENCES lendet (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_lendet_has_profesoret_profesoret1
    FOREIGN KEY (profesori_id)
    REFERENCES profesoret (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;

CREATE TABLE IF NOT EXISTS notat (
  id INT NOT NULL,
  vlera INT NOT NULL,
  rubrika INT NOT NULL,
  gjysmevjetori INT NOT NULL,
  profesori_id INT ,
  lenda_id INT ,
  nxenesi_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_notat_profesoret1_idx (profesori_id ASC) VISIBLE,
  INDEX fk_notat_lendet1_idx (lenda_id ASC) VISIBLE,
  INDEX fk_notat_nxenesit1_idx (nxenesi_id ASC) VISIBLE,
  CONSTRAINT fk_notat_profesoret1
    FOREIGN KEY (profesori_id)
    REFERENCES profesoret (id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT fk_notat_lendet1
    FOREIGN KEY (lenda_id)
    REFERENCES lendet (id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT fk_notat_nxenesit1
    FOREIGN KEY (nxenesi_id)
    REFERENCES nxenesit (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;
