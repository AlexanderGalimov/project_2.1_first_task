package ru.vsu.cs.galimov.tasks;

import java.awt.*;

public class Tree {
    PositionParameters parameters;
    private Color color1;
    private Color color2;
    private Color color3;

    public Tree(PositionParameters parameters, Color color1, Color color2, Color color3) {
        this.parameters = parameters;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
    }

    public void drawType1(Graphics2D g2d){
        DrawUtils.drawTreeType1(g2d, parameters, color1, color2, color3);
    }

    public void drawType2(Graphics2D g2d){
        DrawUtils.drawTreeType2(g2d, parameters, color1, color2, color3);
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
}