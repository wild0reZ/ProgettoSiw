package it.silph.silphportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FunzionarioController {

	
	@RequestMapping(value = "/loginFunzionario", method = RequestMethod.GET)
	public String loggaFunzionario() {
	    return "LoginPage.html";
	}
	
	
	@RequestMapping(value = "/failedLogin" , method = RequestMethod.GET)
	public String loginFallito(Model model) {
	    model.addAttribute("loginError", true);
	    return "LoginPage.html";
	}
	
	


}
	