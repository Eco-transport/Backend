package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the association database table.
 * @author Sebastián Moreno
 */
@Entity
@Table( name = "association", schema = "public" )
public class Association implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * Attributes
     */

    @Id
    @SequenceGenerator( name = "ASSOCIATION_ID_GENERATOR",
            sequenceName = "public.association_association_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ASSOCIATION_ID_GENERATOR" )
    @Column( name = "association_id" )
    private Integer id;

    //bi-directional many-to-one association to Estacion
    @ManyToOne
    @JoinColumn( name = "estacion_id" )
    private Estacion Estacion;

    //bi-directional many-to-one association to UserRole
    @ManyToOne
    @JoinColumn( name = "role_id", referencedColumnName = "role_id" )
    @JoinColumn( name = "user_id", referencedColumnName = "user_id" )
    private UserRole userRole;

    /**
     * Constructors
     */

    public Association( ){
        userRole = new UserRole( );
    }

    public Association( User user, Role role, Estacion Estacion ){
        userRole = new UserRole( );
        userRole.setUser( user );
        userRole.setRole( role );
        this.Estacion = Estacion;
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

    public Estacion getEstacion( ){
        return Estacion;
    }

    public void setEstacion( Estacion Estacion ){
        this.Estacion = Estacion;
    }

    public User getUser( ){
        return userRole.getUser( );
    }

    public void setUser( User user ){
        this.userRole.setUser( user );
    }

    public Role getRole( ){
        return userRole.getRole( );
    }

    public void setRole( Role role ){
        this.userRole.setRole( role );
    }

    UserRole getUserRole( ){
        return userRole;
    }

    void setUserRole( UserRole userRole ){
        this.userRole = userRole;
    }

    /**
     * Methods
     */

    @Override
    public boolean equals( Object object ){
        if( !(object instanceof Association) ) return false;
        return id.equals( ((Association) object).getId( ) );
    }

    @Override
    public int hashCode( ){
        return id;
    }

}