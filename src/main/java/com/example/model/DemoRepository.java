package com.example.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface DemoRepository extends CrudRepository<Demo, Long>{

	public Demo findByName(String name);
	public Demo findByNameIgnoreCase(String name);
	public Demo findByNameAndId(String name, Long id);
	public List<Demo> findAllByOrderByNameAsc();
	
}
