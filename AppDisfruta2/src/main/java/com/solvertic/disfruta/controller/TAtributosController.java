package com.solvertic.disfruta.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.solvertic.disfruta.entity.TAtributos;
import com.solvertic.disfruta.services.ITAtributosService;

@Controller
@RequestMapping("/tatributos")
public class TAtributosController {

	public static final String VISTA_FORMULARIO = "tatributos-form";
	public static final String VISTA_LISTA = "hometatributos-form";

	@Autowired
	private ITAtributosService iTAtributosService;

	@GetMapping("/tatributosform")
	public String tATributosForm(Model model) {
		model.addAttribute("tatributosform", new TAtributos());
		return VISTA_FORMULARIO;
	}

	@PostMapping("/savetatributos")
	public String saveTAtributos(@Valid @ModelAttribute("tatributosform") TAtributos tatributos,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return VISTA_FORMULARIO;

		}
		iTAtributosService.saveTAtributos(tatributos);
		return "redirect:/tatributos/tatributosform";
	}

	@GetMapping("/hometatributos")
	public String homeTAtributos(Model model) {
		model.addAttribute("hometatributos", iTAtributosService.listTAtributosAll());
		return VISTA_LISTA;
	}

	@GetMapping("/deletetatributos/{id}")
	public String deleteTAtributos(@PathVariable("id") int id, RedirectAttributes flash) {
		if (id > 0) {
			iTAtributosService.deleteTAtributosById(id);
			flash.addFlashAttribute("success", "El registro fuel eliminado.");
		} else {
			flash.addFlashAttribute("error", "El registro NO fue eliminado.");
		}

		return "redirect:/tatributos/hometatributos";
	}

	@GetMapping("/updatetatributos/{id}")
	public String updateTAtributos(@PathVariable("id") int id, Model model) {
		TAtributos tatributos = null;
		tatributos = iTAtributosService.findTAtributosById(id);
		model.addAttribute("tatributosform", tatributos);

		return VISTA_FORMULARIO;
	}

}
