package it.silph.silphportal.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import it.silph.silphportal.model.Immagine;
import it.silph.silphportal.service.AlbumService;
import it.silph.silphportal.utils.SilphUtils;
import it.silph.silphportal.validator.FotoValidator;

@Controller
public class AlbumController {
	@Autowired
	private AlbumService albumService;
	@Autowired
	private FotoValidator fotoValidator;

	@RequestMapping(value = "/listAlbum", method = RequestMethod.GET)
	public String listAlbum(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(10);

		Page<Album> albumPage = albumService.findPaginated(PageRequest.of(currentPage - 1, pageSize),
				this.albumService.tuttiPerData());

		model.addAttribute("albumPage", albumPage);

		int totalPages = albumPage.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		return "AlbumsPage";
	}

	@RequestMapping(value = "/album/{id}/newFoto", method = RequestMethod.GET)
	public String newFoto(@PathVariable("id") Long id, Model model) {
		model.addAttribute("album", this.albumService.albumPerId(id));
		if (!model.containsAttribute("foto")) {
			model.addAttribute("foto", new Foto());
		}
		model.addAttribute("immagine", new Immagine());
		return "AddFotoPage.html";
	}

	@RequestMapping(value = "/album/{id}/foto", method = RequestMethod.POST)
	public String addNewFoto(@PathVariable("id") Long id, @Valid @ModelAttribute("foto") Foto foto,
			BindingResult result, @ModelAttribute("immagine") Immagine immagine,
			@RequestParam("multipart") MultipartFile mpf, RedirectAttributes rAttribute) throws IOException {
		this.fotoValidator.validate(foto, result);
	boolean isImage = SilphUtils.isImage(mpf);
	if (!result.hasErrors() && isImage) {
			immagine.setFileImmagine(mpf.getBytes());
			foto.setImmagine(immagine);
			foto.setFotografo(this.albumService.albumPerId(id).getFotografo());
			this.albumService.addFoto(id, foto);
			this.albumService.inserisci(this.albumService.albumPerId(id));
			return "OperazioneCompletataPage.html";
		}
		rAttribute.addFlashAttribute("org.springframework.validation.BindingResult.foto", result);
	if(!isImage)
	    rAttribute.addFlashAttribute("erroreFile", "Formato file non supportato");
		rAttribute.addFlashAttribute("foto", foto);
		return "redirect:/album/{id}/newFoto";
	}
}
