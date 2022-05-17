import Algorithms.Algorithm;
import Algorithms.AlgorithmParameters;
import Algorithms.AlgorithmType;
import Algorithms.Frames;
import Algorithms.Utils.Utils;
import Algorithms.Visuals.FramesDrawer;

import javax.swing.*;

public class Simulation {
    private final PageReferenceBuilder prb;
    private final int[] references;

    private final JPanel panel;

    public Simulation(PageReferenceBuilder prb) {
        this.prb = prb;
        references = prb.create();

        panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
    }

    public void start(Algorithm algorithm) {
        int faults = 0;
        Frames frames = new Frames(prb.getFrames());
        FramesDrawer fd = new FramesDrawer(algorithm.toString());
        AlgorithmParameters ap = new AlgorithmParameters(references, frames);

        long start = System.nanoTime();
        for (int i = 0; i < references.length; i++) {
            int reference = references[i];

            if(algorithm.getType() == AlgorithmType.LRU) {
                ap.lruHelper.add(reference);
            }

            int[] changeArray = null;
            if (!frames.contains(reference)) {
                if (algorithm.getType() == AlgorithmType.ALRU) {
                    ap.ALRUHelper.add(reference);
                }
                faults++;
                if (!frames.add(reference)) {
                    ap.currReference = reference;
                    ap.currIndex = i;
                    changeArray = algorithm.handleSwap(ap);
                } else {
                    changeArray = new int[]{reference};
                }
            }
            int[] array = new int[frames.framesArray.length];
            System.arraycopy(frames.framesArray, 0, array, 0, array.length);
            fd.addFrames(array, changeArray);
        }

        long finish = (System.nanoTime() - start);
        System.out.println("Total faults = " + faults);
        System.out.println("Simulation took " + getTime(finish));

        panel.add(fd.getPanel());
    }

    public void showVisuals() {
        Utils.show(panel, "Frames");
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
