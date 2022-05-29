package poo2.parqueadero.model;

public class Carro {
	
	private String placa;
	private String modelo;
	private String marca;
	private String cilindraje;
	private int puertas;
	private int estado;
	
	
	public Carro(String placa, String modelo, String marca, String cilindraje, int puertas, int estado) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.cilindraje = cilindraje;
		this.puertas = puertas;
		this.estado = estado;
		
		
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


	public int getPuertas() {
		return puertas;
	}


	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}
	

}
