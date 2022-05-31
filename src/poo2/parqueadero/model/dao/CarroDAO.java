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
		h2 =new H2CREAR();
	}

	 public void conectarCarro() {
			try {
	            p = ParqueaderoFachada.getInstance();
	            conexion = H2JDBCUtils.getConnection();
	            Statement statementOb;
			
					statementOb = conexion.createStatement();
				
	            ResultSet rs = statementOb.executeQuery("SELECT * FROM CARRO");

	           
					while (rs.next()) {
					    String placa = rs.getString("PLACA");
					    String marca = rs.getString("MARCA");
					    String modelo = rs.getString("MODELO");
					    String cilindraje = rs.getString("CILINDRAJE");
					    int nPuertas = rs.getInt("NPUERTAS");
					    int estado= rs.getInt("ESTADO");
        //     String Fingreso = rs.getString("CFECHA");
        //      String Hingreso = rs.getString("CHORAI");
        //       String Fsalida = rs.getString("CFECHA_S");
        //      String Hsalida = rs.getString("CHORA_S");
        //       double saldo = rs.getDouble("CSALDO");
					    

					    CarroDTO m = (CarroDTO) p.crearVehiculo("carro");
					    VehiculoDTO v = new VehiculoDTO();

					    m.setPlaca(placa);
					    m.setMarca(marca);
					    m.setModelo(modelo);
					    m.setCilindraje(cilindraje);
					    m.setNpuertas(nPuertas);
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
		  System.out.println("01");
		  CarroDTO carro = new CarroDTO( placa,  modelo,  marca,  cilindraje,  nPuertas,  estado);
		  System.out.println("001");
		  
		  h2.insertCarro(carro);
		  System.out.println("ok");
		return true;
		  
	  }
	
	/*  
	  public boolean agregarCarro(String placa, String modelo, String marca, String cilindraje, int nPuertas, int estado) {
		  System.out.println("0");
	     
	            p = ParqueaderoFachada.getInstance();
	            boolean exito = false;
	            Connection conn = null;
	    		Statement statementOb = null;
	            System.out.println("01");
	            try {      
	            conn = H2JDBCUtils.getConnection();
	            System.out.println("001");

	            Statement st = conexion.createStatement();
	            
	            System.out.println("0001");
	            
	            conexion = H2JDBCUtils.getConnection();
				statementOb = conn.createStatement();
				 System.out.println("00001");
				StringBuffer sb = new StringBuffer();
				sb.append("INSERT INTO CARRO(placa, modelo, marca, cilindraje, nPuertas,estado) ");
				sb.append("VALUES ("+placa+", '"+modelo+"', '"+marca+
						"', '"+cilindraje+"', '"+nPuertas+"', '"+estado+")");

				statementOb.executeUpdate(sb.toString());
	            
	            
	            
	            
	            
	            System.out.println("0001");
	          /*  st.executeUpdate("INSERT INTO CARRO (PLACA)values('" + placa + "')");
	            st.executeUpdate("UPDATE CARRO SET MARCANO=" + marca + " WHERE CPLACA='" + placa + "'");
	            st.executeUpdate("UPDATE CARRO SET CMODELO=" + mModelo + " WHERE CPLACA='" + placa + "'");
	            st.executeUpdate("UPDATE CARRO SET CCILINDRAJE=" + mCilindraje + " WHERE CPLACA='" + placa + "'");
	            st.executeUpdate("UPDATE CARRO SET CNOPUERTAS=" + nPuertas + " WHERE CPLACA='" + placa + "'");
	            st.executeUpdate("UPDATE CARRO SET ESTADO=" + estado + " WHERE CPLACA='" + placa + "'");
		          System.out.println("1");
*/ /*
	            CarroDTO m = (CarroDTO) p.crearVehiculo("carro");
	            VehiculoDTO v = new VehiculoDTO();
	            System.out.println("2");
	            m.setPlaca(placa);
	            m.setMarca(marca);
	            m.setModelo(modelo);
	            m.setCilindraje(cilindraje);
	            m.setNpuertas(nPuertas);
	            m.setEstado(estado);
	          //  m.setFechaI(mFecha);
	          //  m.setHoraI(mHoraI);
	//
	            System.out.println("3");
	            v.vehiculos.add(m);
	            // p.notificar("CARRO");
	             
	            v.imprimir();
	            st.executeUpdate("UPDATE HISTORIAL SET ESTADO ='" + estado + "' WHERE PLACA='" + placa + "'");
	          //st.executeUpdate("UPDATE HISTORIAL SET MHORAI ='" + mHoraI + "' WHERE MPLACA='" + placa + "'");
	           /*
	            } catch (SQLException e) {
	    			// print SQL exception information
	    			e.printStackTrace();
	    		} finally {
	    			// Close the connection
	    			try {
	    				statementOb.close();
	    				conn.close();
	    			} catch (SQLException e) {
	    				// print SQL exception information
	    				e.printStackTrace();
	    			}

	    		}
	    		return exito;
	    }
*/
	    public String consultarCarro() {

	        try {
	            String placa = "", marca = "",modelo = "", cilindraje ="" ;
	            int  nPueras = 0;
	            
	            String todo = "";

	            Statement statementOb = conexion.createStatement();
	            ResultSet rs = statementOb.executeQuery("SELECT C.PLACA, MA.MNAME, C.MODELO, C.CILINDRAJE,C.NPUERTAS FROM CARRO C");

	            while (rs.next()) {
	                placa = rs.getString("PLACA");
	                
	                modelo = rs.getString("MODELO");
	                marca = rs.getString("MARCA");
	                cilindraje = rs.getString("CILINDRAJE");
	                nPueras = rs.getInt("NPUERTAS");
	               
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
/*
	public void updateCarro(CarroDTO carro) {

		try {
			h2.updateCarro(carro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
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
