package h2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class H2CREAR {

	public static void main(String[] argv) throws SQLException {
		H2CREAR h2Example = new H2CREAR();
		h2Example.createTableCarro();
		h2Example.createTablemoto();
		
		String valId = JOptionPane.showInputDialog("Ingrese el ID: ");
		String valName = JOptionPane.showInputDialog("Ingrese el Nombre: ");
		String valEmail = JOptionPane.showInputDialog("Ingrese el Email: ");
		String valCountry = JOptionPane.showInputDialog("Ingrese el Pais: ");
		String valContra = JOptionPane.showInputDialog("Ingrese el Contrasena: ");
		
		h2Example.insertRecord(valId, valName, valEmail, valCountry, valContra);
		
		
		
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

		} catch (SQLException e) {
			// print SQL exception information
			System.err.println("Ya está creada la tabla carro");
		} finally {
//			insertRecord();
		}
	}
	
	public void createTablemoto() throws SQLException {

		StringBuffer sbCreateTableSQL = new StringBuffer();
		sbCreateTableSQL.append("create table carro (placa varchar(20) primary key, ");
		sbCreateTableSQL.append("modelo varchar(20), marca varchar(20), ");
		sbCreateTableSQL.append("cilindraje varchar(20), nPuertas varchar(20)");
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

	public void insertRecord(String id, String name, String email, String country, String contra) throws SQLException {

		Connection conn = null;
		Statement statementOb = null;

		try {
			conn = H2JDBCUtils.getConnection();
			statementOb = conn.createStatement();

			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO USERS(id, name, email, country, password) ");
			sb.append("VALUES ("+id+", '"+name+"', '"+email+"', '"+country+"', '"+contra+"')");

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
	
	public void updateRecord(String id, String name, String email, String country, String contra) throws SQLException {

		Connection conn = null;
		Statement statementOb = null;

		try {
			conn = H2JDBCUtils.getConnection();
			statementOb = conn.createStatement();

			StringBuffer sb = new StringBuffer();
			sb.append("UPDATE USERS SET name = '"+name+"', email = '"+email+"', country='"+country+"', password='"+contra+"' ");
			sb.append("WHERE id="+id+"");

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
