import Algorithms.Algorithm;
import Algorithms.AlgorithmParameters;
import Algorithms.Frames;
import Algorithms.Visuals.FramesDrawer;

public class Simulation {
    private final PageReferenceBuilder prb;
    private final int[] references;

    public Simulation(PageReferenceBuilder prb) {
        this.prb = prb;
        references = prb.create();
    }

    public void start(Algorithm algorithm) {
        long start = System.nanoTime();

        int faults = 0;
        Frames frames = new Frames(prb.getFrames());
        FramesDrawer fd = new FramesDrawer(algorithm.toString());
        AlgorithmParameters ap = new AlgorithmParameters(references, frames);

        for (int i = 0; i < references.length; i++) {
            int reference = references[i];
            ap.lruHelper.add(reference);
            if (!frames.contains(reference)) {
                faults++;
                if (!frames.add(reference)) {
                    ap.currReference = reference;
                    ap.currIndex = i;
                    algorithm.handleSwap(ap);
                }
            }
            int[] array = new int[frames.framesArray.length];
            System.arraycopy(frames.framesArray, 0, array, 0, array.length);
            fd.addFrames(array);
        }

        long finish = (System.nanoTime() - start);
        System.out.println("Total faults = " + faults);
        System.out.println("Simulation took " + getTime(finish));

        fd.show();
    }

    private static String getTime(long nanoseconds) {
        StringBuilder sb = new StringBuilder();
        if (nanoseconds < 1_000_000) {
            return nanoseconds + "ns";
        }
        if (nanoseconds > 60_000_000_000L) {
            long temp = nanoseconds / 60_000_000_000L;
            nanoseconds -= temp * 60_000_000_000L;
            sb.append(temp).append(" min, ");
        }
        if (nanoseconds > 1_000_000_000) {
            long temp = nanoseconds / 1_000_000_000;
            nanoseconds -= temp * 1_000_000_000;
            sb.append(temp).append(" s, ");
        }
        if (nanoseconds > 1_000_000) {
            long temp = nanoseconds / 1_000_000;
            sb.append(temp).append(" ms");
        }
        return sb.toString();
    }
}
