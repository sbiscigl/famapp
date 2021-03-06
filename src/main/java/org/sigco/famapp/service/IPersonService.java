package org.sigco.famapp.service;

import java.util.List;
import java.util.UUID;

import org.sigco.famapp.dto.PersonDto;
import org.sigco.famapp.exception.ConflictException;
import org.sigco.famapp.exception.NotFoundException;

public interface IPersonService {
	PersonDto create(PersonDto userDto) throws ConflictException, NotFoundException;

	PersonDto findOneById(UUID id) throws NotFoundException;

	List<PersonDto> findAll();

	PersonDto update(PersonDto userDto) throws NotFoundException;

	void delete(PersonDto userDto) throws NotFoundException;
}
