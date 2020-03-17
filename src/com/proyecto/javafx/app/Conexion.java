package com.proyecto.javafx.app;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.TimeZone;

/**
 *
 * @author dual108
 * @date 18 feb. 2020
 * @version 1.0
 *
 */

public class Conexion {
	
	private static String host;
	private static String port;
	private static String bd;
	private static String user;
	private static String password;
	private static Connection con = null;

	private Conexion() {
	}

	public static Connection obtenerConexion() {
		
		cargarPropiedades();
		//Connection con = null;
		if (con == null) {
			String cadenaConexion = "jdbc:mysql://" + host + ":" + port + "/" + bd + "?serverTimeZone=Europe/Madrid";
			try {
				con = DriverManager.getConnection(cadenaConexion, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	private static void cargarPropiedades() {		
		
		try {
			InputStream is = ClassLoader.getSystemResourceAsStream("com/acarballeira/bd/recursos/config.inc");
			//InputStream is = Conexion.class.getResourceAsStream("/com/acarballeira/bd/recursos/config.inc")
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
	
private static void cargarPropiedadesV2() {		
		
		try {
			String pathname = "C:\\Users\\dual108\\Documents\\GitHub\\PROG\\Archivos\\config.inc";
			FileReader fr =  new FileReader(pathname);
			Properties prop = new Properties();
			prop.load(fr);
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
