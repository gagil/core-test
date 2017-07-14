package org.gagl.core;

import java.util.Iterator;
import java.util.List;

import org.gagl.core.modelo.Persona;
import org.gagl.core.servicio.GeneralService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private Persona entidad;

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
		GeneralService ds = (GeneralService) appContext.getBean("generalServiceImpl");

		App objeto = new App();

		

		//objeto.insertaPersona(ds);
		// objeto.actualizaPersona(ds);
		objeto.obtenerPersonas(ds);
		objeto.obtenerPersonasPorParametro(ds);
		objeto.obtenerPersonasPorParametroAndQueryName(ds);
		objeto.obtenerPersonasPorParametroAndClase(ds);
		objeto.obtenerPersonasPorParametroAndQueryName(ds);
		objeto.obtenerPersonasPorParametroAndClase(ds);
		objeto.obtenerPersonasPorParametroAndClasePorSqlQuery(ds);

	}

	public void insertaPersona(GeneralService ds) {
		try {

			entidad = new Persona();
			entidad.setId(2);
			entidad.setNombre("jose");
			entidad.setDireccion("argentina");

			ds.guardaPersona(entidad);

		} catch (Exception e) {

		}

	}

	public void actualizaPersona(GeneralService ds) {

		try {
			entidad.setDireccion("Brazil");
			ds.actualizaPersona(entidad);

		} catch (Exception e) {

		}
	}

	public Persona getEntidad() {
		return entidad;
	}

	public void setEntidad(Persona entidad) {
		this.entidad = entidad;
	}

	public void obtenerPersonas(GeneralService ds) {
		try {
			List<Persona> lista = ds.obtenerPersonas();
			
			for (Persona fila : lista) {

				System.out.println("Id--------:" + fila.getId());
				System.out.println("Nombre----:" + fila.getNombre());
				System.out.println("Direccion-:" + fila.getDireccion());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void obtenerPersonasPorParametro(GeneralService ds) {
		try {

			List<Persona> lista = ds.obtenerPersonasPorParametro("suave");

			System.out.println(
					"Obtener lista por query name y por parametro. retorna una lista de entidades tipo persona");
			for (Persona fila : lista) {

				System.out.println("Id--------:" + fila.getId());
				System.out.println("Nombre----:" + fila.getNombre());
				System.out.println("Direccion-:" + fila.getDireccion());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void obtenerPersonasPorParametroAndQueryName(GeneralService ds) {
		try {

			List lista = ds.obtenerPersonasPorParametroConQueryName("suave");
			System.out.println("Obtener lista por query name y por parametro. retorna una lista de objetos");
			// Iterator it=lista.iterator();

			for (Iterator it = lista.iterator(); it.hasNext();) {
				Object obj[] = (Object[]) it.next();
				System.out.println("Id--------:" + obj[0].toString());
				System.out.println("Nombre----:" + obj[1].toString());
				System.out.println("Direccion-:" + obj[2].toString());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void obtenerPersonasPorParametroAndClase(GeneralService ds) {
		try {

			List<Persona> lista = ds.obtenerPersonasPorParametroConQueryNameAndClase("suave");
			System.out.println(
					"Obtener lista por query name y por parametro. retorna una lista de entidades tipo persona");
			for (Persona fila : lista) {

				System.out.println("Id--------:" + fila.getId());
				System.out.println("Nombre----:" + fila.getNombre());
				System.out.println("Direccion-:" + fila.getDireccion());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void obtenerPersonasPorParametroAndClasePorSqlQuery(GeneralService ds) {
		try {

			List<Persona> lista = ds.obtenerPersonasPorParametroPorSqlQuery("suave");
			System.out.println("Obtener lista por sql puro, con parametros y por entidades");
			for (Persona fila : lista) {

				System.out.println("Id--------:" + fila.getId());
				System.out.println("Nombre----:" + fila.getNombre());
				System.out.println("Direccion-:" + fila.getDireccion());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
