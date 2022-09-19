package ru.vsu.cs.galimov.tasks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

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
    private static final Color BIRD_COLOR = new Color(0,0,0);
    private static final Color GRASS_COLOR = new Color(63, 114, 48);
    private static final Color STONE_COLOR = new Color(87, 96, 81);
    private static final Color SUN_COLOR1 = new Color(255, 193, 32);
    private static final Color SUN_COLOR2 = new Color(239, 115, 27);
    private static final Color HOUSE_COLOR_WALL = new Color(126, 67, 24);
    private static final Color HOUSE_COLOR_WINDOW = new Color(138, 239, 233);
    private static Random rnd = new Random();
    private static Timer timer;
    private static Directions directions = Directions.NONE;
    private ScreenLengthParameters sc;
    private static double k1 = 1;
    private static double k2 = 1;
    private static boolean flag = true;

    private static List<Mountain> listOfMountain = new ArrayList<>();
    private static List<TreeType1> listOfTreeType1 = new ArrayList<>();
    private static List<TreeType2> listOfTreeType2 = new ArrayList<>();
    private static List<Cloud> listOfclouds = new ArrayList<>();
    private static List<Bird> listOfBirds = new ArrayList<>();
    private static List<Grass> listOfGrass = new ArrayList<>();
    private static List<Stone> listOfStones = new ArrayList<>();
    private static List<GroundStone> listOfGS = new ArrayList<>();
    private static List<Sun> listOfSun = new ArrayList<>();
    private static List<House> listOfHouses = new ArrayList<>();

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

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(e -> {

            if(e.getKeyCode() == 37){
                directions = Directions.LEFT;
            }
            if(e.getKeyCode() == 39){
                directions = Directions.RIGHT;
            }

            for (int i = 0; i < listOfMountain.size(); i++) {
                listOfMountain.get(i).getParameters().move(directions,sc.getCurr() / 100);
            }
            for (int i = 0; i < listOfTreeType1.size(); i++) {
                listOfTreeType1.get(i).getParameters().move(directions,sc.getCurr() / 100);
            }
            for (int i = 0; i < listOfTreeType2.size(); i++) {
                listOfTreeType2.get(i).getParameters().move(directions,sc.getCurr() / 100);
            }
            for (int i = 0; i < listOfSun.size(); i++) {
                listOfSun.get(i).getParameters().move(directions,sc.getCurr() / 100);
            }
            for (int i = 0; i < listOfclouds.size(); i++) {
                listOfclouds.get(i).getParameters().move(directions,sc.getCurr() / 100);
            }
            for (int i = 0; i < listOfBirds.size(); i++) {
                listOfBirds.get(i).getParameters().move(directions,sc.getCurr() / 100);
            }
            for (int i = 0; i < listOfHouses.size(); i++) {
                listOfHouses.get(i).getParameters().move(directions,sc.getCurr() / 100);
            }
            for (int i = 0; i < listOfGrass.size(); i++) {
                listOfGrass.get(i).getParameters().move(directions,sc.getCurr() / 100);
            }

            this.repaint();
            return false;
        });
    }

    public static void initialize(int width, int height){
        Mountain mountain1, mountain2, mountain3, mountain4,mountain5, mountain6,mountain7,mountain8,mountain9;
        TreeType1 t11,t12,t13;
        TreeType2 t21,t22,t23,t24;
        Cloud cloud1,cloud2,cloud3,cloud4,cloud5,cloud6;
        Bird bird1,bird2,bird3;
        Sun sun;
        House house;
        Grass grass1,grass2,grass3,grass4,grass5;

        if(flag){
            /*mountain1 = Initialization.initMountain(-width * 2 / 3,height / 2 + height / 16, width / 5,height / 3, MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain2 = Initialization.initMountain(-width / 3,height / 2 + height / 16, width / 3,height / 6,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain3 = Initialization.initMountain(width / 3,height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain4 = Initialization.initMountain(width * 2 / 3,height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain5 = Initialization.initMountain(width + width / 3,height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain6 = Initialization.initMountain(width + width * 2 / 3,height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);*/


            mountain1 = Initialization.initMountain(-width * 2 / 3,height / 2 + height / 16, width / 5,height / 3, MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain2 = Initialization.initMountain(-width / 3,height / 2 + height / 16, width / 3,height / 6,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain3 = Initialization.initMountain(width / 3,height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain4 = Initialization.initMountain(width * 2 / 3,height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain5 = Initialization.initMountain(width + width / 3,height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain6 = Initialization.initMountain(width + width * 2 / 3,height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain7 = Initialization.initMountain(width + width * 2 / 3,height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain8 = Initialization.initMountain(width + width * 2 / 3,height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain9 = Initialization.initMountain(width + width * 2 / 3,height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            t11 = Initialization.initTreeType1(-width / 2, height / 2 + height / 16, width / 5, height / 6,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR,TREE_LEAVES_COLOR2, BIRD_COLOR);
            t12 = Initialization.initTreeType1(width / 2, height / 2 + height / 16, width / 5, height / 6,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR,TREE_LEAVES_COLOR2, BIRD_COLOR);
            t13 = Initialization.initTreeType1(width + width / 2, height / 2 + height / 16, width / 5, height / 5,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR,TREE_LEAVES_COLOR2, BIRD_COLOR);
            t21 = Initialization.initTreeType2(-width / 4, height / 2 + height / 16, width / 5, height / 5,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR, BIRD_COLOR);
            t22 = Initialization.initTreeType2(width / 4, height / 2 + height / 16, width / 5, height / 5,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR, BIRD_COLOR);
            t23 = Initialization.initTreeType2(width * 3 / 4, height / 2 + height / 16, width / 5, height / 5,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR, BIRD_COLOR);
            t24 = Initialization.initTreeType2(width + width / 4, height / 2 + height / 16, width / 5, height / 4,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR, BIRD_COLOR);
            sun = Initialization.initSun(width / 2 - width / 10, height / 6, width * 2 / 10, (int)(height * 3.5 / 10),SUN_COLOR1, SUN_COLOR2);
            cloud1 = Initialization.initCloud(-width * 3 / 4,height / 8,width / 15, height / 14,CLOUD_COLOR);
            cloud2 = Initialization.initCloud(-width / 4,height / 8,width / 15, height / 14,CLOUD_COLOR);
            cloud3 = Initialization.initCloud(width / 4,height / 8,width / 15, height / 14,CLOUD_COLOR);
            cloud4 = Initialization.initCloud(width * 3 / 4,height / 8,width / 15, height / 14,CLOUD_COLOR);
            cloud5 = Initialization.initCloud(width + width / 4,height / 8,width / 15, height / 14,CLOUD_COLOR);
            cloud6 = Initialization.initCloud(width + width * 3 / 4,height / 8,width / 15, height / 14,CLOUD_COLOR);
            bird1 = Initialization.initBird(-width * 5 / 6,  height / 10,width / 18, height / 18,BIRD_COLOR);
            bird2 = Initialization.initBird(width / 6,  height / 10,width / 18, height / 18,BIRD_COLOR);
            bird3 = Initialization.initBird(width + width * 5 / 6,  height / 10,width / 18, height / 18,BIRD_COLOR);
            house = Initialization.initHouse(width / 3,height / 2 + height / 8, width / 8, height / 6,HOUSE_COLOR_WALL,TREE_STABLE_COLOR, HOUSE_COLOR_WINDOW, BIRD_COLOR);
            grass1 = Initialization.initGrass(-width * 3 / 4, height / 2 + height / 4 ,width / 25, height / 20, GRASS_COLOR);
            grass2 = Initialization.initGrass(-width / 4, height / 2 + height / 4 ,width / 25, height / 20, GRASS_COLOR);
            grass3 = Initialization.initGrass(width / 4, height / 2 + height / 4 ,width / 25, height / 20, GRASS_COLOR);
            grass4 = Initialization.initGrass(width * 3 / 4, height / 2 + height / 4 ,width / 25, height / 20, GRASS_COLOR);
            grass5 = Initialization.initGrass(width + width * 3 / 4, height / 2 + height / 4 ,width / 25, height / 20, GRASS_COLOR);
            flag = false;
        }

        else{
            mountain1 = Initialization.initMountain((int)(listOfMountain.get(0).getParameters().getX() * k1),height / 2 + height / 16, width / 5,height / 3,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain2 = Initialization.initMountain((int)(listOfMountain.get(1).getParameters().getX() * k1),height / 2 + height / 16, width / 3,height / 6,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain3 = Initialization.initMountain((int)(listOfMountain.get(2).getParameters().getX() * k1),height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain4 = Initialization.initMountain((int)(listOfMountain.get(3).getParameters().getX() * k1),height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain5 = Initialization.initMountain((int)(listOfMountain.get(4).getParameters().getX() * k1),height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            mountain6 = Initialization.initMountain((int)(listOfMountain.get(5).getParameters().getX() * k1),height / 2 + height / 16, width / 7,height / 8,  MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            t11 = Initialization.initTreeType1((int)(listOfTreeType1.get(0).getParameters().getX() * k1), height / 2 + height / 16, width / 5, height / 5,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR,TREE_LEAVES_COLOR2, BIRD_COLOR);
            t12 = Initialization.initTreeType1((int)(listOfTreeType1.get(1).getParameters().getX() * k1), height / 2 + height / 16, width / 5, height / 5,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR,TREE_LEAVES_COLOR2, BIRD_COLOR);
            t13 = Initialization.initTreeType1((int)(listOfTreeType1.get(2).getParameters().getX() * k1), height / 2 + height / 16, width / 5, height / 5,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR,TREE_LEAVES_COLOR2, BIRD_COLOR);
            t21 = Initialization.initTreeType2((int)(listOfTreeType2.get(0).getParameters().getX() * k1), height / 2 + height / 16, width / 5, height / 5,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR, BIRD_COLOR);
            t22 = Initialization.initTreeType2((int)(listOfTreeType2.get(1).getParameters().getX() * k1), height / 2 + height / 16, width / 5, height / 5,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR, BIRD_COLOR);
            t23 = Initialization.initTreeType2((int)(listOfTreeType2.get(2).getParameters().getX() * k1), height / 2 + height / 16, width / 5, height / 5,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR, BIRD_COLOR);
            t24 = Initialization.initTreeType2((int)(listOfTreeType2.get(3).getParameters().getX() * k1), height / 2 + height / 16, width / 5, height / 4,TREE_LEAVES_COLOR1,TREE_STABLE_COLOR, BIRD_COLOR);
            sun = Initialization.initSun((int)(listOfSun.get(0).getParameters().getX() * k1), height / 6, width * 2 / 10, (int)(height * 3.5 / 10),SUN_COLOR1, SUN_COLOR2);
            cloud1 = Initialization.initCloud((int)(listOfclouds.get(0).getParameters().getX() * k1),height / 8,width / 15, height / 14,CLOUD_COLOR);
            cloud2 = Initialization.initCloud((int)(listOfclouds.get(1).getParameters().getX() * k1),height / 8,width / 15, height / 14,CLOUD_COLOR);
            cloud3 = Initialization.initCloud((int)(listOfclouds.get(2).getParameters().getX() * k1),height / 8,width / 15, height / 14,CLOUD_COLOR);
            cloud4 = Initialization.initCloud((int)(listOfclouds.get(3).getParameters().getX() * k1),height / 8,width / 15, height / 14,CLOUD_COLOR);
            cloud5 = Initialization.initCloud((int)(listOfclouds.get(4).getParameters().getX() * k1),height / 8,width / 15, height / 14,CLOUD_COLOR);
            cloud6 = Initialization.initCloud((int)(listOfclouds.get(5).getParameters().getX() * k1),height / 8,width / 15, height / 14,CLOUD_COLOR);
            bird1 = Initialization.initBird((int)(listOfBirds.get(0).getParameters().getX() * k1),  height / 10,width / 18, height / 18,BIRD_COLOR);
            bird2 = Initialization.initBird((int)(listOfBirds.get(1).getParameters().getX() * k1),  height / 10,width / 18, height / 18,BIRD_COLOR);
            bird3 = Initialization.initBird((int)(listOfBirds.get(2).getParameters().getX() * k1),  height / 10,width / 18, height / 18,BIRD_COLOR);
            house = Initialization.initHouse((int)(listOfHouses.get(0).getParameters().getX() * k1),height / 2 + height / 8, width / 8, height / 6,HOUSE_COLOR_WALL,TREE_STABLE_COLOR, HOUSE_COLOR_WINDOW, BIRD_COLOR);
            grass1 = Initialization.initGrass((int)(listOfGrass.get(0).getParameters().getX() * k1), height / 2 + height / 4 ,width / 25, height / 20, GRASS_COLOR);
            grass2 = Initialization.initGrass((int)(listOfGrass.get(1).getParameters().getX() * k1), height / 2 + height / 4 ,width / 25, height / 20, GRASS_COLOR);
            grass3 = Initialization.initGrass((int)(listOfGrass.get(2).getParameters().getX() * k1), height / 2 + height / 4 ,width / 25, height / 20, GRASS_COLOR);
            grass4 = Initialization.initGrass((int)(listOfGrass.get(3).getParameters().getX() * k1), height / 2 + height / 4 ,width / 25, height / 20, GRASS_COLOR);
            grass5 = Initialization.initGrass((int)(listOfGrass.get(4).getParameters().getX() * k1), height / 2 + height / 4 ,width / 25, height / 20, GRASS_COLOR);

            listOfMountain.clear();
            listOfTreeType1.clear();
            listOfTreeType2.clear();
            listOfSun.clear();
            listOfclouds.clear();
            listOfBirds.clear();
            listOfHouses.clear();
            listOfGrass.clear();
        }

        listOfMountain.add(mountain1);
        listOfMountain.add(mountain2);
        listOfMountain.add(mountain3);
        listOfMountain.add(mountain4);
        listOfMountain.add(mountain5);
        listOfMountain.add(mountain6);
        listOfTreeType1.add(t11);
        listOfTreeType1.add(t12);
        listOfTreeType1.add(t13);
        listOfTreeType2.add(t21);
        listOfTreeType2.add(t22);
        listOfTreeType2.add(t23);
        listOfTreeType2.add(t24);
        listOfSun.add(sun);
        listOfclouds.add(cloud1);
        listOfclouds.add(cloud2);
        listOfclouds.add(cloud3);
        listOfclouds.add(cloud4);
        listOfclouds.add(cloud5);
        listOfclouds.add(cloud6);
        listOfBirds.add(bird1);
        listOfBirds.add(bird2);
        listOfBirds.add(bird3);
        listOfHouses.add(house);
        listOfGrass.add(grass1);
        listOfGrass.add(grass2);
        listOfGrass.add(grass3);
        listOfGrass.add(grass4);
        listOfGrass.add(grass5);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );

        int width = getWidth();
        int height = getHeight();

        g2d.setStroke(new BasicStroke(3));

        g2d.setColor(SKY_COLOR_LIGHT);
        g2d.fillRect(0,0, width, height / 2 + height / 16);

        g2d.setColor(GROUND_COLOR1);
        g2d.fillRect(0,height / 2 + height / 16, width, height / 4);

        g2d.setColor(GROUND_COLOR2);
        g2d.fillRect(0,height / 2 + height / 16 + height / 4, width, height / 4);

        if(flag){
            sc = new ScreenLengthParameters(width,width);
        }

        sc.setPrev(sc.getCurr());
        sc.setCurr(width);

        initialize(getWidth(),getHeight());

        k2 = (double)(sc.getCurr()) / (double)(sc.getPrev());

        if(k1 != k2){
            k1 = k2;
            k2 = 0;
        }

        for (Sun sun : listOfSun) {
            sun.draw(g2d);
            if (sun.getParameters().getX() < -width) {
                sun.getParameters().setX(2 * width - Math.abs(Math.abs(sun.getParameters().getX()) - width));
            }
            if (sun.getParameters().getX() > 2 * width) {
                sun.getParameters().setX(-width + Math.abs(Math.abs(sun.getParameters().getX()) - 2 * width));
            }
        }

        for (Mountain mountain : listOfMountain) {
            mountain.draw(g2d);
            if (mountain.getParameters().getX() < -width) {
                mountain.getParameters().setX(2 * width - Math.abs(Math.abs(mountain.getParameters().getX()) - width));
            }
            if (mountain.getParameters().getX() > 2 * width) {
                mountain.getParameters().setX(-width + Math.abs(Math.abs(mountain.getParameters().getX()) - 2 * width));
            }
        }

        for (TreeType1 treeType1 : listOfTreeType1) {
            treeType1.draw(g2d);
            if (treeType1.getParameters().getX() < -width) {
                treeType1.getParameters().setX(2 * width - Math.abs(Math.abs(treeType1.getParameters().getX()) - width));
            }
            if (treeType1.getParameters().getX() > 2 * width) {
                treeType1.getParameters().setX(-width + Math.abs(Math.abs(treeType1.getParameters().getX()) - 2 * width));
            }
        }

        for (TreeType2 treeType2 : listOfTreeType2) {
            treeType2.draw(g2d);
            if (treeType2.getParameters().getX() < -width) {
                treeType2.getParameters().setX(2 * width - Math.abs(Math.abs(treeType2.getParameters().getX()) - width));
            }
            if (treeType2.getParameters().getX() > 2 * width) {
                treeType2.getParameters().setX(-width + Math.abs(Math.abs(treeType2.getParameters().getX()) - 2 * width));
            }
        }


        for (Cloud cloud : listOfclouds) {
            cloud.draw(g2d);
            if (cloud.getParameters().getX() < -width) {
                cloud.getParameters().setX(2 * width - Math.abs(Math.abs(cloud.getParameters().getX()) - width));
            }
            if (cloud.getParameters().getX() > 2 * width) {
                cloud.getParameters().setX(-width + Math.abs(Math.abs(cloud.getParameters().getX()) - 2 * width));
            }
        }

        for (Bird bird : listOfBirds) {
            bird.draw(g2d);
            if (bird.getParameters().getX() < -width) {
                bird.getParameters().setX(2 * width - Math.abs(Math.abs(bird.getParameters().getX()) - width));
            }
            if (bird.getParameters().getX() > 2 * width) {
                bird.getParameters().setX(-width + Math.abs(Math.abs(bird.getParameters().getX()) - 2 * width));
            }
        }

        for (House house : listOfHouses) {
            house.draw(g2d);
            if (house.getParameters().getX() < -width) {
                house.getParameters().setX(2 * width - Math.abs(Math.abs(house.getParameters().getX()) - width));
            }
            if (house.getParameters().getX() > 2 * width) {
                house.getParameters().setX(-width + Math.abs(Math.abs(house.getParameters().getX()) - 2 * width));
            }
        }

        for (Grass grass : listOfGrass) {
            grass.draw(g2d);
            if (grass.getParameters().getX() < -width) {
                grass.getParameters().setX(2 * width - Math.abs(Math.abs(grass.getParameters().getX()) - width));
            }
            if (grass.getParameters().getX() > 2 * width) {
                grass.getParameters().setX(-width + Math.abs(Math.abs(grass.getParameters().getX()) - 2 * width));
            }
        }


        /*PositionParameters p;
        for (int i = 0; i < 5; i++) {
            int l = rnd.nextInt(getWidth() / 4) + width / 15;
            int h = rnd.nextInt(getHeight() / 4) + height / 15;
            p = new PositionParameters(rnd.nextInt(getWidth() - l / 2),height / 2 + height / 16,l, h);
            mountain = new Mountain(p, MOUNTAIN_COLOR1, MOUNTAIN_COLOR2, MOUNTAIN_COLOR3, BIRD_COLOR);
            listOfMountain.add(mountain);
        }*/
        /*for (int i = 0; i < 4; i++) {
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

        /*PositionParameters p = new PositionParameters(width / 3,height / 2 + height / 8, width / 8, height / 6);
        house = new House(p,HOUSE_COLOR_WALL,TREE_STABLE_COLOR, HOUSE_COLOR_WINDOW, BIRD_COLOR);
        house.draw(g2d);*/


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


    }

}
