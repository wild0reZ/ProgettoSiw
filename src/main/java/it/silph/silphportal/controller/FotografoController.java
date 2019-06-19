package it.silph.silphportal.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.silph.silphportal.model.Album;
import it.silph.silphportal.model.Foto;
import it.silph.silphportal.model.Fotografo;
import it.silph.silphportal.model.Immagine;
import it.silph.silphportal.service.FotografoService;
import it.silph.silphportal.service.ImmagineService;
import it.silph.silphportal.validator.AlbumValidator;
import it.silph.silphportal.validator.FotoValidator;
import it.silph.silphportal.validator.FotografoValidator;

@Controller
public class FotografoController {
    @Autowired
    private FotografoService fotografoService;
    @Autowired
    private ImmagineService immagineService;

    @Autowired
    private FotoValidator fotoValidator;
    @Autowired
    private AlbumValidator albumValidator;
    @Autowired
    private FotografoValidator fotografoValidator;

    @RequestMapping(value = "/listFotografi", method = RequestMethod.GET)
    public String listFotografi(Model model, @RequestParam("page") Optional<Integer> page,
	    @RequestParam("size") Optional<Integer> size) {
	int currentPage = page.orElse(1);
	int pageSize = size.orElse(9);

	Page<Fotografo> fotografiPage = fotografoService.findPaginated(PageRequest.of(currentPage - 1, pageSize),
		this.fotografoService.tuttiPerData());

	model.addAttribute("fotografiPage", fotografiPage);

	int totalPages = fotografiPage.getTotalPages();
	if (totalPages > 0) {
	    List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
	    model.addAttribute("pageNumbers", pageNumbers);
	}

	return "FotografiPage";
    }

    @RequestMapping(value = "/fotografo/{id}/newAlbum")
    public String newAlbumFotografo(@PathVariable("id") Long id, Model model) {
	if (!model.containsAttribute("album")) {
	    model.addAttribute("album", new Album());
	}
	if (!model.containsAttribute("foto")) {
	    model.addAttribute("foto", new Foto());
	}
	Fotografo temp = new Fotografo();
	temp.setId(id);
	model.addAttribute("fotografo", temp);
	return "AddAlbumAndFotoPage.html";
    }

    @RequestMapping(value = "/fotografo/{id}/album", method = RequestMethod.POST)
    public String addAlbumFotografo(@PathVariable("id") Long id, @Valid @ModelAttribute("album") Album album,
	    BindingResult resultAlbum, @Valid @ModelAttribute("foto") Foto foto, BindingResult resultFoto,
	    @RequestParam("multipart") MultipartFile mpf, RedirectAttributes rAttribute) throws IOException {
	albumValidator.validate(album, resultAlbum);
	fotoValidator.validate(foto, resultFoto);
	if (!(resultAlbum.hasErrors() || resultFoto.hasErrors())) {
	    Immagine i = this.immagineService.inserisci(new Immagine(mpf.getBytes()));
	    foto.setImmagine(i);
	    album.addFoto(foto);
	    foto.setFotografo(this.fotografoService.trovaPerId(id));
	    this.fotografoService.addAlbum(id, album);
	    this.fotografoService.inserisci(this.fotografoService.trovaPerId(id));
	    return "OperazioneCompletataPage.html";
	}
	rAttribute.addFlashAttribute("org.springframework.validation.BindingResult.foto", resultFoto);
	rAttribute.addFlashAttribute("org.springframework.validation.BindingResult.album", resultAlbum);
	rAttribute.addFlashAttribute("foto", foto);
	rAttribute.addFlashAttribute("album", album);
	return "redirect:/fotografo/{id}/newAlbum";
    }

    @RequestMapping(value = "/newFotografo", method = RequestMethod.GET)
    public String newFotografo(Model model) {
	model.addAttribute("immagine", new Immagine());
	model.addAttribute("fotografo", new Fotografo());
	return "AddFotografoPage.html";
    }

    @RequestMapping(value = "/fotografo", method = RequestMethod.POST)
    public String addNewFotografo(@ModelAttribute("immagine") Immagine immagine,
	    @Valid @ModelAttribute("fotografo") Fotografo fotografo, @RequestParam("multipart") MultipartFile mpf,
	    BindingResult result) throws IOException {
	this.fotografoValidator.validate(fotografo, result);
	if (!result.hasErrors()) {
	    immagine.setFileImmagine(mpf.getBytes());
	    fotografo.setImmagineProfilo(immagine);
	    this.fotografoService.inserisci(fotografo);
	    return "OperazioneCompletataPage.html";
	}
	return "AddFotografoPage.html";
    }

}
