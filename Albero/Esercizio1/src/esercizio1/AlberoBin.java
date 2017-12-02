package esercizio1;

/**
 *
 * @author federico.scaggiante
 */
public class AlberoBin<T> implements Comparable{
	private T info;
	private AlberoBin sX;
	private AlberoBin dX;
	public AlberoBin(T info, AlberoBin sX, AlberoBin dX) {
		this.info = info;
		this.sX = sX;
		this.dX = dX;
	}
	public AlberoBin(T info){
		this(info,null,null);
	}
	public AlberoBin(){
		this(null,null,null);
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public void setsX(AlberoBin sX) {
		this.sX = sX;
	}
	public void setdX(AlberoBin dX) {
		this.dX = dX;
	}
	public T getInfo(){
		return info;
	}
	public AlberoBin getsX() {
		return sX;
	}
	public AlberoBin getdX() {
		return dX;
	}
	public boolean isEmpty(){
		return this.getInfo()==null;
	}
        @Override
        public int compareTo(Object t) {
		if((int)(Object)this.getInfo().hashCode()==(int)(((AlberoBin)t).getInfo().hashCode()))
			return 0;
		else{
			if((int)(Object)this.getInfo().hashCode()>(int)((AlberoBin)t).getInfo().hashCode())
				return 1;
			else
				return -1;	
		}
        }
}
//http://lia.deis.unibo.it/Courses/FondB0506-INF-LZ/laboratorio/Esercitazioni07_e_soluzione.pdf