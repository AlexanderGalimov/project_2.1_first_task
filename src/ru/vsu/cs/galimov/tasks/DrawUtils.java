package ru.vsu.cs.galimov.tasks;

import java.awt.*;

public class DrawUtils {
    public static void drawMountain(Graphics2D g2d, PositionParameters parameters, Color col1, Color col2, Color col3, Color col4){
        g2d.setColor(col1);
        g2d.fillPolygon(new int[] {parameters.getX(), parameters.getX() + parameters.getLength() / 2, parameters.getX() + parameters.getLength() / 2}, new int[] {parameters.getY(), parameters.getY() - parameters.getHeight(), parameters.getY()}, 3);

        g2d.setColor(col2);
        g2d.fillPolygon(new int[] {parameters.getX() + parameters.getLength() / 2, parameters.getX() + parameters.getLength() / 2, parameters.getX() + parameters.getLength()}, new int[] {parameters.getY(), parameters.getY() - parameters.getHeight(), parameters.getY()}, 3);

        g2d.setColor(col3);
        g2d.fillPolygon(new int[] {(int) (parameters.getX() + parameters.getLength() / 2 - parameters.getLength() / 5.7),
                parameters.getX() + parameters.getLength() / 2,
                (int) (parameters.getX() + parameters.getLength() / 2 + parameters.getLength() / 5.7),
                parameters.getX() + parameters.getLength() / 2 + parameters.getLength() / 10,
                parameters.getX() + parameters.getLength() / 2 - parameters.getLength() / 13},
                new int[] {parameters.getY() - parameters.getHeight() * 6 / 9,
                        parameters.getY() - parameters.getHeight() - parameters.getHeight() / 49,
                        parameters.getY() - parameters.getHeight() * 6 / 9,
                        parameters.getY() - parameters.getHeight() * 6 / 9 - parameters.getHeight() / 10,
                        parameters.getY() - parameters.getHeight() * 6 / 9 - parameters.getHeight() / 13}, 5);

        g2d.setColor(col4);
        g2d.setStroke(new BasicStroke(1));
        g2d.drawLine(parameters.getX(),parameters.getY(),(parameters.getX() + parameters.getLength() / 2 - parameters.getLength() / 6),parameters.getY() - parameters.getHeight() * 6 / 9);
        g2d.drawLine(parameters.getX(), parameters.getY(), parameters.getX() + parameters.getLength(), parameters.getY());
        g2d.drawLine(parameters.getX() + parameters.getLength(), parameters.getY(),(parameters.getX() + parameters.getLength() / 2 + parameters.getLength() / 6), parameters.getY() - parameters.getHeight() * 6 / 9);
        g2d.setStroke(new BasicStroke(3));


    }

    public static void drawTreeType1(Graphics2D g2d,PositionParameters parameters, Color color1, Color color2, Color color3, Color color4){
        g2d.setColor(color2);
        g2d.fillRect(parameters.getX() + parameters.getLength() / 2 - parameters.getLength() / 24, parameters.getY() - parameters.getHeight() / 4, parameters.getHeight() / 12, parameters.getHeight() / 4);

        g2d.setColor(color1);
        g2d.fillPolygon(new int[] {parameters.getX(),
                parameters.getX() + parameters.getLength() / 2,
                parameters.getX() + parameters.getLength() / 2},
                new int[] {parameters.getY() - parameters.getHeight() / 4,
                        parameters.getY() - parameters.getHeight() - parameters.getHeight() / 4,
                        parameters.getY() - parameters.getHeight() / 4}, 3);


        g2d.setColor(color3);
        g2d.fillPolygon(new int[] {parameters.getX() + parameters.getLength() / 2,
                parameters.getX() + parameters.getLength() / 2,
                parameters.getX() + parameters.getLength()},
                new int[] {parameters.getY() - parameters.getHeight() / 4,
                        parameters.getY() - parameters.getHeight() - parameters.getHeight() / 4,
                        parameters.getY() - parameters.getHeight() / 4}, 3);

        g2d.setColor(color4);
        g2d.setStroke(new BasicStroke(1));
        g2d.drawLine(parameters.getX(), parameters.getY() - parameters.getHeight() / 4, parameters.getX() + parameters.getLength() / 2, parameters.getY() - parameters.getHeight() - parameters.getHeight() / 4);
        g2d.drawLine(parameters.getX(), parameters.getY() - parameters.getHeight() / 4, parameters.getX() + parameters.getLength(), parameters.getY() - parameters.getHeight() / 4);
        g2d.drawLine(parameters.getX() + parameters.getLength() / 2, parameters.getY() - parameters.getHeight() - parameters.getHeight() / 4, parameters.getX() + parameters.getLength(), parameters.getY() - parameters.getHeight() / 4);
        g2d.setStroke(new BasicStroke(3));

    }

