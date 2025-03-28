package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private AnagrammiModel model;
	
	public void setModel(AnagrammiModel model) {
		this.model=model;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnAnagrammi;

    @FXML
    private TextArea txtRisultatoCorretto;

    @FXML
    private TextArea txtRisultatoErrato;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	if(this.txtParola.getText().isEmpty()) {
    		this.txtRisultatoCorretto.setText("devi inserire una parola");
    		this.txtRisultatoErrato.setText("Devi inserire una parola");
    		return;
    	}
    	
    	for(String a: model.generaAnagrammi(this.txtParola.getText())) {
    		String anagramma= a.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    		if(model.isCorretto(anagramma)) {
    			this.txtRisultatoCorretto.appendText(anagramma+"\n");
    		}else {
    			this.txtRisultatoErrato.appendText(anagramma+"\n");
    		}
    	}

    }

    @FXML
    void doClear(ActionEvent event) {
    	this.txtParola.clear();
    	this.txtRisultatoCorretto.clear();
    	this.txtRisultatoErrato.clear();

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtRisultatoCorretto != null : "fx:id=\"txtRisultatoCorretto\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtRisultatoErrato != null : "fx:id=\"txtRisultatoErrato\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}


