package ru.vsu.cs.galimov.tasks;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private DrawPanel mainPanel;

    public MainWindow() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        DisplayMode displayMode = graphicsDevice.getDisplayMode();
        int width = displayMode.getWidth();
        int height = displayMode.getHeight();
        setSize(width, height);

        mainPanel = new DrawPanel();
        mainPanel.setFocusable(true);
        this.add(mainPanel);
    }
}
