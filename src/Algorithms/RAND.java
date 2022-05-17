package Algorithms;

public class RAND implements Algorithm {

    @Override
    public int[] handleSwap(AlgorithmParameters ap) {
        return ap.frames.randSwap(ap.currReference);
    }

    @Override
    public AlgorithmType getType() {
        return null;
    }

    @Override
    public String toString() {
        return "RAND";
    }
}
