package esercizio1;

/**
 *
 * @author federico.scaggiante
 */
public class Visita {
	public void visitaAnticipata(AlberoBin b){
                System.out.println(b.getInfo());
		if(b.getsX()!=null) visitaAnticipata(b.getsX());
		if(b.getdX()!=null) visitaAnticipata(b.getdX());
	}
	public void visitaDifferita(AlberoBin b){
		if(b.getsX()!=null) visitaDifferita(b.getsX());
		if(b.getdX()!=null) visitaDifferita(b.getdX());
		System.out.println(b.getInfo());
	}
	public void visitaSimmetrica(AlberoBin b){
		if(b.getsX()!=null) visitaDifferita(b.getsX());
		System.out.println(b.getInfo());
		if(b.getdX()!=null) visitaDifferita(b.getdX());
	}
}
