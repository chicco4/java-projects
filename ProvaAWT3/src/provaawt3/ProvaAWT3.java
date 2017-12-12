package provaawt3;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author federico.scaggiante
 */
public class ProvaAWT3 {
    public static void main(String[] args) {
	//Utilizzo classe Stack per comodità
        Stack s =new Stack();
        s.add("1");
        s.add("2");
        FramePila f = new FramePila("GestionePila",s);
	f.setVisible(true);        
    }
    
}
