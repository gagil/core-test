package org.gagl.core.servicio.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gagl.core.modelo.Persona;
import org.gagl.core.servicio.GeneralService;
import org.gagl.fwk.dao.Dao;
import org.gagl.fwk.dao.DaoFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneralServiceImpl implements GeneralService {

	@Autowired
	private Dao dao;
	@Autowired
	private DaoFinder daoFinder;
	
	@Transactional(rollbackFor = Exception.class)
	public void guardaPersona(Persona pEntity) throws Exception {
		this.dao.save(pEntity);
		
	}

	@Transactional(rollbackFor = Exception.class)
	public void actualizaPersona(Persona pEntity) throws Exception {
		this.dao.update(pEntity);
	}

	@Transactional(readOnly=true)
	@Override
	public List obtenerPersonas() throws Exception {
		
		List<Object> lista=this.daoFinder.findByQueryName("findPersona",Persona.class);
		
		return lista;
	}		
		
	@Transactional(readOnly=true)
	@Override
	public List obtenerPersonasPorParametroConQueryName(String pNombre) throws Exception {
		
		Map<Integer,Object> pParams=new HashMap<>();
		pParams.put(0, pNombre);
		List lista=this.daoFinder.findByQueryName("findPersonasPorNombre",pParams);
		
		return lista;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Persona> obtenerPersonasPorParametroConQueryNameAndClase(String pNombre) throws Exception {
		
		Map<Integer,Object> pParams=new HashMap<>();
		pParams.put(0, pNombre);
		List<Persona> lista=this.daoFinder.findByQueryName("findPersonasPorNombre",pParams,Persona.class);
		
		return lista;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Persona> obtenerPersonasPorParametro(String pNombre) throws Exception {
		
		//String sql="Select * from persona where nombre='"+pNombre+"'";
		String sql="Select * from persona ";
		
		List<Persona> listaEntidad=this.daoFinder.findBySqlQuery(sql, Persona.class);		
		
		return listaEntidad;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Persona> obtenerPersonasPorParametroPorSqlQuery(String pNombre) throws Exception {
		
		String sql="Select * from persona where nombre=?";
		Map<Integer,Object> pParams=new HashMap<>();
		pParams.put(0, pNombre);
		
		List<Persona> listaEntidad=this.daoFinder.findBySqlQuery(sql, pParams,Persona.class);		
		
		return listaEntidad;
	}	
}
