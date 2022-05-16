package Algorithms;

public class LRU implements Algorithm {

    @Override
    public void handleSwap(AlgorithmParameters ap) {
        ap.frames.swap(ap.lruHelper.getLRU(), ap.currReference);
    }

    @Override
    public String toString() {
        return "LRU";
    }
}
