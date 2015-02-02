package com.Utilities;

import com.Controllers.CReporte;
import com.Helper.RptType;
import com.Interfaces.ICReporte;

public class LogHelper {
	
	private LogHelper(){
		
	}
	
	public static int Loged(String connection, RptType type){
		ICReporte cont = new CReporte();
		return cont.InsertUpdateRptData(connection, type);
	}
	
	public static  int HelpLoged(String connection){
		ICReporte cont = new CReporte();
		return cont.InsertUpdateRptData(connection, RptType.Ayuda);
	}
	
	public static  int DonationLoged(String connection){
		ICReporte cont = new CReporte();
		return cont.InsertUpdateRptData(connection, RptType.Donacion);
	}
	
	public static  int LostLoged(String connection){
		ICReporte cont = new CReporte();
		return cont.InsertUpdateRptData(connection, RptType.Desaparecido);
	}
	
	public static  int RegistroLoged(String connection){
		ICReporte cont = new CReporte();
		return cont.InsertUpdateRptData(connection, RptType.Usuario);
	}

}
