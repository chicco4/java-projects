/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientg;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    SendRequestToServer d;
    Thread t;
    int portI;
    String ips;
    String ports;
    String targas;

    @FXML
    private TextField ip;
    @FXML
    private TextField port;
    @FXML
    private TextField targa;
    @FXML
    private Slider s;
    @FXML
    private Label l;

    @FXML
    private void handleplayAction(ActionEvent event) {
        ips = ip.getText();
        ports = port.getText();
        portI = Integer.parseInt(ports);
        targas = targa.getText();
        d = new SendRequestToServer(ips, portI, targas);
        t = new Thread(d);
        t.start();
        System.out.println("Thread partito");
        try {
            t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.stop();
        System.out.println("Thread stoppato");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO     
    }

}
