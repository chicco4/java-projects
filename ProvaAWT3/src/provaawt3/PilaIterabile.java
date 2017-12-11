package provaawt3;

import java.util.Iterator;
import java.util.Stack;
import java.util.function.Consumer;

/**
 *
 * @author federico.scaggiante
 */
public class PilaIterabile implements Iterator{
    private NodoConc first;
    public PilaIterabile(Object info) {
        first = new NodoConc(info, null);
    }
    public PilaIterabile() {
        this(null);
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void push(Object info) {
        NodoConc<Object> n = new NodoConc<>(info, null);
        n.setNext(first);
        first = n;
    }
    public Object pop() {
        if (!isEmpty()) {
            Object out = first.getInfo();
            first = first.getNext();
            return out;
        }
        return null;
    }
    public Object top() {
        return first.getInfo();
    }
    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Object next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void remove() {
        Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void forEachRemaining(Consumer cnsmr) {
        Iterator.super.forEachRemaining(cnsmr); //To change body of generated methods, choose Tools | Templates.
    }
}
