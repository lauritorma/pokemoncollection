package com.example.pokemoncollection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.pokemoncollection.domain.Pokemon;
import com.example.pokemoncollection.domain.PokemonRepository;
import com.example.pokemoncollection.domain.TypeRepository;
import com.example.pokemoncollection.domain.VersionRepository;




@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PokemoncollectionApplication.class)
public class PokemonRepositoryTest {

	@Autowired
	 private PokemonRepository repository;
	@Autowired
	private TypeRepository trepository;
	@Autowired
	private VersionRepository vrepository;
	
	@Test
	public void findByPokemonNameShouldReturnSetName() {
		List<Pokemon> pokemons = repository.findByPokemonName("Empoleon");
		assertThat(pokemons.get(0).getSetName()).isEqualTo("Diamond");
	}
	
	@Test
	public void createNewPokemon() {
		Pokemon pokemon = new Pokemon("Charizard",trepository.findByTypeName("Fire").get(0),"100","Diamond", vrepository.findByVersionName("Holo").get(0));
		repository.save(pokemon);
		assertThat(pokemon.getId()).isNotNull();
	}
	
	@Test
	public void DeletePokemon() {
		List<Pokemon> pokemons = repository.findByPokemonName("Pikachu");
		repository.deleteAll(pokemons);
		assertThat(pokemons.get(0).getPokemonName().isEmpty());
		
		
	}
}
