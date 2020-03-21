package com.proyecto.javafx.app;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class JuegosDiagController implements Initializable {
	
	@FXML
    private TextField txtEdad;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    
    @FXML
    private TextField btnGuardar;
    @FXML
    private TextField btnSalir;
    
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
        
        try {
            Juego j = new Juego(this.txtNombre.getText(), this.txtApellidos.getText(), Integer.parseInt(this.txtEdad.getText()));
            if (this.juegos.contains(j)) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Persoa xa existente");
                alert.showAndWait();
            } else {
                this.juego = j;
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Perfecto");
                alert.setContentText("Persoa creada correctamente");
                alert.showAndWait();
            }
            
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Algún dato con formato incorrecto");
            alert.showAndWait();
        }
    }

}
