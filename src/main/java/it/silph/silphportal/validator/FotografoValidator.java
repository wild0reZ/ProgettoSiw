package it.silph.silphportal.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.silph.silphportal.model.Fotografo;

@Component
public class FotografoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
	return Fotografo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "errore");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "errore");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bio", "errore");
    }

}
