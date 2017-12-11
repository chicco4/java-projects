package provaawt3;

/**
 *
 * @author federico.scaggiante
 */
public class NodoConc<T>{
    private T info;
    private NodoConc<T> next;
    NodoConc(T info,NodoConc<T> next){
        this.info=info;
        this.next=next;
    }   
    public T getInfo() {
        return info;
    }
    public NodoConc<T> getNext() {
        return next;
    }
    public void setInfo(T info) {
        this.info=info;
    }
    public void setNext(NodoConc<T> next) {
        this.next=next;
    }
}
