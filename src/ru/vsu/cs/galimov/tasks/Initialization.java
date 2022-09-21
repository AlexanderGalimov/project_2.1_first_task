package ru.vsu.cs.galimov.tasks;

import java.awt.*;

public class Initialization {

    public static Mountain initMountain(int x, int y, int length, int height, Color color1, Color color2, Color color3, Color color4){
        Mountain mountain;
        PositionParameters p = new PositionParameters(x,y, length, height);
        mountain = new Mountain(p,  color1, color2, color3, color4);
        return mountain;
    }

    public static TreeType1 initTreeType1(int x, int y, int length, int height, Color color1, Color color2, Color color3, Color color4){
        TreeType1 treeType1;
        PositionParameters p = new PositionParameters(x,y, length,height);
        treeType1 = new TreeType1(p, color1, color2, color3, color4);
        return treeType1;
    }

    public static TreeType2 initTreeType2(int x, int y, int length, int height, Color color1, Color color2, Color color3){
        TreeType2 treeType2;
        PositionParameters p = new PositionParameters(x,y, length,height);
        treeType2 = new TreeType2(p, color1, color2, color3);
        return treeType2;
    }

    public static Cloud initCloud(int x, int y, int length, int height, Color color1){
        Cloud cloud;
        PositionParameters p = new PositionParameters(x,y, length,height);
        cloud = new Cloud(p, color1);
        return cloud;
    }

    public static Bird initBird(int x, int y, int length, int height, Color color1){
        Bird bird;
        PositionParameters p = new PositionParameters(x,y, length,height);
        bird = new Bird(p,  color1);
        return bird;
    }

    public static Grass initGrass(int x, int y, int length, int height, Color color1){
        Grass grass;
        PositionParameters p = new PositionParameters(x,y, length,height);
        grass = new Grass(p,  color1);
        return grass;
    }

    public static Stone initStone(int x, int y, int length, int height, Color color1){
        Stone stone;
        PositionParameters p = new PositionParameters(x,y, length,height);
        stone = new Stone(p,  color1);
        return stone;
    }

    public static GroundStone initGroundStone(int x, int y, int length, int height, Color color1, Color color2){
        GroundStone groundStone;
        PositionParameters p = new PositionParameters(x,y, length,height);
        groundStone = new GroundStone(p,  color1, color2);
        return groundStone;
    }

    public static House initHouse(int x, int y, int length, int height, Color color1, Color color2, Color color3, Color color4,int typePosition){
        House house;
        PositionParameters p = new PositionParameters(x,y, length,height);
        house = new House(p,  color1, color2, color3, color4, typePosition);
        return house;
    }
    public static Sun initSun(int x, int y, int length, int height, Color color1, Color color2){
        Sun sun;
        PositionParameters p = new PositionParameters(x,y, length,height);
        sun = new Sun(p,  color1, color2);
        return sun;
    }


}
