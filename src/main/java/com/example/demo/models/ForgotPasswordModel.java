package com.example.demo.models;

import javax.persistence.*;



public class ForgotPasswordModel {

    private String email;
    private String respuesta;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}