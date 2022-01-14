package org.generation.italy.service;

import java.util.List;

import org.generation.italy.model.Pizza;
import org.generation.italy.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepository repository;
	
	public List<Pizza> findAll(){
		return repository.findAll();
	}
	
	public List<Pizza> findByKeyword(String keyword){
		return repository.findByNomeContainingIgnoreCase(keyword);
	}
	
	public Pizza salva(Pizza pizza) {
		return repository.save(pizza);
	}
	
	public Pizza getById(Integer id) {
		return repository.getById(id);
	}
	
	public Pizza modifica(Pizza pizza) {
		return repository.save(pizza);
	}
	
	public void cancellaConId(Integer id) {
		repository.deleteById(id);
	}
}
