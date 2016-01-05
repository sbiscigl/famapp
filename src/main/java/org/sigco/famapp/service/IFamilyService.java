package org.sigco.famapp.service;

import java.util.List;

import org.sigco.famapp.dto.FamilyDto;
import org.sigco.famapp.exception.ConflictException;
import org.sigco.famapp.exception.NotFoundException;

public interface IFamilyService {
	FamilyDto create(FamilyDto familyDto) throws ConflictException;

	FamilyDto findOneById(int id) throws NotFoundException;

	List<FamilyDto> findAll();

	FamilyDto update(FamilyDto familyDto) throws NotFoundException;

	void delete(FamilyDto familyDto) throws NotFoundException;

	FamilyDto findFamilyByFamilyname(String familyName);

	boolean isFamiliyPresent(String familyName);

	void updateFamilyMembers(int id, int personId);
}
