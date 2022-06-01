package poo2.parqueadero.controllers;

import java.util.HashMap;



public class ControllersPool {

	private static ControllersPool instance;
	
	private HashMap<String, IController> listControllers;
	
	private ControllersPool() {
		listControllers = new HashMap<String, IController>();
	}
	
	public static ControllersPool getInstance() {
		if(instance==null)
			instance = new ControllersPool();
		
		return instance;
	}
	
	public void guardarInstanciaControlador(String llave, IController valor) {
		listControllers.put(llave, valor);
	}
	
	public IController obtenerInstanciaControlador(String llave) {
		return listControllers.get(llave);
	}
}
