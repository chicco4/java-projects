/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es1clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

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
        input=new Scanner(System.in);
    }

    @Override
    public void run() {
        try {
            out = new PrintStream(socket.getOutputStream(), true);
            System.out.println("Connesso a "+socket.getInetAddress());
        } catch (IOException ex) {
            System.out.println("Buffers non instanziati");
        }
        System.out.println("Inserire stringhe:");
        do{
            str=input.nextLine();
            out.println(str);
        }while(!str.equals("exit"));
        out.close();
    }
}
