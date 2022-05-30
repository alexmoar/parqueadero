package poo2.parqueadero.model;

public class CarroDto extends VehiculoDto{
	
	
	
	private int puertas;
	private int estado;
	
	public CarroDto(String placa, String modelo, String marca, String cilindraje, int puertas, int estado) {
		super(placa, modelo, marca, cilindraje);
		this.puertas = puertas;
		this.estado = estado;
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

	@Override
	public String toString() {
		return "Carro [puertas=" + puertas + ", estado=" + estado + "]";
	}

	
	
	
	
		
		
	

}
