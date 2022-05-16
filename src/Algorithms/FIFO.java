package Algorithms;

public class FIFO implements Algorithm {

    @Override
    public int[] handleSwap(AlgorithmParameters ap) {
        while(!ap.frames.contains(ap.references[ap.longestReference])) {
            ap.longestReference++;
        }
        int currReference = ap.references[ap.longestReference];
        int newReference = ap.currReference;
        ap.frames.swap(currReference, newReference);
        ap.longestReference++;

        return new int[]{currReference, newReference};
    }

    @Override
    public String toString() {
        return "FIFO";
    }
}
