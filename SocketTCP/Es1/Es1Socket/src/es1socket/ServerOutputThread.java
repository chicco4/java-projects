/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es1socket;

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
    String str;

    ServerOutputThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException ex) {
            System.out.println("in non instanziato");
        }
        do {
            try {
                str = in.readLine();
                System.out.println(str);
            } catch (IOException ex) {
                System.out.println("Buffers non instanziati");
            }
        }while(!str.equals("exit"));
    }

}
