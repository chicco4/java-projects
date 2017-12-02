package esercizio;

/**
 *
 * @author federico.scaggiante
 */
public class AlberoBin<T>{
	private NodoConc radix;
	public AlberoBin(T info,AlberoBin sX,AlberoBin dX){
		radix=new NodoConc();
		radix.setInfo(info);
		radix.setsX(sX.radix);
		radix.setdX(dX.radix);
	}
	public AlberoBin(T info){
		this(info,null,null);
	}
	public AlberoBin(){
		this(null,null,null);
	}
	public void setInfo(T info){
		radix.setInfo(info);
	}
	public void setSX(AlberoBin a){
		radix.setsX(radix);
	}
	public void setDX(AlberoBin a){
		radix.setdX(radix);
	}
	public T getInfo(){
		return (T) radix.getInfo();
	}
	public AlberoBin getSX(){
		NodoConc temp=radix;
		temp=
		return 
	}
	public AlberoBin getDX(){
		return radix.dX;
	}
	public boolean isEmpty(){
		return radix.getInfo()==null&&radix.getdX()==null&&radix.getsX()==null;
	}
	public String toString(){
		
	}
}
