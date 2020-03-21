package com.proyecto.javafx.app;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class JuegosController implements Initializable {
	
	@FXML
    private TextField txtTitulo;

    @FXML
    private ComboBox<String> comboBoxGenero;

    @FXML
    private ComboBox<String> comboBoxPlataforma;

    @FXML
    private Button  btnGuardar;

    @FXML
    private Button btnSalir;

    @FXML 
    private RadioButton rdbSi;

    @FXML 
    private RadioButton rdbNo;

    @FXML 
    private ToggleGroup grp1;
	
	private ObservableList<Juego> juegos;
	
	private JuegoDAO juegoDAO;
	
	@FXML
	private void agregarJuego(ActionEvent event) {
		
		try {
			Juego j = new Juego(this.txtTitulo.getText(), this.comboBoxGenero.getValue(), this.comboBoxPlataforma.getValue(), grp1.getSelectedToggle().getUserData().toString());
			this.juegos.add(j);
			this.tblJuegos.setItems(this.juegos);
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Alg�n dato con formato incorrecto");
			alert.showAndWait();
		}

	}
	
	@FXML
    private void modificarJuego(ActionEvent event) {
        Juego j = this.tblJuegos.getSelectionModel().getSelectedItem();
        if (j == null) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No hay nada seleccionado");
            alert.showAndWait();
        } else {
        	
        }
        
	}
	
	@FXML
	private void seleccionar(MouseEvent event) {
		Juego j = this.tblJuegos.getSelectionModel().getSelectedItem();
		if (j != null) {
			this.txtTitulo.setText(j.getTitulo());
			this.txtGenero.setText(j.getGenero());
			this.txtPlataforma.setText(j.getPlataforma());
			this.txtMultijugador.setText(j.isMultijugador());
		}
	}
	
	@FXML
	private void eliminarJuego(ActionEvent event) {
		Juego j = this.tblJuegos.getSelectionModel().getSelectedItem();
		if (j == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("No hay nada seleccionado");
			alert.showAndWait();
		} else {
			this.juegos.remove(j);
			this.tblJuegos.setItems(this.juegos);
		}

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.juegos = FXCollections.observableArrayList();
        this.tblJuegos.setItems(this.juegos);
        this.juegoDAO = new JuegoDAO();
        ArrayList<Juego> lista = (ArrayList) this.juegoDAO.obter();
        Iterator var5 = lista.iterator();

        while (var5.hasNext()) {
            Juego j = (Juego) var5.next();
            this.juegos.add(j);
        }

        this.tblJuegos.refresh();
	}

}

