package com.example.pokemoncollection.web;

import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    // Show list of all Pokemons

    @GetMapping({ "/", "/favicon.ico", "/pokemoncollection" })
    public String pokemonList(Model model) {
        model.addAttribute("pokemons", repository.findAll());
        return "pokemonlist";
    }

    // REST service to get all pokemons
    @RequestMapping(value = "/pokemons", method = RequestMethod.GET)
    public @ResponseBody List<Pokemon> pokemonListRest() {
        return (List<Pokemon>) repository.findAll();
    }

    // REST service to get pokemon by id
    @RequestMapping(value = "pokemon/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Pokemon> findPokemonRest(@PathVariable("id") Long pokemonId) {
        return repository.findById(pokemonId);
    }
    
    
    //Show list of all cards with same Pokémon
    @GetMapping( { "/cardsByPokemonName/{pokemonName}" })
    public String cardListByPokemonName(@PathVariable("pokemonName") String pokemonName, Model model) {
        model.addAttribute("pokemons", repository.findByPokemonName(pokemonName));
        return "pokemonlist";
    }
    
    //Show list of all cards with same type
    @GetMapping({"/cardsByType/{type}"})
    public String cardListByType(@PathVariable("type") String type, Model model) {
    	model.addAttribute("types", repository.findByType(type));
    	return "pokemonlist";
    }
    
    //Show list of all cards with same hp
    @GetMapping({"/cardsByHp/{hp}"})
    public String cardListByHp(@PathVariable("hp") String hp, Model model) {
    	model.addAttribute("pokemons", repository.findByHp(hp));
    	return "pokemonlist";
    }
    
    //Show list of all cards from same set
    @GetMapping({"/cardsBySetName/{setName}"})
    public String cardListBySetName(@PathVariable("setName") String setName, Model model) {
    	model.addAttribute("setNames", repository.findBySetName(setName));
    	return "pokemonlist";
    }
    
    //Show list of all cards with same version
    @GetMapping({"/cardsByVersion/{version}"})
    public String cardListByVersion(@PathVariable("version") String version, Model model) {
    	model.addAttribute("versions", repository.findByVersion(version));
    	return "pokemonlist";
    }

    // Add new card to list

    @GetMapping("/add")
    public String addPokemon(Model model) {
        model.addAttribute("pokemon", new Pokemon());
        model.addAttribute("types", trepository.findAll());
        model.addAttribute("versions", vrepository.findAll());
        return "addpokemon";
    }

    // Save new card

    @PostMapping("/save")
    public String save(@ModelAttribute("pokemon") @Valid Pokemon pokemon, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
          model.addAttribute("types", trepository.findAll());
          model.addAttribute("versions", vrepository.findAll());
          return "addpokemon";
        }
    	repository.save(pokemon);
        return "redirect:pokemoncollection";
    }

    // Edit card
    @GetMapping("/edit/{id}")
    public String editPokemon(@PathVariable("id") Long PokemonId, Long typeId, Long versionId, Model model) {
        model.addAttribute("pokemon", repository.findById(PokemonId));
        model.addAttribute("types", trepository.findAll());
        model.addAttribute("versions", vrepository.findAll());
        return "editpokemon";
    }

    // Delete card from list
    @GetMapping("/delete/{id}")
    public String deletePokemon(@PathVariable("id") Long PokemonId, Model model) {
        repository.deleteById(PokemonId);
        return "redirect:/pokemoncollection";
    }
    
    //Delete all cards from list
    
    @GetMapping("/deleteAll")
    public String deleteAll(Model model) {
    	repository.deleteAll();
    	return "pokemonlist";
    }
}
