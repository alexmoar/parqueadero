package poo2.parqueadero.model;

public class VehiculoDto {
	private String placa;
	private String modelo;
	private String marca;
	private String cilindraje;
	
	public VehiculoDto(String placa, String modelo, String marca, String cilindraje) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.cilindraje = cilindraje;
	
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

	@Override
	public String toString() {
		return "VehiculoDto [placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", cilindraje=" + cilindraje
				+ "]";
	}
	
	
	
	
}
