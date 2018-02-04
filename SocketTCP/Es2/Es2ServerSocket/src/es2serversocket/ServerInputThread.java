/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2serversocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

class ServerInputThread implements Runnable {

    int port;
    ServerSocket server;

    ServerInputThread(int port) {
        this.port = port;
        try {
            server = new ServerSocket(port);
            System.out.println("Il Server è in attesa sulla porta " + port);
        } catch (IOException ex) {
            System.out.println("Server non instanziato");
        }
    }

    @Override
    public void run() {
        System.out.println("In attesa di Connessione...");
        Socket client;
        try {
            while (true) {
                client = server.accept();
                System.out.println("Connesso a: " + client.getInetAddress() + " alle " + new Date());
                ServerOutputThread d = new ServerOutputThread(client);
                Thread t = new Thread(d);
                t.start();
            }
        } catch (IOException ex) {
            System.out.println("Connessione fallita");
        }
    }
}
