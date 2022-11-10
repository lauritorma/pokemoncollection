package com.example.pokemoncollection;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.pokemoncollection.domain.Type;
import com.example.pokemoncollection.domain.TypeRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TypeRepositoryTest {

	@Autowired
	 private TypeRepository repository;
	
	@Test
	public void findByTypeNameShouldReturnTypeName() {
		List<Type> types = repository.findByTypeName("Water");
		assertThat(types).hasSize(1);
		
	}
	
	@Test
	public void createNewType() {
		Type type = new Type("Elemental");
		repository.save(type);
		assertThat(type.getTypeid()).isNotNull();
	}
	
	@Test
	public void DeleteType() {
		List<Type> types = repository.findByTypeName("Fire");
		repository.deleteAll(types);
		assertThat(types.get(0).getTypeName().isEmpty());
		
		
	}
}