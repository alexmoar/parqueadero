package poo2.parqueadero.model;

import java.util.ArrayList;

import h2.H2CREAR;

import poo2.parqueadero.model.factory.VehiculoFactory;


public class ParqueaderoFachada {
	H2CREAR h2Example = new H2CREAR();
	
	


	private VehiculoFactory vF;
	
	private static ParqueaderoFachada instance;
	
	private ParqueaderoFachada() {
		
	}
	
	public static ParqueaderoFachada getInstance() {
		if(instance==null)
			instance = new ParqueaderoFachada();
		
		return instance;
	}
	
	
	
	public void crearCarro(String placa, String modelo, String marca, String cilindraje, int puertas, int estado) {
		
		
		
	}
	
	public void crearMoto(String placa, String modelo, String marca, String cilindraje, String puertas, int estado) {
		
	
	}
}
