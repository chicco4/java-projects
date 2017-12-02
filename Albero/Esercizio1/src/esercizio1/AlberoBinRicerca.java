package esercizio1;

/**
 *
 * @author federico.scaggiante
 */
public class AlberoBinRicerca<T> extends AlberoBin{
    public AlberoBinRicerca(T info, AlberoBin sX, AlberoBin dX) {
        super(info, sX, dX);
    }
    public AlberoBinRicerca(T info) {
        super(info);
    }
    public AlberoBinRicerca() {}
    public void add(T info){
	if(this.compareTo(info)>0){
            if(this.getdX()==null) this.setdX(new AlberoBinRicerca(info));
            else ((AlberoBinRicerca)this.getsX()).add(info);
        }else{
            if(this.getsX()==null) this.setsX(new AlberoBinRicerca(info));
            else ((AlberoBinRicerca)this.getsX()).add(info);
        }
    }
}
