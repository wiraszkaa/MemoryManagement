package Algorithms.Visuals;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class FramesCanvas extends JComponent {
    int[] frames;

    public FramesCanvas(int[] frames) {
        setPreferredSize(new Dimension(80, 500));
        this.frames = frames;
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < frames.length; i++) {
            Rectangle2D.Double r = new Rectangle2D.Double(10, i * 50 + 10, 50, 50);
            g2d.setColor(Color.BLACK);
            g2d.draw(r);

            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g2d.drawString(frames[i] == -1 ? "" : String.valueOf(frames[i]), 15, i * 50 + 50);
        }
    }
}
