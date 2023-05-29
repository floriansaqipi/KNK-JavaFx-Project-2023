use notimi;

CREATE VIEW nxenesi_dashboard AS
SELECT nx.id, n.vlera,n.rubrika,n.gjysmevjetori,l.emri,p.username
FROM nxenesit nx
INNER JOIN notat n ON nx.id = n.nxenesi_id
INNER JOIN lendet l ON n.lenda_id = l.id
INNER JOIN profesoret_lendet pl ON pl.lenda_id = l.id
INNER JOIN profesoret p ON p.id = pl.profesori_id;