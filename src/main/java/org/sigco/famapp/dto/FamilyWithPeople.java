package org.sigco.famapp.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class FamilyWithPeople implements IFamilyDto {
	private UUID id;

	private String familyName;
	protected List<PersonDto> members;

	public FamilyWithPeople() {id = UUID.randomUUID();}

	public FamilyWithPeople(String familyName, List<PersonDto> members) {
		this.id = UUID.randomUUID();
		this.familyName = familyName;
		this.members = members;
	}

	public FamilyWithPeople(UUID id, String familyName, List<PersonDto> members) {
		this.id = id;
		this.familyName = familyName;
		this.members = members;
	}

}
