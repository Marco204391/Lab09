package it.polito.tdp.metrodeparis;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.metrodeparis.model.Fermata;
import it.polito.tdp.metrodeparis.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class MetroDeParisController {
	
	Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Fermata> cbxPartenza;

    @FXML
    private ComboBox<Fermata> cbxarrivo;

    @FXML
    private Button btnCerca;

    @FXML
    void handleCerca(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert cbxPartenza != null : "fx:id=\"cbxPartenza\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
        assert cbxarrivo != null : "fx:id=\"cbxarrivo\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'MetroDeParis.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model=model;
		
		cbxPartenza.getItems().addAll(model.getFermate());
		cbxarrivo.getItems().addAll(model.getFermate());
	}
}