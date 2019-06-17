package it.silph.silphportal.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.silph.silphportal.model.Album;
import it.silph.silphportal.model.Foto;
import it.silph.silphportal.model.Fotografo;
import it.silph.silphportal.model.Immagine;
import it.silph.silphportal.service.FotografoService;
import it.silph.silphportal.service.ImmagineService;

@Controller
public class FotografoController {
    @Autowired
    private FotografoService fotografoService;
    @Autowired
    private ImmagineService immagineService;

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
	model.addAttribute("album", new Album());
	model.addAttribute("foto", new Foto());
	Fotografo temp = new Fotografo();
	temp.setId(id);
	model.addAttribute("fotografo", temp);
	return "AddAlbumAndFotoPage.html";
    }

    @RequestMapping(value = "/fotografo/{id}/album", method = RequestMethod.POST)
    public String addAlbumFotografo(@PathVariable("id") Long id, @ModelAttribute("album") Album album,
	    @ModelAttribute("foto") Foto foto, @RequestParam("multipart") MultipartFile mpf) throws IOException {
	Immagine i = this.immagineService.inserisci(new Immagine(mpf.getBytes()));
	foto.setImmagine(i);
	album.addFoto(foto);
	foto.setFotografo(this.fotografoService.trovaPerId(id));
	this.fotografoService.addAlbum(id, album);
	this.fotografoService.inserisci(this.fotografoService.trovaPerId(id));
	return "OperazioneCompletataPage.html";
    }

}
