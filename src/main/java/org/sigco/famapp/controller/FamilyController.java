package org.sigco.famapp.controller;

import java.util.List;

import org.sigco.famapp.dto.FamilyDto;
import org.sigco.famapp.exception.ConflictException;
import org.sigco.famapp.exception.NotFoundException;
import org.sigco.famapp.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sbisciglia on 12/30/15.
 */
public class FamilyController {
	@Autowired
	FamilyService familySerivce;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public FamilyDto create(@RequestBody FamilyDto familyDto) throws ConflictException {
		return familySerivce.create(familyDto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public FamilyDto findById( @PathVariable(value = "id") int id) throws NotFoundException {
		return familySerivce.findOneById(id);
	}

	/*TODO: Impliment this*/
//	@RequestMapping(value = "", method = RequestMethod.GET, params = {"familyName"})
//	public FamilyDto findByFamilyName( @RequestParam(value = "familyName") String familyName) throws NotFoundException {
//		return familySerivce.findByFamilyName(familyName).get();
//	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<FamilyDto> findAll() {
		return familySerivce.findAll();
	}
}
