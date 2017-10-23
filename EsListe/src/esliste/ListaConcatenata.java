package esliste;

/**
 *
 * @author federico.scaggiante
 */
public class ListaConcatenata <T> {
	private NodoConc head;
	public ListaConcatenata(){
		this.head=new NodoConc(null,null);
	}
	public ListaConcatenata(T[] a) {
		this();
		NodoConc temp = head;
		for (int i=0; i<a.length;i++){
			temp.setInfo(a[i]);
			temp.setNext(new NodoConc(null, null));
			temp = temp.getNext();
		}
	}
	public String toString(){
		NodoConc temp=head;
		String a="";
		for(int i=0;i<this.size();i++){
			a+="["+temp.getInfo()+"] ";
			temp=temp.getNext();
		}
		return a;
	}
	public int size(){
		NodoConc temp=head;
		int s=0;
		while(temp.getNext()!=null){
			s++;
			temp=temp.getNext();
		}
		return s;
	}
	public void addHead(T elem){
		NodoConc a=new NodoConc(elem,head);
		head=a;
	}
	public void addTail(T elem){
            NodoConc temp=head;
            for(int i=0;i<this.size();i++){
				temp=temp.getNext();
            }
            temp.setInfo(elem);
            temp.setNext(new NodoConc(null, null));
	}
	public void removeHead(){
		head=head.getNext();
	}
	public void removeTail(){
		NodoConc temp=head;
                for(int i=0;i<this.size()-1;i++){
                    temp=temp.getNext();
                }
                temp.setNext(null);
	}
	public T get(int n){
		NodoConc temp=head;
		for(int i=0;i<n;i++){
			temp=temp.getNext();
		}
		return (T) temp.getInfo();
	}
	public void set(int n,T x){
		NodoConc temp=head;
		for(int i=0;i<n;i++){
			temp=temp.getNext();
		}
		temp.setInfo(x);
	}
	public void add(int n,T x){
		NodoConc k=new NodoConc(x,null);
		NodoConc temp=head;
		for(int i=0;i<n-1;i++){
			temp=temp.getNext();
		}
		k.setNext(temp.getNext());
		temp.setNext(k);
	}
	public void remove(int n){
		NodoConc temp=head;
		for(int i=0;i<n-1;i++){
			temp=temp.getNext();
		}
		temp.setNext(temp.getNext().getNext());
	}
}
