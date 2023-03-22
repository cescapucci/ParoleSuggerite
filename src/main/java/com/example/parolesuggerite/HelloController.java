package com.example.parolesuggerite;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HelloController {
<<<<<<< Updated upstream
    Parole parole = new Parole();
=======
    /**attributi*/
    @FXML
    private Label control, parolaLabel;
>>>>>>> Stashed changes
    @FXML
    private ListView paroleListView;

    @FXML
    private TextField parolaField;
<<<<<<< Updated upstream
=======
    @FXML
    private Button selezionaParola;
    private ArrayList<String> daPassareAListView = new ArrayList<>();
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======
    }

    /**
     * aggiorna gui lista
     */
    @FXML
    protected void aggiornaLista(){
        paroleListView.getItems().clear();
        for(int i=0; i<daPassareAListView.size(); i++){
            paroleListView.getItems().add(daPassareAListView.get(i));
        }
    }
    /**
     * seleziona la lista
     */
    public String getParolaListView(){
        String s = (String) paroleListView.getFocusModel().getFocusedItem();
        System.out.println(s);
        return s;
    }

    /**
     * seleziona un elemnto della list view
     */
    @FXML
    public void scegliParola(){
        parolaLabel.setText(getParolaListView());
    }

    /**getter/setter*/
>>>>>>> Stashed changes
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