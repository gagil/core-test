package org.gagl.core;


import org.gagl.core.modelo.Persona;
import org.gagl.core.servicio.GeneralService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
		
	
	private Persona entidad;
	
	
    public static void main( String[] args )
    {
    	ApplicationContext appContext= new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
    	GeneralService ds=(GeneralService) appContext.getBean("generalServiceImpl");
    	
    	App objeto=new App();
    	
    	objeto.insertaPersona(ds);
    	objeto.actualizaPersona(ds);
    	    	
    	
    }
    
    public void insertaPersona(GeneralService ds){
    	try{
    		
    		entidad=new Persona();
    		entidad.setId(1);
    		entidad.setNombre("Pele");
    		entidad.setDireccion("Mexico");
    		
    		ds.guardaPersona(entidad);
    		
    	}catch(Exception e){
    		
    	}    	
    	
    }
    
    public void actualizaPersona(GeneralService ds){
    	
    	try{
    		entidad.setDireccion("Brazil");
    		ds.actualizaPersona(entidad);
    		
    	}catch(Exception e){
    		
    	}
    }   

	public Persona getEntidad() {
		return entidad;
	}

	public void setEntidad(Persona entidad) {
		this.entidad = entidad;
	}
	
	
    
    
}
