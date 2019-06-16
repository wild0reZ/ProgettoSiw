package it.silph.silphportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.silph.silphportal.model.Funzionario;

@Controller
public class PortaleController {
	
	@RequestMapping("/loginPage")
	public String loginPage(Model model) {
		model.addAttribute("funzionario", new Funzionario());
		return "LoginPage";
	}
	
}
