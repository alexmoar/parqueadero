package poo2.parqueadero.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import h2.H2CREAR;
import h2.H2JDBCUtils;
import poo2.parqueadero.model.ParqueaderoFachada;
import poo2.parqueadero.model.dto.CarroDTO;
import poo2.parqueadero.model.dto.VehiculoDTO;

public class CarroDAO {

	private H2JDBCUtils util;
	private H2CREAR h2;
	private Connection conexion=null;
	private ParqueaderoFachada p;
	
	public CarroDAO() {
		
		util.getConnection();
		h2 = new H2CREAR();
		
	}

	 public void conectarCarro() {
			try {
	            p = ParqueaderoFachada.getInstance();
	            conexion = H2JDBCUtils.getConnection();
	            Statement statementOb;
			
					statementOb = conexion.createStatement();
				
	            ResultSet rs = statementOb.executeQuery("SELECT * FROM CARROS");

	           
					while (rs.next()) {
					    String placa = rs.getString("PLACA");
					    String marca = rs.getString("MARCA");
					    String modelo = rs.getString("MODELO");
					    String cilindraje = rs.getString("CILINDRAJE");
					    int nPuertas = rs.getInt("PUERTAS");
					    int estado= rs.getInt("ESTADO");
 

					    CarroDTO m = (CarroDTO) p.crearVehiculo("carro");
					    VehiculoDTO v = new VehiculoDTO();

					    m.setPlaca(placa);
					    m.setMarca(marca);
					    m.setModelo(modelo);
					    m.setCilindraje(cilindraje);
					    m.setNpuertas(nPuertas);
					    
					    ArrayList<VehiculoDTO>vehiculo = new ArrayList<>();
					    vehiculo.add(m);
					    v.setVehiculos(vehiculo);
					   
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	        } 
	    
	  public void cerrarCarro() {
	        if (conexion != null) {
	         
	                try {
						conexion.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            
	        }
	    } 
	   
	  public boolean agregarCarro(String placa, String modelo, String marca, String cilindraje, int nPuertas, int estado) throws SQLException {
		//  System.out.println("01");
		  p = ParqueaderoFachada.getInstance();
		  CarroDTO carro = new CarroDTO( placa,  modelo,  marca,  cilindraje,  nPuertas,  estado);
		 // System.out.println("001");
		  
		  h2.insertCarro(carro);
		  String s= "carro";
		  p.notificacion(s);
		 // System.out.println("ok");
		  
		  CarroDTO m = (CarroDTO) p.crearVehiculo("carro");
          VehiculoDTO v = new VehiculoDTO();
          System.out.println("2");
          m.setPlaca(placa);
          m.setModelo(modelo);
          m.setMarca(marca);
          m.setCilindraje(cilindraje);
          m.setNpuertas(nPuertas);
          m.setEstado(estado);
          
          v.imprimir();
          
		return true;
		  
	  }
	
	

	    public String consultarCarro() {

	        try {
	            String placa = "", marca = "",modelo = "", cilindraje ="" ;
	            int  nPueras = 0;
	            
	            String todo = "";

	            Statement statementOb = conexion.createStatement();
	            ResultSet rs = statementOb.executeQuery("SELECT C.PLACA, MA.MODELO, C.MARCA, C.CILINDRAJE,C.PUERTAS FROM CARROS C");

	            while (rs.next()) {
	                placa = rs.getString("PLACA");
	                
	                modelo = rs.getString("MODELO");
	                marca = rs.getString("MARCA");
	                cilindraje = rs.getString("CILINDRAJE");
	                nPueras = rs.getInt("PUERTAS");
	               
	                todo += "********************************************************************************************************CARRO*************************************************************************************************\n \n PLACA:   ";
	                todo += placa += "      MARCA:   ";
	                todo += marca += "         MODELO:   ";
	                todo += modelo + "              CILINDRAJE:   ";
	                todo += cilindraje + "        NUMERO DE PUERTAS:   ";
	                todo += nPueras + "      FECHA INGRESO:   ";


	            }
	            if (todo == "") {
	                todo = "NO HAY REGITROS DE CARROS \n";
	            }
	            return todo;

	        } catch (SQLException ex) {
	           
	        }
	        return "";
	    }

	
	public CarroDAO(H2JDBCUtils util, H2CREAR h2) {
		super();
		this.util = util;
		this.h2 = h2;
	}

	public void agrerarCarro(CarroDTO carro) {

		try {
			h2.insertCarro(carro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<VehiculoDTO> listaVehiculos() {

		ArrayList<VehiculoDTO> lista = new ArrayList<VehiculoDTO>();
		Statement statementOb = null;
		Connection conn = null;
		try {
			ResultSet rs = statementOb.executeQuery("");
			conn = H2JDBCUtils.getConnection();
			statementOb = conn.createStatement();

			while (rs.next()) {
				CarroDTO carro = new CarroDTO();
				
				carro.setPlaca(rs.getString("placa"));
				carro.setMarca(rs.getString("marca"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
