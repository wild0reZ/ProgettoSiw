package it.silph.silphportal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import it.silph.silphportal.model.Foto;
import it.silph.silphportal.model.Modulo;
import it.silph.silphportal.repository.FotoRepository;
import it.silph.silphportal.repository.ModuloRepository;
import it.silph.silphportal.service.FotoService;
import it.silph.silphportal.service.ModuloService;
import it.silph.silphportal.validator.ModuloValidator;

@Controller
@SessionAttributes("fotoRichiesta")
public class ModuloController {
    @Autowired
    private ModuloService moduloService;
    @Autowired
    private ModuloValidator moduloValidator;

    @RequestMapping(value = "/newModulo", method = RequestMethod.GET)
    public String newModulo(@ModelAttribute("fotoRichiesta") ArrayList<Foto> fotoRichiesta, Model model) {
	if (!fotoRichiesta.isEmpty()) {
	    Modulo modulo = new Modulo();
	    model.addAttribute("modulo", modulo);
	    return "CompilaModuloPage.html";
	}
	return "NoFotoPage.html";
    }

    @RequestMapping(value = "/modulo/{id}", method = RequestMethod.GET)
    public String getModulo(@PathVariable("id") Long id, Model model) {
	Modulo modulo = new Modulo();
	this.moduloService.newModuloById(modulo, id);
	model.addAttribute("modulo", modulo);
	return "VisualizzaModuloPage.html";
    }

    @RequestMapping(value = "/modulo", method = RequestMethod.POST)
    public String postModulo(@Valid @ModelAttribute("modulo") Modulo modulo, Model model, BindingResult result,
	    @ModelAttribute("fotoRichiesta") List<Foto> fotoRichiesta, SessionStatus status) {
	this.moduloValidator.validate(modulo, result);
	if (!result.hasErrors()) {
	    modulo.setFoto(fotoRichiesta);
	    this.moduloService.inserisci(modulo);
	    status.setComplete(); // elimina il session attribute!
	    return "OperazioneCompletataPage.html";
	}
	return "CompilaModuloPage.html";
    }

    @RequestMapping(value = "/listModuli", method = RequestMethod.GET)
    public String listFotografi(Model model, @RequestParam("page") Optional<Integer> page,
	    @RequestParam("size") Optional<Integer> size) {
	int currentPage = page.orElse(1);
	int pageSize = size.orElse(9);

	Page<Modulo> moduliPage = moduloService.findPaginated(PageRequest.of(currentPage - 1, pageSize),
		this.moduloService.tutti());

	model.addAttribute("moduliPage", moduliPage);

	int totalPages = moduliPage.getTotalPages();
	if (totalPages > 0) {
	    List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
	    model.addAttribute("pageNumbers", pageNumbers);
	}

	return "ModuliPage.html";
    }
}
