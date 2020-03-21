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
	private Button  btnGuardar;
	
	@FXML
	private Button btnSalir;
    
    @FXML 
    private RadioButton rdbSi;
    
    @FXML 
    private RadioButton rdbNo;
    
    @FXML 
    private ToggleGroup grp1;
    
    private Juego juego;    
    private ObservableList<Juego> juegos;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
    }

    public void inicializarAtributos(ObservableList<Juego> juegos) {
        this.juegos = juegos;
        this.juego = pSeleccionada;
        
        
    }
    
    @FXML
    private void salir(ActionEvent event) {
        this.juego = null;
        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void guardar(ActionEvent event) {
        rdbSi.setUserData("Sí");
        rdbNo.setUserData("No");
        try {
            Juego j = new Juego(this.txtTitulo.getText(), this.comboBoxGenero.getValue(), this.comboBoxPlataforma.getValue(), grp1.getSelectedToggle().getUserData().toString());
            if (this.juegos.contains(j)) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El juego ya existe");
                alert.showAndWait();
            } else {
                this.juego = j;
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Perfecto");
                alert.setContentText("Juego añadido correctamente");
                alert.showAndWait();
            }
            
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos incorrectos");
            alert.showAndWait();
        }
    }

}
