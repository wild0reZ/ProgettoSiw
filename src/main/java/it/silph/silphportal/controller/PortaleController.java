package it.silph.silphportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.silph.silphportal.model.Funzionario;
import it.silph.silphportal.service.AuthService;
import it.silph.silphportal.service.FunzionarioService;

@Controller
public class PortaleController {
	
	@Autowired
	FunzionarioService funzionarioService;
	
	@Autowired
	AuthService authService;
	
	@RequestMapping("/loginPage")
	public String loginPage(Model model) {
		model.addAttribute("funzionario", new Funzionario());
		return "LoginPage";
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("funzionario") Funzionario funzionario, Model model) {
		
		if(funzionario != null) {
			if(this.authService.checkCredential(funzionario)) {
				return "HomePage";
			} else return "LoginPage";
		}else return "Loginpage";
		
	}
}
