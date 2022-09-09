package ru.vsu.cs.galimov.tasks;

import java.awt.*;

public class Stone {
    private PositionParameters parameters;
    private Color color;

    public Stone(PositionParameters parameters, Color color) {
        this.parameters = parameters;
        this.color = color;
    }

    public void draw(Graphics2D g2d){
        DrawUtils.drawStone(g2d, parameters, color);
    }

    public PositionParameters getParameters() {
        return parameters;
    }

    public void setParameters(PositionParameters parameters) {
        this.parameters = parameters;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
