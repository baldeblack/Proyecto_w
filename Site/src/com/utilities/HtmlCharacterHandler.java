package com.utilities;

public class HtmlCharacterHandler {

	public static String Parse(String input){
		
		return input.replace("<", "&lt;").replace(">", "&gt;").replace("&", "&amp;").replace("¡", "&iexcl;").replace("¿", "&iquest;")
				.replace("®", "&reg;").replace("©", "&copy;").replace("€", "&euro;").replace("á", "&aacute;").replace("é", "&eacute;")
				.replace("í", "&iacute;").replace("ó", "&oacute;").replace("ú", "&uacute;").replace("ñ", "&ntilde;").replace("ü", "&uuml;")
				.replace("Á", "&Aacute;").replace("É", "&Eacute;").replace("Í", "&Iacute;").replace("Ó", "&Oacute;").replace("Ú","&Uacute;")
				.replace("Ñ", "&Ntilde;").replace("Ü", "&Uuml;");
		
	}
}
