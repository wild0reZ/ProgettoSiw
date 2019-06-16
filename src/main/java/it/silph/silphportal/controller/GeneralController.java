package it.silph.silphportal.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class GeneralController {

    @RequestMapping("/noFoto")
    public String noFotoPage() {
	return "NoFotoPage.html";
    }
}
