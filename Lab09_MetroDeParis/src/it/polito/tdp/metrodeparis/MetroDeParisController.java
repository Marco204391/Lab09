package it.polito.tdp.metrodeparis;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.metrodeparis.model.Fermata;
import it.polito.tdp.metrodeparis.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class MetroDeParisController {
	
	Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
	private TextArea txtRisultato;
    
    @FXML
    private ComboBox<Fermata> cbxPartenza;

    @FXML
    private ComboBox<Fermata> cbxarrivo;

    @FXML
    private Button btnCerca;

    @FXML
    void handleCerca(ActionEvent event) {
    	
    	Fermata stazioneDiPartenza = cbxPartenza.getValue();
		Fermata stazioneDiArrivo = cbxarrivo.getValue();

		if (stazioneDiPartenza != null && stazioneDiArrivo != null) {
			
			if (!stazioneDiPartenza.equals(stazioneDiArrivo)) {

				try {
					// Calcolo il percorso tra le due stazioni
					model.calcolaPercorso(stazioneDiPartenza, stazioneDiArrivo);
					
					// Ottengo il tempo di percorrenza
					int tempoTotaleInSecondi = (int) model.getPercorsoTempoTotale();
					int ore = tempoTotaleInSecondi / 3600;
					int minuti = (tempoTotaleInSecondi % 3600) / 60;
					int secondi = tempoTotaleInSecondi % 60;
					String timeString = String.format("%02d:%02d:%02d", ore, minuti, secondi);
					StringBuilder risultato = new StringBuilder();

					// Ottengo il percorso
					risultato.append(model.getPercorsoEdgeList());
					risultato.append("\n\nTempo di percorrenza stimato: " + timeString + "\n");

					// Aggiorno la TextArea
					txtRisultato.setText(risultato.toString());

				} catch (RuntimeException e) {
					txtRisultato.setText(e.getMessage());
				}
			
			} else {
				txtRisultato.setText("Inserire una stazione di arrivo diversa da quella di partenza.");
			}

		} else {
			txtRisultato.setText("Inserire una stazione di arrivo ed una di partenza.");
		}

    }

    @FXML
    void initialize() {
    	assert txtRisultato != null : "fx:id=\"txtElencoStazioni\" was not injected: check your FXML file 'gui.fxml'.";
    	assert cbxPartenza != null : "fx:id=\"cbxPartenza\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
        assert cbxarrivo != null : "fx:id=\"cbxarrivo\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'MetroDeParis.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model=model;
		model.createGraph();
		cbxPartenza.getItems().addAll(model.getFermate());
		cbxarrivo.getItems().addAll(model.getFermate());
	}
}