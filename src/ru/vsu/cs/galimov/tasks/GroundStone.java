package ru.vsu.cs.galimov.tasks;

import java.awt.*;

public class GroundStone {
    private PositionParameters parameters;
    private Color color1;
    private Color color2;

    public GroundStone(PositionParameters parameters, Color color1, Color color2) {
        this.parameters = parameters;
        this.color1 = color1;
        this.color2 = color2;
    }

    public void draw(Graphics2D g2d){
        DrawUtils.drawGroundPoint(g2d, parameters, color1, color2);
    }

    public PositionParameters getParameters() {
        return parameters;
    }

    public void setParameters(PositionParameters parameters) {
        this.parameters = parameters;
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color) {
        this.color1 = color;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }
}
