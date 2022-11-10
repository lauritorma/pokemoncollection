package com.example.pokemoncollection.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PokemonRepository extends CrudRepository <Pokemon, Long> {
	List<Pokemon> findByPokemonName(@Param("pokemonName") String pokemonName);
	List<Pokemon> findByType(@Param("type") String type);
	List<Pokemon> findByHp(@Param("hp") String hp);
	List<Pokemon> findBySetName(@Param("setName") String setName);
	List<Pokemon> findByVersion(@Param("version") String version);
	
}
