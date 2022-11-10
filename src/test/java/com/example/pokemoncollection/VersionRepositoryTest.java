package com.example.pokemoncollection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.pokemoncollection.domain.Version;
import com.example.pokemoncollection.domain.VersionRepository;



@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VersionRepositoryTest {

	@Autowired
	 private VersionRepository repository;
	
	@Test
	public void findByVersionNameShouldReturnVersionName() {
		List<Version> versions = repository.findByVersionName("Normal");
		assertThat(versions).hasSize(1);
		
	}
	
	@Test
	public void createNewVersion() {
		Version version = new Version("Special-edition");
		repository.save(version);
		assertThat(version.getVersionId()).isNotNull();
	}
	
	@Test
	public void DeleteVersion() {
		List<Version> versions = repository.findByVersionName("Holo");
		repository.deleteAll(versions);
		assertThat(versions.get(0).getVersionName().isEmpty());
		
		
	}
}
