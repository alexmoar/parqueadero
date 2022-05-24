package poo2.parqueadero.model;

import h2.H2CREAR;

public class ParqueaderoFachada {
	H2CREAR h2Example = new H2CREAR();
	
	
	
	public void crearCarro(String placa, String modelo, String marca, String cilindraje, int puertas, int estado) {
		
		Carro carro = new Carro(cilindraje, cilindraje, cilindraje, cilindraje, estado, estado);
		
	}
	
	public void crearMoto(String placa, String modelo, String marca, String cilindraje, String puertas, int estado) {
		
		Moto moto = new Moto(placa, modelo, marca, cilindraje, puertas, estado);
		
	}
}
