package org.sigco.famapp.repository;

import org.sigco.famapp.dto.FamilyDto;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends CassandraRepository<FamilyDto> {

	@Query("SELECT * FROM familydto WHERE id=?0")
	FamilyDto findOneById(int id);

	@Query("SELECT * FROM familydto WHERE familyname=?0")
	FamilyDto getFamilyByName(String familyName);

	@Query("INSERT INTO family (id, family_name)" +
			"VALUES (?0,?1)")
	void updateFamilyMembers(int id, String familyName);
}
