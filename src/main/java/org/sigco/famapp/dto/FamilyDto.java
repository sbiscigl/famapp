package org.sigco.famapp.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Data
@EqualsAndHashCode
@Table
public class FamilyDto implements IFamilyDto{
	@PrimaryKey
	private UUID id;

	private String familyName;
	protected List<UUID> members;

	public FamilyDto() {id = UUID.randomUUID();}

	public FamilyDto(String familyName, List<UUID> members) {
		this.id = UUID.randomUUID();
		this.familyName = familyName;
		this.members = members;
	}

	public FamilyDto(UUID id, String familyName, List<UUID> members) {
		this.id = id;
		this.familyName = familyName;
		this.members = members;
	}
}
