package it.silph.silphportal.repository;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import it.silph.silphportal.model.Album;
import it.silph.silphportal.model.Foto;
import it.silph.silphportal.model.Fotografo;

/*
 * è un componente della nostra applicazione
 */
@Component
public class DBPopulation implements ApplicationRunner {

    @Autowired
    private FotografoRepository fotografoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
	this.deleteAll();
	this.addAll();
    }

    private void deleteAll() {
	System.out.println("DEVDEBUG: Cancello tutto!");
	fotografoRepository.deleteAll();
    }

    private void addAll() throws IOException {
	System.out.println("DEVDEBUG: Aggiungo fotografi!");
	Fotografo f1 = new Fotografo("Leonardo", "Idone", "Un bravo ragazzo");
	Album a1 = new Album("Album di Leo", "Un bell'album");
	populateAlbum(a1);
	f1.getAlbum().add(a1);
	f1.setImmagineProfilo(extractBytes("fExample1.jpg"));
	fotografoRepository.save(f1);
    }

    private void populateAlbum(Album a) throws IOException {
	for (int i = 1; i <= 11; i++) {
	    a.getFoto().add(new Foto("Bella Foto" + i, "Gran Foto", LocalDate.now().minusDays(i),
		    extractBytes("example" + i + ".jpg")));
	}
    }

    public byte[] extractBytes(String ImageName) throws IOException {
	// open image
	InputStream imgPath = new ClassPathResource("static/SampleData/" + ImageName).getInputStream();
	BufferedImage bufferedImage = ImageIO.read(imgPath);

	// get DataBufferBytes from Raster
	WritableRaster raster = bufferedImage.getRaster();
	DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

	return (data.getData());
    }

}
