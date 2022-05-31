package poo2.parqueadero.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import h2.H2CREAR;
import h2.H2JDBCUtils;
import poo2.parqueadero.model.ParqueaderoFachada;
import poo2.parqueadero.model.dto.CarroDTO;
import poo2.parqueadero.model.dto.MotoDTO;
import poo2.parqueadero.model.dto.VehiculoDTO;

public class MotoDAO {

	private H2JDBCUtils util;
	private H2CREAR h2;
	private Connection conexion=null;
	private ParqueaderoFachada p;
	
	public  MotoDAO() {
		
		util.getConnection();
		h2 = new H2CREAR();
	}
	
	public void conectarMoto() {
		
		try {
            p = ParqueaderoFachada.getInstance();
            conexion = H2JDBCUtils.getConnection();
            Statement statementOb;
		
				statementOb = conexion.createStatement();
			
            ResultSet rs = statementOb.executeQuery("SELECT * FROM MOTO");

           
				while (rs.next()) {
				    String placa = rs.getString("PLACA");
				    String marca = rs.getString("MARCA");
				    String modelo = rs.getString("MODELO");
				    String cilindraje = rs.getString("CILINDRAJE");
				    String tipo = rs.getString("TIPO");
				    int estado= rs.getInt("ESTADO");
    //     String Fingreso = rs.getString("CFECHA");
    //      String Hingreso = rs.getString("CHORAI");
    //       String Fsalida = rs.getString("CFECHA_S");
    //      String Hsalida = rs.getString("CHORA_S");
    //       double saldo = rs.getDouble("CSALDO");
				    
				    MotoDTO m = (MotoDTO) p.crearVehiculo("moto");
				    VehiculoDTO v = new VehiculoDTO();

				    m.setPlaca(placa);
				    m.setMarca(marca);
				    m.setModelo(modelo);
				    m.setCilindraje(cilindraje);
				    m.setTipo(tipo);
				 //    m.setFechaI(Fingreso);
				 //   m.setHoraI(Hingreso);
				 //   m.setFechaS(Fsalida);
				 //    m.setHoraS(Hsalida);
				 //   m.setSaldo(saldo);
				    v.vehiculos.add(m);
				   
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
	
	 public void cerrarMoto() {
	        if (conexion != null) {
	         
	                try {
						conexion.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            
	        }
	    } 	
	 
	  public boolean agregarMoto(String placa, String modelo, String marca, String cilindraje, String tipo, int estado) throws SQLException {
		  System.out.println("01");
		  p = ParqueaderoFachada.getInstance();
		  MotoDTO moto = new MotoDTO( placa,  modelo,  marca,  cilindraje,  tipo,  estado);
		  System.out.println("001");
		  
		  h2.insertMoto(moto);
		  System.out.println("ok");
		  
		 MotoDTO m = (MotoDTO) p.crearVehiculo("moto");
          VehiculoDTO v = new VehiculoDTO();
          System.out.println("2");
          m.setPlaca(placa);
          m.setModelo(modelo);
          m.setMarca(marca);
          m.setCilindraje(cilindraje);
          m.setTipo(tipo);
          m.setEstado(estado);
          
          v.imprimir();
          
		return true;
		  
	  }
}
