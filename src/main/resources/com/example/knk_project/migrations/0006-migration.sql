use notimi;

ALTER TABLE nxenesit RENAME COLUMN date_e_lindjes TO data_e_lindjes;
ALTER TABLE nxenesit RENAME COLUMN userid TO username;    
ALTER TABLE profesoret RENAME COLUMN userid TO username;
ALTER TABLE admin RENAME COLUMN userid TO username;
