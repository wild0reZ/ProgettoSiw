package it.silph.silphportal.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.silph.silphportal.model.Album;

@Component
public class AlbumValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
	return Album.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione", "errore");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titoloAlbum", "errore");
    }

}
