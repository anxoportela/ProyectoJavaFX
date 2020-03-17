package com.proyecto.javafx.app;

/**
 *
 * @author dual108
 * @date 18 feb. 2020
 * @version 1.0
 *
 */

public class Cliente {
	
	private int idCliente;
	private String nome;
	private String apellidos;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String apellidos) {
		this();
		this.nome = nome;
		this.apellidos = apellidos;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", " + (nome != null ? "nome=" + nome + ", " : "")
				+ (apellidos != null ? "apellidos=" + apellidos : "") + "]";
	}
	
}


