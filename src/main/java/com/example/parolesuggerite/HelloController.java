/**
 * @author cesca
 */
package com.example.parolesuggerite;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    /**attributi*/
    @FXML
    private Label control;
    @FXML
    private ListView paroleListView;
    @FXML
    private TextField parolaField;

    private ArrayList<String> daPassareAListView = new ArrayList<>();
    private StringProperty parola = new SimpleStringProperty();

    public HelloController() throws IOException {

    }

    @FXML
    public void initialize() {
        // binding bidirezionale
        this.parolaField.textProperty().bindBidirectional(this.parola);
    }

    /* event handler */

    /**
     * scorro tutte le parole da file
     * e comparo se la parola inizia con l'imput di text field
     * se si, la salva su un arraylist che viene usato per fare la gui
     */
    @FXML
    public void handleSuggerisciParole() {
        System.out.println("\n-----------------------------\nentrato");
        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader("C:\\Users\\pucci_f\\Documents\\GitHub\\ParoleSuggerite\\src\\main\\java\\com\\example\\parolesuggerite\\parole.txt"));

            String line = reader.readLine();

            while (line != null) {
                if (line.startsWith(parolaField.getText())) { //se la parola letta inzia cno quello che l'utente ha digitato
                    daPassareAListView.add(line);
                }
                line = reader.readLine();
            }
            reader.close();
            System.out.println("aggiorno listview\n");
            aggiornaLista();
            daPassareAListView.clear();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

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

    /**getter/setter*/
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