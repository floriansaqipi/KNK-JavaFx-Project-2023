use notimi;

CREATE VIEW users AS
SELECT id,username, emri, mbiemri, 'nxenes' AS roli
FROM nxenesit

UNION ALL

SELECT id,username, emri, mbiemri, 'profesor' AS roli
FROM profesoret;


