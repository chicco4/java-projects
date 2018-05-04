/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author federico.scaggiante
 */
public class FXMLDocumentController implements Initializable {

    ConcreteContainer<String> container = new ConcreteContainer();
    Iterator iteratore;

    @FXML
    private Button first;

    @FXML
    private TextField currentIterator;

    @FXML
    private Button next;

    @FXML
    private Button rimuovi;

    @FXML
    private TextField newElement;

    @FXML
    private Button aggiungi;

    @FXML
    private void firstPressed(ActionEvent event) {
        currentIterator.setText((String) iteratore.first());
    }

    @FXML
    private void nextPressed(ActionEvent event) {
        if (iteratore.hasNext()) {
            currentIterator.setText((String) iteratore.next());
        }
    }

    @FXML
    private void rimuoviPressed(ActionEvent event) {
        container.remove(newElement.getText());
        newElement.setText("");
        if (iteratore.current() == null) {
            currentIterator.setText((String) iteratore.first());
        } else {
            currentIterator.setText((String) iteratore.current());
        }
    }

    @FXML
    private void aggiungiPressed(ActionEvent event) {
        if (!newElement.getText().trim().isEmpty()) {
            container.add(newElement.getText());
            newElement.setText("");
            currentIterator.setText((String) iteratore.current());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        container.add("Nella");
        container.add("Fede");
        container.add("Gaty");
        iteratore = container.getIterator();
        firstPressed(null);
    }

}
