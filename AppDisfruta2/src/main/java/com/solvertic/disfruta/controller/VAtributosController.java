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

import com.solvertic.disfruta.entity.VAtributos;
import com.solvertic.disfruta.services.ITAtributosService;
import com.solvertic.disfruta.services.IVAtributosService;

@Controller
@RequestMapping("/vatributos")
public class VAtributosController {
	
	public static final String VISTA_FORMULARIO = "vatributos-form";
	public static final String VISTA_LISTA = "homevatributos-form";
	
	@Autowired
	private IVAtributosService iVAtributosService;
	
	@Autowired
	private ITAtributosService iTAtributosService;
	
	@GetMapping("/vatributosform")
	public String vAtributosForm(Model model) {
		model.addAttribute("vatributosform", new VAtributos());
		System.out.println(iTAtributosService.listTAtributosAll().size());
		model.addAttribute("tatributosform", iTAtributosService.listTAtributosAll());
		
		return VISTA_FORMULARIO;
	}
	
	@PostMapping("/savevatributos")
	public String saveVAtributos(@Valid @ModelAttribute("vatributosform") 
					VAtributos vatributos, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("tatributosform", iTAtributosService.listTAtributosAll());
			return VISTA_FORMULARIO;
		} 
		iVAtributosService.saveVAtributos(vatributos);
		return "redirect:/vatributos/vatributosform";
	}
	
	@GetMapping("/homevatributos")
	public String homeVAtributos(Model model) {
		model.addAttribute("homevatributos", iVAtributosService.listVAtributosAll());
		//Cómo puedo llenar la descripción del Atributo asociado a estos valores. La descripción está en otra tabla, pero hay una relación de clave foranea.
		return VISTA_LISTA;
	}
	
	@GetMapping("/deletevatributos/{id}")
	public String deleteVAtributos(@PathVariable("id") int id, RedirectAttributes flash) {
		if (id > 0) {
			iVAtributosService.deleteVAtributosById(id);
			flash.addFlashAttribute("success", "El registro fue eliminado.");
		} else {
			flash.addFlashAttribute("error", "El registro NO fue eliminado.");
		}
		
		return "redirect:/vatributos/homevatributos";		
	}
	
	@GetMapping("/updatevatributos/{id}")
	public String updateVAtributos(@PathVariable("id") int id, Model model) {
		VAtributos vatributos = null;
		vatributos = iVAtributosService.findVAtributosById(id);
		model.addAttribute("vatributosform", vatributos);
		model.addAttribute("tatributosform", iTAtributosService.listTAtributosAll());
		
		return VISTA_FORMULARIO;
	}
	
	

}
