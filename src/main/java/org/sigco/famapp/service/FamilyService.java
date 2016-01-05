package org.sigco.famapp.service;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import org.sigco.famapp.dto.FamilyDto;
import org.sigco.famapp.exception.ConflictException;
import org.sigco.famapp.exception.NotFoundException;
import org.sigco.famapp.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyService implements IFamilyService {
	@Autowired
	private FamilyRepository familyRepository;

	@Override
	public FamilyDto findOneById(int id) throws NotFoundException {
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
			return familyRepository.save(new FamilyDto(familyDto.getFamilyName(),familyDto.getMembers()));
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
	/*TODO: THIS LOGIC*/
	public void updateFamilyMembers(int id, int personId) {
		FamilyDto familyDto = familyRepository.findOneById(id);
		List<Integer> members = new ArrayList<>();
		for (int i : familyDto.getMembers()) {
			members.add(i);
		}
		members.add(personId);
		familyDto.setMembers(members);
		familyRepository.save(familyDto);
	}
}
