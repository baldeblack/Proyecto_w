package Validadores;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.models.OngModel;

public class OngValidador implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {	
		return OngModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
				"required.nombre", "El campo Nombre es Necesario.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.email", "El campo Email es Necesario.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "origen",
				"required.origen", "El campo Origen es Necesario.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccion",
				"required.direccion", "El campo Direccion es Necesario.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono",
				"required.telefono", "El campo Telefono es Necesario.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "web",
				"required.web", "El campo Web es Necesario.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "datosPayPal",
				"required.datosPayPal", "El campo Datos PayPal es Necesario.");
		
	}

}
