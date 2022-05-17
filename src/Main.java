import Algorithms.*;

public class Main {

    public static void main(String[] args) {
        PageReferenceBuilder prb = new PageReferenceBuilder(10, 4);
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
        System.out.println("Starting LRU APROX...");
        s.start(new ALRU());

        s.showVisuals();
    }
}
