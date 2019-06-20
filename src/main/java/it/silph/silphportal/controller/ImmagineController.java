package it.silph.silphportal.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import it.silph.silphportal.service.ImmagineService;

@Controller
public class ImmagineController {

    @Autowired
    private ImmagineService immagineService;

    @GetMapping(value = "/immagine/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageWithMediaType(@PathVariable("id") Long id) throws IOException {
	return this.immagineService.immaginePerId(id).getFileImmagine();
    }

}
