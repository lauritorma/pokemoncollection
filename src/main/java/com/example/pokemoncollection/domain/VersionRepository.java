package com.example.pokemoncollection.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VersionRepository extends CrudRepository<Version, Long> {
	List<Type> findByVersionName(String versionName);

}