    public static void drawTreeType2(Graphics2D g2d,PositionParameters parameters, Color col1, Color col2, Color col3){
        g2d.setColor(col2);
        g2d.fillRect(parameters.getX() + parameters.getLength() / 2 - parameters.getLength() / 24, parameters.getY() - parameters.getHeight(), parameters.getHeight() / 12, parameters.getHeight());

        g2d.setColor(col1);
        g2d.fillOval(parameters.getX() + parameters.getLength() / 4, parameters.getY() - parameters.getHeight() - parameters.getLength() / 2, parameters.getLength() / 2, parameters.getLength() / 2);
        g2d.setColor(col3);
        g2d.setStroke(new BasicStroke(1));
        g2d.drawOval(parameters.getX() + parameters.getLength() / 4, parameters.getY() - parameters.getHeight() - parameters.getLength() / 2, parameters.getLength() / 2, parameters.getLength() / 2);
        g2d.setStroke(new BasicStroke(3));
    }

    public static void drawCloud(Graphics2D g2d, PositionParameters parameters, Color color){
        g2d.setColor(color);

        g2d.fillOval(parameters.getX(), parameters.getY(), parameters.getLength(), parameters.getHeight());

        g2d.fillOval(parameters.getX() + parameters.getLength() / 3, parameters.getY() - parameters.getHeight() / 12, parameters.getLength(), parameters.getHeight());

        g2d.fillOval(parameters.getX() + parameters.getLength(), parameters.getY() + parameters.getHeight() / 12, parameters.getLength() * 2 / 3, parameters.getHeight() * 2 / 3);

        g2d.fillOval(parameters.getX() + parameters.getLength(), parameters.getY() + parameters.getHeight() / 4, parameters.getLength() * 2 / 3, parameters.getHeight() * 2 / 3);

        g2d.fillOval(parameters.getX() + parameters.getLength() * 9 / 8, parameters.getY() + parameters.getHeight() / 6, parameters.getLength() * 2 / 3, parameters.getHeight() * 2 / 3);
    }

    // откладывать справа на две длины
    public static void drawBird(Graphics2D g2d, PositionParameters parameters, Color color){
        g2d.setColor(color);

        g2d.drawArc(parameters.getX(), parameters.getY(), parameters.getLength(), parameters.getHeight(), 30,80);
        g2d.drawArc(parameters.getX() + parameters.getLength() * 4 / 5,(int)(parameters.getY() + parameters.getHeight() / 4.8), parameters.getLength() * 2 / 3, parameters.getHeight(), 30,100);
    }

    public static void drawGrass(Graphics2D g2d, PositionParameters parameters, Color color){
        g2d.setColor(color);
        g2d.fillPolygon(new int[] {parameters.getX(), parameters.getX() + parameters.getLength() / 2, parameters.getX() + parameters.getLength()}, new int[] {parameters.getY(), parameters.getY() - parameters.getHeight(), parameters.getY()}, 3);
        g2d.fillPolygon(new int[] {parameters.getX() + parameters.getLength() / 3, parameters.getX() + parameters.getLength() / 2 + parameters.getLength() / 3, parameters.getX() + parameters.getLength() + parameters.getLength() / 3}, new int[] {parameters.getY(), parameters.getY() - parameters.getHeight() * 3 / 2, parameters.getY()}, 3);
        g2d.fillPolygon(new int[] {parameters.getX() + parameters.getLength() * 8 / 9, parameters.getX() + parameters.getLength() / 2 + parameters.getLength() * 8 / 9, parameters.getX() + parameters.getLength() + parameters.getLength() * 8 / 9}, new int[] {parameters.getY(), parameters.getY() - parameters.getHeight(), parameters.getY()}, 3);
    }

    // откладывать слева и справа по length / 2
    public static void drawStone(Graphics2D g2d, PositionParameters parameters, Color color){
        g2d.setColor(color);
        g2d.fillRect(parameters.getX(), parameters.getY(), parameters.getLength(), parameters.getHeight());
        g2d.fillOval(parameters.getX(), parameters.getY() - parameters.getHeight() / 2, parameters.getLength(), parameters.getHeight());
        g2d.fillOval(parameters.getX() + parameters.getLength() * 4 / 9, parameters.getY(), parameters.getLength(), parameters.getHeight());
        g2d.fillOval(parameters.getX() - parameters.getLength() / 2, parameters.getY(), parameters.getLength(), parameters.getHeight());
    }

