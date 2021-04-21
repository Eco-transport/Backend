package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "estacion")
public class EstacionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_estacion", unique = true, nullable = false)
    private Long idEstacion;

	private String nombre;
	private String direccion;
	private Integer telefono;
	private Integer totalVehiculos;

	public Long getIdEstacion() {
		return this.idEstacion;
	}

	public void setIdEstacion(Long idEstacion) {
		this.idEstacion = idEstacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getTotalVehiculos() {
		return this.totalVehiculos;
	}

	public void setTotalVehiculos(Integer totalVehiculos) {
		this.totalVehiculos = totalVehiculos;
	}
   
}