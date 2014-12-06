package Validadores;



import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.models.UsuariosModel;

public class LoginValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UsuariosModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.email", "El campo Mail es Necesario.");
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "El campo Contraseña es Necesario.");		
	
	}

}
