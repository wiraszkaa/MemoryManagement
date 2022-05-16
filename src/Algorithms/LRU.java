package Algorithms;

public class LRU implements Algorithm {

    @Override
    public int[] handleSwap(AlgorithmParameters ap) {
        int currReference = ap.lruHelper.getLRU();
        int newReference = ap.currReference;
        ap.frames.swap(currReference, newReference);

        return new int[]{currReference, newReference};
    }

    @Override
    public String toString() {
        return "LRU";
    }
}
