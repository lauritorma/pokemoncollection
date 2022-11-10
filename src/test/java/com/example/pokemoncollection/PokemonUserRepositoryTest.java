package com.example.pokemoncollection;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.pokemoncollection.domain.User;
import com.example.pokemoncollection.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PokemonUserRepositoryTest {

	@Autowired
	 private UserRepository repository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User user = repository.findByUsername("Testaaja");
		assertThat(user.getRole()).isEqualTo("USER");
	}
	
	@Test
	public void createNewUser() {
		//testuser hashed password= tunnussana
		User user = new User("Vieras", "$2a$12$hegGs8pQnzvLwvQqYXqfEeeMWJNO3KKrKqGK6WCQy9StaLah6KQ82","USER");
		repository.save(user);
		assertThat(user.getUserid()).isNotNull();
	}
	
	@Test
	public void DeleteUser() {
		User user = repository.findByUsername("User");
		repository.delete(user);
		User newUser = repository.findByUsername("User");
		assertThat(newUser).isEqualTo(null);
		
		
	}
}
