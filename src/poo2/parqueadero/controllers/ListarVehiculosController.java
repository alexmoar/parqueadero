package poo2.parqueadero.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import poo2.parqueadero.model.ParqueaderoFachada;

public class ListarVehiculosController  implements Initializable {

	@FXML
	public TextArea txtAreaLista;
	
	private ParqueaderoFachada p;
	

	public ListarVehiculosController( ) {
		p=p.getInstance();
		p.conectarCarro();
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		txtAreaLista.setText(p.consultarCarro());
	}
}
