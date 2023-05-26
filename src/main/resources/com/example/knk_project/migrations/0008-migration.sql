use notimi;

CREATE VIEW combined_view AS
SELECT id,username, emri, mbiemri, 'nxenes' AS roli
FROM nxenesit

UNION ALL

SELECT id,username, emri, mbiemri, 'profesor' AS roli
FROM profesoret;