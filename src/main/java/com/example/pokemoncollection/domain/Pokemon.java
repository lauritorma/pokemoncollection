package com.example.pokemoncollection.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;



@Entity
public class Pokemon {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Cannot be blank")
	private String pokemonName;
	@NotBlank(message = "Cannot be blank")
	private String hp;
	@NotBlank(message = "Cannot be blank")
	private String setName;
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	@ManyToOne
	@JoinColumn(name = "versionId")
	private Version version;


	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pokemon() {}
	
	public Pokemon(String pokemonName, String hp, String setName) {
		super();
		this.pokemonName = pokemonName;
		this.hp = hp;
		this.setName = setName;
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

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", pokemonName=" + pokemonName + ", hp=" + hp + ", setName=" + setName + ", type="
				+ type + ", version=" + version + "]";
	}

	

}
