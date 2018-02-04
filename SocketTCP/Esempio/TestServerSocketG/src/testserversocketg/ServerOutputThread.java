/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testserversocketg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilbos
 */
class ServerOutputThread implements Runnable {

    Socket client;
    BufferedReader in;
    PrintStream out;

    ServerOutputThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintStream(client.getOutputStream(), true);
            //in.readLine();
        } catch (IOException ex) {
            System.out.println("Buffers non instanziati");
        }
        out.println(new Date().toString());
        out.flush();
        // chiude gli stream e le connessioni
        out.close();
        try {
            in.close();
            client.close();
        } catch (IOException ex) {
            System.out.println("Streams non chiusi");
        }
    }

}
