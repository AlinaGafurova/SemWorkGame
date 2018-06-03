package com.gafurova.entities;

import com.gafurova.engine.MonoBehaviour;
import com.gafurova.engine.ResourcesHandler;
import com.gafurova.engine.Sprite;
import javafx.scene.image.Image;

public class Laser extends MonoBehaviour{

    private Sprite sprite;

    private int direction;
    private int owner;
    private float speed = 250;

    public Laser(int direction, int owner){
        this.sprite = new Sprite(ResourcesHandler.getInstance().laser);
        this.direction = direction;
        this.owner = owner;
    }

    @Override
    public void update(double deltaTime) {
        switch (direction){
            case 1: sprite.setY(sprite.getY() - speed * deltaTime); break;
            case 2: sprite.setY(sprite.getY() + speed * deltaTime); break;
        }
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    public int getOwner(){
        return owner;
    }

    public void setPosition(double x, double y){
        sprite.setPosition(x, y);
    }

    public double getPositionX(){
        return sprite.getX();
    }

    public double getPositionY(){
        return sprite.getY();
    }

    public void setPositionX(double x){
        sprite.setX(x);
    }

    public void setPositionY(double y){
        sprite.setY(y);
    }
}
