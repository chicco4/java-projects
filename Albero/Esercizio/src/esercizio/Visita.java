package esercizio;

/**
 *
 * @author federico.scaggiante
 */
public class Visita {
	public static void visitaAnticipata(AlberoBin b){
		if(!b.isEmpty()){
			System.out.println(b.getInfo());
			visitaAnticipata(b.getSX());
			visitaAnticipata(b.getDX());
		}
	}
	public static void visitaDifferita(AlberoBin b){
		if(!b.isEmpty()){
			visitaDifferita(b.getSX());
			visitaDifferita(b.getDX());
			System.out.println(b.getInfo());
		}
	}
	public static void visitaSimmetrica(AlberoBin b){
		if(!b.isEmpty()){
			visitaDifferita(b.getSX());
			System.out.println(b.getInfo());
			visitaDifferita(b.getDX());
		}
	}
}
