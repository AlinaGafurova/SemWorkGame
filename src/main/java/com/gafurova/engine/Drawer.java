package com.gafurova.engine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Drawer {

    public GraphicsContext graphicsContext;

    private Drawer(){}
    private static Drawer drawer = new Drawer();
    public static Drawer getInstance(){
        return drawer;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext){
        this.graphicsContext = graphicsContext;
    }


    public void draw(Image image, double x, double y){
        graphicsContext.drawImage(image, x, y);
    }

    public void draw(Image image){
        draw(image, 0, 0);
    }

    public void draw(Sprite sprite){
        draw(sprite.getImage(), sprite.getX(), sprite.getY());
    }

    public double getWidth(){
        return graphicsContext.getCanvas().getWidth();
    }

    public double getHeight(){
        return graphicsContext.getCanvas().getHeight();
    }

    public void clear(){
        graphicsContext.clearRect(0, 0, graphicsContext.getCanvas().getWidth(), graphicsContext.getCanvas().getHeight());
    }
}
