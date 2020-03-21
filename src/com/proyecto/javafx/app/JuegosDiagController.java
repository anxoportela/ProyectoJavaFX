package com.proyecto.javafx.app;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class JuegosDiagController implements Initializable {

	@FXML
	private TextField txtTitulo;

	@FXML
	private ComboBox<String> comboBoxGenero;

	@FXML
	private ComboBox<String> comboBoxPlataforma;

	@FXML
	private Button btnGuardar;

	@FXML
	private Button btnSalir;

	@FXML
	private RadioButton rdbSi;

	@FXML
	private RadioButton rdbNo;

	@FXML
	private ToggleGroup grp1;

	private Juego juego;
	private JuegoDAO juegoDAO;
	private ObservableList<Juego> juegos;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void inicializarAtributos(ObservableList<Juego> juegos) {
		this.juegos = juegos;
	}

	public void inicializarAtributos(ObservableList<Juego> juegos, Juego j) {
		this.juegos = juegos;
		this.juego = j;
		this.txtTitulo.setText(j.getTitulo());
	}

	@FXML
	private void salir(ActionEvent event) {
		this.juego = null;
		Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void guardar(ActionEvent event) {
		String multi;
		Alert alert;
		if (rdbSi.isSelected()) {
			multi = "Sí";
		} else {
			multi = "No";
		}
		Juego j = new Juego(this.txtTitulo.getText(), this.comboBoxGenero.getValue(),
				this.comboBoxPlataforma.getValue(), multi);
		if (!this.juegos.contains(j)) {
			this.juego.setTitulo(this.txtTitulo.getText());
			this.juego.setGenero(this.comboBoxGenero.getValue());
			this.juego.setPlataforma(this.comboBoxPlataforma.getValue());
			this.juego.setMultijugador(multi);
			alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText((String) null);
			alert.setTitle("Información");
			alert.setContentText("Modificado correctamente");
			alert.showAndWait();
			Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
			stage.close();
		} else {
			alert = new Alert(AlertType.ERROR);
			alert.setHeaderText((String) null);
			alert.setTitle("Erro");
			alert.setContentText("El juego ya existe");
			alert.showAndWait();
		}
	}

	public Juego getJuego() {
		return this.juego;
	}

}
