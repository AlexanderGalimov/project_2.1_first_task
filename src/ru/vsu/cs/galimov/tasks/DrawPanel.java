package ru.vsu.cs.galimov.tasks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static final Color GROUND_COLOR1 = new Color(118, 169, 86);
    private static final Color GROUND_COLOR2 = new Color(70, 46, 34);
    private static final Color SKY_COLOR_LIGHT = new Color(154, 195, 232);
    private static final Color MOUNTAIN_COLOR1 = new Color(122, 122, 106);
    private static final Color MOUNTAIN_COLOR2 = new Color(63, 58, 58);
    private static final Color MOUNTAIN_COLOR3 = new Color(239, 236, 236);
    private static final Color TREE_LEAVES_COLOR1 = new Color(92, 147, 64);
    private static final Color TREE_LEAVES_COLOR2 = new Color(45, 68, 31);
    private static final Color TREE_STABLE_COLOR = new Color(58, 46, 3);
    private static final Color CLOUD_COLOR = new Color(227, 220, 220);
    private static final Color BIRD_COLOR = Color.BLACK;
    private static final Color GRASS_COLOR = new Color(63, 114, 48);
    private static final Color STONE_COLOR = new Color(87, 96, 81);
    private static final Color SUN_COLOR1 = new Color(255, 193, 32);
    private static final Color SUN_COLOR2 = new Color(239, 115, 27);
    private static final Color HOUSE_COLOR_WALL = new Color(126, 67, 24);
    private static final Color HOUSE_COLOR_WINDOW = new Color(138, 239, 233);
    private static Random rnd = new Random();
    private static Timer timer;

    private Mountain mountain;
    private TreeType1 treeT1;
    private TreeType2 treeT2;
    private Cloud cloud;
    private Bird bird;
    private Grass grass;
    private Stone stone;
    private GroundStone groundStone;
    private Sun sun;
    private House house;

    public DrawPanel() {
        timer = new Timer(1000, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );

        int width = getWidth();
        int height = getHeight();

        g2d.setStroke(new BasicStroke(3));

        g2d.setColor(SKY_COLOR_LIGHT);
        g2d.fillRect(0,0, width, height / 2 + height / 16);

        g2d.setColor(GROUND_COLOR1);
        g2d.fillRect(0,height / 2 + height / 16, width, height / 4);

        g2d.setColor(GROUND_COLOR2);
        g2d.fillRect(0,height / 2 + height / 16 + height / 4, width, height / 4);

        PositionParameters parameters = new PositionParameters(width / 2 - width / 10, height / 6, width * 2 / 10, (int)(height * 3.5 / 10));
        sun = new Sun(parameters, SUN_COLOR1, SUN_COLOR2);
        sun.draw(g2d);

        /*for (int i = 0; i < 8; i++) {
            int l = rnd.nextInt(getWidth() / 4) + width / 15;
            int h = rnd.nextInt(getHeight() / 4) + height / 15;
            PositionParameters p = new PositionParameters(rnd.nextInt(getWidth() - l / 2),height / 2 + height / 16,l, h);
            mountain = new Mountain(p, MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain.draw(g2d);
        }

        for (int i = 0; i < 4; i++) {
            int l = rnd.nextInt(getWidth() / 4) + width / 10;
            int h = rnd.nextInt(getHeight() / 4) + height / 8;
            PositionParameters p = new PositionParameters(rnd.nextInt(getWidth() - l / 2),height / 2 + height / 16,l, h);
            treeT1 = new TreeType1(p, TREE_LEAVES_COLOR1,TREE_STABLE_COLOR,TREE_LEAVES_COLOR2, BIRD_COLOR);
            treeT1.draw(g2d);
        }

        for (int i = 0; i < 4; i++) {
            int l = rnd.nextInt(getWidth() / 4) + width / 10;
            int h = rnd.nextInt(getHeight() / 4) + height / 8;
            PositionParameters p = new PositionParameters(rnd.nextInt(getWidth() - l / 2),height / 2 + height / 16,l, h);
            treeT2 = new TreeType2(p, TREE_LEAVES_COLOR1,TREE_STABLE_COLOR, BIRD_COLOR);
            treeT2.draw(g2d);
        }

        for (int i = 0; i < 4; i++) {
            int l = rnd.nextInt(getWidth() / 15) + width / 30;
            PositionParameters p = new PositionParameters(rnd.nextInt(getWidth() - l / 2),  height / 8 - rnd.nextInt(height / 40),width / 15, height / 14);
            cloud = new Cloud(p,CLOUD_COLOR);
            cloud.draw(g2d);
        }

        for (int i = 0; i < 3; i++) {
            int l = rnd.nextInt(getWidth() / 18) + width / 35;
            PositionParameters p = new PositionParameters(rnd.nextInt(getWidth() - l / 2),  height / 10 - rnd.nextInt(height / 40),width / 18, height / 18);
            bird = new Bird(p,BIRD_COLOR);
            bird.draw(g2d);
        }

        for (int i = 0; i < 10; i++) {
            int l = rnd.nextInt(getWidth() / 25) + width / 35;
            PositionParameters p = new PositionParameters(rnd.nextInt(getWidth() - l / 2), height / 2 + height / 4 - rnd.nextInt(height / 8) ,width / 25, height / 20);
            grass = new Grass(p,GRASS_COLOR);
            grass.draw(g2d);
        }

        for (int i = 0; i < 4; i++) {
            int l = rnd.nextInt(getWidth() / 19) + width / 35;
            int h = rnd.nextInt(getHeight() / 20) + height / 30;
            PositionParameters p = new PositionParameters(rnd.nextInt(getWidth() - l / 2), height / 2 + height / 4 - rnd.nextInt(height / 8) , l, h);
            stone = new Stone(p, STONE_COLOR);
            stone.draw(g2d);
        }

        for (int i = 0; i < 20; i++) {
            int l = rnd.nextInt(getWidth() / 30) + width / 60;
            PositionParameters p = new PositionParameters(rnd.nextInt(getWidth() - l / 2),  height - height / 10 - rnd.nextInt(height / 15) , width / 30, height / 27);
            groundStone = new GroundStone(p, BIRD_COLOR, MOUNTAIN_COLOR1);
            groundStone.draw(g2d);
        }*/

        // Drawable
        // сделать мир тип вокруг, плюс компас, который будет показывать градусы при повороте
        //



        /*// todo mountains samples
        PositionParameters p1 = new PositionParameters(0,height / 2 + height / 16,getWidth() / 5, getHeight() / 5);
        mountain = new Mountain(p1, MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
        mountain.draw(g2d);

        PositionParameters p2 = new PositionParameters(500,height / 2 + height / 16,getWidth() / 3, getHeight() / 5);
        mountain = new Mountain(p2, MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
        mountain.draw(g2d);

        PositionParameters p3 = new PositionParameters(800,height / 2 + height / 16,getWidth() / 3, getHeight() / 3);
        mountain = new Mountain(p3, MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
        mountain.draw(g2d);

        // todo tree samples
        PositionParameters p4 = new PositionParameters(0,height / 2 + height / 16, getWidth() / 7, getHeight() / 5);
        treeT1 = new TreeType1(p4,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR, TREE_LEAVES_COLOR2, BIRD_COLOR);
        treeT1.draw(g2d);

        PositionParameters p5 = new PositionParameters(400,height / 2 + height / 16, width / 7, height / 5);
        treeT2 = new TreeType2(p5, TREE_LEAVES_COLOR1, TREE_STABLE_COLOR, BIRD_COLOR);
        treeT2.draw(g2d);

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
        groundStone.draw(g2d);*/

        // todo house sample
        PositionParameters p = new PositionParameters(width / 3,height / 2, width / 8, height / 6);
        house = new House(p,HOUSE_COLOR_WALL,TREE_STABLE_COLOR, HOUSE_COLOR_WINDOW, BIRD_COLOR);
        house.draw(g2d);

    }

}
