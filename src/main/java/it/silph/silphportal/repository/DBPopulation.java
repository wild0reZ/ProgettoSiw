package it.silph.silphportal.repository;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.silph.silphportal.model.Funzionario;

/*
 * è un componente della nostra applicazione
 */
@Component
public class DBPopulation implements ApplicationRunner {

	@Autowired
	private FunzionarioRepository funzionarioRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.deleteAll();
		this.addAll();
	}

	private void deleteAll() {
		System.out.println("DEVDEBUG: Cancello tutto!");
		this.funzionarioRepository.deleteAll();
	}

	private void addAll() throws IOException {
		System.out.println("DEVDEBUG: Aggiungo funzionari!");
		Funzionario f1 = new Funzionario("1234", "1234");
		Funzionario f2 = new Funzionario("1111", "1234");
		this.funzionarioRepository.save(f1);
		this.funzionarioRepository.save(f2);
		System.out.println("DEVDEBUG: Funzionari aggiunti!");
	}

}