/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author federico.scaggiante
 */
public class SendToClient implements Runnable {

    ArrayList database;
    String str;//"request(192.168.56.1)[8080]"

    DatagramSocket dataSocket;
    DatagramPacket pacchetto;
    String ips;
    String ports;
    int portI;
    InetAddress ip;
    String targas;
    String toSend;

    SendToClient(DatagramPacket pacchetto, ArrayList database) {
        this.database = database;
        this.pacchetto=pacchetto;
    }

    @Override
    public void run() {
        ip = pacchetto.getAddress();
        portI = pacchetto.getPort();
        String stri = new String(pacchetto.getData(), 0, pacchetto.getLength());
        System.out.println("stri=" + stri);
        targas = stri.substring(7);
        System.out.println("targas=" + targas);
        String stri1 = database.toString();
        System.out.println("database=" + stri1);
        //[Targa: DESKTOP-TBIEPIU/192.168.1.10(Latitudine: 28.030222 Longitudine: 73.04904 Data: Fri Feb 02 19:31:54 CET 2018), Targa: DESKTOP-T
        toSend="";
        //invio solo dati targas giusta!!!!!!!
        for(int i=0;i<database.size();i++){
            if(database.get(i).toString().contains(targas)){
                toSend+=database.get(i);
            }
        }
        
        try {
            this.dataSocket = new DatagramSocket();
            System.out.println("dataSocket instanziato");
        } catch (SocketException ex) {
            System.out.println("dataSocket non instanziato");
        }
        //creo il pacchetto
        this.pacchetto = new DatagramPacket(toSend.getBytes(), toSend.length(), ip, portI);
        System.out.println("Pacchetto creato");
        try {
            dataSocket.send(pacchetto);
            System.out.println("Pacchetto inviato");
        } catch (IOException ex) {
            System.out.println("Pacchetto non inviato");
        }
    }
}
