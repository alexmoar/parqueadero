package poo2.parqueadero.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import Obsevador.Notificador;
import h2.H2CREAR;
import poo2.parqueadero.controllers.IController;
import poo2.parqueadero.model.dao.CarroDAO;
import poo2.parqueadero.model.dao.MotoDAO;
import poo2.parqueadero.model.dao.CarroDAO;
import poo2.parqueadero.model.dto.CarroDTO;
import poo2.parqueadero.model.dto.MotoDTO;
import poo2.parqueadero.model.dto.VehiculoDTO;
import poo2.parqueadero.model.factory.UtilidadesFactory;
import poo2.parqueadero.model.factory.VehiculoFactory;
import poo2.parqueadero.model.factory.UtilidadesFactory;


public class ParqueaderoFachada     {
	private static ParqueaderoFachada instance;

	H2CREAR h2 = new H2CREAR();
	private CarroDAO carro;
	private MotoDAO moto;
	private VehiculoFactory vF;
	private ArrayList<Suscrictor>suscritores;
	private String tipoVehiculo="";
	
	private ParqueaderoFachada() {
		this.suscritores= new ArrayList<>();
		this.carro = new CarroDAO();
		this.moto= new MotoDAO();
		try { 
			h2.createTableCarro();
			h2.createTablemoto();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static ParqueaderoFachada getInstance() {
		if (instance == null)
			instance = new ParqueaderoFachada();

		return instance;
	}
	
	public VehiculoDTO crearVehiculo(String tipoVehiculo) {
        vF = UtilidadesFactory.getFactory(tipoVehiculo);
        VehiculoDTO c = vF.crearVehiculo();
        return c;
    }

	public void conectarCarro() {
		
		carro.conectarCarro();
	}
	public void cerarCarro() {
		carro.cerrarCarro();
	}
	
	public String consultarCarro() {
        return carro.consultarCarro();
    }
	
	public boolean agregarCarro(String placa, String modelo, String marca, String cilindraje, int puertas, int estado) throws SQLException {
		tipoVehiculo = "carro";
		this.notificacion(tipoVehiculo);
		return carro.agregarCarro(placa, modelo, marca, cilindraje, puertas, estado);
		
		
	

	}

	public boolean agrgarMoto(String placa, String modelo, String marca, String cilindraje, String tipo, int estado) throws SQLException {
		tipoVehiculo = "moto";
		this.notificacion(tipoVehiculo);
		return moto.agregarMoto(placa, modelo, marca, cilindraje, tipo, estado);
		
	}


	
	public void listeners() {
		// TODO Auto-generated method stub
		
	}


	
	public void subscribe(Suscrictor valor ) {
		suscritores.add( valor);
		// TODO Auto-generated method stub
		
	}


	
	public void eliminarsuscritor() {
		// TODO Auto-generated method stub
		
	}


	
	public void notificacion(String tipo) {
		
		for (int i = 0; i < suscritores.size(); i++) {
		suscritores.get(i).actualizar(tipo);
			
		}
		
		
		
	}
	
	
}
