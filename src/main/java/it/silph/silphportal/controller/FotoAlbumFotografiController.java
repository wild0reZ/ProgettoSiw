package it.silph.silphportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.silph.silphportal.service.AlbumService;
import it.silph.silphportal.service.FotoService;
import it.silph.silphportal.service.FotografoService;

@Controller
public class FotoAlbumFotografiController {

    @Autowired
    private FotografoService fotografoService ;
    
    @Autowired
    private AlbumService albumService ;
    
    @Autowired
    private FotoService fotoService ;
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @Transactional
    public String homePageFoto(Model model) {
	model.addAttribute("gruppoFoto", this.fotoService.prime9PerData());
	model.addAttribute("gruppoAlbum", this.albumService.primi10PerDataFraTutte());
	model.addAttribute("gruppoFotografi", this.fotografoService.primi9PerData());
	return "HomePage";
    }

}
