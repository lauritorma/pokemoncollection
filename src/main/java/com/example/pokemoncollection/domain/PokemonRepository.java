package com.example.pokemoncollection.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PokemonRepository extends CrudRepository <Pokemon, Long> {
	List<Pokemon> findByPokemonName(@Param("pokemonName") String pokemonName);
}
