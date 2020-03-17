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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class PersoaController implements Initializable {
	
	@FXML
	private Button btnAgregar;
	
	@FXML
	private Button btnModificar;
	
	@FXML
	private Button btnEliminar;
	
	@FXML
	private TextField txtNombre;
	
	@FXML
	private TextField txtApellidos;
	
	@FXML
	private TextField txtEdad;

	@FXML
	private TableView<Persona> tblPersonas;
	
	@FXML
	private TableColumn colNombre;
	
	@FXML
	private TableColumn colApellidos;
	
	@FXML
	private TableColumn colEdad;
	
	private ObservableList<Persona> personas;
	
	@FXML
	private void agregarPersona(ActionEvent event) {
		
		try {
			Persona p = new Persona(this.txtNombre.getText(), this.txtApellidos.getText(), Integer.parseInt(this.txtEdad.getText()));
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
			this.txtNombre.setText(p.getNombreString());
			this.txtApellidos.setText(p.getApellidoString());
			this.txtEdad.setText(String.valueOf(p.getEdad()));
		}
	}
	
	@FXML
	private void modificarPersona(ActionEvent event) {
		Persona p = this.tblPersonas.getSelectionModel().getSelectedItem();
		if (p == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("No hay nada seleccionado");
			alert.showAndWait();
		} else {			
			try {
				Persona m = new Persona(this.txtNombre.getText(), this.txtApellidos.getText(), Integer.parseInt(this.txtEdad.getText()));
				
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
	private void eliminarPersona(ActionEvent event) {
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
		
		colNombre.setCellValueFactory(new PropertyValueFactory("nombreString"));
		colApellidos.setCellValueFactory(new PropertyValueFactory("apellidoString"));
		colEdad.setCellValueFactory(new PropertyValueFactory("edad"));
		
	}

}
