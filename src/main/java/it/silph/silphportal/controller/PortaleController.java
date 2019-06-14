package it.silph.silphportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.silph.silphportal.model.Funzionario;
import it.silph.silphportal.service.AuthService;
import it.silph.silphportal.service.FunzionarioValidator;

@Controller
public class PortaleController {
	
	@Autowired
	FunzionarioValidator funzionarioValidator;
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/login")
	public String loginFunzionario(@Validated @ModelAttribute("funzionario") Funzionario funzionario, Model model, BindingResult bindingResult) {
		this.funzionarioValidator.validate(funzionario, bindingResult);
		if(!bindingResult.hasErrors()) {
			if(this.authService.checkCredential(funzionario)) {
				funzionario.setRole("FUNZIONARIO");
				model.addAttribute("funzionario", funzionario);
				return "HomePage";
			}else return "HomePage";
		} else return "HomePage";
	}
}
