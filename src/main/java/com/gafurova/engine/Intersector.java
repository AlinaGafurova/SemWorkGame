package com.gafurova.engine;

public class Intersector {

    public static boolean overlap(Sprite first, Sprite second){
        double x1 = first.getX();
        double y1 = first.getY();
        double w1 = first.getWidth();
        double h1 = first.getHeight();

        double x2 = second.getX();
        double y2 = second.getY();
        double w2 = second.getWidth();
        double h2 = second.getHeight();

        double checkX = x2;
        double checkY = y2;
        if(contain(x1, y1, w1, h1, checkX, checkY)){
            return true;
        }

        checkX = x2 + w2;
        checkY = y2;
        if(contain(x1, y1, w1, h1, checkX, checkY)){
            return true;
        }

        checkX = x2;
        checkY = y2 + h2;
        if(contain(x1, y1, w1, h1, checkX, checkY)){
            return true;
        }

        checkX = x2 + w2;
        checkY = y2 + h2;
        if(contain(x1, y1, w1, h1, checkX, checkY)){
            return true;
        }

        return false;
    }

    private static boolean contain(double x1, double y1, double w1, double h1, double checkX, double checkY){
        return (x1 < checkX && (x1 + w1) > checkX) && (y1 < checkY && (y1 + h1) > checkY);
    }
}
