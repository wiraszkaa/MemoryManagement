import java.util.Arrays;
import java.util.Random;

public class PageReferenceBuilder {
    private int[] references;
    private final int frames;

    private int maxReference;
    private double localityChance;
    private boolean manualMode;

    public PageReferenceBuilder(int amount, int frames) {
        this.frames = frames;
        references = new int[amount];

        maxReference = 10;
        localityChance = 0.5;
    }

    public boolean maxReference(int max) {
        if (max >= 0) {
            maxReference = max;
            return true;
        }
        return false;
    }

    public boolean localityChance(double chance) {
        if(chance >= 0 && chance <= 1) {
            localityChance = chance;
            return true;
        }
        return false;
    }

    public boolean manualMode(int[] references) {
        if (references.length > 0) {
            this.references = references;
            manualMode = true;
            return true;
        }
        return false;
    }

    public int[] create() {
        if (!manualMode) {
            Random random = new Random();
            for (int i = 0; i < references.length; i++) {
                int reference = random.nextInt(maxReference);
                if (i >= 2 && random.nextDouble() <= localityChance) {
                    if (i % 3 == 1) {
                        reference = references[0];
                    } else if (i % 3 == 2) {
                        reference = references[1];
                    }
                }
                references[i] = reference;
            }
        }

        System.out.println(this);
        return references;
    }

    public int getFrames() {
        return frames;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Creating %s references...\n", references.length)).append(Arrays.toString(references)).append("\n");

        return sb.toString();
    }
}
