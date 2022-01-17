package org.generation.italy.controller;

import org.generation.italy.service.IngredientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredienti")
public class IngredientiController {

	@Autowired
	private IngredientiService service;
	
	@GetMapping
	public String listaIngredienti (Model model){
		model.addAttribute("ingredienti", service.findAllSortByIngredienti());
		return "/ingredienti/listaingredienti";
	}
	
	
}
