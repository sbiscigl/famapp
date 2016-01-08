package org.sigco.famapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.common.collect.Lists;
import org.sigco.famapp.dto.FamilyDto;
import org.sigco.famapp.dto.FamilyWithPeople;
import org.sigco.famapp.dto.IFamilyDto;
import org.sigco.famapp.dto.PersonDto;
import org.sigco.famapp.exception.ConflictException;
import org.sigco.famapp.exception.NotFoundException;
import org.sigco.famapp.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyService implements IFamilyService {
	@Autowired
	private FamilyRepository familyRepository;

	@Autowired
	private PersonService personService;

	@Override
	public FamilyDto findOneById(UUID id) throws NotFoundException {
		if (familyRepository.findOneById(id) == null) {
			throw new NotFoundException("No family with id found");
		} else {
			return familyRepository.findOneById(id);
		}
	}

	@Override
	public FamilyDto create(FamilyDto familyDto) throws ConflictException {
		if (familyRepository.findOneById(familyDto.getId()) != null) {
			throw new ConflictException("Family already exists");
		} else {
			return familyRepository.save(familyDto);
		}
	}

	@Override
	public FamilyDto update(FamilyDto familyDto) throws NotFoundException {
		if (familyRepository.findOneById(familyDto.getId()) == null) {
			throw new NotFoundException("Family does not exist");
		} else {
			return familyRepository.save(familyDto);
		}
	}

	@Override
	public void delete(FamilyDto familyDto) throws NotFoundException {
		if (familyRepository.findOneById(familyDto.getId()) == null) {
			throw new NotFoundException("Family does not exist");
		} else {
			familyRepository.delete(familyDto);
		}
	}

	@Override
	public List<FamilyDto> findAll() {
		return Lists.newArrayList(familyRepository.findAll());
	}

	@Override
	public FamilyDto findFamilyByFamilyname (String familyName) {
		return familyRepository.getFamilyByName(familyName);
	}

	@Override
	public boolean isFamiliyPresent(String familyName) {
		return findFamilyByFamilyname(familyName) == null;
	}

	@Override
	public IFamilyDto findByFamilyName(String familyName, boolean returnMembers) throws NotFoundException {
		if (!returnMembers) {
			return findFamilyByFamilyname(familyName);
		} else {
			FamilyDto familyDto = findFamilyByFamilyname(familyName);
			List<UUID> peopleIds = familyDto.getMembers();
			List<PersonDto> people = new ArrayList<>();
			for (UUID id: peopleIds) {
				people.add(personService.findOneById(id));
			}
			return new FamilyWithPeople(familyDto.getId(), familyDto.getFamilyName(), people);
		}
	}

	@Override
	public void updateFamilyMembers(UUID id, UUID personId) {
		FamilyDto familyDto = familyRepository.findOneById(id);
		List<UUID> members = new ArrayList<>();
		for (UUID i : familyDto.getMembers()) {
			members.add(i);
		}
		members.add(personId);
		familyDto.setMembers(members);
		familyRepository.save(familyDto);
	}
}
