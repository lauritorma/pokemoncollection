package com.example.pokemoncollection.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Type {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long typeid;
	private String typeName;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
	private List<Pokemon> pokemons;
	
	public Type() {}
	
	
	public Long getTypeid() {
		return typeid;
	}


	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}
	
	public Type(String typeName) {
		super();
		this.typeName = typeName;
	}

	

	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}


	@Override
	public String toString() {
		return "Type [typeid=" + typeid + ", typeName=" + typeName + "]";
	}
	


}
