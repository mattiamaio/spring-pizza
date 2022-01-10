package org.generation.italy.controller;

import org.generation.italy.model.Pizza;
import org.generation.italy.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class PizzaController {

	@Autowired
	private PizzaService service;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("pizza", service.findAll());
		return "/menu/lista";
	}
	
	@GetMapping("/aggiungipizza")
	public String aggiungiPizza(Model model) {
		model.addAttribute("pizza", new Pizza());
		return "/menu/aggiungipizza";
	}
	
}
