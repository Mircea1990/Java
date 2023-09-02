package org.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

//class that will responsible for keeping the Memento
public class Caretaker {

    private final List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
