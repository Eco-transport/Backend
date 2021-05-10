
package com.example.demo.models;

import javax.persistence.*;
import com.example.demo.models.EstacionModel;
import java.util.*;

@Entity
@Table(name = "prestamo")
public class PrestamoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_prestamo", unique = true, nullable = false)
    private Long idPrestamo;
    private Date fechaOrden;
	private String estatusOrden;
	private String comentariosOrden;
	private Long idEstacion;

	
   

    /**
     * @return Long return the idPrestamo
     */
    public Long getIdPrestamo() {
        return idPrestamo;
    }

    /**
     * @param idPrestamo the idPrestamo to set
     */
    public void setIdPrestamo(Long idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    /**
     * @return Date return the fechaOrden
     */
    public Date getFechaOrden() {
        return fechaOrden;
    }

    /**
     * @param fechaOrden the fechaOrden to set
     */
    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    /**
     * @return String return the estatusOrden
     */
    public String getEstatusOrden() {
        return estatusOrden;
    }

    /**
     * @param estatusOrden the estatusOrden to set
     */
    public void setEstatusOrden(String estatusOrden) {
        this.estatusOrden = estatusOrden;
    }

    /**
     * @return String return the comentariosOrden
     */
    public String getComentariosOrden() {
        return comentariosOrden;
    }

    /**
     * @param comentariosOrden the comentariosOrden to set
     */
    public void setComentariosOrden(String comentariosOrden) {
        this.comentariosOrden = comentariosOrden;
    }

    /**
     * @return Long return the idEstacion
     */
    public Long getIdEstacion() {
        return idEstacion;
    }

    /**
     * @param idEstacion the idEstacion to set
     */
    public void setIdEstacion(Long idEstacion) {
        this.idEstacion = idEstacion;
    }

}
