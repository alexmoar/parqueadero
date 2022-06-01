package poo2.parqueadero.model.dto;
import java.util.*;
public class VehiculoDTO {


	private String placa;
	private String modelo;
	private String marca;
	private String cilindraje;
	private int estado;
	public static ArrayList<VehiculoDTO> vehiculos = new ArrayList<>();
	
 public VehiculoDTO() {}
	
	 
public VehiculoDTO(String placa, String modelo, String marca, String cilindraje, int estado) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.cilindraje = cilindraje;
		this.estado = estado;
	}

public void imprimir() {
	
	for (int i = 0; i < vehiculos.size(); i++) {
			VehiculoDTO v= vehiculos.get(i);
			System.out.println(v.getPlaca());
			System.out.println(v.getMarca());
			System.out.println(v.getModelo());
			System.out.println(v.getCilindraje());
			System.out.println(v.getEstado());
			
	}
}
	public String getPlaca() {
		return placa;
	} 
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}


	public static ArrayList<VehiculoDTO> getVehiculos() {
		return vehiculos;
	}


	public static void setVehiculos(ArrayList<VehiculoDTO> vehiculos) {
		VehiculoDTO.vehiculos = vehiculos;
	}
	
	
	
}
