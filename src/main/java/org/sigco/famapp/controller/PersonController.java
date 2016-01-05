package org.sigco.famapp.controller;

import java.util.List;
import java.util.UUID;

import org.sigco.famapp.dto.PersonDto;
import org.sigco.famapp.exception.ConflictException;
import org.sigco.famapp.exception.NotFoundException;
import org.sigco.famapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/people")
public class PersonController {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public PersonDto create(
			@RequestBody PersonDto userDto) throws ConflictException, NotFoundException {
		return  personService.create(userDto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public PersonDto findById(
			@PathVariable(value = "id") UUID id) throws NotFoundException {
		return personService.findOneById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<PersonDto> findAll() {
		return personService.findAll();
	}
}
