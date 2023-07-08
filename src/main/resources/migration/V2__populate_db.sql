INSERT INTO client (name)
VALUES ('Jon Jones'),
    ('Deiveson Figueiredo'),
    ('Merab Dvalishvili'),
    ('Yair Rodriguez'),
    ('Charles Oliveira'),
    ('Kamaru Usman'),
    ('Alex Pereira'),
    ('Israel Adesanya'),
    ('Conor McGregor'),
    ('Michel Pereira');

INSERT INTO planet (id, name)
VALUES ('MRCR','Mercury'),
    ('EARTH','Earth'),
    ('MRS','Mars'),
    ('JPTR','Jupiter'),
    ('STRN','Saturn');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id)
SELECT CURRENT_TIMESTAMP AS created_at, c.id AS client_id, pf.id AS from_planet_id, pt.id AS to_planet_id
FROM  Client c, Planet pf, Planet pt WHERE pf.id != pt.id
ORDER BY RAND()
LIMIT 10;


--SELECT created_at, client_id, from_planet_id, to_planet_id FROM ticket

--TRUNCATE TABLE ticket
