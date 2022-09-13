package ru.vsu.cs.galimov.tasks;

import java.awt.*;

public class Cloud implements Drawable{
    PositionParameters param;
    private Color color;

    public Cloud(PositionParameters param, Color color) {
        this.param = param;
        this.color = color;
    }

    public void draw(Graphics2D g2d){
        DrawUtils.drawCloud(g2d, param, color);
    }

    public PositionParameters getParam() {
        return param;
    }

    public void setParam(PositionParameters param) {
        this.param = param;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
