package org.sigco.famapp.dto;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Data
@EqualsAndHashCode
@Table
public class PersonDto {
	@PrimaryKey
	private UUID id;

	private String firstName;
	private String lastName;

	public PersonDto() {
		this.id = UUID.randomUUID();
	}

	public PersonDto(String firstName, String lastName) {
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public PersonDto(UUID id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
