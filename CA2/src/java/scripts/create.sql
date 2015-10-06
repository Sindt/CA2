CREATE TABLE INFO(
id BIGINT primary key,
email VARCHAR(255)
);

CREATE TABLE Person (
id BIGINT primary key,
email VARCHAR(255),
firstname VARCHAR(255),
lastname VARCHAR(255)
);

CREATE TABLE COMPANY(
id BIGINT primary key,
email VARCHAR(255),
company_name VARCHAR(225),
description VARCHAR(255),
cvr VARCHAR(255),
numemployees BIGINT,
marketvalue VARCHAR(255)
);
CREATE TABLE ADDRESS(
id BIGINT primary key,
STREET VARCHAR(255),
ADDITIONALinfo VARCHAR(255)
);

