package poo2.parqueadero.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import h2.H2CREAR;
import h2.H2JDBCUtils;
import poo2.parqueadero.model.dto.CarroDTO;
import poo2.parqueadero.model.dto.VehiculoDTO;

public class carroDAO {
	private H2JDBCUtils util;
	private H2CREAR h2;

	public carroDAO() {
		util.getConnection();
	}

	public carroDAO(H2JDBCUtils util,H2CREAR h2) {
		super();
		this.util = util;
		this.h2= h2;
	}
	
	
	public void agrerarCarro(CarroDTO carro) throws SQLException {
		
		h2.insertCarro(carro);
		
	}
	
	public ArrayList<VehiculoDTO>listaVehiculos() {
		
		ArrayList<VehiculoDTO> lista = new ArrayList<VehiculoDTO>();
		Statement statementOb = null;
		Connection conn = null;
		try {
			ResultSet rs = statementOb.executeQuery("");
			conn= H2JDBCUtils.getConnection();
			statementOb = conn.createStatement();
			
			
			while(rs.next()) {
				CarroDTO carro= new CarroDTO();
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
