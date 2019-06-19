package it.silph.silphportal.repository;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.silph.silphportal.model.Album;
import it.silph.silphportal.model.Foto;
import it.silph.silphportal.model.Fotografo;
import it.silph.silphportal.model.Funzionario;
import it.silph.silphportal.model.Immagine;

/*
 * è un componente della nostra applicazione
 */
@Component
public class DBPopulation implements ApplicationRunner {

	@Autowired
	private FotografoRepository fotografoRepository;

	@Autowired
	private FunzionarioRepository funzionarioRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.deleteAll();
		this.addAll();
	}

	private void deleteAll() {
		System.out.println("DEVDEBUG: Cancello tutto!");
		this.fotografoRepository.deleteAll();
	}

	private void addAll() throws IOException {
		System.out.println("DEVDEBUG: Aggiungo funzionari!");
		
		Funzionario f1 = new Funzionario(1L, "1234", null, "FUNZIONARIO");
		String passwordF1 = new BCryptPasswordEncoder().encode("1234");
		f1.setPassword(passwordF1);
		f1 = this.funzionarioRepository.save(f1);
		
		Funzionario f2 = new Funzionario(1L, "1111", null, "FUNZIONARIO");
		String passwordF2 = new BCryptPasswordEncoder().encode("4321");
		f2.setPassword(passwordF2);
		f2 = this.funzionarioRepository.save(f2);

		System.out.println("DEVDEBUG: Funzionari aggiunti!");
		
		System.out.println("DEVDEBUG: Aggiungo fotografi!");
		Fotografo fo1 = new Fotografo("Leonardo", "Idone", "Un bravo ragazzo.");
		Fotografo fo2 = new Fotografo("Maria", "Doe", "Fotografo per matrimoni");
		Fotografo fo3 = new Fotografo("Julia", "Peace", "Fotografo per passione");
		Fotografo fo4 = new Fotografo("Travis", "McKean", "Food photographer");
		
		Album a1 = new Album("Album di Leo", "Un bell'album");
		Album a2 = new Album("Album di John", "Foto Varie");
		Album a3 = new Album("Album di Norman", "La mia vita");
		Album a4 = new Album("Album di Travis", "Something..");
		
		populateAlbum(a1, fo1, 1);
		populateAlbum(a2, fo2, 11);
		populateAlbum(a3, fo3, 22);
		populateAlbum(a4, fo4, 33);
		
		
		fo1.getAlbum().add(a1);
		fo1.setImmagineProfilo(new Immagine(extractBytes("fExample1.jpg")));
		a1.setFotografo(fo1);
		
		fo2.getAlbum().add(a2);
		fo2.setImmagineProfilo(new Immagine(extractBytes("fExample2.jpg")));
		a2.setFotografo(fo2);
		
		fo3.getAlbum().add(a3);
		fo3.setImmagineProfilo(new Immagine(extractBytes("fExample3.jpg")));
		a3.setFotografo(fo3);
		
		fo4.getAlbum().add(a4);
		fo4.setImmagineProfilo(new Immagine(extractBytes("fExample4.jpg")));
		a4.setFotografo(fo4);
		
		this.fotografoRepository.save(fo1);
		this.fotografoRepository.save(fo2);
		this.fotografoRepository.save(fo3);
		this.fotografoRepository.save(fo4);
		System.out.println("DEVDEBUG: Fotografi aggiunti!");
	}

	private void populateAlbum(Album a, Fotografo f, int numeroFoto) throws IOException {

		for (int i = numeroFoto; i <= (numeroFoto+10); i++) {
	    Foto foto = new Foto("Foto " + i,
		    LocalDate.now().minusDays(ThreadLocalRandom.current().nextLong(100L)),
					new Immagine(extractBytes("example" + i + ".jpg")));
			foto.setFotografo(f);
			a.addFoto(foto);
		}
	}

	public byte[] extractBytes(String imageName) throws IOException {
		InputStream in = new ClassPathResource("static/SampleData/" + imageName).getInputStream();
		return IOUtils.toByteArray(in);
	}

}