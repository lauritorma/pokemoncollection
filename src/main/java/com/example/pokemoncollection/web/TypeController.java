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
	
	//Add types to type repo
  @GetMapping({"/addTypes"})
  public String addTypes() {
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
	  return "redirect:/pokemoncollection";
  }
	
   //Show list of all cards with same type
	
  @GetMapping({"/cardsByType/{typeName}"})
  public String cardListByType(@PathVariable("typeName") String typeName, Model model) {
  	model.addAttribute("types", trepository.findByTypeName(typeName));
  	return "pokemonlist";
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