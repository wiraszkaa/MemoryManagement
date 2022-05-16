import java.util.Arrays;
import java.util.Random;

public class PageReferenceBuilder {
    private int[] references;
    private final int frames;

    private int maxReference;
    private boolean manualMode;

    public PageReferenceBuilder(int amount, int frames) {
        this.frames = frames;
        references = new int[amount];

        maxReference = 10;
    }

    public boolean maxReference(int max) {
        if(max >= 0) {
            maxReference = max;
            return true;
        }
        return false;
    }

    public boolean manualMode(int[] references) {
        if(references.length == this.references.length) {
            this.references = references;
            manualMode = true;
            return true;
        }
        return false;
    }

    public int[] create() {
        if(!manualMode) {
            Random random = new Random();
            for(int i = 0; i < references.length; i++) {
                references[i] = random.nextInt(maxReference);
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
