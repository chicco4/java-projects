/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rilevatoreg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author federico.scaggiante
 */
public class SendDataToServer implements Runnable {

    DatagramSocket dataSocket;
    DatagramPacket pacchetto;
    String ips;//192.168.56.1
    int portI;
    InetAddress ip;

    public SendDataToServer(String ips, int portI) {
        this.ips = ips;
        this.portI = portI;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.dataSocket = new DatagramSocket();
            } catch (SocketException ex) {
                System.out.println("dataSocket non instanziato");
            }
            try {
                ip = InetAddress.getByName(ips);
            } catch (UnknownHostException ex) {
                System.out.println("InetAddress non creato");
            }
            String toSend = null;
            try {
                toSend = "Targa: " + InetAddress.getLocalHost() + "(Latitudine: " + new Random().nextFloat() * 100 + " Longitudine: " + new Random().nextFloat() * 100 + " Data: " + new Date() + ")";
            } catch (UnknownHostException ex) {
                Logger.getLogger(SendDataToServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.pacchetto = new DatagramPacket(toSend.getBytes(), toSend.length(), ip, portI);
            System.out.println("Pacchetto creato");
            try {
                dataSocket.send(pacchetto);
                System.out.println("Pacchetto inviato");
            } catch (IOException ex) {
                System.out.println("Pacchetto non inviato");
            }
            try {
                System.out.println("Thread in attesa");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("Thread non più in attesa");
            } catch (InterruptedException ex) {
                System.out.println("Interrotto");
            }
        }
    }

}
