package Algorithms.Visuals;

import javax.swing.*;
import java.awt.*;

public class FramesDrawer {
    JPanel panel;
    String title;

    public FramesDrawer(String name) {
        panel = new JPanel();
        title = name;
    }

    public void addFrames(int[] frames) {
        FramesCanvas fc = new FramesCanvas(frames);
        panel.add(fc);
    }

    public void addFrames(int[] frames, int[] changeArray) {
        FramesCanvas fc = new FramesCanvas(frames);
        fc.showChange(changeArray);
        panel.add(fc);
    }

    public void show() {
        JFrame frame = new JFrame("Frames");
        JScrollPane scrollBar = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.add(scrollBar);

        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
