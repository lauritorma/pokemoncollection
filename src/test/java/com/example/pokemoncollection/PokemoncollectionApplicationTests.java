package com.example.pokemoncollection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.pokemoncollection.web.PokemonController;
import com.example.pokemoncollection.web.TypeController;
import com.example.pokemoncollection.web.UserController;
import com.example.pokemoncollection.web.VersionController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PokemoncollectionApplicationTests {


	@Autowired
	private PokemonController controller;
	
	@Autowired 
	private UserController ucontroller;
	
	@Autowired
	private TypeController tcontroller;
	
	@Autowired
	private VersionController vcontroller;
	
	@Test
	 public void contextLoadsPokemonController() throws Exception {
	 assertThat(controller).isNotNull();
	 }
	
	@Test
	 public void contextLoadsUserController() throws Exception {
	 assertThat(ucontroller).isNotNull();
	 }
	@Test
	 public void contextLoadsTypeController() throws Exception {
	 assertThat(tcontroller).isNotNull();
	 }
	@Test
	 public void contextLoadsVersionController() throws Exception {
	 assertThat(vcontroller).isNotNull();
	 }
}