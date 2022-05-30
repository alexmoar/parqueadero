package poo2.parqueadero.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class IngresarCarroController implements Initializable  {
		@FXML
		private TextField txtPlaca;
		@FXML
		private TextField txtModelo;
		@FXML
		private ComboBox<Integer> cbPuertas;
		@FXML
		private ComboBox<Integer> cbCilindraje;
		@FXML
		private ComboBox<String> cbxMarca;
		@FXML
		private ComboBox<String> cbEstado;
		@FXML
		private Button btnAceptar;
		@FXML
		private Button btnLimpiar;
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			ArrayList<Integer> lista =new ArrayList<>();
			Collections.addAll(lista, new Integer[] { 1000,1200,1500,2000});
			cbCilindraje.getItems().addAll(lista);
			

			ArrayList<Integer> listaPuerta =new ArrayList<>();
			Collections.addAll(listaPuerta, new Integer[] { 2,3,4,5});
			cbPuertas.getItems().addAll(listaPuerta);
			
			ArrayList<String> listaMarca =new ArrayList<>();
			Collections.addAll(listaMarca, new String[] {"audi"});
			cbxMarca.getItems().addAll(listaMarca);
			
			ArrayList<String> estado =new ArrayList<>();
			Collections.addAll(estado, new String[] { "Activo","Desactivo"});
			cbEstado.getItems().addAll(estado);
			
		}

		@FXML
		private void comboboxEvent(ActionEvent e) {
			
			Object evt = e.getSource();
			if(evt.equals(cbxMarca)) {
				
				String marca= cbxMarca.getSelectionModel().getSelectedItem();
				System.out.println(marca);
			}
			else if (evt.equals(cbCilindraje)) {
				
				Integer cilindreaje= cbCilindraje.getSelectionModel().getSelectedItem();
				System.out.println(cilindreaje);
			}
			else if (evt.equals(cbPuertas)) {
				
				Integer puertas= cbPuertas.getSelectionModel().getSelectedItem();
				System.out.println(puertas);
			}
			else if (evt.equals(cbEstado)) {
				
				String estado= cbEstado.getSelectionModel().getSelectedItem();
				System.out.println(estado);
			}
		}
		
	}


