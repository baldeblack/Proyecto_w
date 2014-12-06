package Validadores;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.models.CatastrofeModel;

public class CatastrofeValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return CatastrofeModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dominio",
				"required.dominio", "El campo Dominio es Necesario.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "informacion",
				"required.informacion", "El campo Informacion es Necesario.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
				"required.nombre", "El campo Nombre es Necesario.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zonaAfectada",
				"required.zonaAfectada", "Debe especifica una Zona Afectada.");

		CatastrofeModel cast = (CatastrofeModel) target;

		if (cast.getZonaAfectada().equals("[]")) {
			errors.rejectValue("zonaAfectada", "required.zona");
		}

		if (cast.getLogo().isEmpty()) {
			errors.rejectValue("logo", "required.file");
		}

		try {
			MultipartFile f = cast.getMultiUploadedFileList().get(0);
			if (f.getSize() == 0) {
				errors.reject("required.Imagen");
			}
		} catch (Exception e) {
			errors.reject("required.Imagen");
		}

//		try {
//			if (cast.getPalabrasList().size() <= 0) {
//				errors.reject("required.Claves");
//			}
//		} catch (Exception e) {
//			cast.setPalabrasList(new ArrayList<String>());
//			errors.reject("required.Claves");
//		}

//		try {
//			if (cast.getFuenteDedatosMod().size() <= 0) {
//				errors.reject("required.Fuentes");
//			}
//		} catch (Exception e) {
//			cast.setFuenteDedatos(new ArrayList<String>());
//			errors.reject("required.Fuentes");
//		}

	}

}
