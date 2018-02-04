/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2clientsocket;

/**
 *
 * @author ilbos
 */
public class Es2ClientSocket {

    public static void main(String[] args) {
        startClient();
    }

    public static void startClient() {
        int port = 8080;
        ClientThread d = new ClientThread(port);
        Thread t = new Thread(d);
        t.start();
    }
}

