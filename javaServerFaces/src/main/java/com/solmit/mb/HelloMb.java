package com.solmit.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean(name ="helloMb")
public class HelloMb implements Serializable {

	private static final long serialVersionUID = 431543871879494408L;
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
