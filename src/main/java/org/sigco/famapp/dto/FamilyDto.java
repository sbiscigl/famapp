package org.sigco.famapp.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sigco.famapp.util.IdGenerator;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Data
@EqualsAndHashCode
@Table
public class FamilyDto {
	@PrimaryKey
	private int id;

	private String familyName;
	private List<Integer> members;

	public FamilyDto() {id = IdGenerator.generateId();}

	public FamilyDto(String familyName, List<Integer> members) {
		this.id = IdGenerator.generateId();
		this.familyName = familyName;
		this.members = members;
	}

	public FamilyDto(int id, String familyName, List<Integer> members) {
		this.id = id;
		this.familyName = familyName;
		this.members = members;
	}
}
