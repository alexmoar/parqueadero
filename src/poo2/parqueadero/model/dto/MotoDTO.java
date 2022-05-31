package poo2.parqueadero.model.dto;

public class MotoDTO extends VehiculoDTO {

	private String tipo;

	


	public MotoDTO() { 
		
	}

	public MotoDTO(String placa, String modelo, String marca, String cilindraje,String tipo, int estado) {
		super(placa, modelo, marca, cilindraje, estado);
		// TODO Auto-generated constructor stub
		this.tipo=tipo;
	}

	public String getTipo() {
		return tipo;
	}
 
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
