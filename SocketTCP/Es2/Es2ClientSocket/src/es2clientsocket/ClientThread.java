/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2clientsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilbos
 */
class ClientThread implements Runnable {

    BufferedReader in;
    PrintStream out;
    Socket socket;
    String message;
    int port;
    Scanner input;
    String str;

    ClientThread(int port) {
        this.port = port;
        try {
            socket = new Socket("localhost", port);
        } catch (IOException ex) {
            System.out.println("Socket non instanziato");
        }
        input = new Scanner(System.in);
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream(), true);
            System.out.println("Connesso a " + socket.getInetAddress());
        } catch (IOException ex) {
            System.out.println("Buffers non instanziati");
        }
    }

    @Override
    public void run() {
        System.out.println("Inserire comandi: eg. \"date\"");
        do {
            str = input.nextLine();
            out.println(str);
            if (str.equals("date")) {
                try {
                    System.out.println(in.readLine());
                } catch (IOException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } while (!str.equals("exit"));
        out.close();
        out.flush();
        try {
            in.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println("Chiusi streams input");
        }
    }
}
