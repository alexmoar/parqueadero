package poo2.parqueadero.model;

public class Moto {

	private String placa;
	private String modelo;
	private String marca;
	private String cilindraje;
	private String puertas;
	private int estado;
	
	public Moto(String placa, String modelo, String marca, String cilindraje, String puertas, int estado) {
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

	public String getPuertas() {
		return puertas;
	}

	public void setPuertas(String puertas) {
		this.puertas = puertas;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
}
