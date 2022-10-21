package com.example.pokemoncollection.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import com.example.pokemoncollection.domain.Pokemon;
import com.example.pokemoncollection.domain.PokemonRepository;
import com.example.pokemoncollection.domain.TypeRepository;

@Controller
public class PokemonController {

	@Autowired
	private PokemonRepository repository;
	@Autowired
	private TypeRepository trepository;
	
	//Show list of all Pokemons

	@GetMapping({"/","/pokemoncollection"})
	public String pokemonList(Model model) {
		model.addAttribute("pokemons", repository.findAll());
		return "pokemonlist";
	}
	
	// Add new Pokemon to list 
	
	 @GetMapping("/add")
	    public String addPokemon(Model model) {
	        model.addAttribute("pokemon", new Pokemon());
	        model.addAttribute("types", trepository.findAll());
	        return "addpokemon";
	    }
	 
	 // Save new Pokemon
	 
	 @PostMapping("/save")
	    public String save(Pokemon pokemon) {
	        repository.save(pokemon);
	        return "redirect:pokemoncollection";
	    }
	 
	 // Edit Pokemon
	    @GetMapping("/edit/{id}")
	    public String editPokemon(@PathVariable("id") Long PokemonId, Model model) {
	        model.addAttribute("pokemon", repository.findById(PokemonId));
	        return "editpokemon";
	    }
	 
	 //Delete Pokemon from list
	 @GetMapping("/delete/{id}")
	   
	    public String deletePokemon(@PathVariable("id") Long PokemonId, Model model) {
	        repository.deleteById(PokemonId);
	        return "redirect:/pokemoncollection";
	    }
}
