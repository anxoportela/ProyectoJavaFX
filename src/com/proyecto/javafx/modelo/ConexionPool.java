package com.proyecto.javafx.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.TimeZone;

/**
 *
 * @author dual108
 * @date 19 feb. 2020
 * @version 1.0
 *
 */

public class ConexionPool {
	
	private static String host;
	private static String port;
	private static String bd;
	private static String user;
	private static String password;

	private static ArrayList<Connection> lista = null;
	private static final int MAXCON = 5;
	private static final int CONINC = 5;

	private ConexionPool() {
		
		cargarPropiedades();
		lista = new ArrayList<>();
	    crearConexions(MAXCON);
	    }
	    
	    private static void crearConexions(int num) {
	        System.out.println("Creando conexións: " + num);
	        String cadeaConexion = "jdbc:mysql://" + host + ":" + port + "/" + bd + "?serverTimeZone=Europe/Madrid";
	        for (int i = 0; i < num; i++) {
	            try {
	                lista.add(DriverManager.getConnection(cadeaConexion, user, password));
	            } catch (SQLException e) {
	                System.out.println("Erro creando conexión: " + e.getMessage());
	            }
	        }
	    }

	public static Connection obtenerConexion() {
		
		if(lista==null) {
			new ConexionPool();
		}
		
		if(lista.size()>0) {
			Connection con = lista.remove(0);
			return con;
		} else {
			String cadenaConexion = "jdbc:mysql://" + host + ":" + port + "/" + bd + "?serverTimeZone=Europe/Madrid";
			for (int i = 0; i < MAXCON; i++) {
				try {
					lista.add(DriverManager.getConnection(cadenaConexion, user, password));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error de conexi�n: " + e.getMessage());
				}
			}
			Connection con = lista.remove(0);
			return con;
		}
	}
	
	public static void devolverConexion(Connection con) {
		
		lista.add(con);
		
	}

	private static void cargarPropiedades() {		
		
		try {
			InputStream is = ClassLoader.getSystemResourceAsStream("com/proyecto/javafx/config/config.inc");
			Properties prop = new Properties();
			prop.load(is);
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			bd = prop.getProperty("bd");
			port = prop.getProperty("port");
			host = prop.getProperty("host");
		} catch (IOException | NullPointerException e) {
			System.out.println("No se puede cargar el fichero de propiedades" + e.getMessage());
		}
	}

}
