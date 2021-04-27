package com.example.demo.models;

import javax.persistence.*;



public class LoginModel {

    private String email;
    private String contrasena;


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



    


}