package Algorithms;

import java.util.LinkedList;

public class ALRUHelper {

    private final LinkedList<Reference> references;

    public ALRUHelper() {
        references = new LinkedList<>();
    }

    public void add(int reference) {
        references.add(new Reference(reference));
    }

    public int getLRU() {
        Reference reference = null;
        do {
            for (Reference i : references) {
                if (i.chances == 0) {
                    reference = i;
                    break;
                }
                i.chances = 0;
            }
        } while (reference == null);

        references.remove(reference);
        return reference.value;
    }

    private static class Reference {
        int value;
        int chances;

        public Reference(int value) {
            this.value = value;

            chances = 1;
        }
    }
}
