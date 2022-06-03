package poo2.parqueadero.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import poo2.parqueadero.model.ParqueaderoFachada;
import poo2.parqueadero.model.Suscrictor;


public class ReporteCarroController implements Suscrictor,Initializable{

	@FXML private TextField txtContadorCarros;
	
	public ControllersPool pool;
	public ParqueaderoFachada fa;
	
	
	
	public ReporteCarroController() {
		fa=ParqueaderoFachada.getInstance();
	
		fa.subscribe(this);
	}
	
	public void aumentarContadorCarros() {
		
		int contador = 0;
		
		if(!txtContadorCarros.getText().isEmpty()) {
		
			contador = Integer.parseInt(txtContadorCarros.getText());
			contador = contador+1;
		}
			
		txtContadorCarros.setText(""+contador);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		fa=ParqueaderoFachada.getInstance();
		fa.subscribe(this);
	}

	@Override
	public void actualizar(String notificacion) {
		// TODO Auto-generated method stub
		this.aumentarContadorCarros();
	}
}
