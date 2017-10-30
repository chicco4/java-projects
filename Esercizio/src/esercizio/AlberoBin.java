package esercizio;

/**
 *
 * @author federico.scaggiante&stoyan.botusharov
 */
public class AlberoBin<T>{
	private NodoConc radix;
	public AlberoBin(T info,AlberoBin dX,AlberoBin sX){
		radix=new NodoConc();
		radix.info=info;
		radix.dX=dX.radix;
		radix.sX=sX.radix;
	}
	public AlberoBin(T info){
		this(info,null,null);
	}
	public AlberoBin(){
		this(null,null,null);
	}
	public void setInfo(T info){
		radix.info=info;
	}
	public void setSX(AlberoBin a){
		radix.sX=a.radix;
	}
	public void setDX(AlberoBin a){
		radix.dX=a.radix;
	}
	public T getInfo(){
		return (T) radix.info;
	}
	public NodoConc  getSX(){
		return radix.sX;
	}
	public NodoConc getDX(){
		return radix.dX;
	}
	public boolean isEmpty(){
		return radix.info==null&&radix.dX==null&&radix.sX==null;
	}
	public String toString(){
		
	}
}
