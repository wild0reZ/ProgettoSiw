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
import org.springframework.stereotype.Component;

import it.silph.silphportal.model.Album;
import it.silph.silphportal.model.Foto;
import it.silph.silphportal.model.Fotografo;
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
	Funzionario f1 = new Funzionario("1234", "1234");
	Funzionario f2 = new Funzionario("1111", "1234");
	this.funzionarioRepository.save(f1);
	this.funzionarioRepository.save(f2);
	System.out.println("DEVDEBUG: Funzionari aggiunti!");
	System.out.println("DEVDEBUG: Aggiungo fotografi!");
	Fotografo f1 = new Fotografo("Leonardo", "Idone", "Un bravo ragazzo.");
	Album a1 = new Album("Album di Leo", "Un bell'album");
	populateAlbum(a1, f1);
	f1.getAlbum().add(a1);
	f1.setImmagineProfilo(new Immagine(extractBytes("fExample1.jpg")));
	a1.setFotografo(f1);
	this.fotografoRepository.save(f1);
	System.out.println("DEVDEBUG: Fotografi aggiunti!");
    }

    private void populateAlbum(Album a, Fotografo f) throws IOException {
	for (int i = 1; i <= 11; i++) {
	    Foto foto = new Foto( 
		    "Bella Foto " + i,
		    "Gran Foto", LocalDate.now().minusDays(ThreadLocalRandom.current().nextLong(100L)),
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