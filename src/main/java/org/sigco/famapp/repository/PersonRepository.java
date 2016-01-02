package org.sigco.famapp.repository;

import org.sigco.famapp.dto.PersonDto;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CassandraRepository<PersonDto>{

	@Query("SELECT * FROM persondto WHERE id=?0")
	PersonDto findOneById(int id);
}
