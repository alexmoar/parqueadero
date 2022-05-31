package poo2.parqueadero.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import poo2.parqueadero.model.ParqueaderoFachada;

public class IngresarCarroController implements Initializable {
	@FXML
	private TextField txtPlaca;
	@FXML
	private TextField txtModelo;
	@FXML
	private ComboBox<Integer> cbPuertas;
	@FXML
	private ComboBox<String> cbCilindraje;
	@FXML
	private ComboBox<String> cbxMarca;
	@FXML
	private ComboBox<String> cbEstado;
	

	private ParqueaderoFachada f;

	@Override

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method 


		ArrayList<String> lista = new ArrayList<>();
		Collections.addAll(lista, new String[] { "1000", "1200", "1500", "2000" });
		cbCilindraje.getItems().addAll(lista);

		ArrayList<Integer> listaPuerta = new ArrayList<>();
		Collections.addAll(listaPuerta, new Integer[] { 2, 3, 4, 5 });
		cbPuertas.getItems().addAll(listaPuerta);

		ArrayList<String> listaMarca = new ArrayList<>();
		Collections.addAll(listaMarca, new String[] { "audi" });
		cbxMarca.getItems().addAll(listaMarca);

		ArrayList<String> estado = new ArrayList<>();
		Collections.addAll(estado, new String[] { "Activo", "Inactivo" });
		cbEstado.getItems().addAll(estado);

	}

	public IngresarCarroController() {
		f = f.getInstance();
	}
 
	@FXML
	private void comboboxEvent(ActionEvent e) {

		Object evt = e.getSource();
		if (evt.equals(cbxMarca)) {

			String marca = cbxMarca.getValue();
			System.out.println(marca);
		} else if (evt.equals(cbCilindraje)) {

			String cilindreaje = cbCilindraje.getValue();
			System.out.println(cilindreaje);
		} else if (evt.equals(cbPuertas)) {

			Integer puertas = cbPuertas.getValue();
			System.out.println(puertas);
		} else if (evt.equals(cbEstado)) {

			String estado = cbEstado.getValue();
			System.out.println(estado);
		}
	}

	@FXML
		public  void guardarCarro(ActionEvent ev) throws SQLException {
			
		
			String placa = txtPlaca.getText();
			String modelo= txtModelo.getText();
			String marca = cbxMarca.getValue();
			String cilindraje = cbCilindraje.getValue();	
			int puertas = cbPuertas.getValue();	
			String estado = cbEstado.getValue();	
			int estadoInt=0;
			
			System.out.println(placa);
			System.out.println(modelo);
			System.out.println(marca);
			System.out.println(cilindraje);
			System.out.println(puertas);
			System.out.println(estado);
			System.out.println(estadoInt);
			
			if (estado=="Activo") {
				  estadoInt=1;
				
			}else if (estado=="Inactivo") {
				estadoInt=0;
			}
			System.out.println(estadoInt);
			
				f.agregarCarro(placa, modelo, marca, cilindraje, puertas, estadoInt);
				
		
		}
}
