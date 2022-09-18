package ru.vsu.cs.galimov.tasks;

import java.awt.*;

public class Cloud implements Drawable{
    private PositionParameters parameters;
    private Color color;

    public Cloud(PositionParameters param, Color color) {
        this.parameters = param;
        this.color = color;
    }

    public void draw(Graphics2D g2d){
        DrawUtils.drawCloud(g2d, parameters, color);
    }

    public PositionParameters getParameters() {
        return parameters;
    }

    public void setParameters(PositionParameters param) {
        this.parameters = param;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
