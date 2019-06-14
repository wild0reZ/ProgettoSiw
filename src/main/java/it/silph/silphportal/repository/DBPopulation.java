package it.silph.silphportal.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.silph.silphportal.model.Album;
import it.silph.silphportal.model.Fotografo;

/*
 * è un componente della nostra applicazione
 */
@Component
public class DBPopulation implements ApplicationRunner{

	@Autowired
	private FotografoRepository fotografoRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.deleteAll();
		this.addAll();
	}
	
	private void deleteAll() {
		System.out.print("Cancello tutto");
		fotografoRepository.deleteAll();
	}
	
	private void addAll() {
		System.out.print("Aggiungo utenti");
		Fotografo f1 = new Fotografo("Leonardo", "Idone", "Un bravo ragazzo");
		Album a1 = new Album("Album di Leo", "Un bell'album");
		populateAlbum(a1);
		f1.getAlbum().add(a1);
		fotografoRepository.save(f1);
	}
	
	private void populateAlbum(Album a) {
	    
	}
	

	
	
}
