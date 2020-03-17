package com.proyecto.javafx.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.javafx.app.ConexionPool;

/**
 *
 * @author dual108
 * @date 2 mar. 2020
 * @version 1.0
 *
 */

public class ClienteDAO {

	public List<Cliente> obter() {

		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		try {
			int aux = 0;
			Connection con = ConexionPool.obtenerConexion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT IdCliente, Nombre, Apellidos FROM clientes");
			while (rs.next()) {
				lista.add(new Cliente(rs.getString(2), rs.getString(3)));
				lista.get(aux).setIdCliente(rs.getInt(1));
				aux++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;

	}

	public Cliente obter(int id) {

		Cliente aux = new Cliente();

		try {
			Connection con = ConexionPool.obtenerConexion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Nombre, Apellidos FROM clientes WHERE idCliente=" + id + ";");
			if (rs.next()) {
				aux.setIdCliente(id);
				aux.setNome(rs.getString(1));
				aux.setApellidos(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aux;

	}

	public boolean rexistrar(Cliente cliente) {
		boolean rs = false;
		try {
			Connection con = ConexionPool.obtenerConexion();
			Statement st = con.createStatement();
			rs = st.execute("INSERT INTO clientes (Nombre, Apellidos) VALUES ('" + cliente.getNome() + "', '"
					+ cliente.getApellidos() + "');");

			ConexionPool.devolverConexion(con);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public boolean eliminar(Cliente cliente) {
		boolean rs = false;
		try {
			Connection con = ConexionPool.obtenerConexion();
			Statement st = con.createStatement();
			rs = st.execute("DELETE FROM clientes WHERE idCliente = " + cliente.getIdCliente() + ";");

			ConexionPool.devolverConexion(con);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public boolean actualizar(Cliente cliente) {
		boolean rs = false;
		try {
			Connection con = ConexionPool.obtenerConexion();
			Statement st = con.createStatement();
			rs = st.execute("UPDATE clientes SET Nombre = '" + cliente.getNome() + "', Apellidos = '"
					+ cliente.getApellidos() + "' WHERE idCliente = " + cliente.getIdCliente() + ";");

			ConexionPool.devolverConexion(con);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
