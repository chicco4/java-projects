/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 *
 * @author federico.scaggiante
 */
public class FXMLDocumentController implements Initializable {

    ServerInputListener d;
    boolean isAlive = false;
    Thread t;
    int portI;
    String ports;

    @FXML
    private TextField port;
    @FXML
    private Slider s;
    @FXML
    private Label l;

    @FXML
    private void handleplayAction(ActionEvent event) {
        if (isAlive == false) {
            ports = port.getText();
            portI = Integer.parseInt(ports);
            d = new ServerInputListener(portI);
            t = new Thread(d);
            t.start();
            System.out.println("Thread partito");
            isAlive = true;
        } else {
            t.resume();
            System.out.println("Thread ripartito");
        }
    }

    @FXML
    private void handlepausaAction(ActionEvent event) {
        if (isAlive == true) {
            t.suspend();
            System.out.println("Thread sospeso");
        }
    }

    @FXML
    private void handlestopAction(ActionEvent event) {
        if (isAlive == true) {
            t.stop();
            System.out.println("Thread stoppato");
            isAlive = false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO     
    }

}
