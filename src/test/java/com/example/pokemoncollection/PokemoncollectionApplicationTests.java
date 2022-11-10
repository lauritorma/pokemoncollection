package com.example.pokemoncollection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.pokemoncollection.web.PokemonController;
import com.example.pokemoncollection.web.UserController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PokemoncollectionApplicationTests {


	@Autowired
	private PokemonController controller;
	
	@Autowired 
	private UserController ucontroller;
	
	@Test
	 public void contextLoadsPokemonController() throws Exception {
	 assertThat(controller).isNotNull();
	 }
	
	@Test
	 public void contextLoadsUserController() throws Exception {
	 assertThat(ucontroller).isNotNull();
	 }
}
