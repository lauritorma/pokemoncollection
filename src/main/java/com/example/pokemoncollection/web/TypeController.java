package com.example.pokemoncollection.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.pokemoncollection.domain.Type;
import com.example.pokemoncollection.domain.TypeRepository;

@Controller
public class TypeController {

	@Autowired
	private TypeRepository trepository;
	
	 @GetMapping("/addTypes")
	    public String addTypes(Model model) {
	        model.addAttribute("Normal", new Type());
	        model.addAttribute("Fire", new Type());
	        model.addAttribute("Water", new Type());
	        model.addAttribute("Grass", new Type());
	        model.addAttribute("Electric", new Type());
	        model.addAttribute("Ice", new Type());
	        model.addAttribute("Fighting", new Type());
	        model.addAttribute("Poison", new Type());
	        model.addAttribute("Ground", new Type());
	        model.addAttribute("Flying", new Type());
	        model.addAttribute("Psychic", new Type());
	        model.addAttribute("Bug", new Type());
	        model.addAttribute("Rock", new Type());
	        model.addAttribute("Ghost", new Type());
	        model.addAttribute("Dark", new Type());
	        model.addAttribute("Dragon", new Type());
	        model.addAttribute("Steel", new Type());
	        model.addAttribute("Fairy", new Type());
	        
	    
	        return "pokemoncollection";
	    }
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
