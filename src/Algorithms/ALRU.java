package Algorithms;

public class ALRU implements Algorithm {
    @Override
    public int[] handleSwap(AlgorithmParameters ap) {
        int currReference = ap.ALRUHelper.getLRU();
        int newReference = ap.currReference;
        ap.frames.swap(currReference, newReference);

        return new int[]{currReference, newReference};
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.ALRU;
    }

    @Override
    public String toString() {
        return "ALRU";
    }
}
