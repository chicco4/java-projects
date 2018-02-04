/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testserversocketg;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilbos
 */
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
        while (true) {
            System.out.println("In attesa di Connessione...");
            Socket client;
            try {
                client = server.accept();
                System.out.println("Connessione accettata da: " + client.getInetAddress()+" alle "+new Date());
                ServerOutputThread d = new ServerOutputThread(client);
                Thread t = new Thread(d);
                t.start();
            } catch (IOException ex) {
                System.out.println("Connessione fallita");
            }
        }
    }
}
