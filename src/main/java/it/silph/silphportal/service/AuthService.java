package it.silph.silphportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.silph.silphportal.model.Funzionario;

@Service
public class AuthService {
	
	@Autowired
	FunzionarioService funzionarioService;

	
	public boolean isPasswordValid(Funzionario funzionario, String password) {
		if(funzionario.getPassword().equals(password)) {
			return true;
		} else return false;
	}
	
	public boolean checkCredential(Funzionario funzionario) {
		Funzionario funzionarioLogin = this.funzionarioService.findById(funzionario.getId());
		if(isPasswordValid(funzionarioLogin, funzionario.getPassword())) {
			funzionario.setRole("FUNZIONARIO");
			return true;
		} else return false;
	}
}
