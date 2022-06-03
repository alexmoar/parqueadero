package Obsevador;

import poo2.parqueadero.controllers.IController;

public interface Notificador {

	void listeners();


	void eliminarsuscritor();

	

	void notificacion(String tipo);

	void subscribe(IController valor);

}
