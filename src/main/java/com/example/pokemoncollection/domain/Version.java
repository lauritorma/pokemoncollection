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
public class Version {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long versionId;
	private String versionName;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "version")
	private List<Pokemon> pokemons;
	
	public Version() {}

	public Long getVersionId() {
		return versionId;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
	
	public Version(String versionName) {
		super();
		this.versionName = versionName;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	
}
