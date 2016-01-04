--Create and use keyspace
DROP KEYSPACE IF EXISTS families;
CREATE KEYSPACE families
WITH replication = {'class':'SimpleStrategy','replication_factor':2};
--CONSISTENCY QUORUM;
USE families;

--Create people table
CREATE TABLE persondto (
    id int primary key,
    firstname varchar,
    lastname varchar,
) WITH comment = 'A table of people';

--Create family table
CREATE TABLE familydto (
    id int,
    familyname varchar,
    members list<int>,
    primary key (id)
) WITH comment = 'A table of families';
CREATE INDEX family_name_index ON familydto (familyname);