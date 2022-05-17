package Algorithms.Utils;

import javax.swing.*;
import java.awt.*;

public class Utils {

    public static void show(JPanel panel, String title) {
        JFrame frame = new JFrame();
        JScrollPane scrollBar = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.add(scrollBar);

        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
//        label.setFont(new Font("TimesRoman", Font.PLAIN, 100));

        return label;
    }
}
