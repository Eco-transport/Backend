package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Estacion database table.
 */
@Entity
@Table( name = "estacion", schema = "public" )
public class Estacion implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    @Id
    @SequenceGenerator( name = "ESTACION_ESTACIONID_GENERATOR",
            sequenceName = "public.estacion_estacion_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ESTACION_ESTACIONID_GENERATOR" )
    @Column( name = "estacion_id" )
    private Integer id;

    @Column( name = "estacion_name" )
    private String EstacionName;

    /**
     * Constructors
     */

    public Estacion( ){
        // Default constructor is required
    }

    /**
     * Getters and Setters
     */

    public Integer getId( ){
        return id;
    }

    public void setId( Integer id ){
        this.id = id;
    }

    public String getEstacionName( ){
        return EstacionName;
    }

    public void setEstacionName( String EstacionName ){
        this.EstacionName = EstacionName;
    }
    
    /**
     * Methods
     */

    @Override
    public boolean equals( Object object ){
        if( !(object instanceof Estacion) ) return false;
        return id.equals( ((Estacion) object).getId( ) );
    }

    @Override
    public int hashCode( ){
        return id;
    }
}