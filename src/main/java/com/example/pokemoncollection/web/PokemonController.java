package com.example.pokemoncollection.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.pokemoncollection.domain.Pokemon;
import com.example.pokemoncollection.domain.PokemonRepository;
import com.example.pokemoncollection.domain.TypeRepository;
import com.example.pokemoncollection.domain.VersionRepository;

@Controller
public class PokemonController {

	@Autowired
	private PokemonRepository repository;
	@Autowired
	private TypeRepository trepository;
	@Autowired
	private VersionRepository vrepository;
	
	
	
	@RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
	
	
	
	//Show list of all Pokemons

	@GetMapping({"/","/pokemoncollection"})
	public String pokemonList(Model model) {
		model.addAttribute("pokemons", repository.findAll());
		return "pokemonlist";
	}
	
	//REST service to get all pokemons
	 @RequestMapping(value = "/pokemons", method = RequestMethod.GET)
	 public @ResponseBody List<Pokemon> pokemonListRest() {
	    return (List<Pokemon>) repository.findAll();
	    }
	 
	 //REST service to get pokemon by id
	 @RequestMapping(value = "pokemon/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Pokemon> findPokemonRest(@PathVariable("id") Long pokemonId) {
	        return repository.findById(pokemonId);
	    }
	
	// Add new Pokemon to list 
	
	 @GetMapping("/add")
	    public String addPokemon(Model model) {
	        model.addAttribute("pokemon", new Pokemon());
	        model.addAttribute("types", trepository.findAll());
	        model.addAttribute("versions", vrepository.findAll());
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
	        model.addAttribute("types", trepository.findAll());
	        model.addAttribute("versions", vrepository.findAll());
	        return "editpokemon";
	    }
	 
	 //Delete Pokemon from list
	 @GetMapping("/delete/{id}")
	    public String deletePokemon(@PathVariable("id") Long PokemonId, Model model) {
	        repository.deleteById(PokemonId);
	        return "redirect:/pokemoncollection";
	    }
}
