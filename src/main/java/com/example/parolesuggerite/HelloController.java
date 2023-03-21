package com.example.parolesuggerite;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    Parole parole;
    @FXML
    private Label control;
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
    @FXML
    public void handleSuggerisciParole() {
        System.out.println("\n\n\n-----------------------------\n\n\nentrato");
        ArrayList<String> suggerimenti = new ArrayList<>();
        System.out.println(Parole.parole.size());
        for (int i = 0; i < Parole.parole.size(); i++){//scorre l'arryalist del file
            System.out.println(Parole.parole.get(i));
            if (Parole.parole.get(i).contains(parolaField.getText())){//se la scritta nel field è presente nella posizione
                suggerimenti.add(Parole.parole.get(i));
            }
        }

        aggiornaLista();

        System.out.println("arraylist dei suggerimenti  inerenti");
        for (int i = 0; i < suggerimenti.size(); i++){
            System.out.println(suggerimenti.get(i));
        }
        if (suggerimenti.isEmpty()) control.setText("non abbiamo suggerimenti");
    }

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

    /**
     * aggiorna gui lista
     */
    @FXML
    protected void aggiornaLista(){
        paroleListView.getItems().clear();
        for(int i=0; i<Parole.parole.size(); i++){
            paroleListView.getItems().add(Parole.parole.get(i));
        }
    }
}

/**
 *   /* event handler *
 *public void handleAggiungiDipendente(MouseEvent event){
        *if(validaForm()){
        *             // codice per aggiungere un nuovo dipendente
        *             // i valori da usare sono resi disponibili invocando
        *             // getNome(), getCognome() e getCodiceFiscale()
        *}
        *}
        *
 *
 *
        *private boolean validaForm(){
        *boolean valido=true;
        *String msg="";
        *if(getNome()==null||getNome().isEmpty()){
        *msg+="Inserisci nome\n";
        *valido=false;
        *}
        *if(getCognome()==null||getCognome().isEmpty()){
        *msg+="Inserisci cognome\n";
        *valido=false;
        *}
        *if(getCodiceFiscale()==null||getCodiceFiscale().isEmpty()){
        *msg+="Inserisci codice fiscale\n";
        *valido=false;
        *}
        *setMessaggioValidazione(msg);
        *return valido;
        *}
 */