package it.silph.silphportal.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.silph.silphportal.model.Modulo;

@Component
public class ModuloValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
	return Modulo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oggetto", "errore");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "messaggio", "errore");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeCliente", "errore");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognomeCliente", "errore");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "errore");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "errore");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "errore");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "citta", "errore");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nazione", "errore");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "CAP", "errore");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeAzienda", "errore");
    }

}
