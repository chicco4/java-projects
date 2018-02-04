/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author federico.scaggiante
 */
class SendRequestToServer implements Runnable {

    DatagramSocket dataSocket;
    DatagramPacket pacchetto;//"request192.168.56.1"
    String ips;//192.168.56.1
    int portI;
    InetAddress ip;
    String targas;

    public SendRequestToServer(String ips, int portI,String targas) {
        this.ips = ips;
        this.portI = portI;
        this.targas=targas;
    }

    @Override
    public void run() {
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
        String toSend;
        toSend = "request" + targas;
        this.pacchetto = new DatagramPacket(toSend.getBytes(), toSend.length(), ip, portI);
        System.out.println("Pacchetto creato");
        try {
            dataSocket.send(pacchetto);
            System.out.println("Pacchetto inviato");
            byte[] buf = new byte[1024];
            pacchetto = new DatagramPacket(buf, 1024);
            try {
                dataSocket.receive(pacchetto);
            } catch (IOException ex) {
                System.out.println("DatagrammSocket non riceve il pacchetto");
            }
            dataSocket.close();
            String str = new String(pacchetto.getData(), 0, pacchetto.getLength());
            System.out.println(str);
        } catch (IOException ex) {
            System.out.println("Pacchetto non inviato");
        }
    }
}
