package ru.vsu.cs.galimov.tasks;

import java.awt.*;

public class Grass {
    private PositionParameters parameters;
    private Color color;

    public Grass(PositionParameters parameters, Color color) {
        this.parameters = parameters;
        this.color = color;
    }

    public void draw(Graphics2D g2d){
        DrawUtils.drawGrass(g2d, parameters, color);
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
