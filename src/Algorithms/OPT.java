package Algorithms;

public class OPT implements Algorithm {

    @Override
    public int[] handleSwap(AlgorithmParameters ap) {
        int[] array = new int[ap.references.length - ap.currIndex];
        System.arraycopy(ap.references, ap.currIndex, array, 0, array.length);
        return ap.frames.optSwap(array, ap.currReference);
    }

    @Override
    public String toString() {
        return "OPT";
    }
}
