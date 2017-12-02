package esercizio;

/**
 *
 * @author federico.scaggiante
 */
public class NodoConc<T>{
    private T info;
    private NodoConc<T> dX;
	private NodoConc<T> sX;
	public NodoConc(T info, NodoConc<T> sX, NodoConc<T> dX) {
		this.info = info;
		this.dX = dX;
		this.sX = sX;
	}
	public NodoConc() {}
	public void setInfo(T info) {
		this.info = info;
	}
	public void setdX(NodoConc<T> dX) {
		this.dX = dX;
	}
	public void setsX(NodoConc<T> sX) {
		this.sX = sX;
	}
	public T getInfo() {
		return info;
	}
	public NodoConc<T> getdX() {
		return dX;
	}
	public NodoConc<T> getsX() {
		return sX;
	}
}
