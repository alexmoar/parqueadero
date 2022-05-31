package poo2.parqueadero.model.factory;

public class UtilidadesFactory {

public static VehiculoFactory getFactory(String tipoVehiculo){
        
        if (tipoVehiculo.equalsIgnoreCase("moto")) {
            return new MotoFactory();
        }
        else if (tipoVehiculo.equalsIgnoreCase("carro")) {
            return new CarroFactory();
        }  else if (tipoVehiculo.equalsIgnoreCase("bicicleta")) {
            return new BicicletaFarctory();
        }        
        return null;
        }
}
