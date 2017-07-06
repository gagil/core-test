package org.gagl.core.servicio;

import org.gagl.core.modelo.Persona;

public interface GeneralService {
	public void guardaPersona(Persona pEntity) throws Exception;
	public void actualizaPersona(Persona pEntity) throws Exception;
}
