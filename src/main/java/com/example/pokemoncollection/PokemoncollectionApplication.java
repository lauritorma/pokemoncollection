package com.example.pokemoncollection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pokemoncollection.domain.Pokemon;
import com.example.pokemoncollection.domain.PokemonRepository;

@SpringBootApplication
public class PokemoncollectionApplication {
	private static final Logger log = LoggerFactory.getLogger(PokemoncollectionApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PokemoncollectionApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PokemonRepository repository) {return (args) -> {
		
		log.info("saving some demo pokemons to in-memory");
		repository.save(new Pokemon("Empoleon","130","Diamond & Pearl","Holo"));
		repository.save(new Pokemon("Metagross ex", "150", "EX Power keepers", "Standard"));
		repository.save(new Pokemon("Rhyperior", "140", "Diamond & Pearl", "Holo"));
		
	};
	}

}
