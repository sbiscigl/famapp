package org.sigco.famapp.service;

import java.util.List;
import java.util.UUID;

import org.sigco.famapp.dto.FamilyDto;
import org.sigco.famapp.exception.ConflictException;
import org.sigco.famapp.exception.NotFoundException;

public interface IFamilyService {
	FamilyDto create(FamilyDto familyDto) throws ConflictException;

	FamilyDto findOneById(UUID id) throws NotFoundException;

	List<FamilyDto> findAll();

	FamilyDto update(FamilyDto familyDto) throws NotFoundException;

	void delete(FamilyDto familyDto) throws NotFoundException;

	FamilyDto findFamilyByFamilyname(String familyName);

	FamilyDto findByFamilyName(String familyName);

	boolean isFamiliyPresent(String familyName);

	void updateFamilyMembers(UUID id, UUID personId);
}
