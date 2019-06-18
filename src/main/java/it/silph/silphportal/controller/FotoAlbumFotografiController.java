package it.silph.silphportal.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import it.silph.silphportal.model.Album;
import it.silph.silphportal.model.Foto;
import it.silph.silphportal.model.Fotografo;
import it.silph.silphportal.service.AlbumService;
import it.silph.silphportal.service.FotoService;
import it.silph.silphportal.service.FotografoService;

@Controller
public class FotoAlbumFotografiController {

    @Autowired
    private FotografoService fotografoService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private FotoService fotoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePageFoto(Model model, SessionStatus status) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth.isAuthenticated())
	    status.setComplete();
	model.addAttribute("gruppoFoto", this.fotoService.prime9PerData());
	model.addAttribute("gruppoAlbum", this.albumService.primi10PerDataFraTutte());
	model.addAttribute("gruppoFotografo", this.fotografoService.primi9PerDataFraTutti());
	return "HomePage";
    }

    @RequestMapping(value = "/fotografo/{id}")
    public String fotografoPage(@PathVariable("id") Long id, Model model, @RequestParam("page") Optional<Integer> page,
	    @RequestParam("size") Optional<Integer> size) {
	Fotografo f = this.fotografoService.trovaPerId(id);
	model.addAttribute("fotografo", f);
	int currentPage = page.orElse(1);
	int pageSize = size.orElse(15);

	Page<Album> albumFotografoPage = albumService.findPaginated(PageRequest.of(currentPage - 1, pageSize),
		this.albumService.tuttiPerFotografo(f));

	model.addAttribute("albumFotografoPage", albumFotografoPage);

	int totalPages = albumFotografoPage.getTotalPages();
	if (totalPages > 0) {
	    List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
	    model.addAttribute("pageNumbers", pageNumbers);
	}
	return "FotografoPage";
    }

    @RequestMapping(value = "/album/{id}")
    public String albumPage(@PathVariable("id") Long id, Model model, @RequestParam("page") Optional<Integer> page,
	    @RequestParam("size") Optional<Integer> size) {
	Album a = this.albumService.albumPerId(id);
	model.addAttribute("album", a);
	int currentPage = page.orElse(1);
	int pageSize = size.orElse(35);

	Page<Foto> fotoAlbumPage = fotoService.findPaginated(PageRequest.of(currentPage - 1, pageSize),
		this.fotoService.tuttePerAlbum(a));

	model.addAttribute("fotoAlbumPage", fotoAlbumPage);

	int totalPages = fotoAlbumPage.getTotalPages();
	if (totalPages > 0) {
	    List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
	    model.addAttribute("pageNumbers", pageNumbers);
	}
	return "SingoloAlbumPage";
    }

}
