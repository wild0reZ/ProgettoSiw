package it.silph.silphportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.silph.silphportal.model.Foto;
import it.silph.silphportal.model.Modulo;
import it.silph.silphportal.service.ModuloService;

@Controller
public class ModuloController {
    @Autowired
    private ModuloService moduloService;

    @RequestMapping(value = "/newModulo", method = RequestMethod.GET)
    public String newModulo(@ModelAttribute("fotoRichiesta") List<Foto> fotoRichiesta, Model model) {
	if (!fotoRichiesta.isEmpty()) {
	    model.addAttribute("modulo", new Modulo());
	    return "CompilaModuloPage.html";
	}
	return "NoFotoPage.html";
    }
    
}
