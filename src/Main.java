import Algorithms.*;

public class Main {

    public static void main(String[] args) {
        PageReferenceBuilder prb = new PageReferenceBuilder(100, 4);
        prb.localityChance(0.7);
//        prb.localityDensity(3);
//         FIFO BETTER THAN LRU
//        prb.manualMode(new int[]{7, 9, 9, 2, 9, 7, 6, 2, 3, 6});
        Simulation s = new Simulation(prb);
        System.out.println("Starting FIFO...");
        s.start(new FIFO());
        System.out.println("Starting OPT...");
        s.start(new OPT());
        System.out.println("Starting RAND...");
        s.start(new RAND());
        System.out.println("Starting LRU...");
        s.start(new LRU());
        System.out.println("Starting ALRU...");
        s.start(new ALRU());

        s.showVisuals();
    }
}
