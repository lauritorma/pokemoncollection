package com.example.pokemoncollection.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;




@Entity
public class Pokemon {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Cannot be empty")
	@Pattern(regexp="(^[a-öA-ö ]+$)", message = "Cannot contain numbers")
	private String pokemonName, setName;
	
	@Digits(integer=3, fraction=0)
	@Min(value = 1, message="Cannot be lower than 1")
	private int hp;
	
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
	
	public Pokemon(String pokemonName, Type type, int hp, String setName, Version version) {
		super();
		this.pokemonName = pokemonName;
		this.type = type;
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
	

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
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
				+ this.getType() + ", version=" + this.getVersion() + ", user=" + this.getUser() +"]";
	}

	

}
