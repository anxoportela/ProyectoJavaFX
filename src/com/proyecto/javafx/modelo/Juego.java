package com.proyecto.javafx.modelo;

import java.util.Objects;

public class Juego {

	private int id_juego;
	private String titulo;
	private String genero;
	private String plataforma;
	private String multijugador;
	
	public Juego() {
		super();
	}

	public Juego(int id_juego) {
		super();
		this.id_juego = id_juego;
	}

	public Juego(String titulo, String genero, String plataforma, String multijugador) {
		super();
		this.id_juego = getId_juego();
		this.titulo = titulo;
		this.genero = genero;
		this.plataforma = plataforma;
		this.multijugador = multijugador;
	}

	public int getId_juego() {
		return id_juego;
	}
	
	public void setId_juego(int id_juego) {
		this.id_juego = id_juego;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String isMultijugador() {
		return multijugador;
	}

	public void setMultijugador(String multijugador) {
		this.multijugador = multijugador;
	}



	@Override
	public int hashCode() {
		return Objects.hash(genero, id_juego, multijugador, plataforma, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juego other = (Juego) obj;
		return Objects.equals(genero, other.genero) && id_juego == other.id_juego
				&& Objects.equals(multijugador, other.multijugador) && Objects.equals(plataforma, other.plataforma)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return String.format("Juego [id_juego=%s, titulo=%s, genero=%s, plataforma=%s, multijugador=%s]", id_juego,
				titulo, genero, plataforma, multijugador);
	}
	
	
}
