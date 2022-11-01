package com.example.pokemoncollection.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="`usertable`")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false, updatable = false)
    private Long userid;
	
	 @Column(name="username",nullable=false,unique=true)
	 private String username;
	 
	 @Column(name="password",nullable=false)
	 private String passwordHash;
	 
	 @Column(name="role",nullable=false)
	 private String role;
	 
	 @JsonIgnore
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
		private List<Pokemon> pokemons;
	 
	 public User() {
	    }

		public User(String username, String passwordHash, String role) {
			super();
			this.username = username;
			this.passwordHash = passwordHash;
			this.role = role;
		}

		public List<Pokemon> getPokemons() {
			return pokemons;
		}

		public void setPokemons(List<Pokemon> pokemons) {
			this.pokemons = pokemons;
		}

		public Long getUserid() {
			return userid;
		}

		public void setUserid(Long userid) {
			this.userid = userid;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPasswordHash() {
			return passwordHash;
		}

		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}


		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
}
