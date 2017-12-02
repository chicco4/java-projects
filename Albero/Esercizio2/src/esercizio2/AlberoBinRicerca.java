package esercizio2;

/**
 *
 * @author federico.scaggiante
 */
public class AlberoBinRicerca extends AlberoBin{
	public AlberoBinRicerca(Comparable info, AlberoBin sX, AlberoBin dX) {
		super(info, sX, dX);
	}
	public AlberoBinRicerca(Comparable info) {
		super(info);
	}
	public AlberoBinRicerca() {}
    public void add(Comparable info){
	if(this.search(info)==info){}
	else{
		if(this.getInfo()==null){
			this.setInfo(info);
		}else{
			if(this.getInfo().compareTo(info)>0){
				if(this.getsX()==null) this.setsX(new AlberoBinRicerca(info));
				else ((AlberoBinRicerca)this.getsX()).add(info);
			}else{
				if(this.getdX()==null) this.setdX(new AlberoBinRicerca(info));
				else ((AlberoBinRicerca)this.getdX()).add(info);
				}
			}
		}
	}
	public void delete(Comparable info){
		
	}
	public Comparable search(Comparable info){
		if(this.getInfo()==info) return info;
		else{
			if(this.getsX()!=null) return ((AlberoBinRicerca)this.getsX()).search(info);
			if(this.getdX()!=null) return ((AlberoBinRicerca)this.getdX()).search(info);
		}
		return null;
	}
}
