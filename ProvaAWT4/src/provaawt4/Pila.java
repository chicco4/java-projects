package provaawt4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * classe Pila creata a piacere
 *
 * @author federico.scaggiante
 */
public class Pila<T> implements Iterable {
    private NodoConc first;
    private NodoConc head;
    public Pila(T info) {
        first = new NodoConc(info, null);
    }
    public Pila() {
        this(null);
    }
    public boolean isEmpty() {
        return first.getInfo() == null;
    }
    public void push(T info) {
        NodoConc<T> temp = new NodoConc(info, first);
        first = temp;
    }
    public T pop() {
        if (!isEmpty()) {
            T out = (T) first.getInfo();
            first = first.getNext();
            return out;
        }
        return null;
    }
    //possibile errore nel pop
    public T top() {
        return (T) first.getInfo();
    }
    //forse
    public T get(int n) {
        NodoConc temp = first;
        for (int i = 0; i < n; i++) {
            temp = temp.getNext();
        }
        return (T) temp.getInfo();
    }
    public int size() {
        int count = 0;
        NodoConc temp = first;
        while (temp.getNext() != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
    public String toString() {
        String s = "";
        NodoConc temp = first;
        while (temp.getNext() != null) {
            s = s + "[" + temp.getInfo() + "] ";
            temp = temp.getNext();
        }
        return s;
    }
    @Override
    public Iterator iterator() {
        return new PilaIterator();
    }
    //PilaIterator fatto al momento
    class PilaIterator implements Iterator<T> {
        int current = 0;
        ArrayList<T> arrayInfo;
        public PilaIterator() {
            arrayInfo = new ArrayList();
            NodoConc temp = first;
            for (int i = 0; i < Pila.this.size(); i++) {
                arrayInfo.add((T) temp.getInfo());
                temp = temp.getNext();
            }
            ArrayList<T> arrayInfoC = new ArrayList(arrayInfo.size());
            for (int i = arrayInfo.size() - 1; i >= 0; i--) {
                arrayInfoC.add(arrayInfo.get(i));
            }
            arrayInfo = arrayInfoC;
        }
        @Override
        public boolean hasNext() {
            return current < arrayInfo.size();
        }
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return arrayInfo.get(current++);
        }
    }
}
