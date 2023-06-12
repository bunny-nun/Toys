package model.comparator;

import model.toy.Toy;

import java.util.Comparator;

public class ToyComparator implements Comparator<Toy> {

    @Override
    public int compare(Toy t1, Toy t2) {
        return t1.getFrequency().compareTo(t2.getFrequency());
    }
}
