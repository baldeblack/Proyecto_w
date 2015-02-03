package com.utilities;

public class HtmlCharacterHandler {

	public static String Parse(String input){
		
		return input.replace("<", "&lt;").replace(">", "&gt;").replace("&", "&amp;").replace("�", "&iexcl;").replace("�", "&iquest;")
				.replace("�", "&reg;").replace("�", "&copy;").replace("�", "&euro;").replace("�", "&aacute;").replace("�", "&eacute;")
				.replace("�", "&iacute;").replace("�", "&oacute;").replace("�", "&uacute;").replace("�", "&ntilde;").replace("�", "&uuml;")
				.replace("�", "&Aacute;").replace("�", "&Eacute;").replace("�", "&Iacute;").replace("�", "&Oacute;").replace("�","&Uacute;")
				.replace("�", "&Ntilde;").replace("�", "&Uuml;");
		
	}
}
