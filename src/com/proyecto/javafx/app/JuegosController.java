package com.proyecto.javafx.app;

import java.net.URL;
import java.util.ResourceBundle;

import com.proyecto.javafx.modelo.Persona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class JuegosController implements Initializable {
	
	@FXML
	private Button btnAgregar;
	
	@FXML
	private Button btnModificar;
	
	@FXML
	private Button btnEliminar;
	
	@FXML
	private TextField txtTitulo;
	
	@FXML
	private TextField txtGenero;
	
	@FXML
	private TextField txtPlataforma;
	
	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private TableView<Persona> tblPersonas;
	
	@FXML
	private TableColumn colTitulo;
	
	@FXML
	private TableColumn colGenero;
	
	@FXML
	private TableColumn colPlataforma;
	
	private ObservableList<Persona> personas;
	
	@FXML
	private void agregarJuego(ActionEvent event) {
		
		try {
			Persona p = new Persona(this.txtTitulo.getText(), this.txtGenero.getText(), Integer.parseInt(this.txtPlataforma.getText()));
			this.personas.add(p);
			this.tblPersonas.setItems(this.personas);
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Alg�n dato con formato incorrecto");
			alert.showAndWait();
		}

	}
	
	@FXML
	private void seleccionar(MouseEvent event) {
		Persona p = this.tblPersonas.getSelectionModel().getSelectedItem();
		if (p != null) {
			this.txtTitulo.setText(p.getNombreString());
			this.txtGenero.setText(p.getApellidoString());
			this.txtPlataforma.setText(String.valueOf(p.getEdad()));
		}
	}
	
	@FXML
	private void modificarJuego(ActionEvent event) {
		Persona p = this.tblPersonas.getSelectionModel().getSelectedItem();
		if (p == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("No hay nada seleccionado");
			alert.showAndWait();
		} else {			
			try {
				Persona m = new Persona(this.txtTitulo.getText(), this.txtGenero.getText(), Integer.parseInt(this.txtPlataforma.getText()));
				
				if (this.personas.contains(m)) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("La persona ya existe");
					alert.showAndWait();
				} else {
					p.setNombreString(m.getNombreString());
					p.setApellidoString(m.getApellidoString());
					p.setEdad(m.getEdad());
					this.tblPersonas.refresh();
				}
				
			} catch (NumberFormatException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Alg�n dato con formato incorrecto");
				alert.showAndWait();
			}			
		}


	}
	
	@FXML
	private void eliminarJuego(ActionEvent event) {
		Persona p = this.tblPersonas.getSelectionModel().getSelectedItem();
		if (p == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("No hay nada seleccionado");
			alert.showAndWait();
		} else {
			this.personas.remove(p);
			this.tblPersonas.setItems(this.personas);
		}

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.personas = FXCollections.observableArrayList();
		
		colTitulo.setCellValueFactory(new PropertyValueFactory("nombreString"));
		colGenero.setCellValueFactory(new PropertyValueFactory("apellidoString"));
		colPlataforma.setCellValueFactory(new PropertyValueFactory("edad"));
		
	}

}
