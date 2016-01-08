package org.sigco.famapp.service;

import java.util.List;
import java.util.UUID;

import org.sigco.famapp.dto.FamilyDto;
import org.sigco.famapp.dto.IFamilyDto;
import org.sigco.famapp.exception.ConflictException;
import org.sigco.famapp.exception.NotFoundException;

public interface IFamilyService {
	FamilyDto create(FamilyDto familyDto) throws ConflictException;

	FamilyDto findOneById(UUID id) throws NotFoundException;

	List<FamilyDto> findAll();

	FamilyDto update(FamilyDto familyDto) throws NotFoundException;

	void delete(FamilyDto familyDto) throws NotFoundException;

	IFamilyDto findFamilyByFamilyname(String familyName);

	IFamilyDto findByFamilyName(String familyName, boolean returnMembers) throws NotFoundException;

	boolean isFamiliyPresent(String familyName);

	void updateFamilyMembers(UUID id, UUID personId);
}
