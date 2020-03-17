package com.proyecto.javafx.modelo;

import java.util.Objects;

public class Persona {
	
	String nombreString;
	String apellidoString;
	int edad;
	
	public Persona(String nombreString, String apellidoString, Integer edad) {
		super();
		this.nombreString = nombreString;
		this.apellidoString = apellidoString;
		this.edad = edad;
	
	}
	
	public String getNombreString() {
		return nombreString;
	}
	public void setNombreString(String nombreString) {
		this.nombreString = nombreString;
	}
	public String getApellidoString() {
		return apellidoString;
	}
	public void setApellidoString(String apellidoString) {
		this.apellidoString = apellidoString;
	}	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidoString, other.apellidoString) && edad == other.edad
				&& Objects.equals(nombreString, other.nombreString);
	}
	
	



	


}
