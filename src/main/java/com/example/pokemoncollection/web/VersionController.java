package com.example.pokemoncollection.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pokemoncollection.domain.Pokemon;
import com.example.pokemoncollection.domain.Version;
import com.example.pokemoncollection.domain.VersionRepository;

@Controller
public class VersionController {

	@Autowired
	private VersionRepository vrepository;
	
	//Add versions to version repo
	
	@GetMapping({"/addVersions"})
	public String addVersions() {
		vrepository.save(new Version("Normal"));
		vrepository.save(new Version("Holo"));
		vrepository.save(new Version("Reverse Holo"));
		return "redirect:/pokemoncollection";
	}
	
	// REST service to get all versions
    @RequestMapping(value = "/versions", method = RequestMethod.GET)
    public @ResponseBody List<Version> versionListRest() {
        return (List<Version>) vrepository.findAll();
    }

    // REST service to get version by id
    @RequestMapping(value = "version/{versionId}", method = RequestMethod.GET)
    public @ResponseBody Optional<Version> findVersionnRest(@PathVariable("versionId") Long versionId) {
        return vrepository.findById(versionId);
    }
	
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