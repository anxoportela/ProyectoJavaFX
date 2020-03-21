package com.proyecto.javafx.app;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    
    @FXML
	private TableView<Juego> tblJuegos;
	
	@FXML
	private TableColumn colTitulo;
	
	@FXML
	private TableColumn colGenero;
	
	@FXML
	private TableColumn colPlataforma;
	
	@FXML
	private TableColumn colMultijugador;
	
	private ObservableList<Juego> juegos;
	
	private JuegoDAO juegoDAO;
	
	@FXML
	private void agregarJuego(ActionEvent event) {
		
		try {
			String multi;
			if (rdbSi.isSelected()) {
				multi = "Sí";
			} else {
				multi = "No";
			}
			Juego j = new Juego(this.txtTitulo.getText(), this.comboBoxGenero.getValue(), this.comboBoxPlataforma.getValue(), multi);
			this.juegos.add(j);
			juegoDAO.rexistrar(j);
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
        Juego j = (Juego) this.tblJuegos.getSelectionModel().getSelectedItem();
        if (j == null) {
        	Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText((String) null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un juego");
            alert.showAndWait();
        } else {
        	try {
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/proyecto/javafx/app/JuegosDiag.fxml"));
                Parent root = (Parent) loader.load();
                JuegosDiagController controlador = (JuegosDiagController) loader.getController();
                controlador.inicializarAtributos(this.juegos, j);
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.showAndWait();
                Juego aux = controlador.getJuego();
                if (aux != null) {
                    this.juegoDAO.actualizar(aux);
                    this.tblJuegos.refresh();
                }
            } catch (IOException var9) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText((String) null);
                alert.setTitle("Error");
                alert.setContentText(var9.getMessage());
                alert.showAndWait();
            }
        	
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
			juegoDAO.eliminar(j);
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
        
        colTitulo.setCellValueFactory(new PropertyValueFactory("titulo"));
		colGenero.setCellValueFactory(new PropertyValueFactory("genero"));
		colPlataforma.setCellValueFactory(new PropertyValueFactory("plataforma"));
		colMultijugador.setCellValueFactory(new PropertyValueFactory("multijugador"));

        this.tblJuegos.refresh();
	}

}

