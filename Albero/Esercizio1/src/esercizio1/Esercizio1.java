package esercizio1;

/**
 *
 * @author federico.scaggiante
 */
public class Esercizio1 {
	public static void main(String[] args) {
		AlberoBin a=new AlberoBin("a");
		AlberoBin b=new AlberoBin("b");
		AlberoBin c=new AlberoBin("c");
		AlberoBin d=new AlberoBin("d");
		AlberoBin e=new AlberoBin("e");
		a.setsX(b);
		a.setdX(c);
		c.setsX(d);
		c.setdX(e);
		Visita v=new Visita();
		v.visitaAnticipata(a);
		//System.out.println(a.compareTo(b));
                AlberoBinRicerca three=new AlberoBinRicerca(1);
                three.add(2);
                three.add(3);
                three.add(4);
                v.visitaAnticipata(three);
	}	
}
