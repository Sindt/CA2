INSERT INTO CITYINFO (ZIP, CITY) VALUES ('2600', 'Glostrup');
INSERT INTO CITYINFO (ZIP, CITY) VALUES ('2500', 'Valby');

INSERT INTO address (STREET, ADDITIONALinfo, CITYINFO_ID)  values('vej 1','bla bla',1);
INSERT INTO address (STREET, ADDITIONALinfo, CITYINFO_ID)  values('vejnavn 2','blaaa bla',2);

INSERT INTO company (email,name,description,cvr,numemployees,marketvalue,address_id) values('mail@mail.dk', 'test', 'teste','tester',1,1234,1);
INSERT INTO company (email,name,description,cvr,numemployees,marketvalue,address_id) values('minemail@mail.dk', 'APPLE', 'teste','tester',1,2234,2);

INSERT INTO person (email, firstname, lastname, address_id) values('email@mail.dk','bob','jensen',1);
INSERT INTO person (email, firstname, lastname, address_id) values('jh@mail.dk','Jens','Hansen',2);