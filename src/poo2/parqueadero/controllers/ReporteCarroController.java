package poo2.parqueadero.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class ReporteCarroController implements IController{

	@FXML private TextField txtContadorCarros;
	
	private ControllersPool pool;
	
	public ReporteCarroController() {
		pool = ControllersPool.getInstance();
		pool.guardarInstanciaControlador("RC", this);
	}
	
	public void aumentarContadorCarros() {
		
		int contador = 0;
		
		if(!txtContadorCarros.getText().isEmpty()) {
		
			contador = Integer.parseInt(txtContadorCarros.getText());
			contador = contador+1;
		}
			
		txtContadorCarros.setText(""+contador);
	}
}
