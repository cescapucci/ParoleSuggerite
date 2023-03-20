package com.example.parolesuggerite;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {
    Parole parole = new Parole();
    @FXML
    private ListView paroleListView;

    @FXML
    private TextField parolaField;
    private StringProperty parola = new SimpleStringProperty();

    public HelloController() throws IOException {
        
    }

    @FXML
    protected void suggerisciParola() {

    }

    @FXML
    public void initialize() {
        // binding bidirezionale
        this.parolaField.textProperty().bindBidirectional(this.parola);
    }

    /* event handler */
    /**
    public void handleAggiungiDipendente(MouseEvent event) {
        if (validaForm()) {
            // codice per aggiungere un nuovo dipendente
            // i valori da usare sono resi disponibili invocando
            // getNome(), getCognome() e getCodiceFiscale()
        }
    }**/

    public ListView getParoleListView() {
        return paroleListView;
    }

    public void setParoleListView(ListView paroleListView) {
        this.paroleListView = paroleListView;
    }

    public TextField getParolaField() {
        return parolaField;
    }

    public void setParolaField(TextField parolaField) {
        this.parolaField = parolaField;
    }

    public String getParola() {
        return parola.get();
    }

    public StringProperty parolaProperty() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola.set(parola);
    }
}