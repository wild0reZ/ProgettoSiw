package it.silph.silphportal.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.silph.silphportal.model.Foto;
import it.silph.silphportal.service.FotoService;

@Controller
public class FotoController {
    @Autowired
    private FotoService fotoService;

    @RequestMapping(value = "/listFoto", method = RequestMethod.GET)
    public String listFoto(Model model, @RequestParam("page") Optional<Integer> page,
	    @RequestParam("size") Optional<Integer> size) {
	int currentPage = page.orElse(1);
	int pageSize = size.orElse(9);

	Page<Foto> fotoPage = fotoService.findPaginated(PageRequest.of(currentPage - 1, pageSize),
		this.fotoService.tuttePerData());

	model.addAttribute("fotoPage", fotoPage);

	int totalPages = fotoPage.getTotalPages();
	if (totalPages > 0) {
	    List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
	    model.addAttribute("pageNumbers", pageNumbers);
	}

	return "FotoPage";
    }

    //// TODO: Bisogna ancora implementare il tutto
    //// @RequestMapping(value = "/foto", method = RequestMethod.POST)
    //// public String newFoto(@RequestParam("multipartFoto") MultipartFile mpFoto,
    //// @ModelAttribute("foto") Foto foto,
    //// Model model) throws IOException {
    //// foto.setDataInserimento(LocalDate.now());
    //// foto.setImmagine(mpFoto.getBytes());
    //// this.fotoService.aggiungiFoto(foto);
    //// model.addAttribute("foto", foto);
    //// return "FotoPage";
    //// }
    ////
    // @RequestMapping(value = "/addFoto")
    // public String addFoto(Model model) {
    // model.addAttribute("foto", new Foto());
    // return "FormFoto";
    // }
    //
}
