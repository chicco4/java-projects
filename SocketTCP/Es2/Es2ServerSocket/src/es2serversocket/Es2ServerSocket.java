/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es2serversocket;

/**
 *
 * @author ilbos
 */
public class Es2ServerSocket {

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        int port = 8080;
        ServerInputThread d = new ServerInputThread(port);
        Thread t = new Thread(d);
        t.start();
    }
}
