
/* G. Callegarin - "Java, Oggetti e Strutture Dati", Copyright � CEDAM, 2004, wwww.javaosd.org
  pag. 340, Ultima modifica: Maggio 2006 - versione generica per JAVA 5
  Nodo concatenabile */
package provaawt2;

public class NodoConc<T> {

    private T info;     //campo informazione
    private NodoConc<T> next;   //campo link
    //costruttore

    public NodoConc(T info, NodoConc<T> next) {
        this.info = info;
        this.next = next;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setNext(NodoConc<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public NodoConc<T> getNext() {
        return next;
    }
}
