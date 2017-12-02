package esercizio2;

/**
 *
 * @author federico.scaggiante
 */
public class Esercizio2 {
    public static void main(String[] args) {
		Visita v=new Visita();
        AlberoBinRicerca three=new AlberoBinRicerca();
        three.add("a");
        three.add("c");
        three.add("b");
		three.add("r");
		three.add("e");
        v.visitaAnticipata(three);
		System.out.println(three.search("i"));
		System.out.println(three.toString());
    }
}
