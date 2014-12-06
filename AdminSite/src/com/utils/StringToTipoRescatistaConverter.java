package com.utils;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.Controllers.CUsuarios;
import com.Entities.TipoRescatista;
import com.Interfaces.ICUsuarios;

public class StringToTipoRescatistaConverter implements Converter<String, TipoRescatista> {

	 
	@Override
	public TipoRescatista convert(String option) {
        if (option == null){
	            throw new ConversionFailedException(TypeDescriptor.valueOf(String.class),
	                TypeDescriptor.valueOf(String.class), option, null);
	        }
		        TipoRescatista t = new TipoRescatista();
				ICUsuarios ic = new CUsuarios();
				t = ic.getTipoByID(Integer.parseInt(option));
			        return t;
	    }
	
	
	}

	

