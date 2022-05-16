import Algorithms.FIFO;
import Algorithms.LRU;
import Algorithms.OPT;
import Algorithms.RAND;

public class Main {

    public static void main(String[] args) {
        PageReferenceBuilder prb = new PageReferenceBuilder(13, 4);
        prb.manualMode(new int[]{7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2});
        Simulation s = new Simulation(prb);
        System.out.println("Starting FIFO...");
        s.start(new FIFO());
        System.out.println("Starting OPT...");
        s.start(new OPT());
        System.out.println("Starting RAND...");
        s.start(new RAND());
        System.out.println("Starting LRU...");
        s.start(new LRU());
    }
}
