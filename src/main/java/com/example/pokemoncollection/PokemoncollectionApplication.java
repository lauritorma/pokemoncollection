package com.example.pokemoncollection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pokemoncollection.domain.Pokemon;
//import com.example.pokemoncollection.domain.Pokemon;
import com.example.pokemoncollection.domain.PokemonRepository;
import com.example.pokemoncollection.domain.Type;
import com.example.pokemoncollection.domain.TypeRepository;
import com.example.pokemoncollection.domain.Version;
import com.example.pokemoncollection.domain.VersionRepository;

@SpringBootApplication
public class PokemoncollectionApplication {
	private static final Logger log = LoggerFactory.getLogger(PokemoncollectionApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PokemoncollectionApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PokemonRepository repository,TypeRepository trepository,VersionRepository vrepository) {return (args) -> {
		
		
		log.info("Saving Pokemon types to in-memory");
		trepository.save(new Type("Normal"));
		trepository.save(new Type("Fire"));
		trepository.save(new Type("Water"));
		trepository.save(new Type("Grass"));
		trepository.save(new Type("Electric"));
		trepository.save(new Type("Ice"));
		trepository.save(new Type("Fighting"));
		trepository.save(new Type("Poison"));
		trepository.save(new Type("Ground"));
		trepository.save(new Type("Flying"));
		trepository.save(new Type("Psychic"));
		trepository.save(new Type("Bug"));
		trepository.save(new Type("Rock"));
		trepository.save(new Type("Ghost"));
		trepository.save(new Type("Dark"));
		trepository.save(new Type("Dragon"));
		trepository.save(new Type("Steel"));
		trepository.save(new Type("Fairy"));
		
		log.info("Saving Pokemon versions to in-memory");
		vrepository.save(new Version("Normal"));
		vrepository.save(new Version("Holo"));
		vrepository.save(new Version("Reverse Holo"));
		
		log.info("saving some demo pokemons to in-memory for testing");
		repository.save(new Pokemon("Empoleon",trepository.findByTypeName("Ice").get(0),"130","Diamond",vrepository.findByVersionName("Holo").get(0)));
		repository.save(new Pokemon("Pikachu",trepository.findByTypeName("Electric").get(0),"100","Diamond & Pearl",vrepository.findByVersionName("Normal").get(0)));

		
	};
	}

}
