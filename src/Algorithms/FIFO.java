package Algorithms;

public class FIFO implements Algorithm {

    @Override
    public void handleSwap(AlgorithmParameters ap) {
        while(!ap.frames.contains(ap.references[ap.longestReference])) {
            ap.longestReference++;
        }
        ap.frames.swap(ap.references[ap.longestReference], ap.currReference);
        ap.longestReference++;
    }

    @Override
    public String toString() {
        return "FIFO";
    }
}
