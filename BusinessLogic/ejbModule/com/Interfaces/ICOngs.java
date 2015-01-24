package com.Interfaces;

import java.util.List;

import com.Entities.ONG;

public interface ICOngs {
	 void AltaOng(ONG o);
	 List<ONG> ListarOngs();
	 ONG getONG(int idOng);
	 void ActualizarOng(ONG o, Integer idOng);
	 Integer maxOngId();
}
