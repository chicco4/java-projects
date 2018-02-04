/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2serversocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

class ServerOutputThread implements Runnable {

    Socket client;
    BufferedReader in;
    PrintStream out;
    String str;

    ServerOutputThread(Socket client) {
        this.client = client;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintStream(client.getOutputStream(), true);
        } catch (IOException ex) {
            System.out.println("in non instanziato");
        }
    }

    @Override
    public void run() {
        do {
            try {
                str = in.readLine();
                if (str.equals("date")) {
                    out.println(new Date().toString());
                }
            } catch (IOException ex) {
                System.out.println("Buffers non instanziati");
            }
        } while (!str.equals("exit"));
        out.flush();
        out.close();
        try {
            in.close();
            client.close();
        } catch (IOException ex) {
            System.out.println("Chiusi input streams");
        }
    }

}
