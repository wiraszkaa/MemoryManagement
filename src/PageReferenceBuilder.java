import java.util.Arrays;
import java.util.Random;

public class PageReferenceBuilder {
    private int[] references;
    private final int frames;

    private int maxReference;
    private int localityDensity;
    private double localityChance;
    private boolean manualMode;

    public PageReferenceBuilder(int amount, int frames) {
        this.frames = frames;
        references = new int[amount];

        maxReference = 10;
        localityDensity = 3;
        localityChance = 0.5;
    }

    public boolean maxReference(int max) {
        if (max >= 0) {
            maxReference = max;
            return true;
        }
        return false;
    }

    public boolean localityDensity(int density) {
        if (density >= 2) {
            localityDensity = density;
            return true;
        }
        return false;
    }

    public boolean localityChance(double chance) {
        if (chance >= 0 && chance <= 1) {
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
                    if (i % localityChance == localityDensity - 1) {
                        reference = references[0];
                    } else if (i % localityDensity == localityDensity - 2) {
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
        return String.format("Creating %s references...\n%s\n", references.length, Arrays.toString(references));
    }
}
