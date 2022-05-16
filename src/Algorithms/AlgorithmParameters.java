package Algorithms;

public class AlgorithmParameters {
    int[] references;

    Frames frames;
    public int currReference;
    // FIFO
    int longestReference;
    // OPT
    public int currIndex;
    // LRU
    public LRUHelper lruHelper;

    public AlgorithmParameters(int[] references, Frames frames) {
        this.references = references;
        this.frames = frames;

        lruHelper = new LRUHelper();
    }
}
