package Validadores;



import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.models.UsuariosModel;

public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UsuariosModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
//				"required.nombre", "El campo Nombre es Necesario.");
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido",
//				"required.apellido", "El campo Apellido es Necesario.");
//		
//
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
//				"required.email", "El campo email es Necesario.");
//		
//
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
//				"required.password", "El campo Contraseña es Necesario.");
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nick",
//				"required.nick", "El campo Nick es Necesario.");		
//		
//
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sexo",
//				"required.sexo", "El campo Sexo es Necesario.");	
//
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "celular",
//				"required.celular", "El campo Celular es Necesario.");
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccion",
//				"required.direccion", "El campo Direccion es Necesario.");

		UsuariosModel usuM = (UsuariosModel) target;

		if (usuM.getTipoUsuario() == 1 && usuM.getLatLongRecidencia().equals("")) {
			errors.rejectValue("latLongRecidencia", "required.zona");
		}


	}

}
