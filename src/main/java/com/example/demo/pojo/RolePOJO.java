package com.example.demo.pojo;

import com.example.demo.model.*;

public class RolePOJO{

    private final Integer id;
    private final String roleName;

    public RolePOJO( Role role ){
        if( role == null ){
            throw new NullPointerException("Role cannot be null");
        }
        this.id = role.getId( );
        this.roleName = role.getRoleName( );
    }

    public Integer getId( ){
        return id;
    }

    public String getRoleName( ){
        return roleName;
    }
}
