package com.gafurova.engine;


import javafx.scene.image.Image;

public class Sprite {

    private double x;
    private double y;
    private Image image;

    public Sprite(Image image){
        this.image = image;
    }


    public void setImage(Image image){
        this.image = image;
    }
    public Image getImage(){
        return image;
    }

    public double getWidth(){
        return image.getWidth();
    }
    public double getHeight(){
        return image.getHeight();
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setPosition(double x, double y){
        this.x = x;
        this.y = y;
    }
}
