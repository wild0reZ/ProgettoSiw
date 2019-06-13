package it.silph.silphportal.controller;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.silph.silphportal.model.Foto;
import it.silph.silphportal.service.FotoService;

@Controller
public class FotoController {
    @Autowired
    private FotoService fotoService;

    @RequestMapping(value = "/foto/img", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImmagineFoto() {
	HttpHeaders headers = new HttpHeaders();
	//headers.setContentType(MediaType.IMAGE_PNG);
	byte[] img = this.fotoService.fotoPerId(1L).getImmagine();
	return new ResponseEntity<>(img, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/foto", method = RequestMethod.GET)
    public String getFoto( Model model) {
	Foto foto = this.fotoService.fotoPerId(1L);
	model.addAttribute("foto", foto);
	return "FotoPage";
    }



    @RequestMapping(value = "/foto", method = RequestMethod.POST)
    public String newFoto(@RequestParam("multipartFoto") MultipartFile mpFoto, @ModelAttribute("foto") Foto foto,
	    Model model) throws IOException {
	foto.setDataInserimento(LocalDate.now());
	foto.setImmagine(mpFoto.getBytes());
	this.fotoService.aggiungiFoto(foto);
	model.addAttribute("foto", foto);
	return "FotoPage";
    }

    @RequestMapping(value = "/addFoto")
    public String addFoto(Model model) {
	model.addAttribute("foto", new Foto());
	return "FormFoto";
    }

}
