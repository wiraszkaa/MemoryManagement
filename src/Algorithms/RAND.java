package Algorithms;

public class RAND implements Algorithm {

    @Override
    public void handleSwap(AlgorithmParameters ap) {
        ap.frames.randSwap(ap.currReference);
    }

    @Override
    public String toString() {
        return "RAND";
    }
}
