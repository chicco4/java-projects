/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclientsocketg;

/**
 *
 * @author ilbos
 */
public class TestClientSocketG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port=8080;
        ClientThread d=new ClientThread(port);
        Thread t=new Thread(d);
        t.start();
    }
}
