package ru.vsu.cs.galimov.tasks;

import java.awt.*;

public class Mountain implements Drawable{
    PositionParameters parameters;
    private Color color1;
    private Color color2;
    private Color color3;
    private Color color4;

    public Mountain(PositionParameters parameters, Color color1, Color color2, Color color3, Color color4) {
        this.parameters = parameters;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
    }

    public void draw(Graphics2D g2d){
        DrawUtils.drawMountain(g2d, parameters, color1, color2, color3, color4);
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

    public Color getColor3() {
        return color3;
    }

    public void setColor3(Color color3) {
        this.color3 = color3;
    }

    public Color getColor4() {
        return color4;
    }

    public void setColor4(Color color4) {
        this.color4 = color4;
    }
}
