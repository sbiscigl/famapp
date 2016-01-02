package org.sigco.famapp.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.sigco.famapp.util.IdGenerator;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Data
@EqualsAndHashCode
@Table
public class PersonDto {
	@PrimaryKey
	private int id;

	private String firstName;
	private String lastName;

	public PersonDto() {
		this.id = IdGenerator.generateId();
	}

	public PersonDto(String firstName, String lastName) {
		this.id = IdGenerator.generateId();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public PersonDto(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
