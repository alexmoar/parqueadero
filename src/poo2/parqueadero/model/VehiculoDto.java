package poo2.parqueadero.model.dao;

public class Moto {

<<<<<<<< HEAD:src/poo2/parqueadero/model/dao/Moto.java
========
public class VehiculoDto {
>>>>>>>> 509aa0accd1eb8030f84287f1bf3f7e26bba4e3a:src/poo2/parqueadero/model/VehiculoDto.java
	private String placa;
	private String modelo;
	private String marca;
	private String cilindraje;
<<<<<<<< HEAD:src/poo2/parqueadero/model/dao/Moto.java
	private String puertas;
	private int estado;
	
	public Moto(String placa, String modelo, String marca, String cilindraje, String puertas, int estado) {
========
	
	public VehiculoDto(String placa, String modelo, String marca, String cilindraje) {
>>>>>>>> 509aa0accd1eb8030f84287f1bf3f7e26bba4e3a:src/poo2/parqueadero/model/VehiculoDto.java
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.cilindraje = cilindraje;
<<<<<<<< HEAD:src/poo2/parqueadero/model/dao/Moto.java
		this.puertas = puertas;
		this.estado = estado;
========
	
>>>>>>>> 509aa0accd1eb8030f84287f1bf3f7e26bba4e3a:src/poo2/parqueadero/model/VehiculoDto.java
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

<<<<<<<< HEAD:src/poo2/parqueadero/model/dao/Moto.java
	public String getPuertas() {
		return puertas;
	}

	public void setPuertas(String puertas) {
		this.puertas = puertas;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
========
	@Override
	public String toString() {
		return "VehiculoDto [placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", cilindraje=" + cilindraje
				+ "]";
>>>>>>>> 509aa0accd1eb8030f84287f1bf3f7e26bba4e3a:src/poo2/parqueadero/model/VehiculoDto.java
	}
	
	
	
<<<<<<<< HEAD:src/poo2/parqueadero/model/dao/Moto.java
========
	
>>>>>>>> 509aa0accd1eb8030f84287f1bf3f7e26bba4e3a:src/poo2/parqueadero/model/VehiculoDto.java
}
