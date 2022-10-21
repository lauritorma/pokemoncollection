package com.example.pokemoncollection.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class Pokemon {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String pokemonName, hp, setName, version;
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	private Type type;
	
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Pokemon() {}
	
	public Pokemon(String pokemonName, String hp, String setName, String version) {
		super();
		this.pokemonName = pokemonName;
		this.hp = hp;
		this.setName = setName;
		this.version = version;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPokemonName() {
		return pokemonName;
	}

	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}

	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
