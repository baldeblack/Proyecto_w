package com.utils;

import java.util.Calendar;
import java.util.Date;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String option) {
        if (option == null){
	            throw new ConversionFailedException(TypeDescriptor.valueOf(String.class),
	                TypeDescriptor.valueOf(String.class), option, null);
	        }
                
       String dateStr [] = option.split("-");
       
       Calendar cal = Calendar.getInstance();
       cal.set(Calendar.YEAR, (Integer.parseInt(dateStr[0])));
       cal.set(Calendar.MONTH, (Integer.parseInt(dateStr[1])));
       cal.set(Calendar.DAY_OF_MONTH, (Integer.parseInt(dateStr[2])));
       Date dateRepresentation = cal.getTime();           
		       
			        return dateRepresentation;
	    }
	
}
