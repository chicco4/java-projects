package provaawt4;

/**
 *
 * @author federico.scaggiante
 */
public class ProvaAWT4 {

    public static void main(String[] args) {
        //Prova funzionamento pila
        /*
        Pila p=new Pila();
        System.out.println(p.isEmpty());
        p.push("0");
        p.push("1");
        p.push("2");
        p.push("3");
        System.out.println(p.toString());
        System.out.println(p.isEmpty());
        System.out.println(p.size());
        System.out.println(p.top());
        System.out.println(p.size());
        System.out.println(p.pop());
        System.out.println(p.isEmpty());
        System.out.println(p.pop());
        System.out.println(p.isEmpty());
        System.out.println(p.pop());
        System.out.println(p.isEmpty());
        System.out.println(p.pop());
        System.out.println(p.isEmpty());
        p.push("0");
        p.push("1");
        p.push("2");
        p.push("3");
        System.out.println("NUOVO "+p.toString());
        Iterator it=p.iterator();
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
         */
        Pila s = new Pila();
        FramePila f = new FramePila("GestionePila", s);
        f.setVisible(true);
    }
}
