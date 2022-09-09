package ru.vsu.cs.galimov.tasks;

import java.awt.*;

public class Sun {
    private PositionParameters parameters;
    private Color color1;
    private Color color2;

    public Sun(PositionParameters parameters, Color color1, Color color2) {
        this.parameters = parameters;
        this.color1 = color1;
        this.color2 = color2;
    }

    public void draw(Graphics2D g2d){
        DrawUtils.drawSun(g2d, parameters, color1, color2);
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

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }
}
