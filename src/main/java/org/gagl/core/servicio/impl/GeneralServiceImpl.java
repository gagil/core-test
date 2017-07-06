package org.gagl.core.servicio.impl;

import org.gagl.core.modelo.Persona;
import org.gagl.core.servicio.GeneralService;
import org.gagl.fwk.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneralServiceImpl implements GeneralService {

	@Autowired
	private Dao dao;
	
	@Transactional(rollbackFor = Exception.class)
	public void guardaPersona(Persona pEntity) throws Exception {
		this.dao.save(pEntity);
		
	}

	@Transactional(rollbackFor = Exception.class)
	public void actualizaPersona(Persona pEntity) throws Exception {
		this.dao.update(pEntity);
	}


}
