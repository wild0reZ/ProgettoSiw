package it.silph.silphportal.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.silph.silphportal.model.Foto;

@Component
public class FotoValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
	return Foto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titoloFoto", "errore");
    }

}
