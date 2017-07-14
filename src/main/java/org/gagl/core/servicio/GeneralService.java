package org.gagl.core.servicio;

import java.util.List;

import org.gagl.core.modelo.Persona;

public interface GeneralService {
	public void guardaPersona(Persona pEntity) throws Exception;
	public void actualizaPersona(Persona pEntity) throws Exception;
	public List<Persona> obtenerPersonas() throws Exception;
	public List<Persona> obtenerPersonasPorParametro(String pNombre) throws Exception;
	public List<Persona> obtenerPersonasPorParametroConQueryName(String pNombre) throws Exception;
	public List<Persona> obtenerPersonasPorParametroConQueryNameAndClase(String pNombre) throws Exception;
	public List<Persona> obtenerPersonasPorParametroPorSqlQuery(String pNombre) throws Exception;
}
