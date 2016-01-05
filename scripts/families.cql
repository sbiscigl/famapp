--Create and use keyspace
DROP KEYSPACE IF EXISTS families;
CREATE KEYSPACE families
WITH replication = {'class':'SimpleStrategy','replication_factor':2};
--CONSISTENCY QUORUM;
USE families;

--Create people table
CREATE TABLE persondto (
    id uuid primary key,
    firstname varchar,
    lastname varchar,
) WITH comment = 'A table of people';

--Create family table
CREATE TABLE familydto (
    id uuid,
    familyname varchar,
    members list<uuid>,
    primary key (id)
) WITH comment = 'A table of families';
CREATE INDEX family_name_index ON familydto (familyname);