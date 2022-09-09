package ru.vsu.cs.galimov.tasks;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    private static final Color GROUND_COLOR1 = new Color(118, 169, 86);
    private static final Color GROUND_COLOR2 = new Color(70, 46, 34);
    private static final Color SKY_COLOR_LIGHT = new Color(154, 195, 232);
    private static final Color MOUNTAIN_COLOR1 = new Color(122, 122, 106);
    private static final Color MOUNTAIN_COLOR2 = new Color(63, 58, 58);
    private static final Color MOUNTAIN_COLOR3 = new Color(239, 236, 236);
    private static final Color TREE_LEAVES_COLOR1 = new Color(92, 147, 64);
    private static final Color TREE_LEAVES_COLOR2 = new Color(45, 68, 31);
    private static final Color TREE_STABLE_COLOR = new Color(70, 59, 41);
    private static final Color CLOUD_COLOR = new Color(227, 220, 220);
    private static final Color BIRD_COLOR = Color.BLACK;
    private static final Color GRASS_COLOR = new Color(63, 114, 48);
    private static final Color STONE_COLOR = new Color(87, 96, 81);
    private static final Color SUN_COLOR1 = new Color(255, 193, 32);
    private static final Color SUN_COLOR2 = new Color(239, 115, 27);

    private Mountain mountain;
    private Tree tree;
    private Cloud cloud;
    private Bird bird;
    private Grass grass;
    private Stone stone;
    private GroundStone groundStone;
    private Sun sun;

    public DrawPanel() {
        /*s = new Sun(90 + rnd.nextInt(100), 60, 30, 25, 20, Color.YELLOW);
        timer = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.setX(s.getX() + 1);
                repaint();
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (timer.isRunning()){
                    timer.stop();
                }
                else{
                    timer.start();
                }
            }
        });*/
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        g2d.setStroke(new BasicStroke(3));

        g2d.setColor(SKY_COLOR_LIGHT);
        g2d.fillRect(0,0, width, height / 2 + height / 16);

        g2d.setColor(GROUND_COLOR1);
        g2d.fillRect(0,height / 2 + height / 16, width, height / 4);

        g2d.setColor(GROUND_COLOR2);
        g2d.fillRect(0,height / 2 + height / 16 + height / 4, width, height / 4);

        //todo sun sample
        PositionParameters parameters = new PositionParameters(width / 2 - width / 10, height / 6, width * 2 / 10, (int)(height * 3.5 / 10));
        sun = new Sun(parameters, SUN_COLOR1, SUN_COLOR2);
        sun.draw(g2d);

        // todo mountains samples
        PositionParameters p1 = new PositionParameters(0,height / 2 + height / 16,getWidth() / 5, getHeight() / 5);
        mountain = new Mountain(p1, MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3);
        mountain.draw(g2d);

        PositionParameters p2 = new PositionParameters(500,height / 2 + height / 16,getWidth() / 3, getHeight() / 5);
        mountain = new Mountain(p2, MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3);
        mountain.draw(g2d);

        PositionParameters p3 = new PositionParameters(800,height / 2 + height / 16,getWidth() / 3, getHeight() / 3);
        mountain = new Mountain(p3, MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3);
        mountain.draw(g2d);

        // todo tree samples
        PositionParameters p4 = new PositionParameters(0,height / 2 + height / 16, getWidth() / 7, getHeight() / 5);
        tree = new Tree(p4,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR, TREE_LEAVES_COLOR2);
        tree.drawType1(g2d);

        PositionParameters p5 = new PositionParameters(400,height / 2 + height / 16, width / 7, height / 5);
        tree = new Tree(p5, TREE_LEAVES_COLOR1, TREE_STABLE_COLOR, TREE_LEAVES_COLOR2);
        tree.drawType2(g2d);

        // todo cloud sample
        PositionParameters p6 = new PositionParameters(0, height / 8, width / 15, width / 15);
        cloud = new Cloud(p6,CLOUD_COLOR);
        cloud.draw(g2d);

        //todo bird sample
        PositionParameters p7 = new PositionParameters(500, height / 8, width / 18, height / 18);
        bird = new Bird(p7, BIRD_COLOR);
        bird.draw(g2d);

        // todo grass sample
        PositionParameters p8 = new PositionParameters(0,height / 2 + height / 6, width / 25, height / 20);
        grass = new Grass(p8,GRASS_COLOR);
        grass.draw(g2d);

        //todo stone samples
        PositionParameters p9 = new PositionParameters(500,height / 2 + height / 5, width / 19, height / 20);
        stone = new Stone(p9, STONE_COLOR);
        stone.draw(g2d);

        //todo ground_stone
        PositionParameters p10 = new PositionParameters(500, height - height / 8,width / 30, height / 27);
        groundStone = new GroundStone(p10, BIRD_COLOR, MOUNTAIN_COLOR1);
        groundStone.draw(g2d);


/*
        g2d.drawPolygon(new int[] {0, getWidth() / 3, getWidth() * 2 / 3, getWidth()}, new int[] {0, getHeight() / 4, getHeight() / 4, 0}, 4);
*/
    }


}
