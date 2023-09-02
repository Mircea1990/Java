package org.behavioral.iterator;

public class CollectionOfNames implements Container {

    public String[] name = {"Vasile Ion", "Iliescu Gavrila", "Constantinescu Emil", "Stefanescu Valentin", "Irimescu Anton"};

    @Override
    public IteratorPatternInt getIterator() {
        return new CollectionofNamesIterate();
    }

    private class CollectionofNamesIterate implements IteratorPatternInt {
        int i;

        @Override
        public boolean hasNext() {
            return i < name.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return name[i++];
            }
            return null;
        }
    }
}
