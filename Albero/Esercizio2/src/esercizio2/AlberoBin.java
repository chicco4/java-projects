package esercizio2;

/**
 *
 * @author federico.scaggiante
 */
public class AlberoBin {
	private Comparable info;
	private AlberoBin sX;
	private AlberoBin dX;
	public AlberoBin(Comparable info, AlberoBin sX, AlberoBin dX) {
		this.info = info;
		this.sX = sX;
		this.dX = dX;
	}
	public AlberoBin(Comparable info){
		this(info,null,null);
	}
	public AlberoBin(){
		this(null,null,null);
	}
	public void setInfo(Comparable info) {
		this.info = info;
	}
	public void setsX(AlberoBin sX) {
		this.sX = sX;
	}
	public void setdX(AlberoBin dX) {
		this.dX = dX;
	}
	public Comparable getInfo(){
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
	public String toString(){
		return toStringRic();
	}
	static String s="";
	public String toStringRic(){
		if(this==null) s+="()";
		else{
			s+="( "+this.getInfo()+" ";
			if(this.getsX()!=null) this.getsX().toStringRic();
			else{s+="()";}
			if(this.getdX()!=null) this.getdX().toStringRic();
			else{s+="()";}
			s+=" ) ";
		}
		return s;
	}
}
//http://lia.deis.unibo.it/Courses/FondB0506-INF-LZ/laboratorio/Esercitazioni07_e_soluzione.pdf