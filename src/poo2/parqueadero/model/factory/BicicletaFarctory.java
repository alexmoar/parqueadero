package poo2.parqueadero.model.factory;

import poo2.parqueadero.model.dto.BicicletaApi;
import poo2.parqueadero.model.dto.VehiculoDTO;

public class BicicletaFarctory implements VehiculoFactory {

	@Override
	public VehiculoDTO crearVehiculo() {
		BicicletaApi dto = new BicicletaApi();
		return dto;
	}


}