    public static void drawGroundPoint(Graphics2D g2d, PositionParameters parameters, Color color1, Color color2){
        g2d.setColor(color1);
        g2d.fillOval(parameters.getX(), parameters.getY(), parameters.getLength(), parameters.getHeight());

        g2d.setColor(color2);
        g2d.fillOval(parameters.getX() + parameters.getLength() / 4, parameters.getY() + parameters.getHeight() / 3, parameters.getLength() * 2 / 3, parameters.getHeight() * 2 / 3);
    }

    public static void drawSun(Graphics2D g2d, PositionParameters parameters, Color color1, Color color2){
        g2d.setColor(color1);
        g2d.fillOval(parameters.getX(), parameters.getY(), parameters.getLength(), parameters.getHeight());

    }

    public static void drawHouse(Graphics2D g2d, PositionParameters parameters, Color color1, Color color2, Color color3, Color color4){
        g2d.setColor(color1);
        g2d.fillRect(parameters.getX(), parameters.getY(), parameters.getLength(), parameters.getHeight());
        g2d.fillPolygon(new int[] {parameters.getX(), parameters.getX() + parameters.getLength() / 2, parameters.getX() + parameters.getLength()}, new int[] {parameters.getY(), parameters.getY() - parameters.getHeight() / 2, parameters.getY()}, 3);

        g2d.setColor(color4);
        g2d.setStroke(new BasicStroke(1));
        g2d.drawRect(parameters.getX(), parameters.getY(), parameters.getLength(), parameters.getHeight());
        g2d.drawPolygon(new int[] {parameters.getX(), parameters.getX() + parameters.getLength() / 2, parameters.getX() + parameters.getLength()}, new int[] {parameters.getY(), parameters.getY() - parameters.getHeight() / 2, parameters.getY()}, 3);

        g2d.setColor(color2);
        g2d.setStroke(new BasicStroke(3));

        g2d.fillOval(parameters.getX() - parameters.getLength() / 14, parameters.getY(), parameters.getLength() / 6, parameters.getHeight() / 5);
        int d = parameters.getHeight() / 5;
        int height = parameters.getY() + d;

        for (int i = 0; i < 4; i++) {
            g2d.fillOval(parameters.getX() - parameters.getLength() / 14, height, parameters.getLength() / 6, parameters.getHeight() / 5);
            height = height + d;
        }

        g2d.fillOval(parameters.getX() + parameters.getLength() - parameters.getLength() / 14, parameters.getY(), parameters.getLength() / 6, parameters.getHeight() / 5);

        height = parameters.getY() + d;

        for (int i = 0; i < 4; i++) {
            g2d.fillOval(parameters.getX() + parameters.getLength() - parameters.getLength() / 14, height, parameters.getLength() / 6, parameters.getHeight() / 5);
            height = height + d;
        }

        g2d.setColor(color3);
        g2d.fillRect(parameters.getX() + parameters.getLength() / 3, parameters.getY() + parameters.getHeight() / 3, parameters.getLength() / 3, parameters.getHeight() / 3);

        g2d.setColor(color4);
        g2d.fillRect(parameters.getX() + parameters.getLength() / 3, parameters.getY() + parameters.getHeight() / 3 + parameters.getHeight() / 6, parameters.getLength() / 3, parameters.getHeight() / 18);

        g2d.fillRect(parameters.getX() + parameters.getLength() / 3 + parameters.getLength() / 7, parameters.getY() + parameters.getHeight() / 3, parameters.getLength() / 18, parameters.getHeight() / 3);

        g2d.setColor(color2);
        g2d.setStroke(new BasicStroke(7));
        g2d.drawLine(parameters.getX(), parameters.getY(), parameters.getX() + parameters.getLength() / 2, parameters.getY() - parameters.getHeight() / 2);
        g2d.drawLine(parameters.getX() + parameters.getLength() / 2, parameters.getY() - parameters.getHeight() / 2, parameters.getX() + parameters.getLength(), parameters.getY());
        g2d.drawLine(parameters.getX(), parameters.getY(), parameters.getX() + parameters.getLength(), parameters.getY());
        g2d.setStroke(new BasicStroke(3));

    }


}
