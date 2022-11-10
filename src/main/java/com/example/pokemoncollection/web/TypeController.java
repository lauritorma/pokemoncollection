package com.example.pokemoncollection.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.pokemoncollection.domain.TypeRepository;

@Controller
public class TypeController {

	@Autowired
	private TypeRepository trepository;
	
	
	//Delete type
	
	@GetMapping({"/deleteType/{typeid}"})
	public String deleteType(@PathVariable("typeid") Long Typeid, Model model) {
		trepository.deleteById(Typeid);
		return "redirect:/pokemoncollection";
	}
	
	//Delete all types
	@GetMapping({"/deleteAllTypes"})
    public String deleteAllTypes(Model model) {
    	trepository.deleteAll();
    	return "pokemonlist";
    }
}
