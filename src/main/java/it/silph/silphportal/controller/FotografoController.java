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

import it.silph.silphportal.model.Fotografo;
import it.silph.silphportal.service.FotografoService;

@Controller
public class FotografoController {
    @Autowired
    private FotografoService fotografoService;

    @RequestMapping(value = "/listFotografo", method = RequestMethod.GET)
    public String listFotografo(Model model, @RequestParam("page") Optional<Integer> page,
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
}
