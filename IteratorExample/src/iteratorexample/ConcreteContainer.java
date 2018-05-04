/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorexample;

import java.util.ArrayList;

/**
 *
 * @author federico.scaggiante
 */
public class ConcreteContainer<T> implements Container {

    private ArrayList<T> arrayList = new ArrayList<>();

    public ConcreteContainer() {
    }

    public void add(T value) {
        arrayList.add(value);
    }

    public void add(int pos, T value) {
        arrayList.add(pos, value);
    }

    public void remove(T value) {
        arrayList.remove(value);
    }

    public void remove(int pos) {
        arrayList.remove(pos);
    }

    public int size() {
        return arrayList.size();
    }

    public T getValue(int pos) {
        return arrayList.get(pos);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator();
    }

    class ConcreteIterator implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < arrayList.size() - 1;
        }

        @Override
        public T next() {
            index++;
            return current();
        }

        @Override
        public T current() {
            return arrayList.get(index);
        }

        @Override
        public T first() {
            index = 0;
            return current();
        }

    }

}
