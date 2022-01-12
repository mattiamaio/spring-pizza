package org.generation.italy.controller;

import org.generation.italy.model.Pizza;
import org.generation.italy.service.IngredientiService;
import org.generation.italy.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class PizzaController {

	@Autowired
	private PizzaService service;
	
	@Autowired
	private IngredientiService ingredientiService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("pizza", service.findAll());
		return "/menu/lista";
	}
	
	@GetMapping("/aggiungipizza")
	public String aggiungiPizza(Model model) {
		model.addAttribute("pizza", new Pizza());
		model.addAttribute("ingredienti", ingredientiService.findAllSortByIngredienti());
		return "/menu/aggiungipizza";
	}
	
	@PostMapping("/aggiungipizza")
	public String salvaPizza(@ModelAttribute("pizza") Pizza formPizza, Model model) {
		service.salva(formPizza);
		return "redirect:/menu";
	}
	
	@GetMapping("/modifica/{id}")
	public String modifica(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("pizza", service.getById(id));
		model.addAttribute("ingredienti", ingredientiService.findAllSortByIngredienti());
		return "/menu/aggiungipizza";
	}
	
	@PostMapping("/modifica/{id}")
	public String confermaModifica(@ModelAttribute("pizza") Pizza formPizza, Model model) {
		service.modifica(formPizza);
		return "redirect:/menu";
	}
	
	@GetMapping("/cancella/{id}")
	public String doCancella(Model model, @PathVariable("id") Integer id) {
		service.cancellaConId(id);
		return "redirect:/menu";
	}
}
