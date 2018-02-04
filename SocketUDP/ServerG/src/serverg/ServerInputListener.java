/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 *
 * @author federico.scaggiante
 */
public class ServerInputListener implements Runnable {

    DatagramSocket dataSocket;
    DatagramPacket pacchetto;
    int portI;
    SendToClient d;
    //Database
    ArrayList<String> database;

    ServerInputListener(int portI) {
        this.portI = portI;
        database = new ArrayList();
        //in alternativa è possibile creare solo qui il datagramSocket e non chiuderlo nel run
    }

    @Override
    public void run() {
        while (true) {
            try {
                dataSocket = new DatagramSocket(portI);
                System.out.println("dataSocket creato");
            } catch (SocketException ex) {
                System.out.println("DatagramSocket non creato");
            }
            byte[] buf = new byte[1024];
            pacchetto = new DatagramPacket(buf, 1024);
            System.out.println("creato pacchetto da ricevere");
            try {
                System.out.println("attesa pacchetto");
                dataSocket.receive(pacchetto);
                System.out.println("Ricevuto pacchetto");
            } catch (IOException ex) {
                System.out.println("Pacchetto non ricevuto");
            }
            String str = new String(pacchetto.getData(), 0, pacchetto.getLength());
            if (str.contains("request")) {
                d = new SendToClient(pacchetto, database);
                Thread t = new Thread(d);
                t.start();
            } else {
                database.add(str);
            }
            dataSocket.close();
            System.out.println(str);
        }
    }

}
