package com.digitalinnovation.heroesapi.document;

import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName="Heroes_Table_Demo")
public class Heroes {
	
	@Id
    @DynamoDBHashKey(attributeName="id")
    @DynamoDBAttribute(attributeName="id")
	private String id;
	@DynamoDBAttribute(attributeName="name")
	private String name;
	@DynamoDBAttribute(attributeName="universe")
	private String universe;
	@DynamoDBAttribute(attributeName="films")
	private int films;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniverse() {
		return universe;
	}
	public void setUniverse(String universe) {
		this.universe = universe;
	}
	public int getFilms() {
		return films;
	}
	public void setFilms(int films) {
		this.films = films;
	}
	
	public Heroes(String id,String name,String universe, int films) {
		this.id=id;
		this.name=name;
		this.universe=universe;
		this.films=films;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Heroes other = (Heroes) obj;
		if (films != other.films)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (universe == null) {
			if (other.universe != null)
				return false;
		} else if (!universe.equals(other.universe))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + films;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((universe == null) ? 0 : universe.hashCode());
		return result;
	}
	

}
