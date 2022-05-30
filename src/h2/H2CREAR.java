package h2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import poo2.parqueadero.model.dto.CarroDTO;
import poo2.parqueadero.model.dto.MotoDTO;



public class H2CREAR {

	public static void main(String[] argv) throws SQLException {
		
		H2CREAR h2Example = new H2CREAR();
		
		CarroDTO carro = new CarroDTO();
		MotoDTO moto = new MotoDTO();
		h2Example.createTableCarro();
		h2Example.createTablemoto();
		h2Example.insertCarro(carro);
		h2Example.insertMoto(moto);
		
		
		
	}

	public void createTableCarro() throws SQLException {

		StringBuffer sbCreateTableSQL = new StringBuffer();
		sbCreateTableSQL.append("create table carro (placa varchar(20) primary key, ");
		sbCreateTableSQL.append("modelo varchar(20), marca varchar(20), ");
		sbCreateTableSQL.append("cilindraje varchar(20), nPuertas int");
		sbCreateTableSQL.append("estado int");

		System.out.println(sbCreateTableSQL);
		// Step 1: Establishing a Connection
		try (Connection connection = H2JDBCUtils.getConnection();
	
				// Step 2:Create a statement using connection object
				Statement statement = connection.createStatement();) {

			// Step 3: Execute the query or update query
			statement.execute(sbCreateTableSQL.toString());
			connection.close();
		} catch (SQLException e) {
			// print SQL exception information
			System.err.println("Ya está creada la tabla carro");
		} finally {
//			insertRecord();
		}
	
	}
	
	public void createTablemoto() throws SQLException {

		StringBuffer sbCreateTableSQL = new StringBuffer();
		sbCreateTableSQL.append("create table moto (placa varchar(20) primary key, ");
		sbCreateTableSQL.append("modelo varchar(20), marca varchar(20), ");
		sbCreateTableSQL.append("cilindraje varchar(20), tipo varchar(20)");
		sbCreateTableSQL.append("estado int");

		System.out.println(sbCreateTableSQL);
		// Step 1: Establishing a Connection
		try (Connection connection = H2JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				Statement statement = connection.createStatement();) {

			// Step 3: Execute the query or update query
			statement.execute(sbCreateTableSQL.toString());

		} catch (SQLException e) {
			// print SQL exception information
			System.err.println("Ya está creada la tabla moto");
		} finally {
//			insertRecord();
		}
	}

	public boolean insertCarro( CarroDTO carro) throws SQLException {

		boolean exito = false;
		Connection conn = null;
		Statement statementOb = null;

		try {
			conn = H2JDBCUtils.getConnection();
			statementOb = conn.createStatement();

			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO CARRO(placa, modelo, marca, cilindraje, nPuertas,estado) ");
			sb.append("VALUES ("+carro.getPlaca()+", '"+carro.getModelo()+"', '"+carro.getMarca()+
					"', '"+carro.getCilindraje()+"', '"+carro.getNpuertas()+"', '"+carro.getEstado()+")");

			statementOb.executeUpdate(sb.toString());
			exito = true;

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
	
	public boolean insertMoto(MotoDTO moto) throws SQLException {

		boolean exito = false;
		Connection conn = null;
		Statement statementOb = null;

		try {
			conn = H2JDBCUtils.getConnection();
			statementOb = conn.createStatement();

			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO MOTO(placa, modelo, marca, cilindraje, tipo,estado) ");
			sb.append("VALUES ("+moto.getPlaca()+", '"+moto.getModelo()+"', '"+moto.getMarca()+
					"', '"+moto.getCilindraje()+"', '"+moto.getTipo()+"', '"+moto.getEstado()+")");

			statementOb.executeUpdate(sb.toString());
			exito = true;

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
	
	public void updateCarro(CarroDTO carro) throws SQLException {

		Connection conn = null;
		Statement statementOb = null;

		try {
			conn = H2JDBCUtils.getConnection();
			statementOb = conn.createStatement();

			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE CARRO SET placa = '"+carro.getPlaca()+"', modelo = '"+carro.getModelo()
			+"', marca='"+carro.getMarca()+"', cilindraje='"+carro.getCilindraje()+"', nPuertas='"+carro.getNpuertas()+"', estado= '"+carro.getEstado()+")");
			sb.append("WHERE placa="+carro.getPlaca()+"");

			statementOb.executeUpdate(sb.toString());

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

	}
	
	public void updateMoto(MotoDTO moto) throws SQLException {

		Connection conn = null;
		Statement statementOb = null;

		try {
			conn = H2JDBCUtils.getConnection();
			statementOb = conn.createStatement();

			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE MOTO SET placa = '"+moto.getPlaca()+"', modelo = '"+moto.getModelo()
			+"', marca='"+moto.getMarca()+"', cilindraje='"+moto.getCilindraje()+"', estado= '"+moto.getEstado()+")");
			sb.append("WHERE placa="+moto.getPlaca()+"");

			statementOb.executeUpdate(sb.toString());

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

	}
	
}
	


