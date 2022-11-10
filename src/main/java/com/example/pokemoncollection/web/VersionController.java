package com.example.pokemoncollection.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.pokemoncollection.domain.VersionRepository;

@Controller
public class VersionController {

	@Autowired
	private VersionRepository vrepository;
	
	
    //Show list of all cards with same version
  @GetMapping({"/cardsByVersion/{version}"})
  public String cardListByVersion(@PathVariable("version") String version, Model model) {
  	model.addAttribute("versions", vrepository.findByVersionName(version));
  	return "pokemonlist";
  }

	//Delete version
	
	@GetMapping({"/deleteVersion/{versionId}"})
	public String deleteVersion(@PathVariable("versionId") Long VersionId, Model model) {
		vrepository.deleteById(VersionId);
		return "redirect:/pokemoncollection";
	}
	
	//Delete all versions
	@GetMapping({"/deleteAllVersions"})
    public String deleteAllVersions(Model model) {
    	vrepository.deleteAll();
    	return "pokemonlist";
    }
}