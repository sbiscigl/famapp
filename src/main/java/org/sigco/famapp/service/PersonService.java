package org.sigco.famapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.common.collect.Lists;
import org.sigco.famapp.dto.FamilyDto;
import org.sigco.famapp.dto.PersonDto;
import org.sigco.famapp.exception.ConflictException;
import org.sigco.famapp.exception.NotFoundException;
import org.sigco.famapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService{
	@Autowired
	private PersonRepository PersonRepository;

	@Autowired
	private FamilyService familyService;

	@Override
	public PersonDto findOneById(UUID id) throws NotFoundException {
		if (PersonRepository.findOneById(id) == null) {
			throw new NotFoundException("No person with id found");
		} else {
			return PersonRepository.findOneById(id);
		}
	}

	@Override
	public PersonDto create(PersonDto personDto) throws ConflictException, NotFoundException {
		PersonDto createdDto = PersonRepository.save(personDto);
		try {
            familyService.isFamiliyPresent(createdDto.getLastName());
            UUID familyId = familyService.findFamilyByFamilyname(createdDto.getLastName()).getId();
			familyService.updateFamilyMembers(familyId, createdDto.getId());
        } catch (NotFoundException e) {
            List<UUID> members = new ArrayList<>();
			members.add(createdDto.getId());
			familyService.create(new FamilyDto(createdDto.getLastName(), members));
        }
		return createdDto;
	}

	@Override
	public PersonDto update(PersonDto PersonDto) throws NotFoundException {
		if (PersonRepository.findOneById(PersonDto.getId()) == null) {
			throw new NotFoundException("Family does not exist");
		} else {
			return PersonRepository.save(PersonDto);
		}
	}

	@Override
	public void delete(PersonDto PersonDto) throws NotFoundException {
		if (PersonRepository.findOneById(PersonDto.getId()) == null) {
			throw new NotFoundException("Family does not exist");
		} else {
			PersonRepository.delete(PersonDto);
		}
	}

	@Override
	public List<PersonDto> findAll() {
		return Lists.newArrayList(PersonRepository.findAll());
	}
}
