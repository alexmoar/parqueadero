package poo2.parqueadero.model.dto;

public class CarroDTO extends VehiculoDTO {

	

	private int npuertas;

	

	public CarroDTO() {}

	

	public CarroDTO(String placa, String modelo, String marca, String cilindraje, int estado, int npuertas) {
		super(placa, modelo, marca, cilindraje, estado);
		this.npuertas = npuertas;
	}

	public int getNpuertas() {
		return npuertas;
	}

	public void setNpuertas(int npuertas) {
		this.npuertas = npuertas;
	}

	
	
}
