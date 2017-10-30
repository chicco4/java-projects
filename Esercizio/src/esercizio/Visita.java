package esercizio;
import EsListe.*;

/**
 *
 * @author federico.scaggiante&stoyan.botusharov
 */
public class Visita {
	ListaConcatenata lista =new ListaConcatenta();
	public ListaConcatenata visitaAnticipata(AlberoBin a){
		ListaConcatenata list = new ListaConcatenata();
		list.add(a.radix.info);
		list.add(a.radix.sX);
		list.add(a.radix.dX);
		ListaConcatenata(a.radix.sX);
		ListaConcatenata(a.radix.dX);
	}
}
