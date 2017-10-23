package esliste;

/**
 *
 * @author federico.scaggiante
 */
public interface Iterator<T> {
	public boolean inside();
	public T current();
	public void goNext();
	public void goFirst();
}
