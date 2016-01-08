package org.sigco.famapp.controller;

import java.util.List;
import java.util.UUID;

import org.sigco.famapp.dto.FamilyDto;
import org.sigco.famapp.dto.IFamilyDto;
import org.sigco.famapp.exception.ConflictException;
import org.sigco.famapp.exception.NotFoundException;
import org.sigco.famapp.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/families")
public class FamilyController {
	@Autowired
	FamilyService familySerivce;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public FamilyDto create(@RequestBody FamilyDto familyDto) throws ConflictException {
		return familySerivce.create(familyDto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public FamilyDto findById( @PathVariable(value = "id") UUID id) throws NotFoundException {
		return familySerivce.findOneById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, params = {"familyName"})
	public IFamilyDto findByFamilyName(
			@RequestParam(value = "familyName") String familyName,
			@RequestParam(value = "returnMembers", required = false, defaultValue = "false")boolean returnMembers)
			throws NotFoundException {
		return familySerivce.findByFamilyName(familyName, returnMembers);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<FamilyDto> findAll() {
		return familySerivce.findAll();
	}
}
