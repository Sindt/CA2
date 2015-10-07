CREATE TABLE CITYINFO(
id BIGINT primary key AUTO_INCREMENT,
ZIP VARCHAR(255),
CITY VARCHAR(255)
);


CREATE TABLE ADDRESS(
id BIGINT primary key AUTO_INCREMENT,
STREET VARCHAR(255),
ADDITIONALinfo VARCHAR(255),
CITYINFO_Id BIGINT,
foreign key (CITYINFO_ID) references CITYINFO(id) 
);

CREATE TABLE Person (
id BIGINT primary key AUTO_INCREMENT,
email VARCHAR(255),
firstname VARCHAR(255),
lastname VARCHAR(255),
address_id BIGINT,
foreign key (address_id) references ADDRESS(id)
);

CREATE TABLE COMPANY(
id BIGINT primary key AUTO_INCREMENT,
email VARCHAR(255),
name VARCHAR(225),
description VARCHAR(255),
cvr VARCHAR(255),
numemployees BIGINT,
marketvalue BIGINT,
address_id BIGINT,
foreign key (address_id) references ADDRESS(id)
);