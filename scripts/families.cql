--Create and use keyspace
DROP KEYSPACE IF EXISTS families;
CREATE KEYSPACE families
WITH replication = {'class':'SimpleStrategy','replication_factor':2};
--CONSISTENCY QUORUM;
USE families;

--Create courses table
CREATE TABLE persondto (
    id int primary key,
    firstname varchar,
    lastname varchar,
) WITH comment = 'A table of people';