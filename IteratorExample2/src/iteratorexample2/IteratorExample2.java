/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorexample2;

public class IteratorExample2 {
    public static void main(String[] args) {
        AlberoBin albero = new AlberoBin("prova.txt");
        Visitatore a = albero.getVisitatore();
        System.out.println(a.goRadice());
        System.out.println(a.goSx());
        System.out.println(a.goDx());
        System.out.println(a.goSx());
    }
}
