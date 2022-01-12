package org.generation.italy.service;

import java.util.List;

import org.generation.italy.model.Ingredienti;
import org.generation.italy.repository.IngredientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientiService {

	@Autowired
	private IngredientiRepository repository;
	
	public List<Ingredienti> findAllSortByIngredienti(){
		return repository.findAll();
	}
	
}
