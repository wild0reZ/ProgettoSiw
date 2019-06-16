package it.silph.silphportal.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FunzionarioController {

	
	@RequestMapping(value = {"/moduliPage"}, method = RequestMethod.GET)
	public String moduliFunzionario (Model model) {
		
		UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String role = details.getAuthorities().iterator().next().getAuthority();
		model.addAttribute("role", role);
		
		return "Modulipage";
		
	}

}
	