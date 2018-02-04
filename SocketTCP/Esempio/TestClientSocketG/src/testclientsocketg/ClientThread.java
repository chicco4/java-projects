/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclientsocketg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

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

    ClientThread(int port) {
        this.port = port;
        try {
            socket = new Socket("localhost", port);
        } catch (IOException ex) {
            System.out.println("Socket non instanziato");
        }
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream(), true);
            message = in.readLine();
        } catch (IOException ex) {
            System.out.println("Buffers non instanziati");
        }
        System.out.print("Messaggio Ricevuto alle " + message);
        out.close();
        try {
            in.close();
        } catch (IOException ex) {
            System.out.println("Stream input non chiuso");
        }
    }
}
